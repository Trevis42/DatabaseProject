package dbFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utilClasses.messagePopUp;

public class InsertToDB {
private String dbLoc = "jdbc:sqlite:";
	
	public InsertToDB(String dbPath) {
		dbLoc += dbPath;
	}
	
	public void insertUser(String dbName, int dbAge, String dbUser, String dbPass, String dbFavGame, String dbFavGenre, double dbBudget) {
		String query = "INSERT INTO users( name, age, username, password, favGenre, favGame, budget) VALUES (?, ?, ?, ?, ?, ?, ?)";
		
		//Class.forName(driver);
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(dbLoc);
			System.out.println("Database connected successfully.");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//database connected, start inserting user
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, dbName);
			pstmt.setInt(2, dbAge);
			pstmt.setString(3, dbUser);
			pstmt.setString(4, dbPass);
			pstmt.setString(5, dbFavGenre);
			pstmt.setString(6, dbFavGame);
			pstmt.setDouble(7, dbBudget);
			pstmt.executeUpdate();
			System.out.println("Data inserted.");
			messagePopUp.message("Successfully registered!", "Registration Success");
			
			conn.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			messagePopUp.messageError("There was an error with your information", "Registration Error");
		}
	} //end insertUser
	
	public void insertWishlist(String userName, int gameID) {
		String query = "INSERT INTO wishlist(username, gameID) VALUES (?, ?)";
		
		Connection conn = null;
		
		try {
			conn = DriverManager.getConnection(dbLoc);
			System.out.println("Database connected successfully.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		//database connected, start inserting wishlist item
		try {
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, userName);
			pstmt.setInt(2, gameID);
			pstmt.executeUpdate();
			System.out.println("Wishlist Data Updated.");
			messagePopUp.message("Wishlist Data Updated!", "Wishlist Update Success");
			conn.close();
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			messagePopUp.messageError("There was an error updating the wish list!", "Wishlist Update Error");
		}
	} //end insertUser
}
