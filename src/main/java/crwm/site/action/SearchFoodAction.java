package crwm.site.action;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import crwm.site.biz.FoodBiz;
import crwm.site.biz.FoodTypeBiz;
import crwm.site.biz.OrderBiz;
import crwm.site.biz.ShopAptitudeBiz;
import crwm.site.pojo.Food;
import crwm.site.pojo.FoodType;
import crwm.site.pojo.Order;
import crwm.site.pojo.Shop;
import crwm.site.pojo.ShopAptitude;

@Controller
@Scope("prototype")
public class SearchFoodAction {
	private FoodType foodType;
	@Resource
	private FoodBiz foodBiz;
	@Resource
	private FoodTypeBiz foodTypeBiz;
	@Resource
	private OrderBiz orderBiz;
	private FoodType type;
	private List<Food> foodList;
	private Shop shop;
	private List<Order> orderList;
	@Resource
	private ShopAptitudeBiz shopAptitudeBiz;
	private ShopAptitude shopAptitude;
	public String byType(){
		Shop shop=(Shop) ActionContext.getContext().getSession().get("currShop");
		type=foodTypeBiz.getFoodType(foodType.getId());
		foodList=foodBiz.getFoodListByType(type,shop);
		ActionContext.getContext().getSession().put("foodList", foodList);
		return "success";
		
	}
	public String getall(){
		Object shopobj=ActionContext.getContext().getSession().get("currShop");
		if(shopobj==null){
			
		}else{
			shop=(Shop)shopobj;
			foodList=foodBiz.getFoodListByShop(shop);
			ActionContext.getContext().getSession().put("foodList", foodList);
		}
		
		
		return "success";
	}
	
	public String getpinjia(){
		Object shopobj=ActionContext.getContext().getSession().get("currShop");
		if(shopobj==null){
			
		}else{
			shop=(Shop)shopobj;
			orderList=orderBiz.getListByShop(shop);
			ActionContext.getContext().getSession().put("orderList", orderList);
		}
		
		return "pinjia";
	}
	public String getzizhi(){
		Object shopobj=ActionContext.getContext().getSession().get("currShop");
		if(shopobj==null){
			
		}else{
			shop=(Shop)shopobj;
			shopAptitude=shop.getShopAptitude();
			ActionContext.getContext().getSession().put("shopAptitude", shopAptitude);
		}	
		
		return "zizhi";
		
	}
	public FoodType getFoodType() {
		return foodType;
	}

	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}
}
