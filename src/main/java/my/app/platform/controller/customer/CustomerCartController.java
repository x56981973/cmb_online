package my.app.platform.controller.customer;

import my.app.platform.domain.Customer;
import my.app.platform.domain.model.MCart;
import my.app.platform.service.CartService;
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
 *         创建时间：2018-07-17 17:09
 *         创建说明：顾客购物车
 */

@Controller
@RequestMapping(value = "/customer")
public class CustomerCartController {
    @Autowired
    HttpSession session;

    @Autowired
    CartService cartService;

    @Autowired
    CustomerService customerService;

    @RequestMapping(value = "/cart")
    public String customerCart(Model model){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        MCart cart = cartService.queryCartByCustomer(username);
        model.addAttribute("cart", cart);

        Customer customer = customerService.queryCustomerByUsername(username);
        model.addAttribute("customer", customer);

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

    @RequestMapping(value = "/cart/delete", method = RequestMethod.POST)
    @ResponseBody
    public String deleteCart(String i_id){
        String username = session.getAttribute("username").toString();

        if(cartService.deleteCartItem(username, i_id) == 1){
            return "{\"error\":\"0\",\"msg\":\"删除成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"删除失败\"}";
        }
    }

    @RequestMapping(value = "/cart/update_num", method = RequestMethod.POST)
    @ResponseBody
    public String updateItemNum(String i_id, int num){
        String username = session.getAttribute("username").toString();

        if(cartService.updateNum(i_id, num, username) == 1){
            return "{\"error\":\"0\",\"msg\":\"更新成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"删除失败\"}";
        }
    }

}
