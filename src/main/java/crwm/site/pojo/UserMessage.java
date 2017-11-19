package crwm.site.pojo;

import java.util.Date;

public class UserMessage {
	private int id;
	private User user;
	private String message;
	private Admin admin;
	private Date date;
	public UserMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserMessage(User user, String message, Admin admin, Date date) {
		this.user = user;
		this.message = message;
		this.admin = admin;
		this.date = date;
	}

	public UserMessage(int id, User user, String message, Admin admin, Date date) {
		super();
		this.id = id;
		this.user = user;
		this.message = message;
		this.admin = admin;
		this.date = date;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Admin getAdmin() {
		return admin;
	}
	public void setAdmin(Admin admin) {
		this.admin = admin;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	
}
