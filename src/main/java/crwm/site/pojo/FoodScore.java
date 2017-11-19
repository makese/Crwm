package crwm.site.pojo;

public class FoodScore {
	private int id;
	private Food food;
	private int assessCount;
	private int totalPoints;
	public FoodScore() {
		super();
		// TODO Auto-generated constructor stub
	}
	public FoodScore(int id, Food food, int assessCount, int totalPoints) {
		super();
		this.id = id;
		this.food = food;
		this.assessCount = assessCount;
		this.totalPoints = totalPoints;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public int getAssessCount() {
		return assessCount;
	}
	public void setAssessCount(int assessCount) {
		this.assessCount = assessCount;
	}
	public int getTotalPoints() {
		return totalPoints;
	}
	public void setTotalPoints(int totalPoints) {
		this.totalPoints = totalPoints;
	}
	
}
