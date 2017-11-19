package crwm.site.action;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import crwm.site.biz.ShopBiz;
import crwm.site.pojo.Shop;
import crwm.site.pojo.ShopType;

@Controller
@Scope("prototype")
public class SearchShopAction {
	@Resource
	private ShopBiz shopBiz;
	private String type;
	private List<Shop> shopList;
	private ShopType shopType;
	private String searchName;
	public String byType(){
		if(StringUtils.isNotEmpty(type)){
			if(type.equals("all")){
				shopList=shopBiz.getShopListByShopVerify(true);
				ActionContext.getContext().getSession().put("shopList", shopList);
				return "success";
			}
		}else{
			
			shopList=shopBiz.getShopByType(shopType,true);
			ActionContext.getContext().getSession().put("shopList", shopList);
			return "success";
		}
		
		return null;
	}
	public String byName(){
		if(StringUtils.isBlank(searchName) || "".equals(searchName)){
			type="all";
			byType();
			return "search";
		}else{
			
			shopList=shopBiz.searchShopByName(searchName,true);
			
			ActionContext.getContext().getSession().put("shopList", shopList);
			
			return "search";
		}
		
		
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public ShopBiz getShopBiz() {
		return shopBiz;
	}
	public void setShopBiz(ShopBiz shopBiz) {
		this.shopBiz = shopBiz;
	}
	public ShopType getShopType() {
		return shopType;
	}
	public void setShopType(ShopType shopType) {
		this.shopType = shopType;
	}
	public String getSearchName() {
		return searchName;
	}
	public void setSearchName(String searchName) {
		this.searchName = searchName;
	}
}
