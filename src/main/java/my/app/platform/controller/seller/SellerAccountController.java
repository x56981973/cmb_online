package my.app.platform.controller.seller;

import my.app.platform.domain.Seller;
import my.app.platform.service.SellerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 夏之阳
 *         创建时间：2018-07-16 01:27
 *         创建说明：商家账号
 */

@Controller
@RequestMapping(value = "/seller")
public class SellerAccountController {
    @Autowired
    HttpSession session;

    @Autowired
    SellerService sellerService;

    @RequestMapping(value = "/profile")
    public String sellerProfile(Model model){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        Seller seller = sellerService.querySellerByUsername(username);
        model.addAttribute("seller", seller);

        return "/seller/profile";
    }

    @RequestMapping(value = "/account/update/pwd", method = RequestMethod.POST)
    @ResponseBody
    public String sellerAccountUpdatePwd(String username, String name, String password){
        if(sellerService.updateAccountPwd(username, name, password) == 1){
            return "{\"error\":\"0\",\"msg\":\"修改成功,请重新登陆\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"删除失败\"}";
        }
    }

    @RequestMapping(value = "/account/update/name", method = RequestMethod.POST)
    @ResponseBody
    public String sellerAccountUpdateName(String username, String name){
        if(sellerService.updateAccountName(username, name) == 1){
            return "{\"error\":\"0\",\"msg\":\"修改成功,请重新登陆\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"删除失败\"}";
        }
    }
}
