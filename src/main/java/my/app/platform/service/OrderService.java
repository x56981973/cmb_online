package my.app.platform.service;

import my.app.platform.domain.Order;
import my.app.platform.domain.Order_Item;
import my.app.platform.domain.model.MOrder;
import my.app.platform.domain.view.ItemDetail;
import my.app.platform.domain.view.OrderDetail;
import my.app.platform.repository.mapper.order.IOrderDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 16:49
 *         创建说明：订单业务
 */
@Service
public class OrderService {
    @Autowired
    IOrderDao orderDao;

    @Autowired
    ItemService itemService;

    public List<MOrder> queryAllOrders(){
        List<MOrder> mOrderList = new ArrayList<>();

        List<OrderDetail> orderDetailList = orderDao.queryAllOrder();
        if (orderDetailList.size() == 0){
            return mOrderList;
        } else {
            return makeList(orderDetailList);
        }
    }

    public List<MOrder> queryOrderByCustomer(String username){
        List<MOrder> mOrderList = new ArrayList<>();

        List<OrderDetail> orderDetailList = orderDao.queryOrderByCID(username);
        if (orderDetailList.size() == 0){
            return mOrderList;
        } else {
            return makeList(orderDetailList);
        }
    }

    public List<MOrder> queryOrderBySeller(String username){
        List<MOrder> mOrderList = new ArrayList<>();

        List<OrderDetail> orderDetailList = orderDao.queryOrderBySID(username);
        if (orderDetailList.size() == 0){
            return mOrderList;
        } else {
            return makeList(orderDetailList);
        }
    }

    private List<MOrder> makeList(List<OrderDetail> orderDetailList){
        List<MOrder> mOrderList = new ArrayList<>();

        String pre = "";
        for(OrderDetail orderDetail : orderDetailList) {
            String o_id = orderDetail.getO_id();
            if (!o_id.equals(pre)) {
                MOrder mOrder = new MOrder();
                mOrder.setO_id(orderDetail.getO_id());
                mOrder.setDate(orderDetail.getDate());
                mOrder.setTotal_price(orderDetail.getTotal_price());
                mOrder.setPayment(orderDetail.getPayment());
                mOrder.setS_id(orderDetail.getS_id());
                mOrder.setS_username(orderDetail.getS_username());
                mOrder.setS_name(orderDetail.getS_name());
                mOrder.setC_id(orderDetail.getC_id());
                mOrder.setC_username(orderDetail.getC_username());
                mOrder.setC_name(orderDetail.getC_name());
                mOrder.setC_city(orderDetail.getC_city());
                mOrder.setC_address(orderDetail.getC_address());
                mOrder.setC_postcode(orderDetail.getC_postcode());
                mOrder.setC_mobile(orderDetail.getC_mobile());
                mOrder.setStatus(orderDetail.getStatus());

                List<ItemDetail> itemList = new ArrayList<>();
                List<Integer> numList = new ArrayList<>();
                String item_id = orderDetail.getI_id();
                itemList.add(itemService.queryItemByItemID(item_id));
                int num = orderDetail.getNum();
                numList.add(num);
                mOrder.setItemList(itemList);
                mOrder.setNumList(numList);
                mOrderList.add(mOrder);

                pre = o_id;
            } else {
                MOrder mOrder = mOrderList.get(mOrderList.size() - 1);
                List<ItemDetail> itemList = mOrder.getItemList();
                List<Integer> numList = mOrder.getNumList();

                String item_id = orderDetail.getI_id();
                itemList.add(itemService.queryItemByItemID(item_id));
                int num = orderDetail.getNum();
                numList.add(num);
                mOrder.setItemList(itemList);
                mOrder.setNumList(numList);
            }
        }

        for(MOrder mOrder : mOrderList){
            mOrder.setBrief(serializeItemList(mOrder));
        }

        return mOrderList;
    }

    public int createOrder(OrderDetail orderDetail){
        Order order = new Order();
        Order_Item order_item = new Order_Item();

        Date d = new Date();
        String o_id = String.valueOf(d.getTime());

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(d);

        order.setO_id(o_id);
        order.setDate(date);
        order.setC_id(orderDetail.getC_id());
        order.setS_id(orderDetail.getS_id());
        order.setTotal_price(orderDetail.getTotal_price());
        order.setPayment(orderDetail.getPayment());
        order.setCity(orderDetail.getC_city());
        order.setAddress(orderDetail.getC_address());
        order.setPostcode(orderDetail.getC_postcode());
        order.setMobile(orderDetail.getC_mobile());
        order.setStatus(orderDetail.getStatus());
        orderDao.insertOrder(order);

        order_item.setO_id(o_id);
        order_item.setI_id(orderDetail.getI_id());
        order_item.setNum(orderDetail.getNum());
        order_item.setPer_price(orderDetail.getPer_price());
        orderDao.insertOrderItem(order_item);

        return 1;
    }

    public int updateOrder(Order order){
        return orderDao.updateOrder(order);
    }

    public int count(){
        return orderDao.queryAllOrder().size();
    }

    public String serializeItemList(MOrder mOrder){
        List<ItemDetail> itemList = mOrder.getItemList();
        List<Integer> numList = mOrder.getNumList();

        List<String> serialize = new ArrayList<>();
        for (int i = 0; i < itemList.size(); i++){
            ItemDetail itemDetail = itemList.get(i);
            String i_id = itemDetail.getI_id();
            String description = itemDetail.getDescription();
            String price = itemDetail.getPrice();
            String num = numList.get(i).toString();
            String json = "{'i_id':'" + i_id + "'," +
                            "'description':'" + description + "'," +
                            "'price':'" + price + "'," +
                            "'num':'" + num + "'}";
            serialize.add(json);
        }
        return serialize.toString();
    }
}
