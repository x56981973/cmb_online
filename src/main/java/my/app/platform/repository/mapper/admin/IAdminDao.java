package my.app.platform.repository.mapper.admin;

import my.app.platform.domain.Admin;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 09:08
 *         创建说明：管理员查询接口
 */
public interface IAdminDao {
    List<Admin> queryAllAdmin();

    List<Admin> queryAdmin(String username);

    int updateAdminPwd(String username, String name, String password);

    int updateAdminName(String username, String name);
}
