package my.app.platform.domain;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 09:51
 *         创建说明：购物车
 */
public class Cart {
    //用户名
    private String username;

    //商品编号
    private String i_id;

    //商品数量
    private int num;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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
