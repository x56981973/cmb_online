package my.app.platform.service;

import my.app.platform.domain.Item;
import my.app.platform.domain.view.ItemDetail;
import my.app.platform.repository.mapper.item.IItemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 16:02
 *         创建说明：商品业务
 */
@Service
public class ItemService {
    @Autowired
    IItemDao itemDao;

    public List<ItemDetail> queryAllItem(){
        return itemDao.queryAllItem();
    }

    /**
     * 根据商品编号查询
     * @param i_id 商品编号
     * @return 商品信息
     */
    public ItemDetail queryItemByItemID(String i_id){
        List<ItemDetail> itemList = itemDao.queryItemByIId(i_id);
        if (itemList.size() != 0){
            return itemList.get(0);
        } else {
            return null;
        }
    }

    /**
     * 根据卖家编号查询商品
     * @param s_id 卖家编号
     * @return 属于卖家的商品
     */
    public List<ItemDetail> queryItemBySellerID(String s_id) {
        List<ItemDetail> itemList = itemDao.queryItemBySId(s_id);
        if (itemList.size() != 0){
            return itemList;
        } else {
            return null;
        }
    }

    /**
     * 更新商品
     * @param item 商品
     * @return 更新结果
     */
    public int updateItem(Item item){
        return itemDao.updateItem(item);
    }


    /**
     * 新增商品
     * @param item 商品
     * @return 更新结果
     */
    public int addItem(Item item){
        return itemDao.addItem(item);
    }

    /**
     * 获取总数
     * @return 总数
     */
    public int count(){
        return itemDao.queryAllItem().size();
    }
}
