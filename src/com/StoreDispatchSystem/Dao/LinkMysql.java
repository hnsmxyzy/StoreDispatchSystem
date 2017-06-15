package com.StoreDispatchSystem.Dao;
import java.sql.*;

public class LinkMysql{		
		private static String driverName = "com.mysql.jdbc.Driver";
		private static String username = "root";
		private static String userPwd = "root";
		private static String dbName = "storedispatchsystem";
		
		public static Connection getDBconnection(){
			String url1 = "jdbc:mysql://localhost:3306/" + dbName;
			String url2 = "?user=" + username + "&password=" + userPwd;
			String url3 = "&useUnicode=true&characterEncoding=UTF-8";
			String url = url1 + url2 + url3;
			try{
			    Class.forName(driverName);
			    Connection con=DriverManager.getConnection(url); 
			    return con; 
		    }catch (Exception e) {
				   return null;
			}
	    } 
	
		  public static void closeDB(Connection con,PreparedStatement pstm, ResultSet rs){
		 	   try{
		 		   if(rs!=null) rs.close(); 
		 		   if(pstm!=null) pstm.close();
				   if(con!=null) con.close();
			   }catch (SQLException e) {
					e.printStackTrace();
			   }
			}
}