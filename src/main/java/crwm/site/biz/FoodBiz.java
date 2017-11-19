package crwm.site.biz;

import crwm.site.pojo.Food;
import crwm.site.pojo.FoodType;
import crwm.site.pojo.Shop;

import java.util.List;

public interface FoodBiz {

	List<Food> getFoodList();

	List<Food> getFoodListByType(FoodType type, Shop shop);

	List<Food> getFoodListByShop(Shop currShop);

	Food getFoodByid(int id);

	void updateFood(Food food);

	int addFood(Food food);

	void deleteFood(Food food);
}
