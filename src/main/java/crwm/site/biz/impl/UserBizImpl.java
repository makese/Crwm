package crwm.site.biz.impl;

import crwm.site.biz.UserBiz;
import crwm.site.dao.UserDAO;
import crwm.site.pojo.User;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserBizImpl implements UserBiz{
    @Resource
    private UserDAO userDAO;

    @Override
    public List<User> getUserList() {
        return userDAO.getList();
    }

    @Override
    public void addUser(User user) {
        userDAO.add(user);
    }

    @Override
    public void deleteUser(User user) {
        userDAO.delete(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.update(user);
    }



	@Override
	public User getUser(String tel) {
		return userDAO.searchUser(tel);
	}

	@Override
	public User getUserByLoginId(String loginId) {
		return userDAO.searchUserByLoginId(loginId);
	}

	@Override
	public User login(String loginId, String pwd) {
		return userDAO.login(loginId,pwd);
	}

    @Override
    public User getUser(User user) {
        return userDAO.get(user.getId());
    }

	@Override
	public User login(String tel) {
		
		return userDAO.login(tel);
	}
}
