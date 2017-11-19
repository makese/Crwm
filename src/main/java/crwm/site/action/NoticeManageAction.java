package crwm.site.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import crwm.site.biz.ShopBiz;
import crwm.site.pojo.Shop;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
@Scope("prototype")
public class NoticeManageAction extends ActionSupport {

    private String content = "";
    private String result = "";

    @Resource
    private ShopBiz shopBiz;

    public String change(){
        Shop shop = (Shop) ActionContext.getContext().getSession().get("currentShop");
        shop = shopBiz.getShop(shop.getId());
        shop.getShopInfo().setContent(content);
        shopBiz.update(shop);
        ActionContext.getContext().getSession().put("currentShop",shop);
        result = "success";
        return SUCCESS;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
