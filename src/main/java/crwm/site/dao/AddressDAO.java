package crwm.site.dao;

import crwm.site.pojo.Address;
import crwm.site.pojo.User;

/**
 * Created by makese on 2017/10/14.
 */
public interface AddressDAO extends BaseDAO<Address> {


	Address getDefaultAddressByUser(User user);
}
