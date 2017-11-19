package crwm.site.action;

import java.util.List;
import java.util.Set;

import javax.annotation.Resource;

import org.apache.commons.lang3.StringUtils;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import crwm.site.biz.ShopBiz;
import crwm.site.biz.ShopTypeBiz;
import crwm.site.pojo.Shop;
import crwm.site.pojo.ShopType;

@Controller
@Scope("prototype")
public class Pre_mainAction {
	private String addr;
	@Resource
	private ShopTypeBiz shopTypeBiz;
	@Resource
	private ShopBiz shopBiz;
	private List<Shop> shopList;
	private Object addrObj;
	public String setAddr(){
		addrObj=ActionContext.getContext().getSession().get("addr");
		if(addrObj!=null){//直接登录
			if(StringUtils.isBlank(addr) || StringUtils.isEmpty(addr)){//判断index.jsp传过来的地址是否为空
				common();
				
			}else{
				ActionContext.getContext().getSession().put("addr",addr);
				common();
			}
			
		}else{
			ActionContext.getContext().getSession().put("addr",addr);
			common();
		}
		return "success";
	}
	
	
	public void common(){
		Set<ShopType> shopTypeSet=shopTypeBiz.getSet();
		ActionContext.getContext().getSession().put("shopTypeSet", shopTypeSet);
		shopList=shopBiz.getShopListByShopVerify(true);
		ActionContext.getContext().getSession().put("shopList", shopList);
		
		int operate=0;
		ActionContext.getContext().getSession().put("operate", operate);
	}
	
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}

}
