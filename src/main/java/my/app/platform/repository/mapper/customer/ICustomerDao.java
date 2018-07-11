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

    List<Customer> queryCustomerByCID(String c_id);

    List<Customer> queryCustomerByName(String username);

    int insertCustomer(Customer customer);

    int updateCustomer(Customer customer);

    int updateStatus(String c_id, int status);

    int deleteCustomer(String c_id);
}
