package crwm.site.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import crwm.site.dao.CartDAO;
import crwm.site.pojo.Cart;
import crwm.site.pojo.Food;
import crwm.site.pojo.User;

/**
 * Created by makese on 2017/10/14.
 */
@Repository
public class CartDAOImpl extends BaseDAOImpl<Cart> implements CartDAO {
	private Cart cart;
	
	

	@Override
	public void deleteByUser(User user) {
		String hql="delete from Cart c where c.user=?";
		getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql).setParameter(0, user).executeUpdate();
	}

	@Override
	public Cart getCart(User user, Food food) {
		String hql="from Cart c where c.user=? and c.food=?";
	    List<Cart> cartList=(List<Cart>) getHibernateTemplate().find(hql, user,food);
	    if(cartList!= null &&cartList.size()>0){
	      cart=cartList.get(0); 
	      return cart; }
	    else{
	    	return null;
	    }
	   
	
	    
		
	}
	}