package models;

import java.sql.Date;

public class User {
	private int id;
	private String name;
	private String email;
	private String password;
	private String profile;
	private Date created_at;
	private Date updated_at;
	
	public User(String name, String email, String password, String profile) {
		this.name = name;
		this.email = email;
		this.password = password;
		this.profile = profile;
	}

	public User(int id, String name, String email, String password, String profile, Date created_at, Date updated_at) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.profile = profile;
		this.created_at = created_at;
		this.updated_at = updated_at;
	}
	
	public int getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getProfile() {
		return this.profile;
	}

	public void setProfile(String profile) {
		this.profile = profile;
	}
	
	public Date getUpdated_at() {
		return updated_at;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public String toString() {
		return "ID: " + this.id + "\n" +
				"Name: " + this.name + "\n" +
				"E-mail: " + this.email + "\n" +
				"Password: " + this.password + "\n" +
				"Profile: " + this.profile + "\n";
	}
}
