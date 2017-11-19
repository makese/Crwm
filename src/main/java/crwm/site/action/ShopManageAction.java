package crwm.site.action;

import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionContext;
import crwm.site.biz.ShopBiz;
import crwm.site.pojo.Shop;
import org.apache.struts2.json.annotations.JSON;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

@Controller
@Scope("prototype")
public class ShopManageAction extends BaseManageAction<Shop> {

    @Resource
    private ShopBiz shopBiz;

    private boolean shopVerify = false;
    private int id;
    @Override
    public String load() {
        setData(shopBiz.getShopListByShopVerify(shopVerify));
        return SUCCESS;
    }

    public String check() {
        Shop shop = shopBiz.getShop(id);
        shop.setShopVerify(true);
        shop.getShopInfo().setSettlingDate(new Date());
        shopBiz.update(shop);
       return SUCCESS;
    }

    @Override
    public String edit() {
        jsonToData();
        for(int i = 0; i < getData().size(); i ++) {
            Shop updateShop = getData().get(i);
            Shop shop = shopBiz.getShop(updateShop.getId());
            shop.setShopVerify(updateShop.isShopVerify());
            shopBiz.update(shop);
        }
        setData(shopBiz.getShopListByShopVerify(shopVerify));
        return SUCCESS;
    }

    @Override
    public String remove() {
        return null;
    }

    @JSON(serialize = false)
    public String getShopAptitude(){
        Shop shop = shopBiz.getShop(id);
        ActionContext.getContext().put("aptitude",shop.getShopAptitude());
        return SUCCESS;
    }

    @Override
    public Type getType() {
        return new TypeToken<ArrayList<Shop>>() {}.getType();
    }

    public boolean isShopVerify() {
        return shopVerify;
    }

    public void setShopVerify(boolean shopVerify) {
        this.shopVerify = shopVerify;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
