package my.app.platform.repository.mapper.user;

import my.app.platform.domain.view.User;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 13:56
 *         创建说明：用户账号信息
 */
public interface IUserDao {

    List<User> checkLogin(String username, String password);

    List<User> queryUserByUsername(String username);
}
