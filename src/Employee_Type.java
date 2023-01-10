import java.sql.Connection;
import java.sql.Date;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Random;
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
	int option= sc.nextInt();
	switch (option) {
	case 1:
		Employee_Type.EmployeeT();

	break;

	case 2:
		
		System.out.println ("Enter the number of Hotels:");
	  	int f=sc.nextInt();
		Employee_Type.insertIntoTable(f);
	break;
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
	
	
	public static void insertIntoTable(int f){
   	 final String url = "jdbc:mysql://localhost:3306/HotelDBMS";

 	   final String user = "root";
 	   final String pass = "root";
 	 Scanner scanner = new Scanner(System.in);
 	
 	 
// 	 System.out.print("which hotel you want");
//	 String input=scanner.next();
//	 String query="select id from guests where guest_name=String";
 	 
		 String employee_type_name="MM";
		 Date created_date=new Date(System.currentTimeMillis());
		 Date updated_date= new Date(System.currentTimeMillis());
		 boolean is_Active=true;
		 
		 Random rn = new Random();
	  	   Integer numberToAdd = rn.nextInt();
		    Connection conn = null;

		 for(int i=0;i<f;i++) {
			  String sql = "insert into Employee_Type values ("+i+", '"
		 +employee_type_name+i+"','"+ created_date+"', '"+updated_date+"', "+is_Active+")";

		  try{
			  Driver driver = (Driver) Class.forName("com.mysql.cj.jdbc.Driver")
					  .newInstance();
           DriverManager.registerDriver(driver);
           conn = DriverManager.getConnection(url, user,
                   pass);
           Statement stmt = conn.createStatement();
//	  		 ResultSet rs=stmt.executeQuery(query);

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
	
	
	
	
	
	
}
