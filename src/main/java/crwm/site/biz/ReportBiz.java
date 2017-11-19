package crwm.site.biz;

import crwm.site.pojo.Report;

import java.util.List;

public interface ReportBiz {

	void addReport(Report report);

	void updateReport(Report report);

	List<Report> getReportList();

	List<Report> getReportListByStatus(boolean status);

	Report getReportById(int id);
}
