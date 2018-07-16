package my.app.platform.controller.seller;

import my.app.platform.domain.model.MOrder;
import my.app.platform.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-16 01:38
 *         创建说明：
 */

@Controller
@RequestMapping(value = "/seller")
public class SellerOrderController {
    @Autowired
    HttpSession session;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/order")
    public String sellerOrder(Model model){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        List<MOrder> orderDetailList = orderService.queryOrderBySeller(username);
        model.addAttribute("orders", orderDetailList);

        return "/seller/order";
    }
}
