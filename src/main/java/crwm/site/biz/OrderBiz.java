package crwm.site.biz;

import crwm.site.pojo.Address;
import crwm.site.pojo.Order;
import crwm.site.pojo.Shop;
import crwm.site.pojo.User;

import java.util.List;

public interface OrderBiz {

	List<Order> getListByShop(Shop shop);

	List<Order> getListByUser(User user,int max,int first);

	List<Order> getOrderListByFinish(boolean finish);

	List<Order> getEvaluteListByUser(User user, int max, int i);

	Order getOrder(int id);

	void updateOrder(int id,int shopScore);

	void delete(Order order);
	
	void addOrder(Order order);

	void updateOrder(Order order);

	List<Order> getListByAddress(Address target);

	List<Order> getOrderList();
}
	
