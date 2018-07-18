package my.app.platform.repository.mapper.item;

import my.app.platform.domain.Item;
import my.app.platform.domain.ItemClass;
import my.app.platform.domain.view.ItemDetail;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 13:52
 *         创建说明：
 */
public interface IItemDao {
    List<ItemDetail> queryAllItem();

    List<ItemDetail> queryItemByIId(String i_id);

    List<ItemDetail> queryItemBySeller(String username);

    List<ItemDetail> queryItemByClass(String class_name);

    int updateItem(Item item);

    int addItem(Item item);

    int deleteItem(String i_id);

    List<ItemClass> queryItemClass();

    int updateDetail(String i_id, String detail);

    List<ItemDetail> queryItemByName(String description, String s_username);
}
