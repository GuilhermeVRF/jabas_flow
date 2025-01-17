package models;

public class Category {
	private int id;
	private String name;
	private int user_id;
	
	public Category(String name, int user_id) {
		this.name = name;
		this.user_id = user_id;
	}

	public Category(int id, String name, int user_id) {
		this.id = id;
		this.name = name;
		this.user_id = user_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getUser_id() {
		return user_id;
	}

	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	public int getId() {
		return id;
	}
	
	public String toString() {
		return "Category: "+ "\n" +
				"ID: " + this.id + "\n" +
				"Name: " + this.name;
 	}
}
