package views;

import java.sql.Connection;

import controllers.UserController;
import database.MySQLConnection;
import models.User;
import repositories.UserRepository;
import services.UserService;

public class Main {

	public static void main(String[] args) {
		Connection connection = MySQLConnection.getConnection();
		
		UserRepository userRepository = new UserRepository(connection);
		UserService userService = new UserService(userRepository);
		UserController userController = new UserController(userService);
		
		User user = new User("Guilherme", "guilhermevr.figueiredo@outlook.com", "1234", null);
		//userController.store(user);
		
		System.out.println(userController.show(1));
	}
}
