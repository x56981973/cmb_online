package my.app.platform.domain.view;

/**
 * @author 夏之阳
 *         创建时间：2018-07-08 16:11
 *         创建说明：
 */
public class CartDetail {

    //买家用户名
    private String username;

    //商品id
    private String i_id;

    //商品数量
    private int num;

    //商品id
    private String s_id;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }
}
