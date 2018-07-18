package my.app.platform.service;

import my.app.platform.domain.Customer;
import my.app.platform.repository.mapper.cart.ICartDao;
import my.app.platform.repository.mapper.customer.ICustomerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-10 15:14
 *         创建说明：顾客业务
 */
@Service
public class CustomerService {
    @Autowired
    ICustomerDao customerDao;

    public int insertCustomer(Customer customer){
        if (customerDao.insertCustomer(customer) == 1){
            return 1;
        } else {
            return 0;
        }
    }

    public int updateCustomerByAdmin(Customer customer){
        return customerDao.updateCustomerByAdmin(customer);
    }

    public List<Customer> queryAllCustomer(){
        return customerDao.queryAllCustomer();
    }

    public Customer queryCustomerByUsername(String username){
        List<Customer> customerList = customerDao.queryCustomerByName(username);
        if (customerList.size() == 0){
            return null;
        } else {
            return customerList.get(0);
        }
    }

    public int deleteCustomer(String username){
        if (customerDao.deleteCustomer(username) == 1){
            return 1;
        } else {
            return 0;
        }
    }

    public int count(){
        return customerDao.queryAllCustomer().size();
    }

    public int updateAccountPwd(String username, String name, String password){
        return customerDao.updateCustomerPwd(username, name, password);
    }

    public int updateAccountByCustomer(Customer customer){
        return customerDao.updateAccountByCustomer(customer);
    }

    public String getId(String username){
        return queryCustomerByUsername(username).getC_id();
    }
}
