package com.is.ru.tictac;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.io.File;


// Code from sqlitetutorial.net

public class Database{


    public static void createNewDatabase(String fileName){
	String dirName = "./Data/";
	File dir = new File(dirName);

	String url = "jdbc:sqlite:" + dirName + fileName;

	if(!dir.exists()){
	    dir.mkdir();
	}
	
	try(Connection conn = DriverManager.getConnection(url)){
		if (conn != null){
		    DatabaseMetaData meta = conn.getMetaData();
		    System.out.println("The driver name is " + meta.getDriverName());
		    System.out.println("A new database has been created.");
		}
	    } catch (SQLException e) {
	    
                System.out.println(e.getMessage());
        }
    }

}
