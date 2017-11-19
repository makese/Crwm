package crwm.site.biz.impl;

import crwm.site.biz.FoodBiz;
import crwm.site.dao.FoodDAO;
import crwm.site.pojo.Food;
import crwm.site.pojo.FoodType;
import crwm.site.pojo.Shop;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class FoodBizImpl implements FoodBiz {
	@Resource
	private FoodDAO foodDAO;
	@Override
	public List<Food> getFoodList() {
		return foodDAO.getList();
	}
	@Override
	public List<Food> getFoodListByType(FoodType type,Shop shop) {
		return foodDAO.getListByType(type,shop);
	}
	@Override
	public List<Food> getFoodListByShop(Shop currShop) {
		
		return foodDAO.getListByShop(currShop);
	}

	@Override
	public Food getFoodByid(int id) {
		 return foodDAO.get(id);
	}

	@Override
	public void updateFood(Food food) {
		foodDAO.update(food);
	}

	@Override
	public int addFood(Food food) {
		return (int) foodDAO.add(food);
	}

	@Override
	public void deleteFood(Food food) {
		foodDAO.delete(food);
	}

}
