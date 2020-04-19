import java.io.BufferedReader;
import java.util.HashMap;
import java.util.*;

class UserSystem extends RailwayBooking {
	HashMap<String, User> users;

	public UserSystem() {
		users = new HashMap<>();
		User user = new User();
		user.username = "admin";// Default username as admin for login
		user.password = "admin";// Default password
		users.put("admin", user);
	}

	public HashMap<String, User> getUsers() {
		return users;
	}

	public void setUsers(String username, User user) {
		users.put(username, user);
	}

	void disp() throws Exception {
		String[] Strings = new String[] { "Sign Up (Reigster)", "Sign In (Log In)", "Return To previous menu" };
		while (true) {

			disp(Strings);// Calling an abstract method from main file Railway booking and overwriting it
							// below
			Scanner src = new Scanner(System.in);
			int secondChoice = src.nextInt();
			if (secondChoice == 1) {
				RegisterSystem rs = new RegisterSystem(); // Creation of object
				rs.newUser(this);
			} else if (secondChoice == 2) {
				LoginSystem ls = new LoginSystem();
				ls.login(this);
			} else
				return;
		}
	}

	public static void disp(String[] arr) {
		// Function overrriding take place
		// defining the body of function
		// Abstract method derived from Main file
		System.out.println("*******************************************");
		System.out.println("Enter your choice: ");
		for (int i = 0; i < arr.length; i++) {
			System.out.println((i + 1) + ")" + arr[i]);
		}
	}
}
