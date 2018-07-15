package my.app.platform.controller.admin;

import my.app.platform.domain.Admin;
import my.app.platform.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/**
 * @author 夏之阳
 *         创建时间：2018-07-14 21:08
 *         创建说明：
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminAccountController {
    @Autowired
    HttpSession session;

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/profile")
    public String adminProfile(Model model){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        Admin admin = adminService.queryAdminByUsername(username);
        model.addAttribute("admin", admin);

        return "/admin/profile";
    }

    @RequestMapping(value = "/account/update/pwd", method = RequestMethod.POST)
    @ResponseBody
    public String adminAccountUpdatePwd(String username, String name, String password){
        if(adminService.updateAccountPwd(username, name, password) == 1){
            return "{\"error\":\"0\",\"msg\":\"修改成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"删除失败\"}";
        }
    }

    @RequestMapping(value = "/account/update/name", method = RequestMethod.POST)
    @ResponseBody
    public String adminAccountUpdateName(String username, String name){
        if(adminService.updateAccountName(username, name) == 1){
            return "{\"error\":\"0\",\"msg\":\"修改成功,请重新登陆\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"删除失败\"}";
        }
    }
}
