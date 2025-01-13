package services;

import models.Login;
import repositories.LoginRepository;
import utils.Response;

public class LoginService {
	private LoginRepository loginRepository;
	
	public LoginService(LoginRepository loginRepository) {
		this.loginRepository = loginRepository;
	}
	
	public Response login(Login login) {
		return this.loginRepository.login(login);
	}
}
