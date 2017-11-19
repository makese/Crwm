package crwm.site.action;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;

@Controller
@Scope("prototype")
public class SkipAction {
	private int operate;
	public String skip(){
		
		ActionContext.getContext().getSession().put("operate", operate);
		return "success";
	}
	public int getOperate() {
		return operate;
	}
	public void setOperate(int operate) {
		this.operate = operate;
	}
	
}
