package crwm.site.action;

import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionContext;
import crwm.site.biz.OrderBiz;
import crwm.site.biz.OrderStatusBiz;
import crwm.site.biz.ShopBiz;
import crwm.site.pojo.Order;
import crwm.site.pojo.OrderStatus;
import crwm.site.pojo.Shop;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.lang.reflect.Type;
@Controller
@Scope("prototype")
public class OrderManageAction extends BaseManageAction<Order> {

    private boolean finish = false;
    private int id;
    private boolean success = true;

    @Resource
    private OrderBiz orderBiz;

    @Resource
    private OrderStatusBiz orderStatusBiz;
    @Resource
    private ShopBiz shopBiz;

    @Override
    public String load() {
        Shop shop = (Shop) ActionContext.getContext().getSession().get("currentShop");
        shop = shopBiz.getShop(shop.getId());

        for(Order order : shop.getOrderSet()){
            if(!order.getOrderStatus().getStatus().equals("完成") ^ finish){
                getData().add(order);
            }
        }
        return SUCCESS;
    }

    public String checkOut() {
        Order order = orderBiz.getOrder(id);
        if(order.getOrderStatus().getStatus().equals("未付款")){
            OrderStatus orderStatus = orderStatusBiz.getOrderStatusByStatus("完成");
            order.setOrderStatus(orderStatus);
            orderBiz.updateOrder(order);
        } else {
            success = false;
        }

        return SUCCESS;
    }

    public String send() {
        Order order = orderBiz.getOrder(id);
        if(order.getOrderStatus().getStatus().equals("未配送")) {
            OrderStatus orderStatus = orderStatusBiz.getOrderStatusByStatus("配送");
            order.setOrderStatus(orderStatus);
            orderBiz.updateOrder(order);
        } else {
            success = false;
        }
        return SUCCESS;
    }

    @Override
    public Type getType() {
        return new TypeToken<Order>(){}.getType();
    }

    public boolean isFinish() {
        return finish;
    }

    public void setFinish(boolean finish) {
        this.finish = finish;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
