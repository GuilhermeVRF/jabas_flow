package models;

public class Login {
	private final String EMAIL;
	private final String PASSWORD;
	
	public Login(String email, String password) {
		this.EMAIL = email;
		this.PASSWORD = password;
	}

	public String getEMAIL() {
		return this.EMAIL;
	}

	public String getPASSWORD() {
		return this.PASSWORD;
	}
	
	
}
