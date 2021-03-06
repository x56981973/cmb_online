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
     * @param username 用户名
     * @return 商家信息
     */
    public Seller querySellerByUsername(String username){
        List<Seller> sellerList = sellerDao.querySeller(username);
        if (sellerList.size() != 0){
            return sellerList.get(0);
        } else {
            return null;
        }
    }

    public List<Seller> queryAllSeller(){
        return sellerDao.queryAllSeller();
    }

    public int insertSeller(Seller seller){
        return sellerDao.insertSeller(seller);
    }

    public int updateSeller(Seller seller){
        return sellerDao.updateSeller(seller);
    }

    public int deleteSeller(String username){
        return sellerDao.deleteSeller(username);
    }

    public int count(){
        return sellerDao.queryAllSeller().size();
    }

    public int updateAccountPwd(String username, String name, String password){
        return sellerDao.updateSellerPwd(username, name, password);
    }

    public int updateAccountName(String username, String name){
        return sellerDao.updateSellerName(username, name);
    }
}
