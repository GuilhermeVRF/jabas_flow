package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Category;
import models.User;
import utils.Response;
import utils.UserSession;

public class CategoryRepository {
	private Connection connection;
	
	public CategoryRepository(Connection connection) {
		this.connection = connection;
	}
	
	public Response store(Category category) {
		String categoryQuery = "INSERT INTO Category (name, user_id) VALUES (?,?)";
		return null;
	}
	
	public Response<List<Category>> get(){
		String categoriesQuery = "SELECT * FROM Category WHERE user_id = ?";
		User userSession = UserSession.getInstance().getUser();
		List<Category> categories = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatment = this.connection.prepareStatement(categoriesQuery);
			preparedStatment.setInt(1, userSession.getId());
			
			ResultSet resultSet = preparedStatment.executeQuery();
			
			while(resultSet.next()) {
				categories.add(new Category(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("user_id")));
			}
			
			return new Response<>("success", "Categorias coletadas com sucesso", categories);
		}catch(SQLException exception) {
			return new Response<>("error", "Erro durante a coleta das categorias", categories);
		}
	}
}
