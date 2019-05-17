/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbFunctions;

/**
 *
 * @author Futfack
 */
//import java.util.Scanner;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import utilClasses.messagePopUp;

//import java.sql.Statement;
import java.sql.PreparedStatement;

/**
 *
 * @author rwnor
 */
public class LoginDb {
	
	private String dbLoc = "jdbc:sqlite:";
	
	public LoginDb(String dbPath){
		dbLoc += dbPath;
	}

    private Connection connect() {
        //SQLite connection string
        Connection conn = null;
        try{
            conn = DriverManager.getConnection(dbLoc);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
      return conn;  
    }
    
    public int findMatch(String name, String pass){
        int count = 0;
        int accessAllowed = 0;
        // selects all usernames that match 'name' and all paswords that match 'pass'
        String sql = "SELECT * FROM Users WHERE Username = ? and Password = ?";// Username, Password FROM users";
        
        try(Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            
                pstmt.setString(1, name);
                pstmt.setString(2, pass);
                ResultSet rs = pstmt.executeQuery();
            
            //loop through the result set and count how many results were returned
            while (rs.next()) {
                count = count + 1;
               //  System.out.println(rs.getString("Username"));
                
            }
            //if result set is empty then  either Username or Password is incorrect, or User does not exist.
            if (count == 0) {
                System.out.println("Invalid Username or Password.");
                messagePopUp.messageError("Invalid Username or Password./nPlease try again.", "Login Failure");
            }
            else if (count == 1) {
                accessAllowed = 1;
                System.out.println("You are now logged in as...");
                messagePopUp.message("You are now logged in as: " + name, "Login Success");
                System.out.println(name); 
            }
                    
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return accessAllowed;
    }
}
   
   