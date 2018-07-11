package my.app.platform.service;

import my.app.platform.domain.Item;
import my.app.platform.domain.Seller;
import my.app.platform.repository.mapper.seller.ISellerDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-06 16:29
 *         创建说明：商家业务
 */
@Service
public class SellerService {
    @Autowired
    ISellerDao sellerDao;

    /**
     * 查询商家
     * @param s_id 商家id
     * @return 商家信息
     */
    public Seller querySellerBySID(String s_id){
        List<Seller> sellerList = sellerDao.querySeller(s_id);
        if (sellerList.size() != 0){
            return sellerList.get(0);
        } else {
            return null;
        }
    }

    public List<Seller> queryAllSeller(String s_id){
        return sellerDao.queryAllSeller();
    }

    public int insertSeller(Seller seller){
        return sellerDao.insertSeller(seller);
    }

    public int updateSeller(Seller seller){
        return sellerDao.updateSeller(seller);
    }

    public int updateStatus(String s_id, int status){
        return sellerDao.updateStatus(s_id, status);
    }

    public int deleteSeller(String s_id){
        return sellerDao.deleteSeller(s_id);
    }
}
