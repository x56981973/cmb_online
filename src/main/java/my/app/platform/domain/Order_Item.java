package my.app.platform.domain;

/**
 * @author 夏之阳
 *         创建时间：2018-07-07 17:11
 *         创建说明：
 */
public class Order_Item {
    //订单编号
    private String o_id;

    //商品编号
    private String i_id;

    //商品数量
    private int num;

    //单价
    private String per_price;

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
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

    public String getPer_price() {
        return per_price;
    }

    public void setPer_price(String per_price) {
        this.per_price = per_price;
    }
}
