package com.is.ru.tictac;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.Statement;
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


    public static void databaseConnect() {
        Connection conn = null;

        try {
            String url = "jdbc:sqlite:"+dirName + fileName;
            conn = DriverManager.getConnection(url);
            
            System.out.println("Connection to SQLite has been established.");
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
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
	
    }



}
