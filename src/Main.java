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
		System.out.println("\t\t 1. insert 10000 hotels ");
		System.out.println("\t\t 2. inser 1 hotel ");
		System.out.println("\t\t 3. print 10 hotels ");
		System.out.println("\t\t 4.Make first 10 hotels 'is_Active' = false ");
		System.out.println("\t\t 5. Print hotel information by user input ");
		System.out.println(" *********************************************** ");
	  	 Scanner scanner = new Scanner(System.in);

//	     boolean isExit = true;
	    int option = sc.nextInt();
		switch (option) {
		
		case 1:
			System.out.println ("Enter the number of Hotels:");
		  	int f=scanner.nextInt();
		  	Hotels.insertIntoTable(f);

		break;

		case 2:
			Hotels.insertIntoTable(1);
		break;
		
		case 3:
			Hotels.print(10);

		break;
		case 4:
			Hotels.Is_Active_False();
		break;
		case 5:
			System.out.println ("Enter the number of Hotels you want");
		  	int P=scanner.nextInt();
		  	Hotels.print(P);
		break;
		case 6:
			Hotels.Hotel();
		break;
		}
				}exit = false;
				} catch (Exception e) {
					System.out.println(e);
				}
		
		}
	}
