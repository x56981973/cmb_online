package my.app.platform.service;

import my.app.platform.domain.model.MCart;
import my.app.platform.domain.view.CartDetail;
import my.app.platform.domain.view.ItemDetail;
import my.app.platform.repository.mapper.cart.ICartDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 15:18
 *         创建说明：购物车组装
 */
@Service
public class CartService {
    @Autowired
    ICartDao cartDao;

    @Autowired
    ItemService itemService;

    /**
     * 查询用户的购物车
     * @param username 用户名
     * @return 购物车模型
     */
    public MCart queryCartByCustomer(String username){
        MCart mCart = new MCart();

        List<CartDetail> cartDetailList = cartDao.queryCart(username);
        if (cartDetailList.size() == 0){
            return mCart;
        }

        CartDetail cartDetail = cartDetailList.get(0);
        mCart.setUsername(cartDetail.getUsername());
        mCart.setCart_id(cartDetail.getCart_id());
        mCart.setTotal_price(cartDetail.getTotal_price());

        List<ItemDetail> itemList = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();

        for(CartDetail cart : cartDetailList) {
            String item_id = cart.getI_id();
            itemList.add(itemService.queryItemByItemID(item_id));
            int num = cart.getNum();
            numList.add(num);
        }

        mCart.setItemList(itemList);
        mCart.setNumList(numList);
        return mCart;
    }

    /**
     * 根据最新价格计算购物车总价
     * @param username 用户名
     * @return 总价
     */
    protected String calculateTotalPrice(String username){
        List<CartDetail> cartDetailList = cartDao.queryCart(username);
        if (cartDetailList.size() == 0){
            return "0";
        }
        double p = 0;
        for (CartDetail cartDetail : cartDetailList){
            String i_id = cartDetail.getI_id();
            int num = cartDetail.getNum();
            ItemDetail itemDetail = itemService.queryItemByItemID(i_id);
            double per_price = Double.parseDouble(itemDetail.getPrice());
            p = p + per_price * num;
        }

        return Double.toString(p);
    }

    /**
     * 更新购物车数量
     * @param i_id 商品编号
     * @param num 商品数量
     * @param username 用户名
     * @return 更新成功
     */
    public int updateNum(String i_id, int num, String username){
        if(num == 0){
            cartDao.deleteCartItem(username, i_id);
        } else {
            cartDao.updateCartItem(username, i_id, num);
        }
        String price = calculateTotalPrice(username);
        cartDao.updateCart(username, price);

        return 1;
    }

    /**
     * 新加入购物车
     * @param username 用户名
     * @param i_id 商品编号
     * @return 更新成功
     */
    public int insertItem(String i_id, String username){
        List<CartDetail> cartDetailList = cartDao.queryCart(username);

        for(CartDetail cartDetail : cartDetailList){
            if(i_id.equals(cartDetail.getI_id())){
                int num = cartDetail.getNum() + 1;
                return updateNum(i_id, num, username);
            }
        }

        cartDao.insertCartItem(username, i_id, "1");
        String price = calculateTotalPrice(username);
        cartDao.updateCart(username, price);

        return 1;
    }
}
