package crwm.site.biz;

import crwm.site.pojo.Address;
import crwm.site.pojo.User;
public interface AddressBiz {

	Address getAddress(int id);
	
	Address getDefaultAddressByUser(User user);

	void update(Address currAddress);

	void deleteAddress(Address target);

	void addAddress(Address address);

}
