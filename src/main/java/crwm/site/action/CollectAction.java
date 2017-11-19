package crwm.site.action;

import com.opensymphony.xwork2.ActionContext;
import crwm.site.biz.ShopBiz;
import crwm.site.biz.UserBiz;
import crwm.site.pojo.Shop;
import crwm.site.pojo.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

@Controller
@Scope("prototype")
public class CollectAction {
	private Set<Shop> myCollect;
	private Object userCollectobj;
	private Object userObj;
	private Shop currShop;
	private String result;
	private User user;
	private Shop target=null;
	@Resource
	private ShopBiz shopBiz;
	@Resource
	private UserBiz userBiz;
	public String addCollect(){
		userCollectobj= ActionContext.getContext().getSession().get("myCollect");
		userObj=ActionContext.getContext().getSession().get("user");
		if( userObj==null){
			result="login";
			return "success";
		}else if(userCollectobj==null){
			user=(User)userObj;
			myCollect=new HashSet<Shop>();
			myCollect.add(currShop);
			user.setMyCollect(myCollect);
			userBiz.updateUser(user);
			ActionContext.getContext().getSession().put("myCollect", myCollect);
			result="yes";
			return "success";
		}else{
			myCollect=(Set<Shop>) userCollectobj;
			user=(User)userObj;
			for (Shop shop : myCollect) {
				if(shop.getId()==currShop.getId()){
					target=shop;
				
				}
			}
			
			if(target!=null){
				result="no";
				Set<Shop> collect=user.getMyCollect();
				collect.remove(target);
				user.setMyCollect(collect);
				userBiz.updateUser(user);
				ActionContext.getContext().getSession().put("result", result);
				return "success";
				
				
			}else{
				user.getMyCollect().add(currShop);
				result="yes";
				userBiz.updateUser(user);
				ActionContext.getContext().getSession().put("result", result);
				return "success";
				
			}
		}
	}
	
	public String delete(){
		userCollectobj= ActionContext.getContext().getSession().get("myCollect");
		userObj=ActionContext.getContext().getSession().get("user");
		if( userObj==null){
			result="login";
			return "success";
		}else{
			user=(User)userObj;
			myCollect=(Set<Shop>)userCollectobj;
			for (Shop shop2 : myCollect) {
				if(shop2.getId()==currShop.getId()){
					target=shop2;
					
				}
			}
	
			myCollect.remove(target);
			user.setMyCollect(myCollect);
			userBiz.updateUser(user);
			ActionContext.getContext().getSession().put("myCollect", myCollect);
			return "deletecollect";	
		}
		
		
	}
	
	public Shop getCurrShop() {
		return currShop;
	}
	public void setCurrShop(Shop currShop) {
		this.currShop = currShop;
	}

	public Set<Shop> getMyCollect() {
		return myCollect;
	}

	public void setMyCollect(Set<Shop> myCollect) {
		this.myCollect = myCollect;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	
	
}
