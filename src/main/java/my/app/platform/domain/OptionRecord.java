package my.app.platform.domain;

/**
 * @author 夏之阳
 *         创建时间：2018-07-11 15:36
 *         创建说明：操作记录
 */

public class OptionRecord {
    /**
     * 用户名
     */
    private String username;

    /**
     * 操作
     */
    private String option_detail;

    /**
     * 操作类别
     */
    private String option_class;

    /**
     * 操作时间
     */
    private String date;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getOption_detail() {
        return option_detail;
    }

    public void setOption_detail(String option_detail) {
        this.option_detail = option_detail;
    }

    public String getOption_class() {
        return option_class;
    }

    public void setOption_class(String option_class) {
        this.option_class = option_class;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
