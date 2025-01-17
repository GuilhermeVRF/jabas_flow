package Router;
import java.util.List;

import models.Category;
import requests.LoginRequest;
import requests.UserRequest;
import utils.Response;
import utils.RouterDependencyInjection;

public final class Router {	
	public static Response storeUser(UserRequest userRequest) {
		return RouterDependencyInjection.getUserController().store(userRequest);
	}
	
	public static Response login(LoginRequest loginRequest) {
		return RouterDependencyInjection.getLoginController().login(loginRequest);
	}
	
	public static Response<List<Category>> getCategories(){
		return RouterDependencyInjection.getCategoryController().get();
	}
}
