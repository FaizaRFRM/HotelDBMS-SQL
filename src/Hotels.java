import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
	import java.sql.Statement;
import java.util.Random;
import java.util.Scanner;
	
public class Hotels {
	
	public static void menu(){
		boolean exit = true;
		Scanner sc = new Scanner(System.in);

	while (exit) {
	System.out.println("\t \tHOTEL TABLE\t \t \t");
	System.out.println("\t \tChoose One Option:\t \t");
	System.out.println("\t\t 1. create Table ");
	System.out.println("\t\t 2. insert to Table  ");
	System.out.println("\t\t 3. readFromTableTable ");
	System.out.println("\t\t 4. getById ");
	System.out.println("\t\t 5. updateById ");
	System.out.println("\t\t 6. deleteById ");
	System.out.println("\t\t 7. makeIsActiveFalseById");
	
//     boolean isExit = true;
    int option = sc.nextInt();
	switch (option) {
	case 1:
		Hotels.Hotel();

	break;

	case 2:
		Hotels.insertIntoTable(0);
	break;
	
	case 3:
	  	System.out.println ("input number of records you want to show");

		int s=sc.nextInt();
		Hotels.readFromTable(s);

	break;
	case 4:
		Hotels.getById();
	break;
	case 5:
		Hotels.updateById();
	break;
	case 6:
		Hotels.deleteById();;
	break;
	case 7:
		Hotels.makeIsActiveFalseById();;
	break;
	

	}
	}
	exit = false;
	
	
}
	
	
	
	
	 
	  
//	**********************************************************************
//	*************************************************************************
		
