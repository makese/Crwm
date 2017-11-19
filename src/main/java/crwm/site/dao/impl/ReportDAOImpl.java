package crwm.site.dao.impl;

import crwm.site.dao.ReportDAO;
import crwm.site.pojo.Report;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by makese on 2017/10/14.
 */
@Repository
public class ReportDAOImpl extends BaseDAOImpl<Report> implements ReportDAO {
    @Override
    public List<Report> getReportListByStatus(boolean status) {
        return (List<Report>) super.getHibernateTemplate().find("from Report r where r.status = ?", status);
    }
}
