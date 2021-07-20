package models;

public class Good {
	private int id;
	private String title;
	private String description;
	private int price;
	private String img;
	
	Good(int id, String title, String description, int price, String img){
		this.id = id;
		this.title = title;
		this.description = description;
		this.price = price;
		this.img = img;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getImg() {
		return img;
	}
	public void setImg(String img) {
		this.img = img;
	}
}
