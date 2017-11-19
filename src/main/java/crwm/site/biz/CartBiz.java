package crwm.site.biz;

import crwm.site.pojo.Cart;
import crwm.site.pojo.Food;
import crwm.site.pojo.User;

public interface CartBiz {

	Cart getCart(int id);

	void deleteCart(Cart cart);

	void deleteCartByUser(User user);
	Cart getUserCart(User user,Food food);
	void update(Cart cart);
	void add(Cart cart);

}
