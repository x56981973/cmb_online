package my.app.platform.controller.customer;

import my.app.platform.domain.Customer;
import my.app.platform.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 夏之阳
 *         创建时间：2018-07-17 11:09
 *         创建说明：顾客账号管理
 */

@Controller
@RequestMapping(value = "/customer")
public class CustomerAccountController {
    @Autowired
    HttpSession session;

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/profile")
    public String customerProfile(Model model){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        Customer customer = customerService.queryCustomerByUsername(username);
        model.addAttribute("customer", customer);

        return "/customer/profile";
    }

    @RequestMapping(value = "/account/update/pwd", method = RequestMethod.POST)
    @ResponseBody
    public String customerAccountUpdatePwd(String username, String name, String password){
        if (!password.matches("^([A-Za-z]|[0-9]|[!@#$*,.]){0,}$")) {
            return "{\"error\":\"1\",\"msg\":\"密码包含非法字符\"}";
        }
        if(customerService.updateAccountPwd(username, name, password) == 1){
            return "{\"error\":\"0\",\"msg\":\"修改成功,请重新登陆\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"修改失败\"}";
        }
    }

    @RequestMapping(value = "/account/update/info", method = RequestMethod.POST)
    @ResponseBody
    public String customerAccountUpdateInfo(Customer customer){
        if(customerService.updateAccountByCustomer(customer) == 1){
            return "{\"error\":\"0\",\"msg\":\"修改成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"修改失败\"}";
        }
    }
}
