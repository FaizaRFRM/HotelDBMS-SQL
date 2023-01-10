import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class HotelManagement {

	public static void nameEndWithE(int a){

		final String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		   final String user = "root";
		   final String pass = "root";
		   
		   
		   
		  String QUERY = "SELECT * FROM guests where guest_name like'%E'";

		      Connection conn=null;
		      
		 try {
			 conn = DriverManager.getConnection(url, user, pass);
		 Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
         Statement stmt = conn.createStatement();
	     DriverManager.registerDriver(driver);
	     ResultSet rs=stmt.executeQuery(QUERY);
			 while(rs.next()) {
			
				
				String hotel_name=rs.getString("hotel_name");
			     System.out.println("hotel_name :" +hotel_name);
			   
			 }
			 conn.close() ;
		 }  catch (Exception ex) {
	           
	            System.err.println(ex);
   }
    }
	public static void guestsPaying(int a){

		final String url = "jdbc:mysql://localhost:3306/HotelDBMS";
		   final String user = "root";
		   final String pass = "root";
		   
		   
		   
		  String QUERY = "SELECT Rooms.* FROM Rooms inner join on Rooms.id=Guests.room_id"
		  		+ " where guests.guest_payment_amount>1000";

		      Connection conn=null;
		      
		 try {
			 conn = DriverManager.getConnection(url, user, pass);
		 Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
         Statement stmt = conn.createStatement();
	     DriverManager.registerDriver(driver);
	     ResultSet rs=stmt.executeQuery(QUERY);
			 while(rs.next()) {
			
				 

				String hotel_name=rs.getString("hotel_name");
			     System.out.println("hotel_name :" +hotel_name);
			   
			 }
			 conn.close() ;
		 }  catch (Exception ex) {
	           
	            System.err.println(ex);
   }
    }
}
