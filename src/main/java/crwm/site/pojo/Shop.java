package crwm.site.pojo;

import java.util.Set;

public class Shop {
	private int id;
	private String loginId;
	private String pwd;
	private ShopType shopType;
	private String tel;
	private ShopInfo shopInfo;
	private ShopScore shopScore;
	private Set<Order> orderSet;
	private Set<Food> foodSet;
	private ShopAptitude shopAptitude;
	private boolean shopVerify;
	private String shopLogo;
	private Set<ShopMessage> shopMessageSet;
	private Set<Report> ReportSet;
	private Set<FoodType> foodTypeSet;
	public Shop() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Shop(int id) {
		this.id = id;
	}

	public Shop(String loginId, String pwd, String tel, boolean shopVerify, String shopLogo) {
		this.loginId = loginId;
		this.pwd = pwd;
		this.tel = tel;
		this.shopVerify = shopVerify;
		this.shopLogo = shopLogo;
	}

	public Shop(int id, String loginId, String pwd, ShopType shopType, String tel, ShopInfo shopInfo, ShopScore shopScore, Set<Order> orderSet, Set<Food> foodSet, ShopAptitude shopAptitude, boolean shopVerify, String shopLogo, Set<ShopMessage> shopMessageSet) {
		this.id = id;
		this.loginId = loginId;
		this.pwd = pwd;
		this.shopType = shopType;
		this.tel = tel;
		this.shopInfo = shopInfo;
		this.shopScore = shopScore;
		this.orderSet = orderSet;
		this.foodSet = foodSet;
		this.shopAptitude = shopAptitude;
		this.shopVerify = shopVerify;
		this.shopLogo = shopLogo;
		this.shopMessageSet = shopMessageSet;
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

	public ShopType getShopType() {
		return shopType;
	}

	public void setShopType(ShopType shopType) {
		this.shopType = shopType;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public ShopInfo getShopInfo() {
		return shopInfo;
	}

	public void setShopInfo(ShopInfo shopInfo) {
		this.shopInfo = shopInfo;
	}

	public ShopScore getShopScore() {
		return shopScore;
	}

	public void setShopScore(ShopScore shopScore) {
		this.shopScore = shopScore;
	}

	public Set<Order> getOrderSet() {
		return orderSet;
	}

	public void setOrderSet(Set<Order> orderSet) {
		this.orderSet = orderSet;
	}

	public Set<Food> getFoodSet() {
		return foodSet;
	}

	public void setFoodSet(Set<Food> foodSet) {
		this.foodSet = foodSet;
	}

	public ShopAptitude getShopAptitude() {
		return shopAptitude;
	}

	public void setShopAptitude(ShopAptitude shopAptitude) {
		this.shopAptitude = shopAptitude;
	}

	public boolean isShopVerify() {
		return shopVerify;
	}

	public void setShopVerify(boolean shopVerify) {
		this.shopVerify = shopVerify;
	}

	public String getShopLogo() {
		return shopLogo;
	}

	public void setShopLogo(String shopLogo) {
		this.shopLogo = shopLogo;
	}

	public Set<ShopMessage> getShopMessageSet() {
		return shopMessageSet;
	}

	public void setShopMessageSet(Set<ShopMessage> shopMessageSet) {
		this.shopMessageSet = shopMessageSet;
	}

	public Set<Report> getReportSet() {
		return ReportSet;
	}

	public void setReportSet(Set<Report> reportSet) {
		ReportSet = reportSet;
	}

	public Set<FoodType> getFoodTypeSet() {
		return foodTypeSet;
	}

	public void setFoodTypeSet(Set<FoodType> foodTypeSet) {
		this.foodTypeSet = foodTypeSet;
	}
}
