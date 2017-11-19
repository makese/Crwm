package crwm.site.action;

import com.google.gson.reflect.TypeToken;
import crwm.site.biz.ReportBiz;
import crwm.site.pojo.Report;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

@Controller
@Scope("prototype")
public class ReportManageAction extends BaseManageAction<Report> {

    @Resource
    private ReportBiz reportBiz;

    private boolean status = false;

    private int id;

    @Override
    public String load() {
        setData(reportBiz.getReportListByStatus(status));
        return SUCCESS;
    }

    public String process() {
        Report report = reportBiz.getReportById(id);
        report.setStatus(true);
        report.setReportTime(new Date());
        reportBiz.updateReport(report);
        return SUCCESS;
    }

    @Override
    public Type getType() {
        return new TypeToken<ArrayList<Report>>() {}.getType();
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
