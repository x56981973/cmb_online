package my.app.platform.controller.customer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 夏之阳
 *         创建时间：2018-07-11 16:20
 *         创建说明：商品界面
 */
@Controller
public class CustomerHomeController {
    @RequestMapping(value = "/customer")
    public String itemHome(Model model){
        return "/customer/home";
    }
}
