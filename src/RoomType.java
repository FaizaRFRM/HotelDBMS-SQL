import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
public class RoomType {
	public static void menu(){
	boolean exit = true;
	
while (exit) {
	Scanner sc = new Scanner(System.in);
System.out.println("\t \tRoomType TABLE\t \t \t");
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
	RoomType.RoomT();

break;

case 2:
	RoomType.insertIntoTable();
break;

case 3:
	RoomType.readFromTable();

break;
case 4:
	RoomType.getById();
break;
case 5:
	RoomType.updateById();
break;
case 6:
	RoomType.deleteById();;
break;
case 7:
	RoomType.makeIsActiveFalseById();;
break;


}
}
exit = false;


}


public static void RoomT(){
	final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

	   final String user = "root";
	   final String pass = "root";
	 try(Connection conn = DriverManager.getConnection(url, user, pass);
	         Statement stmt = conn.createStatement();
	      ) {		      
	          String sql = "CREATE TABLE Room_Type(" +"  id Int Primary Key, "
	      + " room_type_name VARCHAR(10) not null, "
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
	System.out.println ("Enter the number of Room_Type:");
  Integer numOfHotels=scanner.nextInt();
  
	 String room_type_name="vip";
	 Date created_date=new Date(System.currentTimeMillis());
	 Date updated_date= new Date(System.currentTimeMillis());
	 boolean is_Active=true;
	 
	 Random rn = new Random();
  	   Integer numberToAdd = rn.nextInt(100);

	 for(int i=0;i<=numOfHotels;i++) {
		  String sql = "insert into Room_Type values ("+i+numberToAdd+", '"
	 +room_type_name+i+"', '"+created_date+"', '"+updated_date+"', "+is_Active+")";

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
			 
			 ResultSet rs=stmt.executeQuery("SELECT * FROM Room_Type");
			 while(rs.next()&&count<number) 
			 { 
				 int id=rs.getInt("id");
				String room_type_name=rs.getString("room_type_name");
				Date created_date=rs.getDate("created_date");
				Date updated_date=rs.getDate("updated_date");
				Boolean is_Active=rs.getBoolean("is_Active");
			     System.out.println("id :" + id);
			     System.out.println("room_type_name :" +room_type_name);
			     System.out.println("created_date" +created_date);
			     System.out.println("updated_date" +updated_date);
			     System.out.println("is_Active"+is_Active);
			     count++;
			    
		 
		         conn.close() ; 
//			     conn.close() ;
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
			 ResultSet rs=stmt.executeQuery("SELECT * FROM Room_Type");
			 while(rs.next()) 
			 { 
				inputID=rs.getInt("id");
				String room_type_name=rs.getString("room_type_name");
				Date created_date=rs.getDate("created_date");
				Date updated_date=rs.getDate("updated_date");
				Boolean is_Active=rs.getBoolean("is_Active");
			     System.out.println("id :" + inputID);
			     System.out.println("room_type_name :" +room_type_name);
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
		      String sql = "update Room_Type set room_type_name='pp' where id="+id;
				 
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
		      String sql = "delete from Room_Type where id="+id;
				 
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
		      String sql = "update Room_Type set is_Active='0' where id="+id;
				 
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
