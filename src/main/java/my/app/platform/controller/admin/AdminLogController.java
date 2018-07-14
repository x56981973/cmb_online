package my.app.platform.controller.admin;

import my.app.platform.domain.LoginRecord;
import my.app.platform.domain.OptionRecord;
import my.app.platform.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-13 21:48
 *         创建说明：
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminLogController {
    @Autowired
    HttpSession session;

    @Autowired
    LogService logService;

    @RequestMapping(value = "/log")
    public String adminLog(Model model){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        List<LoginRecord> loginRecords = logService.queryLogin(username);
        List<OptionRecord> optionRecords = logService.queryOption(username);

        model.addAttribute("loginRecords", loginRecords);
        model.addAttribute("optionRecords", optionRecords);

        return "/admin/log";
    }
}
