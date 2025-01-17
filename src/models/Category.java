package models;

public class Category {
	private int id;
	private String name;
	
	public Category(String name) {
		this.name = name;
	}

	public Category(int id, String name, int user_id) {
		this.id = id;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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
