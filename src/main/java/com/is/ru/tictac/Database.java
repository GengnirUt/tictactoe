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
    private static final String fileName = "GameInfo.db";

    private static final String createGameInfo = "CREATE TABLE IF NOT EXISTS gameinfo (\n"
	+ "gid INTEGER PRIMARY KEY,\n"
	+ "winnerid INTEGER NOT NULL, \n"
	+ "moves INTEGER, \n"
	+ "datetime REAL, \n"
	+ "FOREIGN KEY (winnerid) REFERENCES playerinfo(pid)\n"
	+ ");";

    private static final String createPlayerInfo = "CREATE TABLE IF NOT EXISTS playerinfo (\n"
	+ "pid INTEGER PRIMARY KEY, \n"
	+ "name TEXT, \n"
	+ ");";


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
    public static void createNewDatabase(){
	File dir = new File(dirName);

	String url = "jdbc:sqlite:" + dirName + fileName;

	checkDbDirectory(dir);

	try(Connection conn = DriverManager.getConnection(url)){
		if (conn != null){
		    DatabaseMetaData meta = conn.getMetaData();
		    createTables();
		    System.out.println("The driver name is " + meta.getDriverName());
		    System.out.println("A new database has been created.");
		}
	    } catch (SQLException e) {
	    
                System.out.println(e.getMessage());
        }
    }


    // A function to check if the database directory exists and create it if it isn't.
    private static void checkDbDirectory(File directory){
	if(!directory.exists())
	    directory.mkdir();

    }


    // A function to connect to the database.
    public static Connection databaseConnect() {
        Connection conn = null;

        try {
            String url = "jdbc:sqlite:"+dirName + fileName;
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            return conn;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
	    return null;

        }

    }

    // A funtion to create the Tables used in the database.   
    private static void createTables(){
	String url = "jdbc:sqlite:" + dirName + fileName;
	String createGameInfo = "CREATE TABLE IF NOT EXISTS gameinfo (\n"
	    + "gid INTEGER PRIMARY KEY,\n"
	    + "winnerid INTEGER NOT NULL, \n"
	    + "moves INTEGER, \n"
	    + "datetime REAL, \n"
	    + "FOREIGN KEY (winnerid) REFERENCES playerinfo(pid)\n"
	    + ");";

	String createPlayerInfo = "CREATE TABLE IF NOT EXISTS playerinfo (\n"
	    + "pid INTEGER PRIMARY KEY, \n"
	    + "name TEXT, \n"
	    + ");";

        try (Connection conn = DriverManager.getConnection(url);
	     Statement stmt = conn.createStatement()) {
		
		stmt.execute(createGameInfo);
		stmt.execute(createPlayerInfo);

	    } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

	insertIntoPlayerinfo();
    }


    // A function to insert the players into the playersinfo table.
    private static void insertIntoPlayerinfo(){
	String p1sql = "INSERT INTO playerinfo(pid, name) VALUES (1, \"Humanoid 1\")";
	String p2sql = "INSERT INTO playerinfo(pid, name) VALUES (1, \"Humanoid 2\")";
	String p3sql = "INSERT INTO playerinfo(pid, name) VALUES (1, \"Computer\")";

	try (Connection conn = databaseConnect();
	     PreparedStatement pstmt1 = conn.prepareStatement(p1sql);
	     PreparedStatement pstmt2 = conn.prepareStatement(p2sql);
	     PreparedStatement pstmt3 = conn.prepareStatement(p3sql)) {

	     pstmt1.executeUpdate();
	     pstmt2.executeUpdate();
	     pstmt3.executeUpdate();

	    } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    // Returns how often a player has won in total.
    public int selectPlayerHasWon(int playerID){
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
    public int selectPlayerWinningStreak(int playerID){
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

    // Returns all info in the gameinfo table.
    public void selectAll(){
        String sql = "SELECT * FROM gameinfo";

        try (Connection conn = databaseConnect();
             PreparedStatement pstmt  = conn.prepareStatement(sql)){
             ResultSet rs = pstmt.executeQuery();
	     
	     while(rs.next()){
		 System.out.println("Game: " + rs.getInt("gid") + "\t" +
				    "Player: " + rs.getInt("winnerID") + "\t" +
				    "Moves: " + rs.getInt("moves") + "\t" +
				    "Time: " + rs.getString("datetime"));
	     }

            } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    // Returns how many games have been played since the database was created.
    public int selectGamesInTotal(){
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
