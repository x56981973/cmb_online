package my.app.platform.repository.mapper.customer;

import my.app.platform.domain.Customer;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 13:51
 *         创建说明：
 */
public interface ICustomerDao {
    List<Customer> queryAllCustomer();

    List<Customer> queryCustomerByName(String username);

    int insertCustomer(Customer customer);

    int updateCustomerByAdmin(Customer customer);

    int deleteCustomer(String username);

    int updateCustomerPwd(String username, String name, String password);

    int updateAccountByCustomer(Customer customer);
}
