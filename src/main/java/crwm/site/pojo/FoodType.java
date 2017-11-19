package crwm.site.pojo;

import org.apache.struts2.json.annotations.JSON;

import java.util.Set;

public class FoodType {
	private int id;
	private String foodTypeName;
	private Set<Food> foodSet;
	private Shop shop;
	public FoodType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FoodType(int id, String foodTypeName) {
		super();
		this.id = id;
		this.foodTypeName = foodTypeName;
	}

	public FoodType(String foodTypeName, Shop shop) {
		this.foodTypeName = foodTypeName;
		this.shop = shop;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFoodTypeName() {
		return foodTypeName;
	}
	public void setFoodTypeName(String foodTypeName) {
		this.foodTypeName = foodTypeName;
	}
	public FoodType(String foodTypeName) {
		super();
		this.foodTypeName = foodTypeName;
	}

	public Set<Food> getFoodSet() {
		return foodSet;
	}

	public void setFoodSet(Set<Food> foodSet) {
		this.foodSet = foodSet;
	}
	@JSON(serialize = false)
	public Shop getShop() {
		return shop;
	}

	public void setShop(Shop shop) {
		this.shop = shop;
	}
}
