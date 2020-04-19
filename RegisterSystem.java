import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.*;

class RegisterSystem {
	void newUser(UserSystem us) throws IOException {
		System.out.println("******************NEW USER*****************");
		Scanner s = new Scanner(System.in);
		while (true) {
			System.out.print("Enter Username: ");
			String username = s.next();
			if (us.users.containsKey(username)) {
				System.out.println("User already exists! Please try again!");
				continue;
			}

			System.out.print("Enter password: ");
			String password = s.next();
			User user = new User();
			user.username = username;
			user.password = password;
			user.creditBalance = user.generateRandom(1000, 5000);// Genrarting random Credit balance using random
																	// function taught in the class
			user.debitBalance = user.generateRandom(100, 1000);
			us.users.put(username, user);// puting data into the user object
			break;
		}
	}

}
