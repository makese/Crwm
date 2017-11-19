package crwm.site.pojo;

import org.apache.struts2.json.annotations.JSON;

import java.util.Date;

public class Report {
	private int id;
	private Shop shop;
	private String comment;
	private boolean status;
	private Date reportTime;
	private User user;
	public Report() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Report(Shop shop, String comment, boolean status) {
		this.shop = shop;
		this.comment = comment;
		this.status = status;
	}

	public Report(int id, Shop shop, String comment, boolean statu, User user) {
		super();
		this.id = id;
		this.shop = shop;
		this.comment = comment;
		this.status = statu;
		this.user = user;
	}
	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Date getReportTime() {
		return reportTime;
	}

	public void setReportTime(Date reportTime) {
		this.reportTime = reportTime;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
