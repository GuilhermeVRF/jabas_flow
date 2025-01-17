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
	
	private boolean categoryNameExists(String name) {
		String categoryExistsQuery = "SELECT * FROM Category WHERE name = ? AND user_id = ?";
		User userSession = UserSession.getInstance().getUser();
		
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(categoryExistsQuery);
			preparedStatement.setString(1, name);
			preparedStatement.setInt(2, userSession.getId());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			return resultSet.next();
		}catch(SQLException exception) {
			return false;
		}
	}
	
	public Response<Category> store(Category category) {
		if(this.categoryNameExists(category.getName())) return new Response<Category>("error", "Já existe uma categoria cadastrada com esse nome!");
		
		String categoryQuery = "INSERT INTO Category (name, user_id) VALUES (?,?)";
		User userSession = UserSession.getInstance().getUser();
		
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(categoryQuery);
			preparedStatement.setString(1, category.getName());
			preparedStatement.setInt(2, userSession.getId());
			
			if(preparedStatement.executeUpdate() > 0) return new Response<Category>("success", "Categoria criada com sucesso!", category);
			
			return new Response<Category>("error", "Não foi possível criar a categoria!");
		}catch(SQLException exception) {
			return new Response<Category>("error", "Não foi possível criar a categoria!");
		}
	}
	
	public Response<List<Category>> get(){
		String categoriesQuery = "SELECT * FROM Category WHERE user_id = ?";
		User userSession = UserSession.getInstance().getUser();
		List<Category> categories = new ArrayList<>();
		
		try {
			PreparedStatement preparedStatement = this.connection.prepareStatement(categoriesQuery);
			preparedStatement.setInt(1, userSession.getId());
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				categories.add(new Category(resultSet.getInt("id"), resultSet.getString("name"), resultSet.getInt("user_id")));
			}
			
			return new Response<>("success", "Categorias coletadas com sucesso", categories);
		}catch(SQLException exception) {
			return new Response<>("error", "Erro durante a coleta das categorias", categories);
		}
	}
}
