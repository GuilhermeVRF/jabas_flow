package utils;

import java.sql.Connection;

import controllers.CategoryController;
import controllers.LoginController;
import controllers.UserController;
import database.MySQLConnection;
import repositories.CategoryRepository;
import repositories.LoginRepository;
import repositories.UserRepository;
import services.CategoryService;
import services.LoginService;
import services.UserService;

public class RouterDependencyInjection {
private static final Connection connection = MySQLConnection.getConnection();
    
    public static UserController getUserController() {
        UserRepository userRepository = new UserRepository(connection);
        UserService userService = new UserService(userRepository);
        return new UserController(userService);
    }
    
    public static LoginController getLoginController() {
        LoginRepository loginRepository = new LoginRepository(connection);
        LoginService loginService = new LoginService(loginRepository);
        return new LoginController(loginService);
    }
    
    public static CategoryController getCategoryController() {
    	CategoryRepository categoryRepository = new CategoryRepository(connection);
    	CategoryService categoryService = new CategoryService(categoryRepository);
        return new CategoryController(categoryService);
    }
}
