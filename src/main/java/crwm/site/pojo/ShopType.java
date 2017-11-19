package crwm.site.pojo;

public class ShopType {
	private int id;
	private String typeName;
	public ShopType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ShopType(String typeName) {
		this.typeName = typeName;
	}

	public ShopType(int id, String typeName) {
		super();
		this.id = id;
		this.typeName = typeName;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTypeName() {
		return typeName;
	}
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
}
