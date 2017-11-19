package crwm.site.biz.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import crwm.site.biz.OrderItemBiz;

import crwm.site.dao.OrderItemDAO;
import crwm.site.pojo.OrderItem;
@Service
public class OrderItemBizImpl implements OrderItemBiz {
	@Resource
	private OrderItemDAO orderItemDAO;
	@Override
	public void updateScore(int orderId, int foodScore) {
		orderItemDAO.updateFoodScore(orderId, foodScore);
		
	}
	@Override
	public List<OrderItem> getOrderItmList(int orderid) {
		// TODO Auto-generated method stub
		return orderItemDAO.getOrderItmList(orderid);
	}

}
