package crwm.site.dao;

import crwm.site.pojo.User;

/**
 * Created by makese on 2017/10/10.
 */
public interface UserDAO extends BaseDAO<User> {
    User get(String loginId, String pwd);
    //ͨ���ֻ��Ų����û����жϸ��û��Ƿ�ע���
    User searchUser(String tel);
    //ͨ���˺Ų����û����жϸ��û��Ƿ�ע���
    User searchUserByLoginId(String loginId);
	User login(String loginId, String pwd);
	User login(String tel);
}
