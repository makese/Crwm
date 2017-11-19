package crwm.site.action;

import com.opensymphony.xwork2.ActionSupport;
import crwm.site.biz.*;
import crwm.site.pojo.*;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Controller
@Scope("prototype")
public class MessageManageAction extends ActionSupport {

    private String message = "";
    private String result = "";

    @Resource
    private AdminBiz adminBiz;
    @Resource
    private ShopBiz shopBiz;
    @Resource
    private UserBiz userBiz;
    @Resource
    private ShopMessageBiz shopMessageBiz;
    @Resource
    private UserMessageBiz userMessageBiz;

    public String sendMessageToAllUser(){
        Admin admin = new Admin();
        admin.setId(1);
        admin = adminBiz.getAdmin(admin);
        List<User> userList = userBiz.getUserList();
        for(User user : userList){
            UserMessage userMessage = new UserMessage(user, message, admin, new Date());
            userMessageBiz.addUserMessage(userMessage);
        }
        result = "success";
        return SUCCESS;
    }

    public String sendMessageToAllShop(){
        Admin admin = new Admin();
        admin.setId(1);
        admin = adminBiz.getAdmin(admin);
        List<Shop> shopList = shopBiz.getShopList();
        for (int i = 0; i < shopList.size(); i++) {
            Shop shop = shopList.get(i);
            ShopMessage shopMessage = new ShopMessage(shop, message, admin, new Date());
            shopMessageBiz.addShopMessage(shopMessage);
        }
        result = "success";
        return SUCCESS;
    }

    public String setMessageToUser(){
        return SUCCESS;
    }

    public String setMessageToShop(){
        return SUCCESS;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }
}
