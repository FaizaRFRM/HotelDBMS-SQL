import java.sql.SQLException;
import java.util.Scanner;
import java.sql.Connection;

public class Main {


		public static void main(String[] args)  throws SQLException, ClassNotFoundException{
			try {
				boolean exit = true;
				while (exit) {
			Scanner sc = new Scanner(System.in);
		System.out.println("\t \tChoose One Option:\t \t");
		System.out.println("\t\t 1. hotelTable ");
		System.out.println("\t\t 2. RoomTypeTable  ");
		System.out.println("\t\t 3. RoomsTable ");
		System.out.println("\t\t 4. GuestsTable ");
		System.out.println("\t\t 5. EmployeeTypeTable ");
		System.out.println("\t\t 6. EmployeesTable ");
		System.out.println("\t\t 7. Exit ");
		System.out.println(" *********************************************** ");
		
//	     boolean isExit = true;
	    int option = sc.nextInt();
		switch (option) {
		case 1:
			Hotels hotelTable=new Hotels();
			hotelTable.menu();

		break;

		case 2:
			RoomType RoomTypeTable=new RoomType();
			RoomTypeTable.menu();
		break;
		
		case 3:
			Rooms RoomsTable=new Rooms();
			RoomsTable.menu();

		break;
		case 4:
			Guests GuestsTable=new Guests();
			GuestsTable.Guest();
		break;
		case 5:
			Employee_Type EmployeeTypeTable=new Employee_Type();
			Employee_Type.EmployeeT();
		break;
		case 6:
			Employees EmployeesTable=new Employees();
			EmployeesTable.Employee();
		break;
		case 7:
		System.out.println(" See You Soon ");
		System.exit(0);

		break;

		}
				}exit = false;
				} catch (Exception e) {
					System.out.println(e);
				}
		
		}
	}
