package crwm.site.action;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import crwm.site.biz.AddressBiz;
import crwm.site.biz.CartBiz;
import crwm.site.biz.FoodBiz;
import crwm.site.biz.OrderBiz;
import crwm.site.biz.OrderStatusBiz;
import crwm.site.biz.ShopBiz;
import crwm.site.biz.UserBiz;
import crwm.site.pojo.Address;
import crwm.site.pojo.Cart;
import crwm.site.pojo.Food;
import crwm.site.pojo.Order;
import crwm.site.pojo.OrderItem;
import crwm.site.pojo.Shop;
import crwm.site.pojo.User;

@Controller
@Scope("prototype")
public class CartDoAction {
	private String result;
	private Cart cart;
	private Food food;
	@Resource
	private FoodBiz foodBiz;
	@Resource
	private CartBiz cartBiz;
	private Cart currCart;
	private Object cartSetObj;
	private Set<Cart> cartSet;
	private Cart target;
	private Order order;
	@Resource
	private ShopBiz shopBiz;
	@Resource
	private UserBiz userBiz;
	@Resource
	private OrderBiz orderBiz;
	@Resource
	private OrderStatusBiz orderStatusBiz;
	@Resource
	private AddressBiz addressBiz;
	private User user;
	private Object userObj;
	private Object foodObj;
	private Shop shop;
	private Address address;
	private Order currOrder;
	public String deleteCart(){
		cartSetObj=ActionContext.getContext().getSession().get("cartSet");
			if(cartSetObj!=null){
				cartSet=(Set<Cart>) cartSetObj;
				for (Cart cart : cartSet) {
					if(cart.getId()==cart.getId()){
						
						target=cart;
						
					}
				}
				cartSet.remove(target);
				ActionContext.getContext().getSession().put("cartSet",cartSet);
				currCart=cartBiz.getCart(cart.getId());
				cartBiz.deleteCart(currCart);
				
			}
			
			
		
		return "success";
		
	}
	
	public String makeOrder(){
		userObj=ActionContext.getContext().getSession().get("user");
		
		if(userObj!=null){
			user=(User)userObj;
			User currUser=userBiz.getUser(user);
			order=new Order();
			cartSet=(Set<Cart>) ActionContext.getContext().getSession().get("cartSet");
			Date date=new Date();
			order.setOrderTime(date);
			order.setUser(user);
			Address address=addressBiz.getDefaultAddressByUser(user);
			order.setAddress(address);
			order.setUser(currUser);
			Set<OrderItem> orderItemSet=new HashSet<OrderItem>();
			order.setOrderStatus(orderStatusBiz.getStatu(3));
			double total=0;
			boolean flag=true;
			Shop shop=null;
			for (Cart cart : cartSet) {
				if(flag){
					shop=cart.getFood().getShop();
				}	
			
				OrderItem or=new OrderItem();
				or.setFood(cart.getFood());	
				or.setCount(cart.getCount());
				or.setTotal(cart.getFood().getPrice()*cart.getCount());
				or.setOrder(order);
				total=total+or.getTotal();
				orderItemSet.add(or);
			}
			shop=(Shop)ActionContext.getContext().getSession().get("currShop");
			order.setShop(shopBiz.getShop(shop.getId()));
			order.setTotal(total);
			order.setOrderItemSet(orderItemSet);
			orderBiz.addOrder(order);
			//清空购物车
			cartSet.clear();
			cartBiz.deleteCartByUser(currUser);
			ActionContext.getContext().getSession().put("cartSet",cartSet);
			return "makeOrder";
			
			
			
		}else{
			
			
			return "login";
		}}
		public String addCart(){
		
			
				
			shop=(Shop)ActionContext.getContext().getSession().get("currShop");
		    userObj=ActionContext.getContext().getSession().get("user");
		    if(userObj!=null){
				user=(User)userObj;
			     cart=cartBiz.getUserCart(user, food);
			    
				if(cart==null){
				Cart cart=new Cart(user,1,food);
				cartBiz.add(cart);
			
				 
				}
				else{
				
				cart.setCount(cart.getCount()+1);
			    cartBiz.update(cart);
					
				}
				cartSet=userBiz.getUser(user).getCartSet();
				if(cartSet.size()>0){
					Hibernate.initialize(cartSet);
					for (Cart cart : cartSet) {
						Hibernate.initialize(cart.getFood());
					}
					ActionContext.getContext().getSession().put("cartSet", cartSet);
					
				}
			return "add";
				
				
			}
			
			return "fail";
			
			
		}
		
	public String selAddr(){
		if( ActionContext.getContext().getSession().get("currOrder")!=null){
			Address	currAddress=addressBiz.getAddress(address.getId());
		currOrder=(Order) ActionContext.getContext().getSession().get("currOrder");
			currOrder.setAddress(currAddress);
				orderBiz.updateOrder(currOrder);
		}
		return "selAddr";
		
	}
	
	public Cart getCart() {
		return cart;
	}
	public void setCart(Cart cart) {
		this.cart = cart;
	}

	

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public Order getCurrOrder() {
		return currOrder;
	}

	public void setCurrOrder(Order currOrder) {
		this.currOrder = currOrder;
	}

	
	
	
}
