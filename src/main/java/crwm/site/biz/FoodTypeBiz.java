package crwm.site.biz;

import crwm.site.pojo.FoodType;
import crwm.site.pojo.Shop;

import java.util.List;

public interface FoodTypeBiz {

	FoodType getFoodType(int id);

	List<FoodType> getFoodTypeListByShop(Shop shop);

	void addFoodType(FoodType foodType);

	void updateFoodType(FoodType foodType);

	void deleteFoodType(FoodType foodType);

}
