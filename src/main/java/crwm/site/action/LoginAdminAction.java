package crwm.site.action;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import crwm.site.biz.AdminBiz;
import crwm.site.biz.FoodScoreBiz;
import crwm.site.biz.OrderBiz;
import crwm.site.biz.ReportBiz;
import crwm.site.pojo.Admin;
import crwm.site.pojo.FoodScore;
import crwm.site.pojo.Order;
import crwm.site.pojo.Report;
import org.hibernate.Hibernate;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

@Controller
@Scope("prototype")
public class LoginAdminAction extends ActionSupport {

    @Resource
    private OrderBiz orderBiz;

    @Resource
    private ReportBiz reportBiz;

    @Resource
    private FoodScoreBiz foodScoreBiz;

    @Resource
    private AdminBiz adminBiz;

    private List<Order> orderList;
    private List<Report> reportList;

    public String login(){
        Admin admin = adminBiz.getAdmin(new Admin(1));
        Hibernate.initialize(admin);
        ActionContext.getContext().getSession().put("currentAdmin",admin);
        return SUCCESS;
    }

    public String index(){
        orderList = orderBiz.getOrderList();
        reportList = reportBiz.getReportList();
        List<FoodScore> foodScoreList = foodScoreBiz.getAllFoodScoreList();
        double sum = 0.0;
        for(Order order : orderList){
            sum += order.getTotal();
        }
        ActionContext.getContext().put("orderNum", orderList.size());
        ActionContext.getContext().put("turnover", sum);
        ActionContext.getContext().put("reportNum", reportList.size());
        ActionContext.getContext().put("scoreSum", foodScoreList.size());
        ActionContext.getContext().put("data",load());
        return SUCCESS;
    }

    public String load(){
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
            for(Order order : orderList){
                if(dateStr.equals(dft.format(order.getOrderTime()))){
                    sum += order.getTotal();
                    orderNum ++;
                }
            }
            int reportNum = 0;
            for(Report report : reportList){
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
