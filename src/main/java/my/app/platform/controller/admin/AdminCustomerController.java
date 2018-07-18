package my.app.platform.controller.admin;

import my.app.platform.domain.Customer;
import my.app.platform.domain.OptionRecord;
import my.app.platform.domain.view.User;
import my.app.platform.service.CustomerService;
import my.app.platform.service.LogService;
import my.app.platform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-12 12:11
 *         创建说明：管理员的用户接口
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminCustomerController {
    @Autowired
    HttpSession session;

    @Autowired
    CustomerService customerService;

    @Autowired
    UserService userService;

    @Autowired
    LogService logService;

    @RequestMapping(value = "/customer")
    public String adminCustomer(Model model){
        List<Customer> customerList = customerService.queryAllCustomer();
        model.addAttribute("customers", customerList);

        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        return "/admin/customer";
    }

    @RequestMapping(value = "/customer/insert", method = RequestMethod.POST)
    @ResponseBody
    public String adminAddCustomer(String username, String name, String password) {
        User user = userService.queryUser(username);
        if (user != null) {
            return "{\"error\":\"1\",\"msg\":\"已存在此用户名\"}";
        }
        if (!username.matches("^([A-Za-z]|[0-9]|[!@#$*,.]){0,}$")) {
            return "{\"error\":\"1\",\"msg\":\"用户名包含非法字符\"}";
        }
        if (!password.matches("^([A-Za-z]|[0-9]|[!@#$*,.]){0,}$")) {
            return "{\"error\":\"1\",\"msg\":\"密码包含非法字符\"}";
        }

        Customer new_customer = new Customer();
        new_customer.setUsername(username);
        new_customer.setName(name);
        new_customer.setPassword(password);
        if (customerService.insertCustomer(new_customer) == 1) {
            String record = "添加顾客：" + username;
//            setOptionRecord(record);

            return "{\"error\":\"0\",\"msg\":\"添加成功\"}";
        } else {
            return "{\"error\":\"1\",\"msg\":\"添加失败\"}";
        }
    }

    @RequestMapping(value = "/customer/delete", method = RequestMethod.POST)
    @ResponseBody
    public String adminDelCustomer(String username){
        if(customerService.deleteCustomer(username) == 1){
            String record = "删除顾客：" + username;
//            setOptionRecord(record);

            return "{\"error\":\"0\",\"msg\":\"删除成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"删除失败\"}";
        }
    }

    @RequestMapping(value = "/customer/update", method = RequestMethod.POST)
    @ResponseBody
    public String adminUpdateCustomer(Customer customer){
        String username = customer.getUsername();
        String password = customer.getPassword();
        if(!username.matches("^([A-Za-z]|[0-9]|[!@#$*,.]){0,}$")){
            return "{\"error\":\"1\",\"msg\":\"用户名包含非法字符\"}";
        }
        if(!password.matches("^([A-Za-z]|[0-9]|[!@#$*,.]){0,}$")){
            return "{\"error\":\"1\",\"msg\":\"密码包含非法字符\"}";
        }

        if(customerService.updateCustomerByAdmin(customer) == 1){
            String record = "修改顾客：" + username;
//            setOptionRecord(record);

            return "{\"error\":\"0\",\"msg\":\"修改成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"修改失败\"}";
        }
    }

    private int setOptionRecord(String record){
        OptionRecord optionRecord = new OptionRecord();

        optionRecord.setUsername(session.getAttribute("username").toString());
        optionRecord.setOption_class("customer");
        optionRecord.setOption_detail(record);

        return logService.insertOptionRecord(optionRecord);
    }
}
