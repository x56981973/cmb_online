package my.app.platform.service;

import my.app.platform.domain.Admin;
import my.app.platform.repository.mapper.admin.IAdminDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-14 21:13
 *         创建说明：管理员业务
 */

@Service
public class AdminService {
    @Autowired
    IAdminDao adminDao;

    public int updateAccountPwd(String username, String name, String password){
        return adminDao.updateAdminPwd(username, name, password);
    }

    public int updateAccountName(String username, String name){
        return adminDao.updateAdminName(username, name);
    }

    public Admin queryAdminByUsername(String username){
        List<Admin> adminList = adminDao.queryAdmin(username);
        if (adminList.size() != 0){
            return adminList.get(0);
        } else {
            return null;
        }

    }
}
