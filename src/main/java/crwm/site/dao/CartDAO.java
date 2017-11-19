package crwm.site.dao;

import crwm.site.pojo.Cart;
import crwm.site.pojo.Food;
import crwm.site.pojo.User;

/**
 * Created by makese on 2017/10/14.
 */
public interface CartDAO extends BaseDAO<Cart> {

	void deleteByUser(User user);
	Cart  getCart(User user,Food food);
	
	
		
	}

	
		
	
	
	

