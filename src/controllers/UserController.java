package controllers;

import models.User;
import requests.UserRequest;
import services.UserService;
import utils.Response;

public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	public Response store(UserRequest userRequest) {
		try {
			userRequest.validate();
		}catch(IllegalArgumentException exception) {
			return new Response("error", exception.getMessage());
		}
		
		return this.userService.store(userRequest.toUser());
	}
	
	public User show(int id) {
		return this.userService.show(id);
	}
	
	public boolean update(User user) {
		return this.userService.update(user);
	}
}
