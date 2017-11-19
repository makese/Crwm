package crwm.site.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import crwm.site.dao.AddressDAO;
import crwm.site.pojo.Address;
import crwm.site.pojo.User;

/**
 * Created by makese on 2017/10/14.
 */
@Repository
public class AddressDAOImpl extends BaseDAOImpl<Address> implements AddressDAO {

	@Override
	public Address getDefaultAddressByUser(User user) {
		String hql="from Address addr where addr.user=? and addr.defaultAddress=true";
		List<Address> addressList=(List<Address>) getHibernateTemplate().find(hql, user);
		if(addressList.size()>0){
			
			return addressList.get(0);
			
		}else{
			
			return null;
		}
	}

	
}
