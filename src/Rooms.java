import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
public class Rooms {
	public static void menu(){
		boolean exit = true;
		
	while (exit) {
		Scanner sc = new Scanner(System.in);
	System.out.println("\t \tRooms TABLE\t \t \t");
	System.out.println("\t \tChoose One Option:\t \t");
	System.out.println("\t\t 1. create Table ");
	System.out.println("\t\t 2. insert to Table  ");
	System.out.println("\t\t 3. readFromTableTable ");
	System.out.println("\t\t 4. getById ");
	System.out.println("\t\t 5. updateById ");
	System.out.println("\t\t 6. deleteById ");
	System.out.println("\t\t 7. makeIsActiveFalseById");

	// boolean isExit = true;
	int option = sc.nextInt();
	switch (option) {
	case 1:
		Rooms.Room();

	break;

	case 2:
		Rooms.insertIntoTable();
	break;

	case 3:
		Rooms.readFromTable();

	break;
	case 4:
		Rooms.getById();
	break;
	case 5:
		Rooms.updateById();
	break;
	case 6:
		Rooms.deleteById();;
	break;
	case 7:
		Rooms.makeIsActiveFalseById();;
	break;


	}
	}
	exit = false;


	}


public static void Room(){
		
		final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		   final String user = "root";
		   final String pass = "root";
		 try(Connection conn = DriverManager.getConnection(url, user, pass);
		         Statement stmt = conn.createStatement();
		      ) {		      
		          String sql = "CREATE "
		          		+ " Rooms(" +"  id Int Primary Key, "
		      + " room_type_id int  REFERENCES Room_Type(id), "
		       + " hotel_id int REFERENCES Hotels(id), "
		      + " created_date Date not null,"
		      +"updated_date Date,"+"is_Active Boolean not null)"; 
		      
		          
		         int m=stmt.executeUpdate(sql);
		         if (m >=  0)
		         	System.out.println("Created table in given database..." + sql);
		            
		         else
		             System.out.println("failed to create");
		 
		         conn.close() ; 	  
		          } catch (Exception ex) {
			           
			            System.err.println(ex);
		   }
		}
	
		
	public static void insertIntoTable(){
		 final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		   final String user = "root";
		   final String pass = "root";
		   
		 Scanner scanner = new Scanner(System.in);
		System.out.println ("Enter the number of Rooms:");
	  Integer numOfHotels=scanner.nextInt();
	  
		 int room_type_id=215;
		 int hotel_id=84;
		 Date created_date=new Date(System.currentTimeMillis());
		 Date updated_date= new Date(System.currentTimeMillis());
		 boolean is_Active=true;
		 
		 Random rn = new Random();
	  	   Integer numberToAdd = rn.nextInt(100);

		 for(int i=0;i<=numOfHotels;i++) {
			  String sql = "insert into Rooms values ("+i+numberToAdd+", '"
		 +room_type_id+i+", '" +hotel_id+i+"', '"+created_date+"', '"+updated_date+"', "+is_Active+")";

		    Connection conn = null;
		  try{
			  Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver")
					  .newInstance();
	        DriverManager.registerDriver(driver);
	        conn = DriverManager.getConnection(url, user,
	                pass);
	        Statement stmt = conn.createStatement();
	        int m = stmt.executeUpdate(sql);
	      if (m >=  0)
	        System.out.println(
	                "inserted successfully : " + sql);
	    else
	        System.out.println("insertion failed");
	    conn.close();
			 }catch (Exception ex) {
		         System.out.println(ex);
		     }
		 }
	     
		    }


