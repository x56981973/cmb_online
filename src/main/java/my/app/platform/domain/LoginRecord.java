package my.app.platform.domain;

/**
 * @author 夏之阳
 *         创建时间：2018-07-11 15:36
 *         创建说明：登录记录
 */
public class LoginRecord {
    /**
     * 用户名
     */
    private String username;

    /**
     * 登陆时间
     */
    private String date;

    /**
     * 登陆ip地址
     */
    private String ip_address;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getIp_address() {
        return ip_address;
    }

    public void setIp_address(String ip_address) {
        this.ip_address = ip_address;
    }
}
