package crwm.site.pojo;

public class Admin {
	private int id;
	private String loginId;
	private String pwd;
	private String name;

	public Admin() {
	}

	public Admin(int id) {
		this.id = id;
	}

	public Admin(String loginId, String pwd, String name) {
		this.loginId = loginId;
		this.pwd = pwd;
		this.name = name;
	}

	public Admin(int id, String loginId, String pwd, String name) {
		this.id = id;
		this.loginId = loginId;
		this.pwd = pwd;
		this.name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
