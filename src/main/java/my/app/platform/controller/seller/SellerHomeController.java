package my.app.platform.controller.seller;

import my.app.platform.service.ItemService;
import my.app.platform.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @author 夏之阳
 *         创建时间：2018-07-11 16:25
 *         创建说明：卖家主页
 */
@Controller
@RequestMapping(value = "/seller")
public class SellerHomeController {
    @Autowired
    HttpSession session;

    @Autowired
    OrderService orderService;

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/home")
    public String sellerHome(Model model){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        int order_num = orderService.countByUsername(username);
        int not_done_order_num = orderService.countNDByUsername(username);
        int item_num = itemService.count();

        model.addAttribute("username", username);
        model.addAttribute("name", name);

        model.addAttribute("order_num", order_num);
        model.addAttribute("not_done_order_num", not_done_order_num);
        model.addAttribute("item_num", item_num);


        return "/seller/dashboard";
    }
}
