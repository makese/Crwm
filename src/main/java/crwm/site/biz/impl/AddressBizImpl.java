package crwm.site.biz.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import crwm.site.biz.AddressBiz;
import crwm.site.dao.AddressDAO;
import crwm.site.pojo.Address;
import crwm.site.pojo.User;
@Service
public class AddressBizImpl implements AddressBiz {
	@Resource
	private AddressDAO addressDAO;
	@Override
	public Address getAddress(int id) {
		return addressDAO.get(id);
	}
	@Override
	public Address getDefaultAddressByUser(User user) {
		return addressDAO.getDefaultAddressByUser(user);
	}
	@Override
	public void update(Address currAddress) {
		addressDAO.update(currAddress);
		
	}
	@Override
	public void deleteAddress(Address target) {
		addressDAO.delete(target);
		
	}
	@Override
	public void addAddress(Address address) {
		addressDAO.add(address);
		
	}
	

}
