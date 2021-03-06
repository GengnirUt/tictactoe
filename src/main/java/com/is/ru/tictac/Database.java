package com.is.ru.tictac;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.io.File;
import java.io.IOException;


// Code from sqlitetutorial.net

public class Database{

    private static final String dirName = "./Data/";
    private static final String fileName = "Gameinfo.db";

    // A function to insert the results from the latest game into the database.
    public static void insertNewGame(int winner, int moves){
    	String sqlDate = "SELECT julianday('now') as date";
    	String sql = "INSERT INTO gameinfo(winnerid, moves, datetime) VALUES (?,?,?)";

    	try (Connection conn = databaseConnect();
    		PreparedStatement pstmtDate = conn.prepareStatement(sqlDate);
    		PreparedStatement pstmt = conn.prepareStatement(sql)) {
    		Double date = Double.parseDouble(pstmtDate.executeQuery().getString("date"));

    		pstmt.setInt(1, winner);
    		pstmt.setInt(2, moves);
    		pstmt.setDouble(3, date);
    		pstmt.executeUpdate();

    	} catch (SQLException e) {
    		System.out.println(e.getMessage());
        }
    }


    // A function to create a new database if it is not already set up.
    private static void createNewDatabase(){

    	String url = "jdbc:sqlite:" + dirName + fileName;

    	try(Connection conn = DriverManager.getConnection(url)){
    		if (conn != null){
    			DatabaseMetaData meta = conn.getMetaData();
		}
	    } catch (SQLException e) {
	    	System.out.println(e.getMessage());
        }

    }


    // A function to check if the database exists and creates it if it isn't.
    private static void checkDbExists(){
	File dir = new File(dirName);
	if(!dir.exists()){
	    System.out.println("creating folder and database");
	    createDirectory();
	    createNewDatabase();
	    createTables();	    
	    insertIntoPlayerinfo();
	    return;
	}
	File newdb = new File(dirName + fileName);
	if(!newdb.exists()){
	    System.out.println("creating just the database");
	    createNewDatabase();
	    createTables();
	    insertIntoPlayerinfo();
	}
	    
 }

    private static void createDirectory(){
	File dir = new File(dirName);
	if(!dir.mkdirs())
	    System.out.println("Not able to create directory");
    }


    // A function to connect to the database.
    public static Connection databaseConnect() {
        Connection conn = null;
	// Checking that the database exists before connecting to it.
	checkDbExists();
        try {
            String url = "jdbc:sqlite:"+dirName + fileName;
	    
            conn = DriverManager.getConnection(url);
	    return conn;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
	    return null;

        }

    }

    // A funtion to create the Tables used in the database.   
    private static void createTables(){
	String url = "jdbc:sqlite:" + dirName + fileName;
	String gameInfo = "CREATE TABLE IF NOT EXISTS gameinfo (\n"
	    + "gid INTEGER PRIMARY KEY,\n"
	    + "winnerid INTEGER NOT NULL, \n"
	    + "moves INTEGER, \n"
	    + "datetime REAL, \n"
	    + "FOREIGN KEY (winnerid) REFERENCES playerinfo(pid)\n"
	    + ")";

	String playerInfo = "CREATE TABLE IF NOT EXISTS playerinfo (\n"
	    + "pid INTEGER PRIMARY KEY, \n"
	    + "name TEXT \n"
	    + ")";

        try (Connection conn = DriverManager.getConnection(url);
	     Statement stmt = conn.createStatement()) {
		
		stmt.execute(gameInfo);
		stmt.execute(playerInfo);

	    } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

	// insertIntoPlayerinfo();
    }


    // A function to insert the players into the playersinfo table.
    private static void insertIntoPlayerinfo(){
	String p1sql = "INSERT INTO playerinfo(pid, name) VALUES (1, \"Humanoid 1\")";
	String p2sql = "INSERT INTO playerinfo(pid, name) VALUES (1, \"Humanoid 2\")";
	String p3sql = "INSERT INTO playerinfo(pid, name) VALUES (1, \"Computer\")";
	String p4sql = "INSERT INTO playerinfo(pid, name) VALUES (1, \"No winner\")";

	try (Connection conn = databaseConnect();
	     PreparedStatement pstmt1 = conn.prepareStatement(p1sql);
	     PreparedStatement pstmt2 = conn.prepareStatement(p2sql);
	     PreparedStatement pstmt3 = conn.prepareStatement(p3sql);
	     PreparedStatement pstmt4 = conn.prepareStatement(p4sql)) {

	     pstmt1.executeUpdate();
	     pstmt2.executeUpdate();
	     pstmt3.executeUpdate();
	     pstmt4.executeUpdate();

	    } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Returns how often a player has won in total.
    public static int selectPlayerHasWon(int playerID){
	String sql = "SELECT count(gid) AS wins FROM gameinfo WHERE winnerID = ?";

	try (Connection conn = databaseConnect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
            	pstmt.setInt(1, playerID);	
		return pstmt.executeQuery().getInt("wins");
            
	    } catch (SQLException e) {
            System.out.println(e.getMessage());
	    return -1;
        }
    }


    // Returns how often a player has won in a row.
    public static int selectPlayerWinningStreak(int playerID){
        String sql = "SELECT count(gid) AS streak FROM gameinfo WHERE winnerID = ? AND \n"
	    + "datetime > (SELECT MAX(datetime) FROM gameinfo WHERE winnerID <> ?)";

        try (Connection conn = databaseConnect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
                pstmt.setInt(1, playerID);
		pstmt.setInt(2, playerID);
                return pstmt.executeQuery().getInt("streak");

            } catch (SQLException e) {
	    System.out.println(e.getMessage());
	    return -1;
	}
    }
    
    // Returns how many games have been played since the database was created.
    public static int selectGamesInTotal(){
        String sql = "SELECT count(gid) AS games FROM gameinfo";

        try (Connection conn = databaseConnect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
                return pstmt.executeQuery().getInt("games");

            } catch (SQLException e) {
            System.out.println(e.getMessage());
            return -1;
        }
    }


}
