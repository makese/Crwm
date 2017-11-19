package crwm.site.biz.impl;

import crwm.site.biz.ShopTypeBiz;
import crwm.site.dao.ShopTypeDAO;
import crwm.site.pojo.ShopType;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class ShopTypeBizImpl implements ShopTypeBiz{
	@Resource
	private ShopTypeDAO shopTypeDAO;

	@Override
	public void addShopType(ShopType shopType) {
		shopTypeDAO.add(shopType);
	}

	@Override
	public void deleteShopType(ShopType shopType) {
		shopTypeDAO.delete(shopType);
	}

	@Override
	public void updateShopType(ShopType shopType) {
		shopTypeDAO.update(shopType);
	}

	@Override
	public Set<ShopType> getSet() {
		List<ShopType> shopTypeList=shopTypeDAO.getList();
		 Set<ShopType> shopTypeSet=new HashSet<ShopType>();
		 shopTypeSet.addAll(shopTypeList);
		 return shopTypeSet;
	}
	
	@Override
	public ShopType getTypeByTypeName(String shopType) {
		
		return shopTypeDAO.getTypeByTypeName(shopType);
	}
	
	public ShopTypeDAO getShopTypeDAO() {
		return shopTypeDAO;
	}
	public void setShopTypeDAO(ShopTypeDAO shopTypeDAO) {
		this.shopTypeDAO = shopTypeDAO;
	}
}
