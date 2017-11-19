package crwm.site.pojo;

import java.util.Set;

import org.apache.struts2.json.annotations.JSON;

public class User {
	private String id;
	private String loginId;
	private String pwd;
	private String tel;
	private UserInfo userInfo;
	private Set<Cart> cartSet;
	private Set<Address> addressSet;
	private Set<Order> orderSet;
	private Set<Shop> myCollect;
	private Set<UserMessage> userMessageSet;
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String loginId, String pwd, String tel) {
		this.loginId = loginId;
		this.pwd = pwd;
		this.tel = tel;
	}

	public User(String id, String loginId, String pwd, String tel, UserInfo userInfo, Set<Cart> cartSet,
				Set<Address> addressSet, Set<Order> orderSet, Set<Shop> myCollect, Set<UserMessage> userMessageSet) {
		super();
		this.id = id;
		this.loginId = loginId;
		this.pwd = pwd;
		this.tel = tel;
		this.userInfo = userInfo;
		this.cartSet = cartSet;
		this.addressSet = addressSet;
		this.orderSet = orderSet;
		this.myCollect = myCollect;
		this.userMessageSet = userMessageSet;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
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
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	@JSON(serialize = false)
	public Set<Cart> getCartSet() {
		return cartSet;
	}
	public void setCartSet(Set<Cart> cartSet) {
		this.cartSet = cartSet;
	}
	@JSON(serialize = false)
	public Set<Address> getAddressSet() {
		return addressSet;
	}
	public void setAddressSet(Set<Address> addressSet) {
		this.addressSet = addressSet;
	}
	@JSON(serialize = false)
	public Set<Order> getOrderSet() {
		return orderSet;
	}
	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}
	@JSON(serialize = false)
	public Set<Shop> getMyCollect() {
		return myCollect;
	}
	public void setMyCollect(Set<Shop> myCollect) {
		this.myCollect = myCollect;
	}
	@JSON(serialize = false)
	public Set<UserMessage> getUserMessageSet() {
		return userMessageSet;
	}
	public void setUserMessageSet(Set<UserMessage> userMessageSet) {
		this.userMessageSet = userMessageSet;
	}
}
