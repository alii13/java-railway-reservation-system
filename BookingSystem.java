import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Scanner;

class BookingSystem extends RailwayBooking {
	EnquiryEngine Eengine;
	BookingEngine Bengine;
	PaymentEngine Pengine;
	CancellationEngine Cengine;
	static Scanner in = new Scanner(System.in);

	public int booking(User user) throws Exception {
		Scanner s = new Scanner(System.in);
		String Strings[] = new String[] { "Enquire", "Book Ticket", "Cancel Ticket", "Return to previous menu",
				"Enter your choice: " };
		System.out.println("*******************************************");
		disp(Strings);// Calling an Derived function from Main file
		int choice = Integer.parseInt(s.next());
		if (choice == 1) {
			HashMap<Integer, Train> tt = enquiry();// Using hashing
			if (tt.isEmpty())
				System.out.println("No trains exists for the given information");

			return 0; // why?
		} else if (choice == 2) {
			HashMap<Integer, Train> tt = enquiry();
			if (!tt.isEmpty()) {
				// while(true) and Booking of train take place
				{
					System.out.println("Select train number to book");
					int n = in.nextInt();
					if (tt.containsKey(n)) {
						Train t = tt.get(n);
						if (t.getNumberOfSeats() > 0) {
							System.out.println("Train has " + t.getNumberOfSeats() + " seats");
							System.out.println("booking");
							if (Bengine == null)
								Bengine = new BookingEngine();
							if (Pengine == null)
								Pengine = new PaymentEngine();

							if (Pengine.deductBalance(t, user)) {
								Bengine.bookTicket(n, user);
							} else
								System.out.println("Booking failed. User has insufficient balance.");
						} else {
							System.out.println("Train doesn't have any vacant seat");
						}
					} else
						System.out.println("Please enter the correct Train Number");
				}
			}

			return 0;
		} else if (choice == 3) {
			if (Cengine == null)
				Cengine = new CancellationEngine();

			Cengine.cancelTicket(user);
		}
		return 1;
	}

	private HashMap<Integer, Train> enquiry() throws Exception {
		if (Eengine == null)
			Eengine = new EnquiryEngine();

		HashMap<Integer, Train> t = Eengine.enquire();

		return t;

	}

}
