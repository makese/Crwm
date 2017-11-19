package crwm.site.pojo;

public class ShopAptitude {
	private int id;
	private String IDCardImgZ;
	private String IDCardImgF;
	private String shopImg;
	private String businessLicenseImg;
	private String foodLicense;
	private Shop shop;
	public ShopAptitude() {
		super();
	}

	public ShopAptitude(String IDCardImgZ, String IDCardImgF, String shopImg, String businessLicenseImg, String foodLicense) {
		this.IDCardImgZ = IDCardImgZ;
		this.IDCardImgF = IDCardImgF;
		this.shopImg = shopImg;
		this.businessLicenseImg = businessLicenseImg;
		this.foodLicense = foodLicense;
	}

	public ShopAptitude(String IDCardImgZ, String IDCardImgF, String shopImg, String businessLicenseImg, String foodLicense, Shop shop) {
		this.IDCardImgZ = IDCardImgZ;
		this.IDCardImgF = IDCardImgF;
		this.shopImg = shopImg;
		this.businessLicenseImg = businessLicenseImg;
		this.foodLicense = foodLicense;
		this.shop = shop;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getIDCardImgZ() {
		return IDCardImgZ;
	}

	public void setIDCardImgZ(String IDCardImgZ) {
		this.IDCardImgZ = IDCardImgZ;
	}

	public String getIDCardImgF() {
		return IDCardImgF;
	}

	public void setIDCardImgF(String IDCardImgF) {
		this.IDCardImgF = IDCardImgF;
	}

	public String getShopImg() {
		return shopImg;
	}

	public void setShopImg(String shopImg) {
		this.shopImg = shopImg;
	}

	public String getBusinessLicenseImg() {
		return businessLicenseImg;
	}

	public void setBusinessLicenseImg(String businessLicenseImg) {
		this.businessLicenseImg = businessLicenseImg;
	}

	public String getFoodLicense() {
		return foodLicense;
	}

	public void setFoodLicense(String foodLicense) {
		this.foodLicense = foodLicense;
	}

	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
}
