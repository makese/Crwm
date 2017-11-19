package crwm.site.dao;

import crwm.site.pojo.ShopType;

/**
 * Created by makese on 2017/10/14.
 */
public interface ShopTypeDAO extends BaseDAO<ShopType> {

	ShopType getTypeByTypeName(String shopType);
}
