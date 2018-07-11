package my.app.platform.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 夏之阳
 *         创建时间：2018-07-11 16:17
 *         创建说明：管理员主页
 */
@Controller
@RequestMapping(value = "/admin")
public class AdminHomeController {
    @RequestMapping(value = "/home")
    public String adminHome(Model model){
        return "/admin/dashboard";
    }
}
