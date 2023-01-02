import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.SQLException;
	import java.sql.Statement;
	
public class Hotels {
	
	
		public static void Hotel(){
			final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

			   final String user = "root";
			   final String pass = "root";
			 try(Connection conn = DriverManager.getConnection(url, user, pass);
			         Statement stmt = conn.createStatement();
			      ) {		      
			          String sql = "CREATE TABLE Hotels(" +"  id Int Primary Key, " 
			      + " hotel_name VARCHAR(10) not null,"
			      + " hotel_location VARCHAR(10), "
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
		}
