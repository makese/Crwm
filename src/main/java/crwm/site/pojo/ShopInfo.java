package crwm.site.pojo;

import org.apache.struts2.json.annotations.JSON;

import java.util.Date;

public class ShopInfo {
	private int id;
	private String shopName;
	private String shopAddress;
	private Shop shop;
	private String content;
	private Date settlingDate;
	public ShopInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopInfo(String shopName, String shopAddress, String content) {
		this.shopName = shopName;
		this.shopAddress = shopAddress;
		this.content = content;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopAddress() {
		return shopAddress;
	}
	public void setShopAddress(String shopAddress) {
		this.shopAddress = shopAddress;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	@JSON(format="yyyy-MM-dd HH:mm:ss")
	public Date getSettlingDate() {
		return settlingDate;
	}

	public void setSettlingDate(Date settlingDate) {
		this.settlingDate = settlingDate;
	}
}
