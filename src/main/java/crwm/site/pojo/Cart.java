package crwm.site.pojo;

public class Cart {
	private int id;
	private User user;
	private int count;
	private Food food;
	public Cart() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

	public Cart(User user, int count, Food food) {
		super();
		this.user = user;
		this.count = count;
		this.food = food;
	}



	public Cart(int id, User user, int count, Food food) {
		super();
		this.id = id;
		this.user = user;
		this.count = count;
		this.food = food;
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
	
}
