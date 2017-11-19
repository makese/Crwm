package crwm.site.biz.impl;

import crwm.site.biz.FoodTypeBiz;
import crwm.site.dao.FoodTypeDAO;
import crwm.site.pojo.FoodType;
import crwm.site.pojo.Shop;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FootTypeBizImpl implements FoodTypeBiz {

	@Resource
	private FoodTypeDAO foodTypeDAO;
	@Override
	public FoodType getFoodType(int id) {
		return foodTypeDAO.get(id);
	}

	@Override
	public List<FoodType> getFoodTypeListByShop(Shop shop) {
		return foodTypeDAO.getFoodTypeListByShop(shop);
	}

	@Override
	public void addFoodType(FoodType foodType) {
		foodTypeDAO.add(foodType);
	}

	@Override
	public void updateFoodType(FoodType foodType) {
		foodTypeDAO.update(foodType);
	}

	@Override
	public void deleteFoodType(FoodType foodType) {
		foodTypeDAO.delete(foodType);
	}

}
