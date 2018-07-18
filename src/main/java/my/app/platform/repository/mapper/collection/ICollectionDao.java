package my.app.platform.repository.mapper.collection;

import java.util.List;

/**
 * @author 夏之阳
 *         创建时间：2018-07-17 16:24
 *         创建说明：收藏夹
 */
public interface ICollectionDao {
    List<String> queryCollection(String username);

    int insertCollection(String username, String i_id);

    int deleteCollection(String username, String i_id);
}
