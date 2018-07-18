package my.app.platform.controller.customer;

import my.app.platform.domain.view.ItemDetail;
import my.app.platform.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-11 16:20
 *         创建说明：商品界面
 */
@Controller
@RequestMapping(value = "/customer")
public class CustomerHomeController {
    @Autowired
    HttpSession session;

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/home")
    public String itemHome(Model model){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        List<ItemDetail> itemDetailList = itemService.queryAllItem();
        model.addAttribute("items", itemDetailList);

        return "/customer/home";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public String searchHome(Model model,String keyword){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        List<ItemDetail> itemDetailList = itemService.queryAllItem();
        List<ItemDetail> temp = new ArrayList<>();
        for(ItemDetail item : itemDetailList){
            if(item.getDescription().contains(keyword)){
                temp.add(item);
            }
        }
        model.addAttribute("items", temp);
        model.addAttribute("flag", "search");

        return "/customer/home";
    }

    @RequestMapping(value = "/class", method = RequestMethod.GET)
    public String classHome(Model model,String class_name){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        List<ItemDetail> itemDetailList = itemService.queryItemByClass(class_name);

        model.addAttribute("items", itemDetailList);
        model.addAttribute("flag", class_name);

        return "/customer/home";
    }
}
