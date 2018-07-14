package my.app.platform.controller.admin;

import my.app.platform.domain.view.ItemDetail;
import my.app.platform.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-13 17:21
 *         创建说明：
 */

@Controller
@RequestMapping(value = "/admin")
public class AdminItemController {
    @Autowired
    HttpSession session;

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/item")
    public String adminItem(Model model){
        List<ItemDetail> itemDetailList = itemService.queryAllItem();
        model.addAttribute("items", itemDetailList);

        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        return "/admin/item";
    }
}
