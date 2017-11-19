package crwm.site.pojo;

public class ShopScore {
	private int id;
	private Shop shop;
	private int assessCount;
	private int totalScore;
	public ShopScore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ShopScore(int id, Shop shop, int assessCount, int totalScore) {
		super();
		this.id = id;
		this.shop = shop;
		this.assessCount = assessCount;
		this.totalScore = totalScore;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Shop getShop() {
		return shop;
	}
	public void setShop(Shop shop) {
		this.shop = shop;
	}
	public int getAssessCount() {
		return assessCount;
	}
	public void setAssessCount(int assessCount) {
		this.assessCount = assessCount;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	
}
