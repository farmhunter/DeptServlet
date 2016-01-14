package com.liwei.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DbConn {
	   private static String driver="oracle.jdbc.driver.OracleDriver";
	    private static String url="jdbc:oracle:thin:@localhost:1521:orcl";
	    private static String user="scott";
	    private static String password="admin";
	    private static Connection conn;
	    private static DbConn db;

	    private DbConn(){

	    }

	    public static DbConn getInstance(){
	        synchronized(DbConn.class){
	            if(db==null){
	                db=new DbConn();
	            }
	        }
	        return db;
	    }

	    public Connection getConn(){
	        try {
	            Class.forName(driver);
	            conn= DriverManager.getConnection(url, user, password);
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return conn;
	    }

	    public void connClose(){
	        try {
	            conn.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
}
