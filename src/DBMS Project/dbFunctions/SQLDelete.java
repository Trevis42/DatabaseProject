package dbFunctions;

import java.sql.Connection;
import java.sql.DriverManager;
import utilClasses.messagePopUp;

import java.sql.PreparedStatement;


public class SQLDelete {
	
	private static String sql = "jdbc:sqlite:";
	//private final static String driver = "org.sqlite.JDBC";

	public SQLDelete(String dbName) {
		sql += dbName;
	}

	public void delByPrime(String table, String username, int gameid) throws ClassNotFoundException {
		try {
			//Class.forName(driver);
			Connection conn = DriverManager.getConnection(sql);
			//Statement stat = conn.createStatement();
			String sqlDel = "delete from ? where username = ? and gameID = ?"; //might ahve to do tablename.attribue = instead
			PreparedStatement stmt = conn.prepareStatement(sqlDel);
			stmt.setString(1, table);
			stmt.setString(2, username);
			stmt.setInt(3, gameid);
			int flag = stmt.executeUpdate();
			if(flag == 1) {
				System.out.println("Success!");
				messagePopUp.message("Successfullly deleted entry!", "Delete Stuff");				
			}
			conn.close();     
			} catch (Exception e) {
				e.printStackTrace();
				messagePopUp.messageError(e.getMessage(), "Delete Error");
			} finally {
				System.out.println("Succeeded connecting to SQLite database!");
			}
	}
	public void delByPrime(String username, int gameid) throws ClassNotFoundException {
		try {
			//Class.forName(driver);
			Connection conn = DriverManager.getConnection(sql);
			//Statement stat = conn.createStatement();
			String sqlDel = "delete from wishlist where wishlist.username = ? and wishlist.gameID = ?";
			PreparedStatement stmt = conn.prepareStatement(sqlDel);
			stmt.setString(1, username);
			stmt.setInt(2, gameid);
			int flag = stmt.executeUpdate();
			if(flag == 1) {
				System.out.println("Success!");
				messagePopUp.message("Successfullly deleted entry!", "Delete Stuff");				
			}
			conn.close();     
			} catch (Exception e) {
				e.printStackTrace();
				messagePopUp.messageError(e.getMessage(), "Delete Error");
			} finally {
				System.out.println("Succeeded connecting to SQLite database!");
			}
	}

}