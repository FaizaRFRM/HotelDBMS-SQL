import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
	
	
public class Guests {
	public static void menu(){
		boolean exit = true;
		
	while (exit) {
		Scanner sc = new Scanner(System.in);
	System.out.println("\t \t Guests TABLE\t \t \t");
	System.out.println("\t \t Choose One Option:\t \t");
	System.out.println("\t\t 1. create Table ");
	System.out.println("\t\t 2. insert to Table  ");
	System.out.println("\t\t 3. readFromTableTable ");
	System.out.println("\t\t 4. getById ");
	System.out.println("\t\t 5. updateById ");
	System.out.println("\t\t 6. deleteById ");
	System.out.println("\t\t 7. makeIsActiveFalseById");

	int option = sc.nextInt();
	switch (option) {
	case 1:
		Guests.Guest();

	break;

	case 2:
		System.out.println ("Enter the number of records:");
	  	int f=sc.nextInt();
	  	Guests.insertIntoTable(f);
	break;

	case 3:
		Guests.readFromTable();

	break;
	case 4:
		Guests.getById();
	break;
	case 5:
		Guests.updateById();
	break;
	case 6:
		Guests.deleteById();;
	break;
	case 7:
		Guests.makeIsActiveFalseById();;
	break;


	}
	}
	exit = false;


	}
	public static void Guest(){
		final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		   final String user = "root";
		   final String pass = "root";
		 try(Connection conn = DriverManager.getConnection(url, user, pass);
		         Statement stmt = conn.createStatement();
		      ) {		      
		          String sql = "CREATE TABLE Guests(" +"  id Int Primary Key AUTO_INCREMENT, "
		      + " guest_name Varchar(10)not null, "
		       + " guest_phone Varchar(10)not null, "
		       + " guest_accompanying_members int not null, "
		       + " guest_payment_amount int not null, "
		       + " room_id int REFERENCES Rooms(id), "
		       + " hotel_id int REFERENCES Hotels(id), "
		      + " created_date Date not null,"
		      +"updated_date Date,"
		      +"is_Active Boolean not null)"; 
		                                           
		          
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
	
	public static void insertIntoTable( int s){
	
		 final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		   final String user = "root";
		   final String pass = "root";
		   
		 Scanner scanner = new Scanner(System.in);

		 int guest_accompanying_members=215654;
		 int guest_payment_amount=215654;
		 String guest_name="Muscat";
		 String guest_phone="97668779";
		 int hotel_id=2;
		 int room_id=2;
		 
//		 System.out.print("which hotel you want");
//		 String input=scanner.next();
//		 String query="select id from hotels where hotel_name=String";
		 
		 
		 Date created_date=new Date(System.currentTimeMillis());
		 Date updated_date= new Date(System.currentTimeMillis());
		 boolean is_Active=true;
		    Connection conn = null;

		 Random rn = new Random();
		  Integer num=rn.nextInt();

		 for(int i=0;i<=s;i++) {
			 
			  String sql = "insert into Guests(guest_name,guest_phone,guest_accompanying_members ,guest_payment_amount ,room_id ,hotel_id ,created_date ,updated_date,is_Active)"+
        "values("+guest_name+"," +guest_phone+","+guest_accompanying_members*50+","+guest_payment_amount+","+room_id+","+hotel_id  +","+created_date+","+updated_date+","+is_Active+")";
			 
		    try{
		    	 Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver")
						  .newInstance();
	           DriverManager.registerDriver(driver);
	           conn = DriverManager.getConnection(url, user,
	                   pass);
	           Statement stmt = conn.createStatement();
	           
	           int m = stmt.executeUpdate(sql);
	         if (m >=0)
	           System.out.println(
	                   sql+"inserted successfully : ");
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
