package crwm.site.action;

import com.google.gson.reflect.TypeToken;
import crwm.site.biz.AdminBiz;
import crwm.site.pojo.Admin;
import crwm.site.pojo.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by makese on 2017/10/19.
 */
@Controller
@Scope("prototype")
public class AdminManageAction extends BaseManageAction<Admin>{

    @Resource
    private AdminBiz adminBiz;

    @Override
    public String load() {
        setData(adminBiz.getAdminList());
        return SUCCESS;
    }

    @Override
    public String edit() {
        jsonToData();
        for(int i = 0; i < getData().size(); i ++){
            adminBiz.updateAdmin(getData().get(i));
        }
        return SUCCESS;
    }

    @Override
    public String remove() {
        jsonToData();
        for(int i = 0; i < getData().size(); i ++){
            adminBiz.deleteAdmin(getData().get(i));
        }
        return SUCCESS;
    }

    @Override
    public String create() {
        jsonToData();
        for(int i = 0; i < getData().size(); i ++){
            adminBiz.addAdmin(getData().get(i));
        }
        return SUCCESS;
    }

    @Override
    public Type getType() {
        return new TypeToken<ArrayList<Admin>>() {}.getType();
    }

}
