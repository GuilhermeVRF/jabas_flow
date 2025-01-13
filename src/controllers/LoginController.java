package controllers;

import requests.LoginRequest;
import services.LoginService;
import utils.Response;

public class LoginController {
	private LoginService loginService;
	
	public LoginController(LoginService loginService) {
		this.loginService = loginService;
	}
	
	public Response login(LoginRequest loginRequest) {
		try {
			loginRequest.validate();
		}catch(IllegalArgumentException exception) {
			return new Response("error", exception.getMessage());
		}
		
		return this.loginService.login(loginRequest.toModel());
	}
}
