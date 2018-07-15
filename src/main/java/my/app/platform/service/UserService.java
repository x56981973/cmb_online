package my.app.platform.service;

import my.app.platform.domain.LoginRecord;
import my.app.platform.domain.view.User;
import my.app.platform.repository.mapper.log.ILogInfoDao;
import my.app.platform.repository.mapper.user.IUserDao;
import my.app.platform.tool.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-11 15:24
 *         创建说明：用户登录服务
 */
@Service
public class UserService {
    @Autowired
    IUserDao userDao;

    @Autowired
    ILogInfoDao logInfoDao;

    public User loginCheck(String userName, String password){
        List<User> userList = userDao.checkLogin(userName, password);
        if(userList.size() != 0){
            return userList.get(0);
        } else {
            return null;
        }
    }

    public int insertLoginRecord(HttpServletRequest request, String username) {
        //插入登陆记录
        LoginRecord loginRecord = new LoginRecord();
        loginRecord.setUsername(username);

        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
        loginRecord.setDate(date);

        loginRecord.setIp_address(IpUtil.getIpAddr(request));
        return logInfoDao.insertLoginRecord(loginRecord);
    }

    public User queryUser(String username){
        List<User> userList  = userDao.queryUserByUsername(username);
        if(userList.size() != 0){
            return userList.get(0);
        } else {
            return null;
        }
    }

}
