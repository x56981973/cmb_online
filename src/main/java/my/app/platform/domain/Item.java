package my.app.platform.domain;

/**
 * @author 夏之阳
 *         创建时间：2018-07-05 17:21
 *         创建说明：商品信息
 */
public class Item {
    //商品id
    private String i_id;

    //商品描述
    private String description;

    //价格
    private String price;

    //商品细节
    private String detail;

    //库存
    private int stock;

    //所属卖家
    private String s_id;

    //类别
    private String class_id;

    public String getI_id() {
        return i_id;
    }

    public void setI_id(String i_id) {
        this.i_id = i_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }
}
