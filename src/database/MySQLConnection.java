package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {
	private static Connection connection;
	private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
	private static final String URL = "jdbc:mysql://localhost:3306/jabas_flow";
	private static final String USER = "root";
	private static final String PASSWORD = "root";
	
	public static Connection getConnection() {
		if(connection != null) return connection;
		
		try {
			Class.forName(DRIVER);
			connection = DriverManager.getConnection(URL, USER, PASSWORD);
			
			return connection;
		}catch(ClassNotFoundException | SQLException exception) {
			System.err.println("Não foi possível conectar ao banco de dados: " + exception.getMessage());
			return null;
		}
	}
}
