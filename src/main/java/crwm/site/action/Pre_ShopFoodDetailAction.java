package crwm.site.action;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import crwm.site.biz.FoodBiz;
import crwm.site.biz.ShopBiz;
import crwm.site.pojo.Food;
import crwm.site.pojo.FoodType;
import crwm.site.pojo.Shop;

@Controller
@Scope("prototype")
public class Pre_ShopFoodDetailAction {
	@Resource
	private ShopBiz shopBiz;
	@Resource
	private FoodBiz foodBiz;
	private Shop currShop=null;
	private Shop shop;
	private List<Food> foodList;
	private Set<FoodType> foodTypeSet=new HashSet<FoodType>();
	private Object userObj;
	private Set<Shop> myCollect;
	private Object userCollectobj;
	private String result;
	public String predo(){
		userObj=ActionContext.getContext().getSession().get("user");
		if(userObj==null){
			common();
			return "success";
		}else{//判断为登录状态
			userCollectobj= ActionContext.getContext().getSession().get("myCollect");
			if(userCollectobj==null){//判断该用户是否有收藏
					common();
					result="no";
					ActionContext.getContext().getSession().put("result", result);
					return "success";
			}else{
				myCollect=(Set<Shop>) userCollectobj;
				common();
				for (Shop shop : myCollect) {
					if(shop.getId()==currShop.getId()){//判断该店铺已经收藏
						
						result="yes";
						ActionContext.getContext().getSession().put("result", result);
						return "success";
					}
				}
				result="no";
				ActionContext.getContext().getSession().put("result", result);
				return "success";
				
			}
		}
		
	
	}
	
	
	
	public void common(){
		currShop=shopBiz.getShop(shop.getId());
		Hibernate.initialize(currShop);
		ActionContext.getContext().getSession().put("currShop", currShop);
		foodList=foodBiz.getFoodListByShop(currShop);
		for (Food food : foodList) {
			Hibernate.initialize(food);
			Hibernate.initialize(food.getFoodType());
			foodTypeSet.add(food.getFoodType());
		}
		ActionContext.getContext().getSession().put("foodTypeSet", foodTypeSet);
		ActionContext.getContext().getSession().put("foodList", foodList);
	}
	
	
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public Object getUserObj() {
		return userObj;
	}
	public void setUserObj(Object userObj) {
		this.userObj = userObj;
	}
	public Object getUserCollectobj() {
		return userCollectobj;
	}
	public void setUserCollectobj(Object userCollectobj) {
		this.userCollectobj = userCollectobj;
	}



	public String getResult() {
		return result;
	}



	public void setResult(String result) {
		this.result = result;
	}

	


}
