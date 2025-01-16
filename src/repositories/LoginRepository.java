package repositories;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Login;
import models.User;
import utils.EncryptUtils;
import utils.Response;

public class LoginRepository {
	private Connection connection;
	
	public LoginRepository(Connection connection) {
		this.connection = connection;
	}
	
	public Response<User> login(Login login) {
		String loginQuery = "SELECT * FROM User WHERE email = ? AND password = ?";
			
		try {
			String encryptedLoginPassword = EncryptUtils.encrypt(login.getPASSWORD());
			PreparedStatement preparedStatement = this.connection.prepareStatement(loginQuery);
			
			preparedStatement.setString(1, login.getEMAIL());
			preparedStatement.setString(2, encryptedLoginPassword);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				String imagePath = resultSet.getString("profile");
				File profileImage = new File(imagePath);
				return new Response<User>("success", "Login efetuado com sucesso!", 
						new User(
								resultSet.getInt("id"),
								resultSet.getString("name"),
								resultSet.getString("email"),
								resultSet.getString("password"),
								profileImage,
								resultSet.getDate("created_at"),
								resultSet.getDate("updated_at")
						)
				);
			}else {
				return new Response<User>("error", "Usuário ou senha incorreto(s)!");
			}
			
		}catch(SQLException | NoSuchAlgorithmException| UnsupportedEncodingException exception) {
			return new Response<User>("error", exception.getMessage());
		}
	}
}
