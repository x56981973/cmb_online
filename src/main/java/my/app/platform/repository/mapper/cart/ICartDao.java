package my.app.platform.repository.mapper.cart;

import my.app.platform.domain.Cart;
import my.app.platform.domain.Cart_Item;
import my.app.platform.domain.view.CartDetail;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 15:20
 *         创建说明：
 */
public interface ICartDao {
    List<CartDetail> queryCart(String username);

    int insertCart(String username);

    int deleteCart(String username);

    int updateCart(String username, String price);

    int insertCartItem(String username, String i_id, String num);

    int deleteCartItem(String username, String i_id);

    int updateCartItem(String username, String i_id, int num);
}
