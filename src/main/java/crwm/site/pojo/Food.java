package crwm.site.pojo;

import org.apache.struts2.json.annotations.JSON;

public class Food {
	private int id;
	private String foodName;
	private Shop shop;
	private FoodType foodType;
	private String foodImg;
	private double price;
	private String introduction;
	private FoodScore foodScore;
	public Food() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Food(int id, String foodName, Shop shop, FoodType foodType, String foodImg, double price,
			String introduction, FoodScore foodScore) {
		super();
		this.id = id;
		this.foodName = foodName;
		this.shop = shop;
		this.foodType = foodType;
		this.foodImg = foodImg;
		this.price = price;
		this.introduction = introduction;
		this.foodScore = foodScore;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodName() {
		return foodName;
	}
	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}
	@JSON(serialize = false)
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public FoodType getFoodType() {
		return foodType;
	}
	public void setFoodType(FoodType foodType) {
		this.foodType = foodType;
	}
	public String getFoodImg() {
		return foodImg;
	}
	public void setFoodImg(String foodImg) {
		this.foodImg = foodImg;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getIntroduction() {
		return introduction;
	}
	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}
	@JSON(serialize = false)
	public FoodScore getFoodScore() {
		return foodScore;
	}
	public void setFoodScore(FoodScore foodScore) {
		this.foodScore = foodScore;
	}

	
 
}
