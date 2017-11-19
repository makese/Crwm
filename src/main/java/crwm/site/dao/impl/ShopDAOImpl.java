package crwm.site.dao.impl;

import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Repository;

import crwm.site.dao.ShopDAO;
import crwm.site.pojo.Shop;
import crwm.site.pojo.ShopType;

import java.util.List;

/**
 * Created by makese on 2017/10/14.
 */
@Repository
public class ShopDAOImpl extends BaseDAOImpl<Shop> implements ShopDAO {

	@Override
	public Shop searchShopByTel(String tel) {
		String hql="from Shop s where s.tel=?";
		List<Shop> shopList= (List<Shop>) getHibernateTemplate().find(hql, tel);
		if(shopList.size()>0){
			
			return shopList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public Shop getShopByLoginId(String loginId) {
		String hql="from Shop s where s.loginId=?";
		List<Shop> shopList= (List<Shop>) getHibernateTemplate().find(hql, loginId);
		if(shopList.size()>0){
			
			return shopList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public Shop getShopByTel(String shopTel) {
		String hql="from Shop s where s.tel=?";
		List<Shop> shopList= (List<Shop>) getHibernateTemplate().find(hql, shopTel);
		if(shopList.size()>0){
			
			return shopList.get(0);
		}else{
			return null;
		}
	}

	@Override
	public List<Shop> getShopByType(ShopType type,boolean verify) {
		String hql="from Shop s where s.shopType=? and s.shopVerify=?";
		List<Shop> shopList= (List<Shop>) getHibernateTemplate().find(hql, type,verify);
		if(shopList.size()>0){
			
			return shopList;
		}else{
			return null;
		}
	}

	@Override
	public List<Shop> getShopByName(String searchName,boolean verify) {
		String hql="from Shop s where s.shopInfo.shopName like '%"+searchName+"%' and s.shopVerify=?";
		List<Shop> shopList= (List<Shop>) getHibernateTemplate().find(hql,verify);
		if(shopList.size()>0){
			
			return shopList;
		}else{
			return null;
		}
	}

	@Override
	public List<Shop> getShopListByShopVerify(boolean shopVerify) {
		return (List<Shop>) getHibernateTemplate().find("from Shop s where s.shopVerify = ?",shopVerify);
	}
}
