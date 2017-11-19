package crwm.site.action;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.aliyuncs.exceptions.ClientException;
import com.google.gson.Gson;
import com.opensymphony.xwork2.ActionContext;

import crwm.site.biz.OrderBiz;
import crwm.site.biz.UserBiz;
import crwm.site.pojo.Address;
import crwm.site.pojo.Cart;
import crwm.site.pojo.Order;
import crwm.site.pojo.Shop;
import crwm.site.pojo.User;
import crwm.site.pojo.UserMessage;
import crwm.site.util.SendMessage;
@Controller
@Scope("prototype")
public class LoginAction {
	private String result;
	@Resource
	private UserBiz userBiz;
	private String loginId;
	private String pwd;
	private User user=null;
	private String tel;
	private String verify;
	private Set<Shop> myCollect;
	private List<Order> orderList;
	private Set<Address> addressSet;
	private Set<Cart> cartSet;
	private Set<UserMessage> userMessageSet;
	@Resource
	private OrderBiz orderBiz;
	private String addr;
	public String userByPwd(){
		Gson json=new Gson();
		user=userBiz.login(loginId,pwd);
		if(user==null){
	
			result=json.toJson("noUser");
			return "success";
		}else{
			int max=5;
			orderList=orderBiz.getListByUser(user,max,0);
			ServletActionContext.getRequest().getSession().setAttribute("orderList", orderList);
			ServletActionContext.getRequest().getSession().setAttribute("max", max);
			myCollect=user.getMyCollect();
			if(myCollect.size()>0){
				Hibernate.initialize(myCollect);
				ServletActionContext.getRequest().getSession().setAttribute("myCollect", myCollect);
			}
			cartSet=user.getCartSet();
			if(cartSet.size()>0){
				Hibernate.initialize(cartSet);
				for (Cart cart : cartSet) {
					Hibernate.initialize(cart.getFood());
				}
				ServletActionContext.getRequest().getSession().setAttribute("cartSet", cartSet);
			}
			userMessageSet=user.getUserMessageSet();
			if(userMessageSet.size()>0){
				Hibernate.initialize(userMessageSet);
//				for (UserMessage me : userMessageSet) {
//					Hibernate.initialize(me);
//				}
				ServletActionContext.getRequest().getSession().setAttribute("userMessageSet", userMessageSet);
			}
			ServletActionContext.getRequest().getSession().setAttribute("user", user);
			Hibernate.initialize(user.getAddressSet());
			addressSet=user.getAddressSet();
			ServletActionContext.getRequest().getSession().setAttribute("addressSet", addressSet);
			
			
			
			result=json.toJson("ok");
			return "success";
		}
	}
	public String userByPhone(){
		Gson json=new Gson();
		try {
			String key=SendMessage.sendSms(tel);
			ActionContext.getContext().getSession().put("key", key);
			
		} catch (ClientException e) {
			e.printStackTrace();
		}
		
		result=json.toJson("send-ok");
		return "success";
		
	}
	public String verify(){
		Gson json=new Gson();
		Object keyObj=ActionContext.getContext().getSession().get("key");
		if(keyObj==null){//说明没有发送验证码
			result=json.toJson("noVerify");
			return "success";
		}else{
			String key=(String)keyObj; 
			if(key.equals(verify)){//判断验证码的正确
				user=userBiz.login(tel);
				int max=5;
				orderList=orderBiz.getListByUser(user,max,0);
				ServletActionContext.getRequest().getSession().setAttribute("orderList", orderList);
				ServletActionContext.getRequest().getSession().setAttribute("max", max);
				myCollect=user.getMyCollect();
				if(myCollect.size()>0){
					Hibernate.initialize(myCollect);
					ServletActionContext.getRequest().getSession().setAttribute("myCollect", myCollect);
				}
				cartSet=user.getCartSet();
				if(cartSet.size()>0){
					Hibernate.initialize(cartSet);
					for (Cart cart : cartSet) {
						Hibernate.initialize(cart.getFood());
					}
					ServletActionContext.getRequest().getSession().setAttribute("cartSet", cartSet);
				}
				ActionContext.getContext().getSession().put("user", user);
				ServletActionContext.getRequest().getSession().removeAttribute("key");
				ServletActionContext.getRequest().getSession().setAttribute("user", user);
				Hibernate.initialize(user.getAddressSet());
				addressSet=user.getAddressSet();
				ServletActionContext.getRequest().getSession().setAttribute("addressSet", addressSet);
				
				result=json.toJson("ok");
				return "success";
			}else{//验证码错误
				result=json.toJson("errorVerify");
				return "success";
			}
		}
		
		
	}
	public String setAddr(){
		
		
		
		ActionContext.getContext().getSession().put("addr",addr);
		return "login.jsp";
		
		
		
	}
	public String getResult() {
		return result;
	}


	public void setResult(String result) {
		this.result = result;
	}


	public UserBiz getUserBiz() {
		return userBiz;
	}


	public void setUserBiz(UserBiz userBiz) {
		this.userBiz = userBiz;
	}


	public String getLoginId() {
		return loginId;
	}


	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}


	public String getPwd() {
		return pwd;
	}


	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getVerify() {
		return verify;
	}
	public void setVerify(String verify) {
		this.verify = verify;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
}
