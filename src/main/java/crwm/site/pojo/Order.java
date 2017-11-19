package crwm.site.pojo;

import java.util.Date;
import java.util.Set;

public class Order {
	private int id;
	private Shop shop;
	private User user;
	private int shopGrade;
	private Date orderTime;
	private Address address;
	private OrderStatus orderStatus;
	private Set<OrderItem> orderItemSet;
	private double total;
	public Order() {
		super();
	}

	public Order(int shopGrade, Date orderTime, double total) {
		this.shopGrade = shopGrade;
		this.orderTime = orderTime;
		this.total = total;
	}

	public Order(int id, Shop shop, User user, int shopGrade, Date orderTime, Address address, OrderStatus orderStatus,
				 Set<OrderItem> orderItemSet, double total) {
		super();
		this.id = id;
		this.shop = shop;
		this.user = user;
		this.shopGrade = shopGrade;
		this.orderTime = orderTime;
		this.address = address;
		this.orderStatus = orderStatus;
		this.orderItemSet = orderItemSet;
		this.total = total;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getShopGrade() {
		return shopGrade;
	}
	public void setShopGrade(int shopGrade) {
		this.shopGrade = shopGrade;
	}
	public Date getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(Date orderTime) {
		this.orderTime = orderTime;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}
	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus = orderStatus;
	}
	public Set<OrderItem> getOrderItemSet() {
		return orderItemSet;
	}
	public void setOrderItemSet(Set<OrderItem> orderItemSet) {
		this.orderItemSet = orderItemSet;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	

	
}
