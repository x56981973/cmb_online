package my.app.platform.controller.customer;

import my.app.platform.domain.view.ItemDetail;
import my.app.platform.repository.mapper.collection.ICollectionDao;
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
 *         创建时间：2018-07-17 23:44
 *         创建说明：
 */

@Controller
@RequestMapping(value = "/customer")
public class CustomerCollectionController {
    @Autowired
    HttpSession session;

    @Autowired
    ICollectionDao collectionDao;

    @Autowired
    ItemService itemService;

    @RequestMapping(value = "/collection")
    public String customerCollection(Model model){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        List<String> idList = collectionDao.queryCollection(username);
        List<ItemDetail> itemDetailList = new ArrayList<>();
        for(String i : idList){
            ItemDetail itemDetail = itemService.queryItemByItemID(i);
            if(itemDetail != null){
                itemDetailList.add(itemDetail);
            }
        }

        model.addAttribute("items", itemDetailList);
        return "/customer/collection";
    }

    @RequestMapping(value = "/collection/search", method = RequestMethod.GET)
    public String searchCollection(Model model,String keyword){
        String name = session.getAttribute("name").toString();
        String username = session.getAttribute("username").toString();
        model.addAttribute("username", username);
        model.addAttribute("name", name);

        List<String> idList = collectionDao.queryCollection(username);
        List<ItemDetail> itemDetailList = new ArrayList<>();
        for(String i : idList){
            ItemDetail itemDetail = itemService.queryItemByItemID(i);
            if(itemDetail != null){
                itemDetailList.add(itemDetail);
            }
        }

        List<ItemDetail> temp = new ArrayList<>();
        for(ItemDetail item : itemDetailList){
            if(item.getDescription().contains(keyword)){
                temp.add(item);
            }
        }
        model.addAttribute("items", temp);
        model.addAttribute("flag", "search");
        return "/customer/collection";
    }

    @RequestMapping(value = "/collection/delete", method = RequestMethod.POST)
    @ResponseBody
    public String collectionDelete(String i_id){
        String username = session.getAttribute("username").toString();
        if(collectionDao.deleteCollection(username, i_id) == 1){
            return "{\"error\":\"0\",\"msg\":\"删除成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"删除失败\"}";
        }
    }

    @RequestMapping(value = "/collection/add", method = RequestMethod.POST)
    @ResponseBody
    public String collectionAdd(String i_id){
        String username = session.getAttribute("username").toString();

        List<String> idList = collectionDao.queryCollection(username);
        if(idList.contains(i_id)){
            return "{\"error\":\"1\",\"msg\":\"该商品已收藏\"}";
        }

        if(collectionDao.insertCollection(username, i_id) == 1){
            return "{\"error\":\"0\",\"msg\":\"添加成功\"}";
        }else{
            return "{\"error\":\"1\",\"msg\":\"添加失败\"}";
        }
    }
}
