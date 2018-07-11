package my.app.platform.controller.seller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 夏之阳
 *         创建时间：2018-07-11 16:25
 *         创建说明：卖家主页
 */
@Controller
@RequestMapping(value = "/seller")
public class SellerHomeController {
    @RequestMapping(value = "/home")
    public String sellerHome(Model model){
        return "/seller/dashboard";
    }
}
