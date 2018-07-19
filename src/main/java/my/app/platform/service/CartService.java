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
            mCart.setTotal_price("0");
            return mCart;
        }

        CartDetail cartDetail = cartDetailList.get(0);
        mCart.setUsername(cartDetail.getUsername());

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

        String total_price = calculateTotalPrice(cartDetailList);
        mCart.setTotal_price(total_price);

        return mCart;
    }

    /**
     * 根据最新价格计算购物车总价
     * @param cartDetailList 购物车列表
     * @return 总价
     */
    private String calculateTotalPrice(List<CartDetail> cartDetailList){
        double p = 0;
        for (CartDetail cartDetail : cartDetailList){
            String i_id = cartDetail.getI_id();
            int num = cartDetail.getNum();
            ItemDetail itemDetail = itemService.queryItemByItemID(i_id);
            if(itemDetail.getStock() != 0) {
                double per_price = Double.parseDouble(itemDetail.getPrice());
                p = p + per_price * num;
            }
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
        return cartDao.updateCartItem(username, i_id, num);
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

        return cartDao.insertCartItem(username, i_id, "1");
    }

    /**
     * 删除购物车中的物品
     * @param username 用户名
     * @param i_id 商品id
     * @return 删除成功
     */
    public int deleteCartItem(String username, String i_id){
        if(cartDao.deleteCartItem(username, i_id) == 1){
            return 1;
        }else{
            return 0;
        }
    }
}
