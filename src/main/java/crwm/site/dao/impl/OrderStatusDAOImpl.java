package crwm.site.dao.impl;

import crwm.site.dao.OrderStatusDAO;
import crwm.site.pojo.OrderStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by makese on 2017/10/14.
 */
@Repository
public class OrderStatusDAOImpl extends BaseDAOImpl<OrderStatus> implements OrderStatusDAO {
    @Override
    public OrderStatus getOrderStatusByStatus(String status) {
        String hql = "from OrderStatus o where o.status = ?";
        List<OrderStatus> orderStatusList = (List<OrderStatus>) super.getHibernateTemplate().find(hql, status);
        if(orderStatusList.size() > 0 ){
            return orderStatusList.get(0);
        } else {
            return null;
        }
    }
}
