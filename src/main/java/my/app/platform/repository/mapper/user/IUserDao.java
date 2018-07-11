package my.app.platform.repository.mapper.user;

import my.app.platform.domain.view.User;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 13:56
 *         创建说明：用户账号信息
 */
public interface IUserDao {
    /**
     * 登陆验证
     * @param username 用户名
     * @param password 密码
     * @return 用户列表
     */
    List<User> checkLogin(String username, String password);
}
