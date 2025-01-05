package repositories;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.User;

public class UserRepository {
	private Connection connection;
	
	public UserRepository(Connection connection) {
		this.connection = connection;
	}
	
	public boolean store(User user) {
		String insertUserQuery = "INSERT INTO User (name, email, password, profile, created_at, updated_at) VALUES (?, ?, ?, ?, NOW(), NOW());";
		
		try {
			PreparedStatement preparedStatment = this.connection.prepareStatement(insertUserQuery);
			
			preparedStatment.setString(1, user.getName());
			preparedStatment.setString(2, user.getEmail());
			preparedStatment.setString(3, user.getPassword());
			preparedStatment.setString(4, user.getProfile());
			
			return preparedStatment.executeUpdate() > 0;
		}catch(SQLException exception) {
			System.err.println(exception.getMessage());
			return false;
		}
	}
	
	public User show(int id) {
		String selectUserQuery = "SELECT * FROM User WHERE id = ?";
		
		try {
			PreparedStatement preparedStatment = this.connection.prepareStatement(selectUserQuery);
			preparedStatment.setInt(1, id);
			
			ResultSet resultSet = preparedStatment.executeQuery();
			
			return resultSet.next() ? 
					new User(
							resultSet.getInt("id"),
							resultSet.getString("name"),
							resultSet.getString("email"),
							resultSet.getString("password"),
							resultSet.getString("profile"),
							resultSet.getDate("created_at"),
							resultSet.getDate("updated_at")
					)
				:
					null;
		}catch(SQLException exception) {
			System.err.println(exception.getMessage());
			return null;
		}
	}
	
	public boolean update(User user) {
		String updateUserQuery = "UPDATE User SET name = ?, email = ?, password = ?, updated_at = NOW() WHERE id = ?";
		try {
			PreparedStatement preparedStatment = this.connection.prepareStatement(updateUserQuery);
			
			preparedStatment.setString(1, user.getName());
			preparedStatment.setString(2, user.getEmail());
			preparedStatment.setString(3, user.getPassword());
			preparedStatment.setInt(4, user.getId());
			
			return preparedStatment.executeUpdate() > 0;
		}catch(SQLException exception) {
			return false;
		}
	}
}
