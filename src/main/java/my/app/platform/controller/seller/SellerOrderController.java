package my.app.platform.controller.seller;

import my.app.platform.domain.model.MOrder;
import my.app.platform.service.OrderService;
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
 *         创建时间：2018-07-16 01:38
 *         创建说明：卖家订单
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

        model.addAttribute("flag", "all");

        return "/seller/order";
    }

    @RequestMapping(value = "/done_order")
    public String sellerDoneOrder(Model model){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        List<MOrder> orderDetailList = orderService.queryDoneOrderBySeller(username);
        model.addAttribute("orders", orderDetailList);

        model.addAttribute("flag", "done");

        return "/seller/order";
    }

    @RequestMapping(value = "/not_done_order")
    public String sellerNotDoneOrder(Model model){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        List<MOrder> orderDetailList = orderService.queryNotDoneOrderBySeller(username);
        model.addAttribute("orders", orderDetailList);

        model.addAttribute("flag", "not_done");

        return "/seller/order";
    }

    @RequestMapping(value = "/order/confirm", method = RequestMethod.POST)
    @ResponseBody
    public String sellerConfirmDeliver(String o_id){
        if(orderService.confirmDeliver(o_id) == 1){
            return "{\"error\":\"0\",\"msg\":\"确认发货成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"确认发货失败\"}";
        }
    }
}
