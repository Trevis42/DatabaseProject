package dbFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SQLUpdate {

	private String dbLoc = "jdbc:sqlite:";
	
	public SQLUpdate(String dbPath) {
		dbLoc += dbPath;
	}
	
	public void updateUser(String userName, String password, String name, int age, String favGenre, String favGame, double budget) {
		String query = "UPDATE users SET password = ?, name = ?, age = ?, favGenre = ?, favGame = ?, budget = ? WHERE username = ?";
		
		//Class.forName(driver);
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(dbLoc);
			System.out.println("Database connected successfully.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//database connected, begin the update
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, password);
			pstmt.setString(2, name);
			pstmt.setInt(3, age);
			pstmt.setString(4, favGenre);
			pstmt.setString(5, favGame);
			pstmt.setDouble(6, budget);
			pstmt.setString(7, userName);
			pstmt.executeUpdate();
			System.out.println("Data modified.");
			conn.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
		}
	} //end insertUser
}

