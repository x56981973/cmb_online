package my.app.platform.controller.admin;

import my.app.platform.service.CustomerService;
import my.app.platform.service.ItemService;
import my.app.platform.service.OrderService;
import my.app.platform.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 夏之阳
 *         创建时间：2018-07-11 16:17
 *         创建说明：管理员主页
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminHomeController {
    @Autowired
    HttpSession session;

    @Autowired
    SellerService sellerService;

    @Autowired
    CustomerService customerService;

    @Autowired
    OrderService orderService;

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/home")
    public String adminHome(Model model){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        int seller_num = sellerService.count();
        int order_num = orderService.count();
        int item_num = itemService.count();
        int customer_num = customerService.count();

        model.addAttribute("username", username);
        model.addAttribute("name", name);
        model.addAttribute("seller_num", seller_num);
        model.addAttribute("order_num", order_num);
        model.addAttribute("item_num", item_num);
        model.addAttribute("customer_num", customer_num);

        return "/admin/dashboard";
    }
}
