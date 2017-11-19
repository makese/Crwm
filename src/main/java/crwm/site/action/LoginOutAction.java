package crwm.site.action;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
@Controller
@Scope("prototype")
public class LoginOutAction {
	
	
	public String shopLO(){
		ServletActionContext.getRequest().getSession().removeAttribute("currShop");
		return "success";
	}
	public String userLO(){
		
		ServletActionContext.getRequest().getSession().removeAttribute("result");
		ServletActionContext.getRequest().getSession().removeAttribute("myCollect");
		ServletActionContext.getRequest().getSession().removeAttribute("user");
		ServletActionContext.getRequest().getSession().removeAttribute("orderList");
		ServletActionContext.getRequest().getSession().removeAttribute("evaluteOrderList");
		ServletActionContext.getRequest().getSession().removeAttribute("max");
		ServletActionContext.getRequest().getSession().removeAttribute("addressSet");
		ServletActionContext.getRequest().getSession().removeAttribute("operate");
		ServletActionContext.getRequest().getSession().removeAttribute("cartSet");
		ServletActionContext.getRequest().getSession().removeAttribute("userMessageSet");
		return "ok";
		
	}
}
