package crwm.site.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import crwm.site.biz.CartBiz;
import crwm.site.dao.CartDAO;
import crwm.site.pojo.Cart;
import crwm.site.pojo.Food;
import crwm.site.pojo.User;
@Service
public class CartBizImpl implements CartBiz {
	@Resource
	private CartDAO cartDAO;
	@Override
	public Cart getCart(int id) {
		// TODO Auto-generated method stub
		return cartDAO.get(id);
	}
	@Override
	public void deleteCart(Cart cart) {
		cartDAO.delete(cart);
		
	}
	@Override
	public void deleteCartByUser(User user) {
		cartDAO.deleteByUser(user);
		
	}
	@Override
	public Cart getUserCart(User user, Food food) {
		return cartDAO.getCart(user, food);
		
	}
	@Override
	public void update(Cart cart) {
		cartDAO.update(cart);
		
	}
	@Override
	public void add(Cart cart) {
		cartDAO.add(cart);
		
	}

}
