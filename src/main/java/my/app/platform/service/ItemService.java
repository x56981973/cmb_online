package my.app.platform.service;

import my.app.platform.domain.Item;
import my.app.platform.domain.ItemClass;
import my.app.platform.domain.view.ItemDetail;
import my.app.platform.repository.mapper.item.IItemDao;
import my.app.platform.service.File.UploadFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    UploadFileService uploadFileService;

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
     * @param username 卖家编号
     * @return 属于卖家的商品
     */
    public List<ItemDetail> queryItemBySeller(String username) {
        List<ItemDetail> itemList = itemDao.queryItemBySeller(username);
        if (itemList.size() != 0){
            return itemList;
        } else {
            return null;
        }
    }

    /**
     * 根据分类查询商品
     * @param class_name 分类名
     * @return 属于卖家的商品
     */
    public List<ItemDetail> queryItemByClass(String class_name) {
        List<ItemDetail> itemList = itemDao.queryItemByClass(class_name);
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
     * 删除商品
     * @param i_id 商品编号
     * @return 删除结果
     */
    public int deleteItem(String i_id){
        return itemDao.deleteItem(i_id);
    }

    /**
     * 获取总数
     * @return 总数
     */
    public int count(){
        return itemDao.queryAllItem().size();
    }

    /**
     * 获取分类列表
     * @return 分类
     */
    public List<ItemClass> queryItemClass(){
        return itemDao.queryItemClass();
    }

    /**
     * 更新图片地址
     * @param pic 图片
     * @param i_id 商品id
     * @return 更新结果
     */
    public int updatePic(MultipartFile pic, String i_id, String username){
        String path = uploadFileService.uploadPic(pic, username);
        if("".equals(path)){
            return 0;
        } else {
            return itemDao.updateDetail(i_id, path);
        }
    }

    public ItemDetail queryItemByName(String description, String s_username){
        List<ItemDetail> itemList = itemDao.queryItemByName(description, s_username);
        if (itemList.size() != 0){
            return itemList.get(0);
        } else {
            return null;
        }
    }
}
