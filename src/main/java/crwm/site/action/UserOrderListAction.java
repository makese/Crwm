package crwm.site.action;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

import crwm.site.biz.OrderBiz;
import crwm.site.pojo.Order;
import crwm.site.pojo.User;

@Controller
@Scope("prototype")
public class UserOrderListAction {
	private Object maxObj;
	private int max;
	private List<Order> orderList;
	private List<Order> evaluteOrderList;
	private Object userObj;
	private User user;
	private String result;
	private String operate;
	@Resource
	private OrderBiz orderBiz;
	public String showMore(){
		userObj=ActionContext.getContext().getSession().get("user");
		maxObj=ActionContext.getContext().getSession().get("max");
		if(maxObj!=null && userObj!=null ){
			user=(User)userObj;
			max=(Integer)maxObj*2;
			orderList=orderBiz.getListByUser(user, max, 0);
			if(max>orderList.size()){
				result="noMore";
			}else{
				result="ok";
			}
			ActionContext.getContext().getSession().put("orderList",orderList);
			ActionContext.getContext().getSession().put("max",max);
			
		}
		return "success";
	}
	public void show(){
		userObj=ActionContext.getContext().getSession().get("user");
		maxObj=ActionContext.getContext().getSession().get("max");
		if(maxObj!=null && userObj!=null ){
			user=(User)userObj;
			max=(Integer)maxObj;
			orderList=orderBiz.getListByUser(user, max, 0);
			ActionContext.getContext().getSession().put("orderList",orderList);
			ActionContext.getContext().getSession().put("max",max);
			
		}
		
	}
	public String setmax(){
		int max=5;
		ActionContext.getContext().getSession().put("max",max);
		
		if(operate.equals("person")){
			show();
			return "person";
		}else if(operate.equals("order")){
			show();
			return "order";
		}else if(operate.equals("evalute")){
			showEvalute();
			return "evalute";
		}
		return null;
		
	}
	public void showEvalute(){
		userObj=ActionContext.getContext().getSession().get("user");
		maxObj=ActionContext.getContext().getSession().get("max");
		if(maxObj!=null && userObj!=null ){
			user=(User)userObj;
			max=(Integer)maxObj;
			evaluteOrderList=orderBiz.getEvaluteListByUser(user, max, 0);
			ActionContext.getContext().getSession().put("evaluteOrderList",evaluteOrderList);
			ActionContext.getContext().getSession().put("max",max);
			
		}
		
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getOperate() {
		return operate;
	}
	public void setOperate(String operate) {
		this.operate = operate;
	}
	
}
