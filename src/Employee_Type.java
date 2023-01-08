import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Employee_Type {
	public static void menu(){
		boolean exit = true;
		
	while (exit) {
		Scanner sc = new Scanner(System.in);
	System.out.println("\t \tEmployee_Type TABLE\t \t \t");
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
		Employee_Type.EmployeeT();

	break;

//	case 2:
//		Employee_Type.insertIntoTable();
//	break;
//
//	case 3:
//		Employee_Type.readFromTable();
//
//	break;
//	case 4:
//		Employee_Type.getById();
//	break;
//	case 5:
//		Employee_Type.updateById();
//	break;
//	case 6:
//		Employee_Type.deleteById();;
//	break;
//	case 7:
//		Employee_Type.makeIsActiveFalseById();;
//	break;


	}
	}
	exit = false;


	}
	
	public static void EmployeeT(){
		final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

		   final String user = "root";
		   final String pass = "root";
		 try(Connection conn = DriverManager.getConnection(url, user, pass);
		         Statement stmt = conn.createStatement();
		      ) {		      
		          String sql = "CREATE TABLE Employee_Type(" +"  id Int Primary Key AUTO_INCREMENT, "
		      + " employee_type_name Varchar(10)not null, "
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
