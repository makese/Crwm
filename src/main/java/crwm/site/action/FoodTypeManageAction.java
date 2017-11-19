package crwm.site.action;

import com.google.gson.reflect.TypeToken;
import crwm.site.biz.FoodTypeBiz;
import crwm.site.biz.ShopBiz;
import crwm.site.pojo.FoodType;
import crwm.site.pojo.Shop;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashSet;

@Controller
@Scope("prototype")
public class FoodTypeManageAction extends BaseManageAction<FoodType> {

    @Resource
    private FoodTypeBiz foodTypeBiz;

    @Resource
    private ShopBiz shopBiz;

    @Override
    public String load() {
        Shop shop = shopBiz.getShop(1);
        setData(foodTypeBiz.getFoodTypeListByShop(shop));
        return SUCCESS;
    }

    @Override
    public String create() {
        jsonToData();
        Shop shop = shopBiz.getShop(1);
        for(FoodType foodType : getData()){
            foodType.setShop(shop);
            foodType.setFoodSet(new HashSet<>());
            foodTypeBiz.addFoodType(foodType);
        }
        return SUCCESS;
    }

    @Override
    public String remove() {
        jsonToData();
        for(FoodType foodType : getData()){
            foodTypeBiz.deleteFoodType(foodType);
        }
        return SUCCESS;
    }

    @Override
    public String edit() {
        jsonToData();
        for(FoodType foodType : getData()){
            String typeName = foodType.getFoodTypeName();
            foodType = foodTypeBiz.getFoodType(foodType.getId());
            foodType.setFoodTypeName(typeName);
            foodTypeBiz.updateFoodType(foodType);
        }
        return SUCCESS;
    }

    @Override
    public Type getType() {
        return new TypeToken<ArrayList<FoodType>>(){}.getType();
    }

}
