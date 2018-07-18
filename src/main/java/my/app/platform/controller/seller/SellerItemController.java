package my.app.platform.controller.seller;

import my.app.platform.domain.Item;
import my.app.platform.domain.ItemClass;
import my.app.platform.domain.Seller;
import my.app.platform.domain.view.ItemDetail;
import my.app.platform.service.ItemService;
import my.app.platform.service.SellerService;
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
 *         创建时间：2018-07-16 01:38
 *         创建说明：
 */

@Controller
@RequestMapping(value = "/seller")
public class SellerItemController {
    @Autowired
    HttpSession session;

    @Autowired
    ItemService itemService;

    @Autowired
    SellerService sellerService;

    @RequestMapping(value = "/item")
    public String sellerItem(Model model){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        List<ItemDetail> itemDetailList = itemService.queryItemBySeller(username);
        model.addAttribute("items", itemDetailList);

        List<ItemClass> itemClassList = itemService.queryItemClass();
        model.addAttribute("itemClass", itemClassList);

        return "/seller/item";
    }

    @RequestMapping(value = "/item/edit/{i_id}")
    public String sellerEditItem(@PathVariable String i_id, Model model){
        ItemDetail itemDetail = itemService.queryItemByItemID(i_id);
        model.addAttribute("i", itemDetail);

        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        return "/seller/editItem";
    }

    @RequestMapping(value = "/item/new")
    public String sellerNewItem(Model model){
        List<ItemClass> itemClassList = itemService.queryItemClass();
        model.addAttribute("itemClass", itemClassList);

        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        return "/seller/addItem";
    }

    @RequestMapping(value = "/item/add", method = RequestMethod.POST)
    @ResponseBody
    public String sellerAddItem(MultipartFile pic, Item item, String username){
        Seller seller = sellerService.querySellerByUsername(username);
        if(seller == null){
            return "{\"error\":\"1\",\"msg\":\"无此用户\"}";
        }
        String s_id = seller.getS_id();
        item.setS_id(s_id);

        if(itemService.addItem(item) == 1){
            String description = item.getDescription();
            ItemDetail itemDetail = itemService.queryItemByName(description, username);
            String i_id = itemDetail.getI_id();
            itemService.updatePic(pic, i_id, username);

            return "{\"error\":\"0\",\"msg\":\"新增成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"新增失败\"}";
        }
    }

    @RequestMapping(value = "/item/delete", method = RequestMethod.POST)
    @ResponseBody
    public String sellerDelItem(String i_id){
        if(itemService.deleteItem(i_id) == 1){
            return "{\"error\":\"0\",\"msg\":\"删除成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"删除失败\"}";
        }
    }

    @RequestMapping(value = "/item/update", method = RequestMethod.POST)
    @ResponseBody
    public String sellerUpdateItem(Item item){
        if(itemService.updateItem(item) == 1){
            return "{\"error\":\"0\",\"msg\":\"修改成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"修改失败\"}";
        }
    }

    @RequestMapping(value = "/item/update_pic", method = RequestMethod.POST)
    @ResponseBody
    public String sellerUpdateItem(MultipartFile pic, String i_id, String username){
        if(itemService.updatePic(pic, i_id, username) == 1){
            return "{\"error\":\"0\",\"msg\":\"修改成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"修改失败\"}";
        }
    }
}
