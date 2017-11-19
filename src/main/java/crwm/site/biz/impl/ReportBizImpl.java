package crwm.site.biz.impl;

import crwm.site.biz.ReportBiz;
import crwm.site.dao.ReportDAO;
import crwm.site.pojo.Report;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ReportBizImpl implements ReportBiz {
	
	@Resource
	private ReportDAO reportDAO;
	@Override
	public void addReport(Report report) {
		reportDAO.add(report);
	}

	@Override
	public void updateReport(Report report) {
		reportDAO.update(report);
	}

	@Override
	public List<Report> getReportList() {
		return reportDAO.getList();
	}

	@Override
	public List<Report> getReportListByStatus(boolean status) {
		return reportDAO.getReportListByStatus(status);
	}

	@Override
	public Report getReportById(int id) {
		return reportDAO.get(id);
	}

}
