package my.app.platform.domain;

/**
 * @author 夏之阳
 *         创建时间：2018-07-05 22:09
 *         创建说明：商品分类
 */
public class ItemClass {
    //分类id
    private String class_id;

    //分类名称
    private String class_name;

    public String getClass_id() {
        return class_id;
    }

    public void setClass_id(String class_id) {
        this.class_id = class_id;
    }

    public String getClass_name() {
        return class_name;
    }

    public void setClass_name(String class_name) {
        this.class_name = class_name;
    }
}
