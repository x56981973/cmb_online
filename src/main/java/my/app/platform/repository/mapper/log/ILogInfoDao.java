package my.app.platform.repository.mapper.log;

import my.app.platform.domain.LoginRecord;
import my.app.platform.domain.OptionRecord;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-11 15:39
 *         创建说明：日志接口
 */
public interface ILogInfoDao {
    //插入登陆记录
    int insertLoginRecord(LoginRecord loginRecord);

    //插入操作记录
    int insertOptionRecord(OptionRecord optionRecord);

    //查询近x条的登录记录
    List<LoginRecord> queryLoginRecord(String uid);

    //查询近x条的操作记录
    List<OptionRecord> queryOptionRecord(String uid);
}
