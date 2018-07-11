package my.app.platform.domain;

/**
 * @author 夏之阳
 *         创建时间：2018-07-07 17:11
 *         创建说明：
 */
public class Cart_Item {
    //购物车编号
    private String cart_id;

    //商品编号
    private String i_id;

    //商品数量
    private int num;

    public String getCart_id() {
        return cart_id;
    }

    public void setCart_id(String cart_id) {
        this.cart_id = cart_id;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getI_id() {
        return i_id;
    }

    public void setI_id(String i_id) {
        this.i_id = i_id;
    }
}
