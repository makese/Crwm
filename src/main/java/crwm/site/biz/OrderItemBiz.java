package crwm.site.biz;

import java.util.List;

import crwm.site.pojo.OrderItem;

public interface OrderItemBiz {
	void updateScore(int orderId,int foodScore);

	List<OrderItem> getOrderItmList(int orderid);

}
