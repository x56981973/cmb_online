package my.app.platform.controller.customer;

import my.app.platform.domain.model.MOrder;
import my.app.platform.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-17 10:56
 *         创建说明：顾客订单页面
 */

@Controller
@RequestMapping(value = "/customer")
public class CustomerOrderController {
    @Autowired
    HttpSession session;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order")
    public String customerOrder(Model model){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        List<MOrder> orderDetailList = orderService.queryOrderByCustomer(username);
        model.addAttribute("orders", orderDetailList);

        model.addAttribute("flag", "all");

        return "/customer/order";
    }

    @RequestMapping(value = "/not_done_order")
    public String sellerNotDoneOrder(Model model){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        List<MOrder> orderDetailList = orderService.queryNotDoneOrderByCustomer(username);
        model.addAttribute("orders", orderDetailList);

        model.addAttribute("flag", "not_done");

        return "/customer/order";
    }
}
