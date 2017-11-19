package crwm.site.pojo;

import org.apache.struts2.json.annotations.JSON;

public class UserInfo {
	private String id;
	private String nickName;
	private String realName;
	private double balance;
	private String headImg;
	private User user;
	public UserInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserInfo(String nickName, String realName, double balance, String headImg) {
		this.nickName = nickName;
		this.realName = realName;
		this.balance = balance;
		this.headImg = headImg;
	}

	public UserInfo(String id, String nickName, String realName, double balance, String headImg, User user) {
		super();
		this.id = id;
		this.nickName = nickName;
		this.realName = realName;
		this.balance = balance;
		this.headImg = headImg;
		this.user = user;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getNickName() {
		return nickName;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	public String getHeadImg() {
		return headImg;
	}
	public void setHeadImg(String headImg) {
		this.headImg = headImg;
	}
	@JSON(serialize = false)
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
}
