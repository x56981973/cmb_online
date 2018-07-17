package my.app.platform.repository.mapper.order;

import my.app.platform.domain.Order;
import my.app.platform.domain.Order_Item;
import my.app.platform.domain.view.OrderDetail;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 13:54
 *         创建说明：
 */
public interface IOrderDao {
    List<OrderDetail> queryAllOrder();

    List<OrderDetail> queryOrderByCID(String username);

    List<OrderDetail> queryOrderBySID(String username);

    List<OrderDetail> queryDoneOrderBySID(String username);

    List<OrderDetail> queryNotDoneOrderBySID(String username);

    int insertOrder(Order order);

    int insertOrderItem(Order_Item order_item);

    int confirmDeliver(String o_id);

    int confirmReceive(String o_id);
}
