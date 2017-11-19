package crwm.site.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import crwm.site.dao.ShopTypeDAO;
import crwm.site.pojo.ShopType;
import org.springframework.stereotype.Repository;

/**
 * Created by makese on 2017/10/14.
 */
@Repository
public class ShopTypeDAOImpl extends BaseDAOImpl<ShopType> implements ShopTypeDAO {

	@Override
	public ShopType getTypeByTypeName(String shopType) {
		String hql="from ShopType st where st.typeName=?";
		List<ShopType> shopTypeList=(List<ShopType>) getHibernateTemplate().find(hql, shopType);
		if(shopTypeList.size()>0){
			
			return shopTypeList.get(0);
		}else{
			
			return null;
		}
	}
}
