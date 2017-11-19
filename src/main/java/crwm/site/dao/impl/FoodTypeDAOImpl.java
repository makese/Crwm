package crwm.site.dao.impl;

import crwm.site.dao.FoodTypeDAO;
import crwm.site.pojo.FoodType;
import crwm.site.pojo.Shop;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by makese on 2017/10/14.
 */
@Repository
public class FoodTypeDAOImpl extends BaseDAOImpl<FoodType> implements FoodTypeDAO {
    @Override
    public List<FoodType> getFoodTypeListByShop(Shop shop) {
        return (List<FoodType>) super.getHibernateTemplate().find("from FoodType f where f.shop = ? ",shop);
    }
}
