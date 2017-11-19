package crwm.site.dao;

import crwm.site.pojo.Address;
import crwm.site.pojo.Order;
import crwm.site.pojo.Shop;
import crwm.site.pojo.User;

import java.util.List;

/**
 * Created by makese on 2017/10/14.
 */
public interface OrderDAO extends BaseDAO<Order> {

	List<Order> getListByShop(Shop shop);

	List<Order> getListByUser(User user,int max,int first);

	List<Order> getEvaluteListByUser(User user, int max, int i);
	void updateOrder(int id,int shopScore);


	List<Order> getOrderListByFinish(boolean finish);

	List<Order> getListByAddress(Address target);
}
