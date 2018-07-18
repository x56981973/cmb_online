package my.app.platform.controller.customer;

import my.app.platform.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 夏之阳
 *         创建时间：2018-07-17 17:09
 *         创建说明：
 */

@Controller
@RequestMapping(value = "/customer")
public class CustomerCartController {
    @Autowired
    HttpSession session;

    @Autowired
    CartService cartService;

    @RequestMapping(value = "/cart")
    public String customerCart(Model model){

        return "/customer/cart";
    }

    @RequestMapping(value = "/add_to_cart", method = RequestMethod.POST)
    @ResponseBody
    public String insertCart(String i_id){
        String username = session.getAttribute("username").toString();

        if(cartService.insertItem(i_id, username) == 1){
            return "{\"error\":\"0\",\"msg\":\"添加成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"添加失败\"}";
        }
    }

}
