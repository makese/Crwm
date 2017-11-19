package crwm.site.pojo;

public class Address {
	private int id;
	private User user;
	private String address;
	private String phoneNumber;
	private String linkPersonName;
	private boolean defaultAddress;
	public Address() {
		super();
		// TODO Auto-generated constructor stub`
	}
	public Address(int id, User user, String address, String phoneNumber, String linkPersonName,
			boolean defaultAddress) {
		super();
		this.id = id;
		this.user = user;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.linkPersonName = linkPersonName;
		this.defaultAddress = defaultAddress;
	}
	
	public Address(User user, String address, String phoneNumber, String linkPersonName) {
		super();
		this.user = user;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.linkPersonName = linkPersonName;
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
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLinkPersonName() {
		return linkPersonName;
	}
	public void setLinkPersonName(String linkPersonName) {
		this.linkPersonName = linkPersonName;
	}
	public boolean isDefaultAddress() {
		return defaultAddress;
	}
	public void setDefaultAddress(boolean defaultAddress) {
		this.defaultAddress = defaultAddress;
	}
	
}
