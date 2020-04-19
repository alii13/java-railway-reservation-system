import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

class LoginSystem {
	void login(UserSystem us) throws Exception {
		System.out.println("************RETURNING USER*****************");
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.print("Enter Username: ");
			String username = s.next();
			System.out.print("Enter password: ");
			String password = s.next();
			if (us.users.containsKey(username))// checking iF username present in databse by Hashing
				if (us.users.get(username).password.equals(password)) {
					BookingSystem bs = new BookingSystem();// if present send it to booking manager system
					while (true) {
						User loggedInUser = us.getUsers().get(username);
						int val = loggedInUser.bookingSystem.booking(loggedInUser);
						if (val == 1)
							return;
					}
				}
			System.out.println("Credentials don't match! Try again!");
		}
	}
}
