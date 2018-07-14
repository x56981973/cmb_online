package my.app.platform.service;

import my.app.platform.domain.LoginRecord;
import my.app.platform.domain.OptionRecord;
import my.app.platform.repository.mapper.log.ILogInfoDao;
import my.app.platform.tool.IpUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-13 21:53
 *         创建说明：日志服务
 */
@Service
public class LogService {
    @Autowired
    ILogInfoDao logInfoDao;

    public List<LoginRecord> queryLogin(String username){
        return logInfoDao.queryLoginRecord(username);
    }

    public List<OptionRecord> queryOption(String username){
        return logInfoDao.queryOptionRecord(username);
    }

    public int insertLoginRecord(HttpServletRequest request, LoginRecord loginRecord) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
        loginRecord.setDate(date);

        loginRecord.setIp_address(IpUtil.getIpAddr(request));
        return logInfoDao.insertLoginRecord(loginRecord);
    }

    public int insertOptionRecord(OptionRecord optionRecord) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        String date = df.format(new Date());
        optionRecord.setDate(date);

        return logInfoDao.insertOptionRecord(optionRecord);
    }
}
