package crwm.site.action;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.io.FileUtils;
import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import crwm.site.biz.AddressBiz;
import crwm.site.biz.OrderBiz;
import crwm.site.biz.OrderItemBiz;
import crwm.site.biz.OrderStatusBiz;
import crwm.site.biz.UserBiz;
import crwm.site.pojo.Address;
import crwm.site.pojo.Order;
import crwm.site.pojo.OrderItem;
import crwm.site.pojo.OrderStatus;
import crwm.site.pojo.User;

@Controller
@Scope("prototype")
public class PersonCenterAction {
	private String result;
	private Order currOrder;
	private Order order;
	private Order cuOrder;
	private double money;
	private User user;
	private User currUser;
	private Object userObj;
	private Address address;
	private int allScore;
	private int orderId;
	private int foodScore;
	private int orderid;
	private File headImg;
	private String headImgFileName;
	@Resource
	private OrderStatusBiz orderStatusBiz;
	@Resource
	private AddressBiz addressBiz;
	@Resource
	private UserBiz userBiz;
	@Resource
	private OrderBiz orderBiz;
	@Resource
	private OrderItemBiz orderItemBiz;
	public String orderItem(){
		currOrder=orderBiz.getOrder(order.getId());
		Hibernate.initialize(currOrder.getOrderItemSet());
		ActionContext.getContext().getSession().put("currOrder", currOrder);
		
		return "success";
	}
	public String addBalance(){	
		currUser=userBiz.login(user.getTel());
		money=currUser.getUserInfo().getBalance()+money;
		currUser.getUserInfo().setBalance(money);
		userBiz.updateUser(currUser);
		ActionContext.getContext().getSession().put("user", currUser);
		return "addBalance";
	}
	public String modifyUserName(){
		
		userObj=ActionContext.getContext().getSession().get("user");
		if(userObj==null){
			
			
		}else{
			currUser=(User)userObj;
			currUser.getUserInfo().setNickName(user.getUserInfo().getNickName());
			userBiz.updateUser(currUser);
			ActionContext.getContext().getSession().put("user", currUser);
		}
		return "addBalance";
	}
	public String modifyUserTel(){
		
		userObj=ActionContext.getContext().getSession().get("user");
		if(userObj==null){
			
			
		}else{
			currUser=(User)userObj;
			currUser.setTel(user.getTel());
			userBiz.updateUser(currUser);
			ActionContext.getContext().getSession().put("user", currUser);
		}
		return "addBalance";
	}
	
	public String modifyUserPwd(){
		
		userObj=ActionContext.getContext().getSession().get("user");
		if(userObj!=null){
			if(user.getPwd()==null || user.getPwd().equals("")){
				
				return "modifyPwd";
			}
			
			currUser=(User)userObj;
			currUser.setPwd(user.getPwd());
			userBiz.updateUser(currUser);
			ActionContext.getContext().getSession().put("user", currUser);
		}
		return "addBalance";
	}
	
	public String setDefaultAddress(){
		userObj=ActionContext.getContext().getSession().get("user");
		if(userObj!=null){
			user=(User)userObj;
			Address currAddress=addressBiz.getAddress(address.getId());
			currAddress.setDefaultAddress(true);
			Address targetAddress=addressBiz.getDefaultAddressByUser(user);
			if(targetAddress!=null){
				
				targetAddress.setDefaultAddress(false);
				addressBiz.update(targetAddress);
			}
			addressBiz.update(currAddress);
			Set<Address> addressSet=userBiz.getUser(user).getAddressSet();
				Hibernate.initialize(userBiz.getUser(user).getAddressSet());
			ActionContext.getContext().getSession().put("addressSet", addressSet);
		}
		
		return "ok";
		
	}
	
	public String deleteAddress(){
		userObj=ActionContext.getContext().getSession().get("user");
		if(userObj!=null){
			user=(User)userObj;
			Address currAddress=addressBiz.getAddress(address.getId());
			User newUser=userBiz.getUser(user);
			Set<Address> addressSet=newUser.getAddressSet();
			Address target=null;
			for (Address address : addressSet) {
				if(address.getId()==currAddress.getId()){
					target=address;
				}
			}
			addressSet.remove(target);
			List<Order> orderList1=orderBiz.getListByAddress(target);
			for (Order order : orderList1) {
				order.setAddress(null);
			}
			for (Order order : orderList1) {
				orderBiz.updateOrder(order);
			}
			
			addressBiz.deleteAddress(target);
		
			ActionContext.getContext().getSession().put("addressSet", addressSet);
		}
		return "ok";
	}
	
	public String addAddress(){
		userObj=ActionContext.getContext().getSession().get("user");
		if(userObj!=null){
			user=(User)userObj;
			address.setUser(user);
			addressBiz.addAddress(address);
			Set<Address> addressSet=userBiz.getUser(user).getAddressSet();
			Hibernate.initialize(userBiz.getUser(user).getAddressSet());
			ActionContext.getContext().getSession().put("addressSet", addressSet);
		}
		return "ok";	}
	
