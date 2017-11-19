package crwm.site.dao;

import crwm.site.pojo.OrderStatus;

/**
 * Created by makese on 2017/10/14.
 */
public interface OrderStatusDAO extends BaseDAO<OrderStatus> {
    OrderStatus getOrderStatusByStatus(String status);
}
