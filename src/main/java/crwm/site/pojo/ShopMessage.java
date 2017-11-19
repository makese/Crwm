package crwm.site.pojo;

import org.apache.struts2.json.annotations.JSON;

import java.util.Date;

public class ShopMessage {
	private int id;
	private Shop shop;
	private String message;
	private Admin admin;
	private Date date;
	public ShopMessage() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopMessage(Shop shop, String message, Admin admin, Date date) {
		this.shop = shop;
		this.message = message;
		this.admin = admin;
		this.date = date;
	}

	public ShopMessage(int id, Shop shop, String message, Admin admin, Date date) {
		super();
		this.id = id;
		this.shop = shop;
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
	@JSON(serialize = false)
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
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
