package com.is.ru.tictac;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;
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
	+ "FOREIGN KEY (winnerid) REFERENCES playerinfo(pid)\n"
	+ ");";

    private static final String createPlayerInfo = "CREATE TABLE IF NOT EXISTS playerinfo (\n"
	+ "pid INTEGER PRIMARY KEY, \n"
	+ "name TEXT, \n"
	+ ");";


    public static void insertNewGame(int winner, int moves){
	String sql = "INSERT INTO gameinfo(winnerid, moves) VALUES (?,?)";

	try (Connection conn = databaseConnect();
	     PreparedStatement pstmt = conn.prepareStatement(sql)) {
		pstmt.setInt(1, winner);
		pstmt.setInt(2, moves);
		pstmt.executeUpdate();

	    } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

    }



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


    private static void checkDbDirectory(File directory){
	//	try{
	    if(!directory.exists())
	    	directory.mkdir();

	    //	} catch(IOException e){

	    //	    System.out.println(e.getMessage());
	    //	}
    }


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


    private static void createTables(){
	String url = "jdbc:sqlite:" + dirName + fileName;
        
        try (Connection conn = DriverManager.getConnection(url);
	     Statement stmt = conn.createStatement()) {
		
		stmt.execute(createGameInfo);
		stmt.execute(createPlayerInfo);

	    } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

	insertIntoPlayerinfo();
    }

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


}
