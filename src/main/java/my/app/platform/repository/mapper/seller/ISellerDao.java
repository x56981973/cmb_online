package my.app.platform.repository.mapper.seller;

import my.app.platform.domain.Seller;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 13:54
 *         创建说明：
 */
public interface ISellerDao {
    List<Seller> queryAllSeller();

    List<Seller> querySeller(String s_id);

    int insertSeller(Seller seller);

    int updateSeller(Seller seller);

    int updateStatus(String s_id, int status);

    int deleteSeller(String s_id);
}
