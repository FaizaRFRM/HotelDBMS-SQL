import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
	
	
public class Guests {
	public static void Guest(){
		final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		   final String user = "root";
		   final String pass = "root";
		 try(Connection conn = DriverManager.getConnection(url, user, pass);
		         Statement stmt = conn.createStatement();
		      ) {		      
		          String sql = "CREATE TABLE Guests(" +"  id Int Primary Key, "
		      + " guest_name Varchar(10)not null, "
		       + " guest_phone Varchar(10)not null, "
		       + " guest_accompanying_members int not null, "
		       + " guest_payment_amount int not null, "
		       + " room_id int REFERENCES Rooms(id), "
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
}
