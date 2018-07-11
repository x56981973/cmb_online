package my.app.platform.controller;

import my.app.framework.web.Result;
import my.app.framework.web.ResultHelper;
import my.app.platform.domain.Customer;
import my.app.platform.repository.mapper.admin.IAdminDao;
import my.app.platform.repository.mapper.seller.ISellerDao;
import my.app.platform.repository.mapper.user.IUserDao;
import my.app.platform.service.CartService;
import my.app.platform.service.CustomerService;
import my.app.platform.service.ItemService;
import my.app.platform.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
    ItemService itemService;

    @Autowired
    CartService cartService;

    @Autowired
    OrderService orderService;

    @RequestMapping(value = "/test", method = RequestMethod.POST)
    public Result testHandler(Customer customer) {
        return ResultHelper.newSuccessResult(customerService.updateCustomer(customer));
    }
}
