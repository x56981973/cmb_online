package my.app.platform.domain.model;

import my.app.platform.domain.view.ItemDetail;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-07 16:07
 *         创建说明：
 */
public class MOrder {
    //订单编号
    private String o_id;

    //订单日期
    private String date;

    //支付方式
    private String payment;

    //订单总额
    private String total_price;

    //卖家编号
    private String s_id;

    //卖家用户名
    private String s_username;

    //卖家名
    private String s_name;

    //商品id
    private List<ItemDetail> itemList;

    //数量
    private List<Integer> numList;

    //订单状态
    private String status;

    //买家编号
    private String c_id;

    //买家用户名
    private String c_username;

    //买家姓名
    private String c_name;

    //城市
    private String c_city;

    //地址
    private String c_address;

    //邮编
    private String c_postcode;

    //电话
    private String c_mobile;

    public String getO_id() {
        return o_id;
    }

    public void setO_id(String o_id) {
        this.o_id = o_id;
    }

    public String getPayment() {
        return payment;
    }

    public void setPayment(String payment) {
        this.payment = payment;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getS_id() {
        return s_id;
    }

    public void setS_id(String s_id) {
        this.s_id = s_id;
    }

    public String getTotal_price() {
        return total_price;
    }

    public void setTotal_price(String total_price) {
        this.total_price = total_price;
    }

    public String getS_name() {
        return s_name;
    }

    public void setS_name(String s_name) {
        this.s_name = s_name;
    }

    public List<ItemDetail> getItemList() {
        return itemList;
    }

    public void setItemList(List<ItemDetail> itemList) {
        this.itemList = itemList;
    }

    public List<Integer> getNumList() {
        return numList;
    }

    public void setNumList(List<Integer> numList) {
        this.numList = numList;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getC_id() {
        return c_id;
    }

    public void setC_id(String c_id) {
        this.c_id = c_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_city() {
        return c_city;
    }

    public void setC_city(String c_city) {
        this.c_city = c_city;
    }

    public String getC_address() {
        return c_address;
    }

    public void setC_address(String c_address) {
        this.c_address = c_address;
    }

    public String getC_postcode() {
        return c_postcode;
    }

    public void setC_postcode(String c_postcode) {
        this.c_postcode = c_postcode;
    }

    public String getC_mobile() {
        return c_mobile;
    }

    public void setC_mobile(String c_mobile) {
        this.c_mobile = c_mobile;
    }

    public String getS_username() {
        return s_username;
    }

    public void setS_username(String s_username) {
        this.s_username = s_username;
    }

    public String getC_username() {
        return c_username;
    }

    public void setC_username(String c_username) {
        this.c_username = c_username;
    }
}
