package crwm.site.action;

import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import crwm.site.biz.ReportBiz;
import crwm.site.biz.ShopBiz;
import crwm.site.biz.UserBiz;
import crwm.site.pojo.Report;
import crwm.site.pojo.Shop;
import crwm.site.pojo.User;

@Controller
@Scope("prototype")
public class ReportShopAction {
	@Resource
	private ReportBiz reportBiz;
	@Resource
	private ShopBiz shopBiz;
	@Resource 
	UserBiz userBiz;
	private Report report;
	private Shop shop;
	private Shop currShop;
	private String result;
	private User user;
	private User currUser;
	public String report(){
		Object userObj=ActionContext.getContext().getSession().get("user");
		if(userObj==null){
			result="noUser";
			
		}else{
			user=(User)userObj;
			currUser=userBiz.getUser(user.getTel());
		currShop=shopBiz.getShop(shop.getId());
		report.setShop(currShop);
		report.setUser(currUser);
		reportBiz.addReport(report);
		result="ok";
		}
		return "success";
	}
	public Report getReport() {
		return report;
	}
	public void setReport(Report report) {
		this.report = report;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}

}
