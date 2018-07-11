package my.app.platform.domain.view;

/**
 * @author 夏之阳
 *         创建时间：2018-07-05 16:56
 *         创建说明：用户视图
 */
public class User {
    //用户名
    private String username;

    //密码
    private String password;

    //姓名
    private String name;

    //角色
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
