package repositories;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Login;
import utils.EncryptUtils;
import utils.Response;

public class LoginRepository {
	private Connection connection;
	
	public LoginRepository(Connection connection) {
		this.connection = connection;
	}
	
	public Response login(Login login) {
		String loginQuery = "SELECT id FROM User WHERE email = ? AND password = ?";
			
		try {
			String encryptedLoginPassword = EncryptUtils.encrypt(login.getPASSWORD());
			PreparedStatement preparedStatement = this.connection.prepareStatement(loginQuery);
			
			preparedStatement.setString(1, login.getEMAIL());
			preparedStatement.setString(2, encryptedLoginPassword);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			if(resultSet.next()) {
				return new Response("success", "Login efetuado com sucesso!");
			}else {
				return new Response("error", "Usuário ou senha incorreto(s)!");
			}
			
		}catch(SQLException | NoSuchAlgorithmException| UnsupportedEncodingException exception) {
			return new Response("error", exception.getMessage());
		}
	}
}
