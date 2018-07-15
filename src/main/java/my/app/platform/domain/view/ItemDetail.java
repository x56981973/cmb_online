package my.app.platform.domain.view;

/**
 * @author 夏之阳
 *         创建时间：2018-07-08 16:29
 *         创建说明：
 */
public class ItemDetail {
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

    //卖家用户名
    private String s_username;

    //卖家名称
    private String s_name;

    //类别编号
    private String class_id;

    //类别名
    private String class_name;

    public String getI_id() {
        return i_id;
    }

    public void setI_id(String i_id) {
        this.i_id = i_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }

    public String getS_username() {
        return s_username;
    }

    public void setS_username(String s_username) {
        this.s_username = s_username;
    }
}
