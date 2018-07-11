package my.app.platform.domain;

/**
 * @author 夏之阳
 *         创建时间：2018-07-05 17:06
 *         创建说明：卖家信息
 */
public class Seller {
    //用户id
    private String s_id;

    //用户名
    private String username;

    //姓名
    private String name;

    //密码
    private String password;

    //地址
    private String address;

    //订单
    private String orders;

    //角色
    private String role;

    //状态
    private String status;

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOrders() {
        return orders;
    }

    public void setOrders(String orders) {
        this.orders = orders;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
