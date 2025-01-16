package Router;
import java.sql.Connection;

import javax.swing.JPanel;

import controllers.LoginController;
import controllers.UserController;
import database.MySQLConnection;
import models.User;
import repositories.LoginRepository;
import repositories.UserRepository;
import requests.LoginRequest;
import requests.UserRequest;
import services.LoginService;
import services.UserService;
import utils.Response;
import views.Main;

public final class Router {
	/* Displaying view */
	public static JPanel displayingView = null;
	
	public static void displayView(JPanel view) {
		if(displayingView != null) Main.FRAME.remove(displayingView);
		
		displayingView = view;
		Main.FRAME.add(view);
		Main.FRAME.revalidate();
		Main.FRAME.repaint();
	}
	
	/* Database Connection */
	private static final Connection connection = MySQLConnection.getConnection();
	
	/* User handler */
	private static final UserRepository USER_REPOSITORY = new UserRepository(connection);
	private static final UserService USER_SERVICE = new UserService(USER_REPOSITORY);
	private static final UserController USER_CONTROLLER = new UserController(USER_SERVICE);
	
	public static Response storeUser(UserRequest userRequest) {
		return USER_CONTROLLER.store(userRequest);
	}
	
	/* Login handler */
	private static final LoginRepository LOGIN_REPOSITORY = new LoginRepository(connection);
	private static final LoginService LOGIN_SERVICE = new LoginService(LOGIN_REPOSITORY);
	private static final LoginController LOGIN_CONTROLLER = new LoginController(LOGIN_SERVICE);
	
	public static Response<User> login(LoginRequest loginRequest) {
		return LOGIN_CONTROLLER.login(loginRequest);
	}
}
