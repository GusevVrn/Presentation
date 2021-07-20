package models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class BaseModel {
	private static ArrayList<Category> categories = new ArrayList<Category>();
	private static ArrayList<Good> goods = new ArrayList<Good>();
	private static ArrayList<User> users = new ArrayList<User>();
	public static ArrayList<Feedback> feedbacks = new ArrayList<Feedback>();
	public static ArrayList<Basket> basket = new ArrayList<Basket>();

	static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(Config.driver);
		String url = "jdbc:mysql://localhost/" + Config.db;
		return DriverManager.getConnection(url, Config.login, Config.pass);
	}

	public static ArrayList<Category> getCategories() throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement("Select * from category");
		ResultSet rs = ps.executeQuery();
		int id;
		String name, img;
		categories.clear();
		while (rs.next()) {
			id = rs.getInt("id");
			name = rs.getString("name");
			img = rs.getString("img");
			categories.add(new Category(id, name, img));
		}
		return categories;
	}

	public static ArrayList<Good> getGoods(int id) throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement("Select * from goods where id_category = " + id);
		ResultSet rs = ps.executeQuery();
		int i, price;
		String title, desc, img;
		goods.clear();
		while (rs.next()) {
			i = rs.getInt("id");
			title = rs.getString("title");
			desc = rs.getString("description");
			price = rs.getInt("price");
			img = rs.getString("img");
			goods.add(new Good(i, title, desc, price, img));
		}
		return goods;
	}

	public static ArrayList<Good> getGoods() throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement("Select * from goods");
		ResultSet rs = ps.executeQuery();
		int i, price;
		String title, desc, img;
		goods.clear();
		while (rs.next()) {
			i = rs.getInt("id");
			title = rs.getString("title");
			desc = rs.getString("description");
			price = rs.getInt("price");
			img = rs.getString("img");
			goods.add(new Good(i, title, desc, price, img));
		}
		return goods;
	}

	public static Good getGood(int id) throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement("select * from goods where id = " + id);
		ResultSet rs = ps.executeQuery();
		int i, price;
		String title, desc, img;
		if (rs.next()) {
			i = rs.getInt("id");
			title = rs.getString("title");
			desc = rs.getString("description");
			price = rs.getInt("price");
			img = rs.getString("img");
			return new Good(i, title, desc, price, img);
		}
		return null;
	}

	public static ArrayList<User> getUsers() throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement("Select * from goods");
		ResultSet rs = ps.executeQuery();
		int i, idBacket;
		String username, password, phone;
		users.clear();
		while (rs.next()) {
			i = rs.getInt("id");
			username = rs.getString("Username");
			password = rs.getString("Password");
			phone = rs.getString("phone");
			idBacket = rs.getInt("idBacket");
			users.add(new User(i, username, password, phone, idBacket));
		}
		return users;
	}

	public static int FindUser(String username, String password) throws SQLException, ClassNotFoundException {
		int check = 0;
		try {
			Connection c = getConnection();
			PreparedStatement ps = c.prepareStatement(
					"SELECT id FROM user WHERE username = '" + username + "' and password = '" + password + "'");
			try {
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					return rs.getInt(1);
				} else {
					return -1;
				}
			} finally {
				c.close();
				ps.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return check;
	}

	public static int findbyUsername(String username) throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement("SELECT id FROM user WHERE username = '" + username + "'");
		try {
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return -1;
			}
		} finally {
			ps.close();
			c.close();
		}
	}

	public static int findIdUser(String phone) throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement("SELECT id FROM USER WHERE phone = '" + phone + "'");
		try {
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			} else {
				return -1;
			}
		} finally {
			c.close();
			ps.close();
		}
	}

	public static boolean addUser(String Username, String Password, String phone)
			throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		int b = getMaxBasket();
		PreparedStatement ps = c
				.prepareStatement("INSERT INTO `user`(`ID`,`Username`, `Password`, `phone`, `id_basket`) VALUES (NULL,'"
						+ Username + "','" + Password + "','" + phone + "','" + getMaxBasket() + "')");
		try {
			if (ps.executeUpdate() > 0) {
				return true;
			} else {

				return false;
			}
		} finally {
			c.close();
			ps.close();
		}
	}

	public static int getMaxBasket() throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement("SELECT MAX(`id_basket`) as 'max' FROM `user`");
		ResultSet rs = ps.executeQuery();
		int id;
		if (rs.next()) {
			id = rs.getInt("max") + 1;
		} else {
			id = 1;
		}
		return id;
	}

	public static ArrayList<Feedback> getFeedback() throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement("Select * from feedback");
		ResultSet rs = ps.executeQuery();
		int id;
		String name, email, text;
		feedbacks.clear();
		while (rs.next()) {
			id = rs.getInt("id");
			name = rs.getString("name");
			email = rs.getString("email");
			text = rs.getString("text");
			feedbacks.add(new Feedback(id, name, email, text));
		}
		return feedbacks;
	}

	public static boolean addFeed(String name, String email, String text) throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement("INSERT INTO `feedback`(`id`,`name`, `email`, `text`) VALUES (NULL,'"
				+ name + "','" + email + "','" + text + "')");
		try {
			if (ps.executeUpdate() > 0) {
				return true;
			} else {

				return false;
			}
		} finally {
			c.close();
			ps.close();
		}
	}

	public static boolean addToCart(int idGood, String username) throws SQLException, ClassNotFoundException {
		var c = getConnection();
		PreparedStatement ps = c
				.prepareStatement("INSERT INTO `basket`(`id`,`id_good`, `id_basket`, `status`) VALUES (NULL,'" + idGood
						+ "', (SELECT `id_basket` FROM `user` where username = '" + username + "'),'" + "Не оплачено"
						+ "')");
		try {
			if (ps.executeUpdate() > 0) {
				return true;
			} else {

				return false;
			}
		} finally {
			c.close();
			ps.close();
		}
	}

	public static ArrayList<Basket> getBasket() throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(
				"select b.id, g.title as 'title', g.price as 'price', u.username as 'user', u.phone as 'phone', status from basket b inner join goods g on b.id_good=g.id inner join user u on b.id_basket=u.id_basket where b.status = 'Отправлено' or b.status = 'Оплачено'");
		ResultSet rs = ps.executeQuery();
		int id, price;
		String title, user, status, phone;
		basket.clear();
		while (rs.next()) {
			id = rs.getInt("b.id");
			title = rs.getString("title");
			price = rs.getInt("price");
			user = rs.getString("user");
			phone = rs.getString("phone");
			status = rs.getString("status");
			basket.add(new Basket(id, title, price, user, phone, status));
		}
		return basket;
	}

	public static ArrayList<Basket> getBasket(String username) throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(
				"select b.id, g.title as 'title', g.price as 'price', u.username as 'user', u.phone as 'phone', status from basket b inner join goods g on b.id_good=g.id inner join user u on b.id_basket=u.id_basket where b.status != 'Не Оплачено' and b.status != 'Удалено' and u.username = '"+ username + "'");
		ResultSet rs = ps.executeQuery();
		int id, price;
		String title, user, status, phone;
		basket.clear();
		while (rs.next()) {
			id = rs.getInt("b.id");
			title = rs.getString("title");
			price = rs.getInt("price");
			user = rs.getString("user");
			phone = rs.getString("phone");
			status = rs.getString("status");
			basket.add(new Basket(id, title, price, user, phone, status));
		}
		return basket;
	}

	public static ArrayList<Basket> getCard(String username) throws ClassNotFoundException, SQLException {
		Connection c = getConnection();
		PreparedStatement ps = c.prepareStatement(
				"select b.id, g.title as 'title', g.price as 'price', u.username as 'user', u.phone as 'phone', status from basket b inner join goods g on b.id_good=g.id inner join user u on b.id_basket=u.id_basket where b.status = 'Не Оплачено' and u.username = '"
						+ username + "'");
		ResultSet rs = ps.executeQuery();
		int id, price;
		String title, user, status, phone;
		basket.clear();
		while (rs.next()) {
			id = rs.getInt("b.id");
			title = rs.getString("title");
			price = rs.getInt("price");
			user = rs.getString("user");
			phone = rs.getString("phone");
			status = rs.getString("status");
			basket.add(new Basket(id, title, price, user, phone, status));
		}
		return basket;
	}

	public static boolean promote(int idGood) throws SQLException, ClassNotFoundException {
		var c = getConnection();
		String status = "";
		PreparedStatement ps = c.prepareStatement("select status from `basket` where id = '" + idGood + "'");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			status = rs.getString(1);
		} else {
		}
		if (status.equals("Оплачено")) {
			status = "Отправлено";
		} else if (status.equals("Отправлено")) {
			status = "Доставлено";
		} else if (status.equals("Не оплачено")) {
			status = "Оплачено";
		}
		PreparedStatement ps1 = c
				.prepareStatement("update basket set status = '" + status + "' where id = '" + idGood + "'");
		try {
			if (ps1.executeUpdate() > 0) {
				return true;
			} else {

				return false;
			}
		} finally {
			c.close();
			ps.close();
		}
	}

	public static boolean drop(int idGood) throws SQLException, ClassNotFoundException {
		var c = getConnection();
		PreparedStatement ps = c.prepareStatement("update basket set status = 'Удалено' where id = '"+ idGood +"'");
		try {
			if (ps.executeUpdate() > 0) {
				return true;
			} else {
				return false;
			}
		} finally {
			c.close();
			ps.close();
		}
	}

}
