package crwm.site.action;

import com.google.gson.reflect.TypeToken;
import crwm.site.biz.UserBiz;
import crwm.site.pojo.Admin;
import crwm.site.pojo.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.ArrayList;

/**
 * Created by makese on 2017/10/16.
 */
@Controller
@Scope("prototype")
public class UserManageAction extends BaseManageAction<User> {

    @Resource
    private UserBiz userBiz;

    @Override
    public String execute() throws Exception {
        return super.execute();
    }

    public String load(){
        setData(userBiz.getUserList());
        return SUCCESS;
    }

    public String edit(){
        jsonToData();
        for(int i = 0; i < getData().size(); i ++){
            User user = getData().get(i);
            user.getUserInfo().setUser(user);
            user.getUserInfo().setId(user.getId());
            userBiz.updateUser(user);
        }
        return SUCCESS;
    }

    public String remove(){
        jsonToData();
        for(int i = 0; i < getData().size(); i ++){
            User user = getData().get(i);
            user.getUserInfo().setUser(user);
            user.getUserInfo().setId(user.getId());
            userBiz.deleteUser(user);
        }
        return SUCCESS;
    }

    public String create(){
        jsonToData();
        for(int i = 0; i < getData().size(); i ++){
            User user = getData().get(i);
            user.getUserInfo().setUser(user);
            userBiz.addUser(user);
        }
        return SUCCESS;
    }

    @Override
    public Type getType() {
        return new TypeToken<ArrayList<User>>() {}.getType();
    }
}
