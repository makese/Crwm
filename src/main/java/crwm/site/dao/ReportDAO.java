package crwm.site.dao;

import crwm.site.pojo.Report;

import java.util.List;

/**
 * Created by makese on 2017/10/14.
 */
public interface ReportDAO extends BaseDAO<Report> {

    List<Report> getReportListByStatus(boolean status);
}
