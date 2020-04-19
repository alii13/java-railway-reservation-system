import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

/*
This is the main file of Railway Reservation system the topics I include in this sytem is Inheritence,
 overrdiding methods,polymorphism,Abstract clasess,Intterfaces,Exceptional Handling,Lambda Expressions
*/
public class RailwayBooking {
	// Abstract class declaration for printing menu
	public abstract class PrintHeading {
		public void disp() {

		}

	}

	interface getX {
		// Using interface to show the name of owner
		public void inputx();
	}

	public static void main(String args[]) throws Exception {
		// Using concept if exception
		String[] Strings = new String[] { "User System", "Admin System", "Exit" };
		TrainAdmin ta = TrainAdmin.getTrainAdmin();
		UserSystem us = new UserSystem();
		while (true) {

			System.out.println(
					"******************************  RAILWAY RESERVATION SYSTEM | Reg No.- 11802246 | Section- PD  ******************************\n");
			System.out.println("                                *************************************************");
			System.out.println("                                *  Default Username- Admin & Password= admin    *");
			System.out.println("                                *  Use source- phagwara & destination - delhi   *");
			System.out.println("                                *************************************************");
			getX dxx = () -> {
				// lambda expression
				System.out.println("                               ------------->Solely made by ALI<----------------");
			};
			dxx.inputx();
			;
			disp(Strings);
			Scanner src = new Scanner(System.in);

			int firstChoice = src.nextInt();
			if (firstChoice == 1)
				us.disp();
			else if (firstChoice == 2)
				ta.adminMenu();
			else
				break;
		}
	}

	public static void disp(String[] arr) {
		// Function overrriding take place
		// defining the body of function
		System.out.println("*******************************************");
		System.out.println("Enter your choice: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println((i + 1) + ")" + arr[i]);
		}
	}
}
