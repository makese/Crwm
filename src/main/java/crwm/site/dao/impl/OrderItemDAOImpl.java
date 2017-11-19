package crwm.site.dao.impl;

import crwm.site.biz.OrderBiz;
import crwm.site.dao.OrderItemDAO;
import crwm.site.pojo.Order;
import crwm.site.pojo.OrderItem;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

/**
 * Created by makese on 2017/10/14.
 */
@Repository
public class OrderItemDAOImpl extends BaseDAOImpl<OrderItem> implements OrderItemDAO {
	@Resource
	private OrderBiz orderBiz;
	
	
	@Override
	public void updateFoodScore(int orderId, int foodScore) {
		Order order=orderBiz.getOrder(orderId);
		
	String hql="from OrderItem o where o.order=?";
	List<OrderItem> orderItemList=(List<OrderItem>) getHibernateTemplate().find(hql, order);
		if(orderItemList.size()>0){
			for (OrderItem orderItem : orderItemList) {
					
				
					orderItem.setFoodGrade(foodScore);
					getHibernateTemplate().update(orderItem);
				}
			}
		}
	
	

@Override
public List<OrderItem> getOrderItmList(int orderid) {
	Order order=orderBiz.getOrder(orderid);
	String hql="from OrderItem o where o.order=?";
	List<OrderItem> orderItemList=(List<OrderItem>) getHibernateTemplate().find(hql, order);
	if(orderItemList.size()>0){
		return  orderItemList;
	}else{
		
		return null;
	}

	}	
	
}
