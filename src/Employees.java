import java.sql.Connection;
	import java.sql.DriverManager;
	import java.sql.Statement;
import java.util.Scanner;
public class Employees {
	public static void menu(){
		boolean exit = true;
		
	while (exit) {
		Scanner sc = new Scanner(System.in);
	System.out.println("\t \tEmployees TABLE\t \t \t");
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
		Employees.Employee();

	break;

//	case 2:
//		Employees.insertIntoTable();
//	break;
//
//	case 3:
//		Employees.readFromTable();
//
//	break;
//	case 4:
//		Employees.getById();
//	break;
//	case 5:
//		Employees.updateById();
//	break;
//	case 6:
//		Employees.deleteById();;
//	break;
//	case 7:
//		Employees.makeIsActiveFalseById();;
//	break;


	}
	}
	exit = false;


	}
	
	public static void Employee(){
		final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		   final String user = "root";
		   final String pass = "root";
		 try(Connection conn = DriverManager.getConnection(url, user, pass);
		         Statement stmt = conn.createStatement();
		      ) {		      
		          String sql = "CREATE TABLE Employees(" +"  id Int Primary Key AUTO_INCREMENT, "
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
