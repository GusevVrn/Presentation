package models;

public class User {
	private int id;
	private String username;
	private String password;
	private String phone;
	private int idBacket;
	
	User(int id,String username, String password, String phone, int idBacket){
		this.id = id;
		this.username = username;
		this.password = password;
		this.phone = phone;
		this.idBacket = idBacket;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}

	public int getIdBacket() {
		return idBacket;
	}

	public void setIdBacket(int idBacket) {
		this.idBacket = idBacket;
	}	
}
