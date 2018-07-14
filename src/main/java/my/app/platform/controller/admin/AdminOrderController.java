package my.app.platform.controller.admin;

import my.app.platform.domain.model.MOrder;
import my.app.platform.domain.view.OrderDetail;
import my.app.platform.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-13 16:53
 *         创建说明：
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminOrderController {
    @Autowired
    HttpSession session;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order")
    public String adminOrder(Model model){
        List<MOrder> orderDetailList = orderService.queryAllOrders();
        model.addAttribute("orders", orderDetailList);

        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        return "/admin/order";
    }
}