		public static void readFromTable(){
			final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

			   final String user = "root";
			   final String pass = "root";
			   Scanner scanner = new Scanner(System.in);
			  	System.out.println ("input number of records you want to show");
			  	int number=scanner.nextInt();
			      int count=0;
			      
			 try(Connection conn = DriverManager.getConnection(url, user, pass);
			         Statement stmt = conn.createStatement();
			      ) {
				 
				 ResultSet rs=stmt.executeQuery("SELECT * FROM Rooms");
				 while(rs.next()&&count<number) 
				 { 
					 int id=rs.getInt("id");
					int room_type_id=rs.getInt("room_type_id");
					int hotel_id=rs.getInt("hotel_id");
					Date created_date=rs.getDate("created_date");
					Date updated_date=rs.getDate("updated_date");
					Boolean is_Active=rs.getBoolean("is_Active");
				     System.out.println("id :" + id);
				     System.out.println("room_type_id :" +room_type_id);
				     System.out.println("hotel_id :" +hotel_id);
				     System.out.println("created_date" +created_date);
				     System.out.println("updated_date" +updated_date);
				     System.out.println("is_Active"+is_Active);
				     count++;
				    
			 
			         conn.close() ; 
				 }
			 }  catch (Exception ex) {
		           
		            System.err.println(ex);
	   }
		    }
		
		
		
		    
		public static void getById(){
			final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

			   final String user = "root";
			   final String pass = "root";
			   Scanner scanner = new Scanner(System.in);
			  	System.out.println ("input id you want to show");
			      Integer inputID=scanner.nextInt();
			      
			 try(Connection conn = DriverManager.getConnection(url, user, pass);
			         Statement stmt = conn.createStatement();
			      ) {
				 ResultSet rs=stmt.executeQuery("SELECT * FROM Rooms");
				 while(rs.next()) 
				 { 
					 int id=rs.getInt("id");
						int room_type_id=rs.getInt("room_type_id");
						int hotel_id=rs.getInt("hotel_id");
						Date created_date=rs.getDate("created_date");
						Date updated_date=rs.getDate("updated_date");
						Boolean is_Active=rs.getBoolean("is_Active");
					     System.out.println("id :" + id);
					     System.out.println("room_type_id :" +room_type_id);
					     System.out.println("hotel_id :" +hotel_id);
					     System.out.println("created_date" +created_date);
					     System.out.println("updated_date" +updated_date);
					     System.out.println("is_Active"+is_Active);
				     conn.close() ;
				 }
			 }  catch (Exception ex) {
		           
		            System.err.println(ex);
	   }
		    }
		
		
		
		public static void updateById(){
			
			final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

			 String user = "root";
			 String pass = "root";
			 try {
			 Scanner scanner = new Scanner(System.in);

			  	System.out.println ("input id you want to update");
			      Integer id=scanner.nextInt();
			      String sql = "update Rooms set room_type_id='pp' where id="+id;
					 
					 Connection conn = null;
			      
			 
				 Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				   
			     DriverManager.registerDriver(driver);

			     conn = DriverManager.getConnection(url, user,
			             pass);

			     Statement st = conn.createStatement();

			     int m = st.executeUpdate(sql);
			     if (m >=0)
			         System.out.println("update is successful of " +id);
			     else
			         System.out.println("failed");

			     conn.close();
			 }

				  catch (Exception ex) {
		           
		            System.err.println(ex);
	   }
		    }
		
		public static void deleteById() {
			final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

			 String user = "root";
			 String pass = "root";
			 try {
			 Scanner scanner = new Scanner(System.in);

			  	System.out.println ("inter id uou want to delete");
			      Integer id=scanner.nextInt();
			      String sql = "delete from Rooms where id="+id;
					 
					 Connection conn = null;
			      
			 
				 Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				   
			     DriverManager.registerDriver(driver);

			     conn = DriverManager.getConnection(url, user,
			             pass);

			     Statement st = conn.createStatement();

			     int m = st.executeUpdate(sql);
			     if (m >=0)
			         System.out.println("deleted is successful of " +id);
			     else
			         System.out.println("failed");

			     conn.close();
			 }

				  catch (Exception ex) {
		           
		            System.err.println(ex);
	   }
		    }
		public static void makeIsActiveFalseById() {
			final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

			 String user = "root";
			 String pass = "root";
			 try {
			 Scanner scanner = new Scanner(System.in);

			  	System.out.println ("input id you want to update is_active to true");
			      Integer id=scanner.nextInt();
			      String sql = "update Rooms set is_Active='0' where id="+id;
					 
					 Connection conn = null;
			      
			 
				 Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				   
			     DriverManager.registerDriver(driver);

			     conn = DriverManager.getConnection(url, user,
			             pass);

			     Statement st = conn.createStatement();

			     int m = st.executeUpdate(sql);
			     if (m >=0)
			         System.out.println("update is successful of " +id);
			     else
			         System.out.println("failed");

			     conn.close();
			 }

				  catch (Exception ex) {
		           
		            System.err.println(ex);
	   }
		    }
	
}
