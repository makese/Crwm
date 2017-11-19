package crwm.site.biz.impl;

import java.io.Serializable;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import crwm.site.biz.ShopBiz;
import crwm.site.dao.ShopDAO;
import crwm.site.pojo.Shop;
import crwm.site.pojo.ShopType;
@Service
public class ShopBizImpl implements ShopBiz {
	@Resource
	private ShopDAO shopDAO;

	@Override
	public Shop getUser(String tel) {
		
		return shopDAO.searchShopByTel(tel);
	}

	@Override
	public Serializable addShop(Shop shop) {
		return	shopDAO.add(shop);
	}

	@Override
	public Shop getShop(Serializable id) {
		return shopDAO.get(id);
	}

	@Override
	public Shop getShopByLoginId(String loginId) {
		
		return shopDAO.getShopByLoginId(loginId);
	}

	@Override
	public Shop getShopByTel(String shopTel) {
		return shopDAO.getShopByTel(shopTel);
	}

	@Override
	public void update(Shop shop) {
		shopDAO.update(shop);
	}

	@Override
	public List<Shop> getShopListByShopVerify(Boolean shopVerify) {
		return shopDAO.getShopListByShopVerify(shopVerify);
	}

	@Override
	public List<Shop> getShopList() {
		return shopDAO.getList();
	}



	@Override
	public List<Shop> getShopByType(ShopType type,boolean verify) {
		return shopDAO.getShopByType(type,verify);
	}



	@Override
	public List<Shop> searchShopByName(String searchName,boolean verify) {
		return shopDAO.getShopByName(searchName,verify);
	}




	
}
