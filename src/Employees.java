import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
public class Employees {
	public static void Employee(){
		final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		   final String user = "root";
		   final String pass = "root";
		 try(Connection conn = DriverManager.getConnection(url, user, pass);
		         Statement stmt = conn.createStatement();
		      ) {		      
		          String sql = "CREATE TABLE Employees(" +"  id Int Primary Key, "
		       + " employee_type_id int REFERENCES Employee_Type(id), "
		       + " room_id int REFERENCES Hotels(id), "
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
