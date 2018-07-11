package my.app.platform.domain;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 09:51
 *         创建说明：购物车
 */
public class Cart {
    //购物车id
    private String cart_id;

    //买家id
    private String c_id;

    //总额
    private String price;

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
