package my.app.platform.domain.view;

/**
 * @author 夏之阳
 *         创建时间：2018-07-08 16:11
 *         创建说明：
 */
public class CartDetail {
    //购物车id
    private String cart_id;

    //买家用户名
    private String username;

    //总额
    private String total_price;

    //商品id
    private String i_id;

    //商品数量
    private int num;

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getI_id() {
        return i_id;
    }

    public void setI_id(String i_id) {
        this.i_id = i_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
