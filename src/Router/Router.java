package Router;
import java.sql.Connection;

import javax.swing.JPanel;

import controllers.UserController;
import database.MySQLConnection;
import repositories.UserRepository;
import requests.UserRequest;
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
}