	public String orderPay(){
		userObj=ActionContext.getContext().getSession().get("user");
		Object orderListObj=ActionContext.getContext().getSession().get("orderList");
		if(orderListObj!=null && userObj!=null){
			user=(User)userObj;
			currUser=userBiz.getUser(user);
			Order target=null;
			List<Order> orderList=(List<Order>) orderListObj;
			currOrder=orderBiz.getOrder(order.getId());
			OrderStatus orderStatus= orderStatusBiz.getStatu(1);
			currOrder.setOrderStatus(orderStatus);
			orderBiz.updateOrder(currOrder);
			for (Order order : orderList) {
				if(order.getId()==currOrder.getId()){
					
					target=order;
					
				}
			}
			Hibernate.initialize(currOrder);
			Hibernate.initialize(currOrder.getOrderStatus());
			currUser.getUserInfo().setBalance(currUser.getUserInfo().getBalance()-currOrder.getTotal());
			user.getUserInfo().setBalance(currUser.getUserInfo().getBalance()-currOrder.getTotal());
			userBiz.updateUser(currUser);
			orderList.remove(target);
			orderList.add(currOrder);
			ActionContext.getContext().getSession().put("orderList",orderList);
			ActionContext.getContext().getSession().put("user",user);
			
		}
		return "orderPay";
	}
	public String modifyHeadImg(){
		userObj=ActionContext.getContext().getSession().get("user");
		if(userObj!=null){
			user=(User)userObj;
		File destFile=new File(ServletActionContext.getServletContext().getRealPath("/userImgs")+"/"+headImgFileName);			
			try {
				FileUtils.copyFile(headImg, destFile);
			} catch (IOException e) {
		}
			currUser=userBiz.getUser(user);
			currUser.getUserInfo().setHeadImg("userImgs"+"/"+headImgFileName);
			userBiz.updateUser(currUser);
			ActionContext.getContext().getSession().put("user", currUser);
		}
		return "commitHeadImg";
	}
	
	public String  confirm(){
		currOrder=orderBiz.getOrder(order.getId());
		currOrder.setOrderStatus(orderStatusBiz.getStatu(4));
		orderBiz.updateOrder(currOrder);
		
		return "addBalance";
	}
	
	
	public String report(){
		order=orderBiz.getOrder(orderId);
		if(order.getShopGrade()!=0){
			result="no";
		}else{
			 orderBiz.updateOrder(orderId, allScore);
			   result="ok";
		}
		
	
		return "report";
		
		
		
		
	}
	
	public String reportFood(){
		List<OrderItem> orderItemList=orderItemBiz.getOrderItmList(orderid);
		OrderItem orderItem = orderItemList.get(0);
		Order target=null;
		if(orderItem.getFoodGrade()!=0){
			result="no";
			}else{
				orderItemBiz.updateScore(orderid, foodScore);
				  result="yes";
	Object evaluteOrderListObj=ActionContext.getContext().getSession().get("evaluteOrderList");
				if(evaluteOrderListObj!=null){
					
				List<Order>	evaluteOrderList=(List<Order>) evaluteOrderListObj;
					for (Order order : evaluteOrderList) {
						if(order.getId()==orderid){
							
							target=order;
							
						}
					}
				
					evaluteOrderList.remove(target);
				
				ActionContext.getContext().getSession().put("evaluteOrderList",evaluteOrderList);
				}
			}
		
		return "reportFood";
		}
			
			
	public String verifyPwd(){
		userObj=ActionContext.getContext().getSession().get("user");
		if(userObj!=null){
			currUser=(User)userObj;
			if(user.getPwd().equals(currUser.getPwd())){
				
				result="yes";
				
			
			}else{
				result="no";
				
				
			}
			
		}
		return "verifyPwd";
		
	}
	
	
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}

	public double getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public Order getCuOrder() {
		return cuOrder;
	}

	public void setCuOrder(Order cuOrder) {
		this.cuOrder = cuOrder;
	}

	public int getAllScore() {
		return allScore;
	}

	public void setAllScore(int allScore) {
		this.allScore = allScore;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getFoodScore() {
		return foodScore;
	}

	public void setFoodScore(int foodScore) {
		this.foodScore = foodScore;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}
	public OrderItemBiz getOrderItemBiz() {
		return orderItemBiz;
	}
	public void setOrderItemBiz(OrderItemBiz orderItemBiz) {
		this.orderItemBiz = orderItemBiz;
	}

	public File getHeadImg() {
		
		return headImg;
	}
	public void setHeadImg(File headImg) {
		this.headImg = headImg;
	}
	public String getHeadImgFileName() {
		return headImgFileName;
	}
	public void setHeadImgFileName(String headImgFileName) {
		this.headImgFileName = headImgFileName;
	}


	

	
	
}

