package net.codejava;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Movies {

	public static void main(String[] args) {
		String jdbcUrl="jdbc:sqlite;/C:\\Users\\fahme\\SQLite\\sqlite-tools-win32-x86-3370200\\moviesdb";
		
		try {
			
			Connection connection = DriverManager.getConnection(jdbcUrl);
			String sql = "SELECT * FROM movies";
			
			Statement statement = connection.createStatement();
			
			
			ResultSet result = statement.executeQuery(sql);
			
			while (result.next()) {
				String movie = result.getString("movie");
				String actor = result.getString("actor");
				String actress = result.getString("actress");
				String year = result.getString("year_of_release");
				String director = result.getString("director");
				
				System.out.println(movie + " | " + actor + " | " + actress + " | " + year + " | " + director);
								
			}
			
		} catch (SQLException e) {
			System.out.println("Error connecting to SQLite database");
			e.printStackTrace();
		}
		
		
		

	}

}
