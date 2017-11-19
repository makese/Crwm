package crwm.site.dao;

import java.util.List;

import crwm.site.pojo.OrderItem;

/**
 * Created by makese on 2017/10/14.
 */
public interface OrderItemDAO extends BaseDAO<OrderItem> {
	void updateFoodScore(int orderId,int foodScore);

	List<OrderItem> getOrderItmList(int orderid);
}
