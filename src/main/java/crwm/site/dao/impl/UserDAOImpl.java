package crwm.site.dao.impl;

import crwm.site.dao.UserDAO;
import crwm.site.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by makese on 2017/10/10.
 */
@Repository
public class UserDAOImpl extends BaseDAOImpl<User> implements UserDAO {

    @Override
    public User get(String loginId, String pwd) {
        List<User> userList = (List<User>) getHibernateTemplate()
                .find("from User u where u.loginId = ? and u.pwd = ?", loginId, pwd);
        if(userList != null && userList.size() != 0){
            return userList.get(0);
        } else {
            return null;
        }
    }

	@Override
	public User searchUser(String tel) {
		String hql="from User u where u.tel=?";
		 List<User> userList=(List<User>) getHibernateTemplate().find(hql,tel);
		if(userList.size()>0){
			User user=(User) getHibernateTemplate().find(hql, tel).get(0);
			return user;
		}else{
			return null;
		}
	}

	@Override
	public User searchUserByLoginId(String loginId) {
		String hql="from User u where u.loginId=?";
		 List<User> userList=(List<User>) getHibernateTemplate().find(hql,loginId);
		if(userList.size()>0){
			User user=userList.get(0);
			return user;
		}else{
			return null;
		}
	}

	@Override
	public User login(String loginId, String pwd) {
		String hql="from User u where u.loginId=? and u.pwd=? or u.tel=? and u.pwd=?";
		 List<User> userList=(List<User>) getHibernateTemplate().find(hql,loginId,pwd,loginId,pwd);
		 if(userList.size()>0){
				User user=userList.get(0);
				return user;
			}else{
				return null;
			}
		 
	}

	@Override
	public User login(String tel) {
		String hql="from User u where u.tel=?";
		List<User> userList=(List<User>) getHibernateTemplate().find(hql,tel);
		if(userList.size()>0){
			User user=userList.get(0);
			return user;
		}else{
			return null;
		}
	}
}
