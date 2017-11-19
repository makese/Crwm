package crwm.site.dao.impl;

import crwm.site.dao.OrderDAO;
import crwm.site.pojo.Address;
import crwm.site.pojo.Order;
import crwm.site.pojo.Shop;
import crwm.site.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by makese on 2017/10/14.
 */
@Repository
public class OrderDAOImpl extends BaseDAOImpl<Order> implements OrderDAO {

	@Override
	public List<Order> getListByShop(Shop shop) {
		String hql="from Order o where o.shop=? order by orderTime desc";
		 List<Order>  orderList=(List<Order>) getHibernateTemplate().find(hql, shop);
		if(orderList.size()>0){
			
			return orderList;
		}else{
			
			return null;
		}
	}

	@Override
	public List<Order> getListByUser(User user,int max,int first) {
		String hql="from Order o where o.user=? order by orderTime desc";
		 List<Order>  orderList=(List<Order>)  getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql).setFirstResult(first).setMaxResults(max).setParameter(0, user).list();
		 if(orderList.size()>0){
				
				return orderList;
			}else{
				
				return null;
			}
	}

	@Override
	public List<Order> getEvaluteListByUser(User user, int max, int i) {
		String hql="from Order o where o.user=? and o.shopGrade=0 order by orderTime desc";
		 List<Order>  orderList=(List<Order>)  getHibernateTemplate().getSessionFactory().getCurrentSession().createQuery(hql).setFirstResult(i).setMaxResults(max).setParameter(0, user).list();
		 if(orderList.size()>0){
				
				return orderList;
			}else{
				
				return null;
			}
	}

	@Override
	public void updateOrder(int id, int score) {
		Order order=getHibernateTemplate().load(Order.class, id);
		order.setShopGrade(score);
		getHibernateTemplate().update(order);}

	
	

	

	



	@Override
	public List<Order> getOrderListByFinish(boolean finish) {
		String hql = "";
		if(finish){
			hql = "from Order o where o.orderStatus.status = '完成'";
		} else {
			hql = "from Order o where o.orderStatus.status != '完成'";
		}

		return (List<Order>) super.getHibernateTemplate().find(hql);
	}

	@Override
	public List<Order> getListByAddress(Address target) {
		String hql="from Order o where o.address=? order by orderTime desc";
		 List<Order>  orderList=(List<Order>)  getHibernateTemplate().find(hql, target);
		 if(orderList.size()>0){
				
				return orderList;
			}else{
				
				return null;
			}
	}
}
