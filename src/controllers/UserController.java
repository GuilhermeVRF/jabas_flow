package controllers;

import models.User;
import services.UserService;

public class UserController {
	private UserService userService;
	
	public UserController(UserService userService) {
		this.userService = userService;
	}
	
	public boolean store(User user) {
		return this.userService.store(user);
	}
	
	public User show(int id) {
		return this.userService.show(id);
	}
	
	public boolean update(User user) {
		return this.userService.update(user);
	}
}
