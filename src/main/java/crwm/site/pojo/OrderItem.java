package crwm.site.pojo;

public class OrderItem {
	private int id;
	private Order order;
	private int count;
	private Food food;
	private int foodGrade;
	private double total;
	public OrderItem(int id, Order order, int count, Food food, int foodGrade, double total) {
		super();
		this.id = id;
		this.order = order;
		this.count = count;
		this.food = food;
		this.foodGrade = foodGrade;
		this.total = total;
	}
	public OrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	public int getFoodGrade() {
		return foodGrade;
	}
	public void setFoodGrade(int foodGrade) {
		this.foodGrade = foodGrade;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}
	
	
}
