package crwm.site.dao;

import crwm.site.pojo.Food;
import crwm.site.pojo.FoodType;
import crwm.site.pojo.Shop;

import java.util.List;

/**
 * Created by makese on 2017/10/14.
 */
public interface FoodDAO extends BaseDAO<Food> {

	List<Food> getListByType(FoodType type,Shop shop);

	List<Food> getListByShop(Shop currShop);

}
