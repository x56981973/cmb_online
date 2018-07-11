package my.app.platform.repository.mapper.item;

import my.app.platform.domain.Item;
import my.app.platform.domain.view.ItemDetail;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 13:52
 *         创建说明：
 */
public interface IItemDao {
    List<ItemDetail> queryItemByIId(String i_id);

    List<ItemDetail> queryItemBySId(String s_id);

    int updateItem(Item item);

    int addItem(Item item);
}
