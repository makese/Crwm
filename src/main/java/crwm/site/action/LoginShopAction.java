package crwm.site.action;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import crwm.site.biz.ShopBiz;
import crwm.site.pojo.Food;
import crwm.site.pojo.Order;
import crwm.site.pojo.Report;
import crwm.site.pojo.Shop;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

@Controller
@Scope("prototype")
public class LoginShopAction extends ActionSupport {

    @Resource
    private ShopBiz shopBiz;

    public String login(){
        Shop shop = shopBiz.getShop(1);
        Hibernate.initialize(shop);
        ActionContext.getContext().getSession().put("currentShop",shop);
        return SUCCESS;
    }

    public String index(){
        Shop shop = (Shop) ActionContext.getContext().getSession().get("currentShop");
        shop = shopBiz.getShop(shop.getId());
        ActionContext.getContext().put("orderNum", shop.getOrderSet().size());
        double sum = 0.0;
        for(Order order : shop.getOrderSet()){
            sum += order.getTotal();
        }
        ActionContext.getContext().put("turnover", sum);
        ActionContext.getContext().put("reportNum", shop.getReportSet().size());
        int scoreSum = 0;
        for(Food food : shop.getFoodSet()){
            if(food.getFoodScore() != null){
                scoreSum += food.getFoodScore().getAssessCount();
            }
        }
        ActionContext.getContext().put("scoreSum", scoreSum);
        ActionContext.getContext().put("data",load());
        return SUCCESS;
    }
    public String load(){
        Shop shop = (Shop) ActionContext.getContext().getSession().get("currentShop");
        shop = shopBiz.getShop(shop.getId());
        Date date = new Date();
        SimpleDateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        Calendar calendar = Calendar.getInstance();
        JsonArray data = new JsonArray();
        for(int i = 30 ; i >= 0; i --){
            calendar.setTime(date);
            calendar.set(Calendar.DATE, calendar.get(Calendar.DATE) - i);
            String dateStr = dft.format(calendar.getTime());
            JsonObject jsonObject = new JsonObject();
            double sum = 0.0;
            int orderNum = 0;
            for(Order order : shop.getOrderSet()){
                if(dateStr.equals(dft.format(order.getOrderTime()))){
                    sum += order.getTotal();
                    orderNum ++;
                }
            }
            int reportNum = 0;
            for(Report report : shop.getReportSet()){
                if(report.isStatus() && dateStr.equals(dft.format(report.getReportTime()))){
                    reportNum ++;
                }
            }
            jsonObject.addProperty("date",dateStr);
            jsonObject.addProperty("sum",sum);
            jsonObject.addProperty("orderNum",orderNum);
            jsonObject.addProperty("reportNum",reportNum);
            data.add(jsonObject);
        }
        Gson gson = new Gson();
        return gson.toJson(data);
    }
}
