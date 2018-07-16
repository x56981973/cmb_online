package my.app.platform.controller;

import my.app.framework.web.Result;
import my.app.framework.web.ResultHelper;
import my.app.platform.repository.mapper.admin.IAdminDao;
import my.app.platform.repository.mapper.seller.ISellerDao;
import my.app.platform.repository.mapper.user.IUserDao;
import my.app.platform.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 09:14
 *         创建说明：接口测试
 */
@RestController
public class TestController {
    @Autowired
    IAdminDao adminDao;

    @Autowired
    IUserDao userDao;

    @Autowired
    CustomerService customerService;

    @Autowired
    ISellerDao sellerDao;

    @Autowired
    SellerService sellerService;

    @Autowired
    ItemService itemService;

    @Autowired
    CartService cartService;

    @Autowired
    OrderService orderService;

    @Autowired
    LogService logService;

    @Autowired
    AdminService adminService;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Result testHandler() {
        return ResultHelper.newSuccessResult(orderService.queryOrderBySeller("uniqlo"));
    }
}
