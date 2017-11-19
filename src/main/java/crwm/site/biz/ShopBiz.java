package crwm.site.biz;

import java.io.Serializable;
import java.util.List;

import crwm.site.pojo.Shop;
import crwm.site.pojo.ShopType;

public interface ShopBiz {

	Shop getUser(String tel);

	Serializable addShop(Shop shop);

	Shop getShop(Serializable id);

	Shop getShopByLoginId(String loginId);

	Shop getShopByTel(String shopTel);

	void update(Shop shop);

	List<Shop> getShopByType(ShopType type,boolean verify);

	List<Shop> searchShopByName(String searchName,boolean verify);

	List<Shop> getShopListByShopVerify(Boolean shopVerify);

	List<Shop> getShopList();
}
