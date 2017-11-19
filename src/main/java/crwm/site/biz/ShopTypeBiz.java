package crwm.site.biz;

import crwm.site.pojo.ShopType;

import java.util.Set;

public interface ShopTypeBiz {

	void addShopType(ShopType shopType);

	void deleteShopType(ShopType shopType);

	void updateShopType(ShopType shopType);

	Set<ShopType> getSet();

	ShopType getTypeByTypeName(String shopType);

}
