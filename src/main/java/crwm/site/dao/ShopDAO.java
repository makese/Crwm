package crwm.site.dao;

import java.util.List;
import java.util.Set;

import crwm.site.pojo.Shop;
import crwm.site.pojo.ShopType;

/**
 * Created by makese on 2017/10/14.
 */
public interface ShopDAO extends BaseDAO<Shop> {

	Shop searchShopByTel(String tel);

	Shop getShopByLoginId(String loginId);

	Shop getShopByTel(String shopTel);

	List<Shop> getShopByType(ShopType type,boolean verify);

	List<Shop> getShopByName(String searchName,boolean verify);

	List<Shop> getShopListByShopVerify(boolean shopVerify);
}
