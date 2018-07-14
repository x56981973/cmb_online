package my.app.platform.controller.admin;

import my.app.platform.domain.OptionRecord;
import my.app.platform.domain.Seller;
import my.app.platform.domain.view.User;
import my.app.platform.service.LogService;
import my.app.platform.service.SellerService;
import my.app.platform.service.UserService;
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
 *         创建时间：2018-07-14 16:56
 *         创建说明：
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminSellerController {
    @Autowired
    HttpSession session;

    @Autowired
    SellerService sellerService;

    @Autowired
    UserService userService;

    @Autowired
    LogService logService;

    @RequestMapping(value = "/seller")
    public String adminSeller(Model model){
        List<Seller> sellerList = sellerService.queryAllSeller();
        model.addAttribute("sellers", sellerList);

        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        return "/admin/seller";
    }

    @RequestMapping(value = "/seller/insert", method = RequestMethod.POST)
    @ResponseBody
    public String adminAddSeller(String username, String name, String password){
        User user = userService.queryUser(username);
        if(user != null){
            return "{\"error\":\"1\",\"msg\":\"已存在此用户名\"}";
        }
        if(!username.matches("^([A-Za-z]|[0-9]|[!@#$*,.]){0,}$")){
            return "{\"error\":\"1\",\"msg\":\"用户名包含非法字符\"}";
        }
        if(!password.matches("^([A-Za-z]|[0-9]|[!@#$*,.]){0,}$")){
            return "{\"error\":\"1\",\"msg\":\"密码包含非法字符\"}";
        }

        Seller new_seller = new Seller();
        new_seller.setUsername(username);
        new_seller.setName(name);
        new_seller.setPassword(password);
        if(sellerService.insertSeller(new_seller) == 1){
            String record = "添加商家：" + username;
            setOptionRecord(record);

            return "{\"error\":\"0\",\"msg\":\"添加成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"添加失败\"}";
        }
    }

    @RequestMapping(value = "/seller/delete", method = RequestMethod.POST)
    @ResponseBody
    public String adminDelSeller(String username){
        if(sellerService.deleteSeller(username) == 1){
            String record = "删除商家：" + username;
            setOptionRecord(record);

            return "{\"error\":\"0\",\"msg\":\"删除成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"删除失败\"}";
        }
    }

    @RequestMapping(value = "/seller/update", method = RequestMethod.POST)
    @ResponseBody
    public String adminUpdateSeller(Seller seller){
        String username = seller.getUsername();
        String password = seller.getPassword();
        if(!username.matches("^([A-Za-z]|[0-9]|[!@#$*,.]){0,}$")){
            return "{\"error\":\"1\",\"msg\":\"用户名包含非法字符\"}";
        }
        if(!password.matches("^([A-Za-z]|[0-9]|[!@#$*,.]){0,}$")){
            return "{\"error\":\"1\",\"msg\":\"密码包含非法字符\"}";
        }

        if(sellerService.updateSeller(seller) == 1){
            String record = "修改商家：" + username;
            setOptionRecord(record);

            return "{\"error\":\"0\",\"msg\":\"修改成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"修改失败\"}";
        }
    }

    private int setOptionRecord(String record){
        OptionRecord optionRecord = new OptionRecord();

        optionRecord.setUsername(session.getAttribute("username").toString());
        optionRecord.setOption_class("seller");
        optionRecord.setOption_detail(record);

        return logService.insertOptionRecord(optionRecord);
    }
}
