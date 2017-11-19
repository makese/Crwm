package crwm.site.biz.impl;

import crwm.site.biz.OrderStatusBiz;
import crwm.site.dao.OrderStatusDAO;
import crwm.site.pojo.OrderStatus;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class OrderStatuBizImpl implements OrderStatusBiz {
	@Resource
	private OrderStatusDAO orderStatusDAO;
	@Override
	public OrderStatus getStatu(int id) {
		// TODO Auto-generated method stub
		return orderStatusDAO.get(id);
	}

	@Override
	public OrderStatus getOrderStatusByStatus(String string) {
		return orderStatusDAO.getOrderStatusByStatus(string);
	}

}
