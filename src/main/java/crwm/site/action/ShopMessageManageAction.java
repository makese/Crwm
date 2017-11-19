package crwm.site.action;

import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionContext;
import crwm.site.biz.ShopBiz;
import crwm.site.pojo.Shop;
import crwm.site.pojo.ShopMessage;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.ArrayList;

@Controller
@Scope("prototype")
public class ShopMessageManageAction extends BaseManageAction<ShopMessage> {

    Shop shop = (Shop) ActionContext.getContext().getSession().get("currentShop");
    @Resource
    private ShopBiz shopBiz;

    @Override
    public String load() {
        shop = shopBiz.getShop(shop.getId());
        getData().addAll(shop.getShopMessageSet());
        return SUCCESS;
    }

    @Override
    public Type getType() {
        return new TypeToken<ArrayList<ShopMessage>>(){}.getType();
    }
}
