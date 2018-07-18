package my.app.platform.domain.model;

import my.app.platform.domain.Item;
import my.app.platform.domain.view.ItemDetail;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 15:34
 *         创建说明：
 */
public class MCart {
    //买家用户名
    private String username;

    //商品id列表
    private List<ItemDetail> itemList;

    //数量
    private List<Integer> numList;

    //总额
    private String total_price;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public List<ItemDetail> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemDetail> itemList) {
        this.itemList = itemList;
    }

    public List<Integer> getNumList() {
        return numList;
    }

    public void setNumList(List<Integer> numList) {
        this.numList = numList;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }
}
