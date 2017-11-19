package crwm.site.dao;

import crwm.site.pojo.FoodType;
import crwm.site.pojo.Shop;

import java.util.List;

/**
 * Created by makese on 2017/10/14.
 */
public interface FoodTypeDAO extends BaseDAO<FoodType> {
    List<FoodType> getFoodTypeListByShop(Shop shop);
}
