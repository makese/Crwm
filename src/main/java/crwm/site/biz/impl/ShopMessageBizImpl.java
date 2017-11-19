package crwm.site.biz.impl;

import crwm.site.biz.ShopMessageBiz;
import crwm.site.dao.ShopMessageDAO;
import crwm.site.pojo.ShopMessage;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShopMessageBizImpl implements ShopMessageBiz {

    @Resource
    private ShopMessageDAO shopMessageDAO;

    @Override
    public void addShopMessage(ShopMessage shopMessage) {
        shopMessageDAO.add(shopMessage);
    }

    @Override
    public void deleteShopMessage(ShopMessage shopMessage) {
        shopMessageDAO.delete(shopMessage);
    }
}
