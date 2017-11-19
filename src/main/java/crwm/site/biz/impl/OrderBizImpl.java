package crwm.site.biz.impl;

import crwm.site.biz.OrderBiz;
import crwm.site.dao.OrderDAO;
import crwm.site.pojo.Address;
import crwm.site.pojo.Order;
import crwm.site.pojo.Shop;
import crwm.site.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class OrderBizImpl implements OrderBiz {

	@Resource
	private OrderDAO orderDAO;
	@Override
	public List<Order> getListByShop(Shop shop) {
		
		return orderDAO.getListByShop(shop);
	}
	@Override
	public List<Order> getListByUser(User user,int max,int first) {
		return orderDAO.getListByUser(user,max,first);
	}

	@Override
	public List<Order> getOrderListByFinish(boolean finish) {
		return orderDAO.getOrderListByFinish(finish);
	}

	@Override
	public List<Order> getEvaluteListByUser(User user, int max, int i) {
		return orderDAO.getEvaluteListByUser(user,max,i);
	}
	@Override
	public Order getOrder(int id) {
		
		return orderDAO.get(id);
	}
	
	@Override
	public void updateOrder(int id, int shopScore) {
		orderDAO.updateOrder(id, shopScore);
		
	}
	@Override
	public void delete(Order order) {
		orderDAO.delete(order);
		
	}

	@Override
	public void addOrder(Order order) {
		orderDAO.add(order);
		
	}

	@Override
	public void updateOrder(Order currOrder) {
		orderDAO.update(currOrder);
		
	}
	@Override
	public List<Order> getListByAddress(Address target) {
		
		return orderDAO.getListByAddress(target);
	}

	@Override
	public List<Order> getOrderList() {
		return orderDAO.getList();
	}


}
