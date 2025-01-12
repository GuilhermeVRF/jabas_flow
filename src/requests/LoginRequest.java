package requests;

import java.util.regex.Pattern;

import models.Login;

public class LoginRequest implements FormRequest<Login>{
	private String email;
	private String password;
	
	public LoginRequest(String email, String password) {
		this.email = email;
		this.password = password;
	}
	
	@Override
	public void validate() {
		if (email == null || email.isBlank())throw new IllegalArgumentException("O campo e-mail é obrigatório!");
        if(!Pattern.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", email)) throw new IllegalArgumentException("Formato especificado de e-mail inválido!");
        if (password == null || password.isBlank()) throw new IllegalArgumentException("O campo senha é obrigatório!");
	}

	@Override
	public Login toModel() {
		return new Login(this.email, this.password);
	}

}
