package crwm.site.biz.impl;

import crwm.site.biz.AdminBiz;
import crwm.site.dao.AdminDAO;
import crwm.site.pojo.Admin;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AdminBizImpl implements AdminBiz {

    @Resource
    private AdminDAO adminDAO;

    @Override
    public List<Admin> getAdminList() {
        return adminDAO.getList();
    }

    @Override
    public Admin getAdmin(Admin admin) {
        return adminDAO.get(admin.getId());
    }

    @Override
    public void deleteAdmin(Admin admin) {
        adminDAO.delete(admin);
    }

    @Override
    public void updateAdmin(Admin admin) {
        adminDAO.update(admin);
    }

    @Override
    public void addAdmin(Admin admin) {
        adminDAO.add(admin);
    }
}
