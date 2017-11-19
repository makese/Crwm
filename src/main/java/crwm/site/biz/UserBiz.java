package crwm.site.biz;

import crwm.site.pojo.User;

import java.util.List;

public interface UserBiz {
    List<User> getUserList();
    void addUser(User user);
    void deleteUser(User user);
    void updateUser(User user);
	User getUser(String tel);
	User getUser(User user);
	User getUserByLoginId(String loginId);
	User login(String loginId, String pwd);
	User login(String tel);
}
