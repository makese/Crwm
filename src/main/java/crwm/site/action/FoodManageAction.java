package crwm.site.action;

import com.google.gson.reflect.TypeToken;
import com.opensymphony.xwork2.ActionContext;
import crwm.site.biz.FoodBiz;
import crwm.site.biz.FoodTypeBiz;
import crwm.site.biz.ShopBiz;
import crwm.site.pojo.Food;
import crwm.site.pojo.FoodType;
import crwm.site.pojo.ImgFile;
import crwm.site.pojo.Shop;
import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.io.File;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
public class FoodManageAction extends BaseManageAction<Food> {
    @Resource
    private FoodBiz foodBiz;
    @Resource
    private ShopBiz shopBiz;
    @Resource
    private FoodTypeBiz foodTypeBiz;

    @Override
    public String execute() throws Exception {
        Shop shop = (Shop) ActionContext.getContext().getSession().get("currentShop");
        shop = shopBiz.getShop(shop.getId());
        shop.getFoodTypeSet().size();
        ActionContext.getContext().put("foodTypeSet",shop.getFoodTypeSet());

        return SUCCESS;
    }

    @Override
    public String load() {
        Shop shop = (Shop) ActionContext.getContext().getSession().get("currentShop");
        setData(foodBiz.getFoodListByShop(shop));
        if(getData() == null){
            setData(new ArrayList<>());
        }
        for(Food food : getData()){
            if("".equals(food.getFoodImg())){
                continue;
            }
            int i = food.getId();
            ImgFile imgFile = new ImgFile();
            imgFile.setId(i);
            imgFile.setWebPath(food.getFoodImg());
            food.setFoodImg(food.getId() + "");
            addImage(imgFile);
        }
        return SUCCESS;
    }

    public String create(){
        jsonToData();
        Shop shop = (Shop) ActionContext.getContext().getSession().get("currentShop");
        shop = shopBiz.getShop(shop.getId());

        List<Food> foodList = new ArrayList<>();
        for(Food food : getData()){
            FoodType foodType = foodTypeBiz.getFoodType(food.getFoodType().getId());
            food.setFoodType(foodType);
            food.setShop(shop);
            String no = food.getFoodImg();
            if(!"".equals(no)) {
                String path = "shopImgs" + "/" + shop.getTel() + "/foodImg/" + no + ".jpg";
                food.setFoodImg(path);
            }
            food.setId(foodBiz.addFood(food));
            food.setFoodImg(no);
            foodList.add(food);
        }
        setData(foodList);
        return SUCCESS;
    }

    @Override
    public String edit() {
        jsonToData();
        Shop shop = (Shop) ActionContext.getContext().getSession().get("currentShop");
        List<Food> foodList = new ArrayList<>();
        for(Food food : getData()){
            Food food1 = foodBiz.getFoodByid(food.getId());
            food1.setFoodName(food.getFoodName());
            food1.setPrice(food.getPrice());
            FoodType foodType = foodTypeBiz.getFoodType(food.getFoodType().getId());
            food1.setFoodType(foodType);
            if(!(food.getId() +"").equals(food.getFoodImg())){
                File file = new File(ServletActionContext.getServletContext().getRealPath(food1.getFoodImg()));
                file.delete();
                String path = "shopImgs" + "/" + shop.getTel() + "/foodImg/" + food.getFoodImg() + ".jpg";
                food1.setFoodImg(path);
            } else if("".equals(food.getFoodImg())){
                food1.setFoodImg("");
            }
            foodBiz.updateFood(food1);
            food1.setFoodImg(food.getFoodImg());
            foodList.add(food1);
        }
        setData(foodList);
        return SUCCESS;
    }

    public String delete(){
        jsonToData();
        for(Food food : getData()){
            food = foodBiz.getFoodByid(food.getId());
            File file = new File(ServletActionContext.getServletContext().getRealPath(food.getFoodImg()));
            file.delete();
            foodBiz.deleteFood(food);
        }
        return SUCCESS;
    }
    @Override
    public Type getType() {
        return new TypeToken<ArrayList<Food>>(){}.getType();
    }
}
