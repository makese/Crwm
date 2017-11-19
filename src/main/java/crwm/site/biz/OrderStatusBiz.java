package crwm.site.biz;

import crwm.site.pojo.OrderStatus;

public interface OrderStatusBiz {

	OrderStatus getStatu(int id);
	OrderStatus getOrderStatusByStatus(String string);
}
