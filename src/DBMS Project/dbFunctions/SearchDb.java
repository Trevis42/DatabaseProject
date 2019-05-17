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
//import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSetMetaData;



public class SearchDb {
	
	private String dbLoc = "jdbc:sqlite:";
	
	public SearchDb(String dbPath){
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
     } // end connect()
    
    //this method allows user to search the games table using parameters for any column value
    public String searchGamesTable(String serialNo, String name, String manfBy, String genre, String price, String estPlayTime, String manfDate) { //Connection paramater was just for testing use, no paramater needed if Connection is global variable.
       String queryResult = null;
        String sqlSearch = "SELECT serialNo, name, manfBy, genre, price, estPlayTime, manfDate FROM games "
                            + "WHERE serialNo = ? or name = ? or manfBy = ? or genre = ? or price = ? "
                            + "or estPlayTime = ? or manfDate = ? ";
        
        try(Connection conn = this.connect();
            PreparedStatement pst = conn.prepareStatement(sqlSearch)){
        
/*NOTE: SQL will allow for any of the following paramater calls to the above query statement to be null,
  i.e. when asked to give a value for a search attribute you dont want to specify information for, just press enter
  to give it a null string which will in turn delete/null that condition from the above SQL query statement.*/
         pst.setString(1, serialNo);   
         pst.setString(2, name);
         pst.setString(3, manfBy);
         pst.setString(4, genre);
         pst.setString(5, price);
         pst.setString(6, estPlayTime);
         pst.setString(7, manfDate);
                  
         ResultSet rs1 = pst.executeQuery();         
         queryResult = ConcatenateResultSet(rs1);   
       
        } catch(SQLException e){
            System.out.println(e.getMessage());
        }
        return queryResult;
    } //end searchGamesTable
    
    public String searchUserWish(String user) {
        String queryResult = null;
        String sqlSearch = "SELECT serialNo, name, manfBy, genre, price, estPlayTime, manfDate "
                            + "FROM games INNER JOIN wishlist on games.serialNO = wishlist.gameID "
                            + "WHERE wishlist.username = ? ";
        
        try(Connection conn = this.connect();
                PreparedStatement pst = conn.prepareStatement(sqlSearch)){
        
            pst.setString(1, user);
            
            ResultSet rs1 = pst.executeQuery();
            queryResult = ConcatenateResultSet(rs1);
          // System.out.println("printing queryResult...\n\n\n");
         //   System.out.println(queryResult);
        
    } catch(SQLException e){
        System.out.println(e.getMessage());
    }
        return queryResult;
    } //end searchUserWish
    
    public String ConcatenateResultSet(ResultSet rslt){   
        String attribute;
        int difference;        
        int maxLength = 0;
        String result = "";
        try{
        ResultSetMetaData rsmd = rslt.getMetaData();
        int numColumns = rsmd.getColumnCount();   
        
        //print the column lables before printing attribute information               
         for(int j = 1; j <= numColumns; j++){
             attribute = rsmd.getColumnLabel(j);
             
             //set maxLength for each attribute field
             switch (j) {
                 case 1: maxLength = 8;
                 break;
                 case 2: maxLength = 25;
                 break;
                 case 3: maxLength = 25;
                 break;
                 case 4: maxLength = 10;
                 break;
                 case 5: maxLength = 7;
                 break;
                 case 6: maxLength = 4;
                 break;
                 case 7: maxLength = 4;
                 break;
                 default:
                     break;             
             }
             
             //find the ammount of spaces needed to fill the attribute field
             difference = maxLength - attribute.length();
             
             //pad string with necessary ammount of spaces for organized printing
             for (int k = 0; k < difference; k++) {
                 attribute += " ";
             }
             //finish it off with a tab to seperate from next attribute
             attribute += "\t";   
             
           // System.out.print(rsmd.getColumnLabel(j) + "\t\t\t");
            result += attribute;
         }
       //skip line after printing column labels
        result += "\n";
        
        //loop through each tuple of the result set
        while (rslt.next()) {
            
            //loop through each attribute of the tuple and concatenate string with result
            for(int i = 1; i <= numColumns; i++){   
                attribute = rslt.getString(i);
                
                //set maxLength for each attribute field
                switch (i) {
                 case 1: maxLength = 8; //serialNo
                 break;
                 case 2: maxLength = 25; //name
                 break;
                 case 3: maxLength = 25; //manfBy
                 break;
                 case 4: maxLength = 10; //genre
                 break;
                 case 5: maxLength = 7; //price
                 break;
                 case 6: maxLength = 11; //estPlayTime
                 break;
                 case 7: maxLength = 4; //manfDate
                 break;
                 default:
                     break;    
                } //end switch(i)
                
                //find the ammount of spaces needed to fill the attribute field
                difference = maxLength - attribute.length();
                
                //pad string with necessary ammount of spaces for organized printing
                for (int k = 0; k < difference; k++) {
                    attribute += " ";
                }
                //finish it off with a tab to seperate from next attribute
                attribute +="\t";                
                        
                //concatenate next attribute in the tuple with result            
                result += attribute;
            } //end for loop
            
            //Move down to next line (tuple)          
            result += "\n";                 
        } //end tuple loop while
        
        } catch (SQLException e){
            System.out.println(e.getMessage());
        }      
        return result;
    } //end ConcatenateResultSet   
} // end class SearchDb
