package crwm.site.biz;

import crwm.site.pojo.Admin;

import java.util.List;

public interface AdminBiz {
    List<Admin> getAdminList();
    Admin getAdmin(Admin admin);
    void deleteAdmin(Admin admin);
    void updateAdmin(Admin admin);
    void addAdmin(Admin admin);
}
