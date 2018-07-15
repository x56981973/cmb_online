package my.app.platform.controller.admin;

import my.app.platform.domain.Item;
import my.app.platform.domain.ItemClass;
import my.app.platform.domain.OptionRecord;
import my.app.platform.domain.view.ItemDetail;
import my.app.platform.service.ItemService;
import my.app.platform.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

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

    @Autowired
    LogService logService;

    @RequestMapping(value = "/item")
    public String adminItem(Model model){
        List<ItemDetail> itemDetailList = itemService.queryAllItem();
        model.addAttribute("items", itemDetailList);

        List<ItemClass> itemClassList = itemService.queryItemClass();
        model.addAttribute("itemClass", itemClassList);

        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        return "/admin/item";
    }

    @RequestMapping(value = "/item/edit/{i_id}")
    public String adminEditItem(@PathVariable String i_id, Model model){
        ItemDetail itemDetail = itemService.queryItemByItemID(i_id);
        model.addAttribute("i", itemDetail);

        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        return "/admin/editItem";
    }

    @RequestMapping(value = "/item/delete", method = RequestMethod.POST)
    @ResponseBody
    public String adminDelItem(String i_id){
        if(itemService.deleteItem(i_id) == 1){
            String record = "删除商品编号：" + i_id;
//            setOptionRecord(record);

            return "{\"error\":\"0\",\"msg\":\"删除成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"删除失败\"}";
        }
    }

    @RequestMapping(value = "/item/update", method = RequestMethod.POST)
    @ResponseBody
    public String adminUpdateItem(Item item){
        if(itemService.updateItem(item) == 1){
            String record = "修改商品编号：" + item.getI_id();
//            setOptionRecord(record);

            return "{\"error\":\"0\",\"msg\":\"修改成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"修改失败\"}";
        }
    }

    @RequestMapping(value = "/item/updatePic", method = RequestMethod.POST)
    @ResponseBody
    public String adminUpdateItem(MultipartFile pic, String i_id, String username){
        if(itemService.updatePic(pic, i_id, username) == 1){
            String record = "修改商品图片,编号：" + i_id;
//            setOptionRecord(record);

            return "{\"error\":\"0\",\"msg\":\"修改成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"修改失败\"}";
        }
    }

    private int setOptionRecord(String record){
        OptionRecord optionRecord = new OptionRecord();

        optionRecord.setUsername(session.getAttribute("username").toString());
        optionRecord.setOption_class("item");
        optionRecord.setOption_detail(record);

        return logService.insertOptionRecord(optionRecord);
    }
}
