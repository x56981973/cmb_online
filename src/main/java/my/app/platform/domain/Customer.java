package my.app.platform.domain;

/**
 * @author 夏之阳
 *         创建时间：2018-07-05 16:59
 *         创建说明：买家信息
 */
public class Customer {
    //用户id
    private String c_id;

    //用户名
    private String username;

    //姓名
    private String name;

    //密码
    private String password;

    //城市
    private String city;

    //地址
    private String address;

    //邮编
    private String postcode;

    //电话
    private String mobile;

    //默认支付
    private String default_payment;

    //角色
    private String role;

    //状态
    private String status;

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getDefault_payment() {
        return default_payment;
    }

    public void setDefault_payment(String default_payment) {
        this.default_payment = default_payment;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
