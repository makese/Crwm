package crwm.site.dao.impl;

import crwm.site.dao.FoodDAO;
import crwm.site.pojo.Food;
import crwm.site.pojo.FoodType;
import crwm.site.pojo.Shop;

import java.util.List;

import org.springframework.stereotype.Repository;

/**
 * Created by makese on 2017/10/14.
 */
@Repository
public class FoodDAOImpl extends BaseDAOImpl<Food> implements FoodDAO{

	@Override
	public List<Food> getListByType(FoodType type,Shop shop) {
		String hql="from Food f where f.foodType=? and f.shop=?";
		List<Food> foodList=(List<Food>) getHibernateTemplate().find(hql, type,shop);
		if(foodList.size()>0){
			
			return foodList;
			
		}else{
			return null;
			
		}
		
	}

	@Override
	public List<Food> getListByShop(Shop currShop) {
		String hql="from Food f where f.shop=?";
		List<Food> foodList=(List<Food>) getHibernateTemplate().find(hql, currShop);
		if(foodList.size()>0){
			
			return foodList;
			
		}else{
			return null;
			
		}
	}


}