			public static void Hotel(){
			final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

			   final String user = "root";
			   final String pass = "root";
			   Connection con=null;
			 try(Connection conn = DriverManager.getConnection(url, user, pass);
			         Statement stmt = conn.createStatement();
			      ) {		      
			          String sql = ("CREATE TABLE Hotels(" +" id int Primary Key AUTO_INCREMENT, " 
			      + " hotel_name VARCHAR(10) not null,"
			      + " hotel_location VARCHAR(10), "
			      + " created_date Date not null,"
			      + "updated_date Date,"
			      + "is_Active Boolean not null)"); 
			           
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
//		**********************************************************************
//		*************************************************************************

		
    public static void insertIntoTable(int f){
    	 final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

  	   final String user = "root";
  	   final String pass = "root";
  	 Scanner scanner = new Scanner(System.in);
  	
  	 
  	 System.out.print("which hotel you want");
	 String input=scanner.next();
	 String query="select id from guests where guest_name=String";
  	 
		 String hotel_name="MM";
		 String hotel_location="Muscut";
		 Date created_date=new Date(System.currentTimeMillis());
		 Date updated_date= new Date(System.currentTimeMillis());
		 boolean is_Active=true;
		 
		 Random rn = new Random();
	  	   Integer numberToAdd = rn.nextInt();
	
		 for(int i=0;i<f;i++) {
			  String sql = "insert into hotels values ("+i+", '"
		 +hotel_name+i+"', '"+hotel_location+i+"','"+
					  created_date+"', '"+updated_date+"', "+is_Active+")";

		    Connection conn = null;
		  try{
			  Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver")
					  .newInstance();
            DriverManager.registerDriver(driver);
            conn = DriverManager.getConnection(url, user,
                    pass);
            Statement stmt = conn.createStatement();
	  		 ResultSet rs=stmt.executeQuery(query);

            int m = stmt.executeUpdate(sql);
          if (m >=0)
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
//	**********************************************************************
//	*************************************************************************


    	public static void readFromTable(int a){

    		final String url = "jdbc:mysql://localhost:3306/HotelDBMS";
    		   final String user = "root";
    		   final String pass = "root";
    		   
    		   
    		   
    		  String QUERY = "SELECT * FROM Hotels order by id limit "+a+"";

    		      Connection conn=null;
    		      
    		 try {
    			 conn = DriverManager.getConnection(url, user, pass);
    		 Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
             Statement stmt = conn.createStatement();
    	     DriverManager.registerDriver(driver);
    	     ResultSet rs=stmt.executeQuery(QUERY);
    			 while(rs.next()) {
    			
    				int id=rs.getInt("id");
    				String hotel_name=rs.getString("hotel_name");
    				String hotel_location=rs.getString("hotel_location");
    				Date created_date=rs.getDate("created_date");
    				Date updated_date=rs.getDate("updated_date");
    				Boolean is_Active=rs.getBoolean("is_Active");
    			     System.out.println("id :" + id);
    			     System.out.println("hotel_name :" +hotel_name);
    			     System.out.println("hotel_location" +hotel_location);
    			     System.out.println("created_date" +created_date);
    			     System.out.println("updated_date" +updated_date);
    			     System.out.println("is_Active"+is_Active);
    			   
    			 }
    			 conn.close() ;
    		 }  catch (Exception ex) {
    	           
    	            System.err.println(ex);
       }
	    }
		
//		**********************************************************************
//		*************************************************************************
//    public void resultsetFunction() throws SQLException{
//    	final String url = "jdbc:mysql://localhost:3306/HotelDBMS";
//
//		   final String user = "root";
//		   final String pass = "root";
//	 Connection conn = DriverManager.getConnection(url, user, pass);
// 	Statement stmt = conn.createStatement();
//	ResultSet rst=stmt.executeQuery(null);
//	
//    }   
    
    public static void getById(){
		final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		   final String user = "root";
		   final String pass = "root";

			 Connection conn = null;

		   Scanner scanner = new Scanner(System.in);
		  	System.out.println ("input id you want to show");
		      Integer inputID=scanner.nextInt();
			   final String QUERY = "SELECT * FROM Hotels where id="+inputID;

		 try
		 {
			 conn = DriverManager.getConnection(url, user, pass);
    		 Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
             Statement stmt = conn.createStatement();
    	     DriverManager.registerDriver(driver);
    	     ResultSet rs=stmt.executeQuery(QUERY);
			 while(rs.next()) 
			 { 
				inputID=rs.getInt("id");
				String hotel_name=rs.getString("hotel_name");
				String hotel_location=rs.getString("hotel_location");
				Date created_date=rs.getDate("created_date");
				Date updated_date=rs.getDate("updated_date");
				Boolean is_Active=rs.getBoolean("is_Active");
			     System.out.println("id :" + inputID);
			     System.out.println("hotel_name :" +hotel_name);
			     System.out.println("hotel_location" +hotel_location);
			     System.out.println("created_date" +created_date);
			     System.out.println("updated_date" +updated_date);
			     System.out.println("is_Active"+is_Active);
			 }
		     conn.close() ;

		 }  catch (Exception ex) {

	            System.err.println(ex);
   }
	    }
		
		public static void print(int P){
		
			final String url = "jdbc:mysql://localhost:3306/HotelDBMS";
			   Connection con=null;

			   final String user = "root";
			   final String pass = "root";
			   final String QUERY = "SELECT * FROM Hotels order by id limit "+P+"";

			      Connection conn=null;
			 try {
				 conn = DriverManager.getConnection(url, user, pass);
		         Statement stmt = conn.createStatement();
			 Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			   
		     DriverManager.registerDriver(driver);
				 ResultSet rs = stmt.executeQuery(QUERY);
				 while(rs.next()) {
				
					int id=rs.getInt("id");
					String hotel_name=rs.getString("hotel_name");
					String hotel_location=rs.getString("hotel_location");
					Date created_date=rs.getDate("created_date");
					Date updated_date=rs.getDate("updated_date");
					Boolean is_Active=rs.getBoolean("is_Active");
				     System.out.println("id :" + id);
				     System.out.println("hotel_name :" +hotel_name);
				     System.out.println("hotel_location" +hotel_location);
				     System.out.println("created_date" +created_date);
				     System.out.println("updated_date" +updated_date);
				     System.out.println("is_Active"+is_Active);
				     System.out.println("*******************************");
				   
				 }
			     conn.close() ;

			 }  catch (Exception ex) {
		           
		            System.err.println(ex);
	   }
			
		    }
		
//		**********************************************************************
//		*************************************************************************	
		
		public static void updateById(){
			
			final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

			 String user = "root";
			 String pass = "root";
			 Connection conn = null;

			 try {
			 Scanner scanner = new Scanner(System.in);

			  	System.out.println ("input id you want to update");
			      Integer id=scanner.nextInt();
			      String sql = "update Hotels set hotel_name='FF' where id="+id;
					 
			      
			 
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
			     conn.close() ;
			 }

				  catch (Exception ex) {
		           
		            System.err.println(ex);
	   }
		    }
//		**********************************************************************
//		*************************************************************************	
		
		public static void Is_Active_False(){
			Scanner scanner = new Scanner(System.in);

			final String url = "jdbc:mysql://localhost:3306/HotelDBMS";
			
			String user = "root";
			String pass = "root";
			try {
				
				
				String sql = "update Hotels set is_Active='0' ORDER BY id LIMIT 10";
				
				Connection conn = null;
				
				
				Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
				
				DriverManager.registerDriver(driver);
				
				conn = DriverManager.getConnection(url, user,
						pass);
				
				Statement st = conn.createStatement();
				
				int m = st.executeUpdate(sql);
				if (m >=0)
					System.out.println("update is successful of ");
				else
					System.out.println("failed");
				
				conn.close();
			}
			
			catch (Exception ex) {
				
				System.err.println(ex);
			}
		}
		
//		**********************************************************************
//		*************************************************************************
		
		public static void deleteById() {
			final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

			 String user = "root";
			 String pass = "root";
			 try {
			 Scanner scanner = new Scanner(System.in);

			  	System.out.println ("inter id uou want to delete");
			      Integer id=scanner.nextInt();
			      String sql = "delete from  Hotels where id="+id;
					 
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
		
//		**********************************************************************
//		*************************************************************************
		
		public static void makeIsActiveFalseById() {
			final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

			 String user = "root";
			 String pass = "root";
			 try {
			 Scanner scanner = new Scanner(System.in);

			  	System.out.println ("input id you want to update is_active to true");
			      Integer id=scanner.nextInt();
			      String sql = "update Hotels set is_Active='0' where id="+id;
					 
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
