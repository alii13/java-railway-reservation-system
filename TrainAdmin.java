import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;

public class TrainAdmin extends Train {
	// inheritence

	static Scanner in = new Scanner(System.in);
	private static TrainAdmin tAdmin;

	private TrainAdmin() {
		init();
	}

	private void init() {
		Train t1 = new Train();
		Train t2 = new Train();
		Train t3 = new Train();
		Train t4 = new Train();
		Train t5 = new Train();

		t2.setStartCity("phagwara");
		t2.setEndCity("delhi");
		t2.setTrainFare(30.00);
		t2.setOperatingDays(1234567);
		t2.setNumberOfSeats(40);

		t1.setStartCity("phagwara");
		t1.setEndCity("kanpur");
		t1.setTrainFare(75.25);
		t1.setOperatingDays(1234567);
		t1.setNumberOfSeats(100);

		t3.setStartCity("phagwara");
		t3.setEndCity("chennai");
		t3.setTrainFare(70.0);
		t3.setOperatingDays(1234567);
		t3.setNumberOfSeats(120);

		t4.setStartCity("phagwara");
		t4.setEndCity("kolkata");
		t4.setTrainFare(40.0);
		t4.setOperatingDays(1234567);
		t4.setNumberOfSeats(20);

		t5.setStartCity("phagwara");
		t5.setEndCity("hyderabad");
		t5.setTrainFare(60.0);
		t5.setOperatingDays(1234567);
		t5.setNumberOfSeats(10);

		TrainScheduler.setTrainList(t2);
		TrainScheduler.setTrainList(t1);
		TrainScheduler.setTrainList(t3);
	}

	public static TrainAdmin getTrainAdmin() {
		if (tAdmin == null) {
			synchronized (TrainAdmin.class) {
				if (tAdmin == null) {
					tAdmin = new TrainAdmin();
				}
			}
		}
		return tAdmin;
	}

	public void addTrain() {
		Train train = new Train();

		System.out.println("Enter start city");
		String startCity = in.nextLine();
		train.setStartCity(startCity.toLowerCase());

		System.out.println(("Enter destination city"));

		String destinationCity = in.nextLine();
		train.setEndCity(destinationCity.toLowerCase());

		System.out.println("Enter train fare");
		double trainFare = in.nextDouble();
		train.setTrainFare(trainFare);

		System.out.println("Enter the total number of seats");
		int totalSeats = in.nextInt();
		train.setNumberOfSeats(totalSeats);

		System.out.println("Enter the days the train will operate on (eg: 12 = Sunday & Monday, 467 = Wed,Fri & Sat");
		int days = in.nextInt();
		train.setOperatingDays(days);
		TrainScheduler.setTrainList(train);
	}

	public boolean trainExists(int n) {
		HashMap<Integer, Train> trainList = TrainScheduler.getTrainList();
		if (!trainList.containsKey(n))
			return false;
		return true;
	}

	public Train trainSelector(int n) {

		HashMap<Integer, Train> trainList = TrainScheduler.getTrainList();
		return trainList.get(n);
	}

	public void deleteTrain(int n) {
		HashMap<Integer, Train> trainList = TrainScheduler.getTrainList();
		if (!trainList.containsKey(n)) {
			System.out.println("Invalid Key Selected");
			return;
		} else {
			trainList.remove(n);
			System.out.println("Deleted Successfully ");
		}
	}

	public void updateTrain(int n) {

		System.out.println("Select the field to update");
		System.out.println("1) Start City");
		System.out.println("2) destination city");
		System.out.println("3) train fare");
		System.out.println("4) Days train operates");
		System.out.println("5) Number of seats");
		int choice = in.nextInt();
		in.nextLine();
		String temp;
		Train t = trainSelector(n);
		switch (choice) {
		case 1:
			System.out.println("Enter new Start City:");
			temp = in.nextLine();
			t.setStartCity(temp.toLowerCase());
			break;
		case 2:
			System.out.println("Enter New end City:");
			temp = in.nextLine().toLowerCase();
			t.setEndCity(temp);
			break;
		case 3:
			System.out.println("Enter New Fare:");
			double tt = in.nextDouble();
			in.nextLine();
			t.setTrainFare(tt);
			break;
		case 4:
			System.out.println("Enter the days the Train operates on now:");
			int opDay = in.nextInt();
			t.setOperatingDays(opDay);
			break;
		case 5:
			System.out.println("Enter the Total Number of seats:");
			int seats = in.nextInt();
			t.setNumberOfSeats(seats);
			break;
		default:
			System.out.println("Inavlid option selected. Please enter again:");
		}

		TrainScheduler.setTrainList(t);

	}

	public void display() {
		HashMap<Integer, Train> trainList = TrainScheduler.getTrainList();

		for (Map.Entry<Integer, Train> entry : trainList.entrySet()) {
			Integer key = entry.getKey();
			System.out.println("Train Number: " + key);
			Train t = entry.getValue();
			System.out.println("Source City: " + t.getStartCity());
			System.out.println("Destination City: " + t.getEndCity());
			System.out.println("Train Fare: " + t.getTrainFare());
			System.out.println("Total Number of seats " + t.getNumberOfSeats());
			System.out.print("Days the train operates: ");
			HashMap<String, Integer> h = t.getOperatingDays();
			for (String d : h.keySet()) {
				if (h.get(d) == 1)
					System.out.print(d + " ");
			}
			System.out.println();

			System.out.println();
		}
	}

	public void adminMenu() {
		System.out.println("*******************************************");
		System.out.println("Admin logged in");
		mainloop: while (true) {
			System.out.println("*******************************************");
			System.out.println("Please select an option");
			System.out.println("1) Add Train");
			System.out.println("2) Update Train");
			System.out.println("3) Delete Train");
			System.out.println("4) Display Information of all the Trains");
			System.out.println("5) Return to Main Menu");
			int option = in.nextInt();
			in.nextLine();
			TrainAdmin ali = TrainAdmin.getTrainAdmin();
			switch (option) {
			case 1:
				System.out.println("*******************************************");
				System.out.println("Adding Train");
				System.out.println("*******************************************");

				System.out.println("Please fill the train info");
				ali.addTrain();
				break;

			case 2:
				System.out.println("*******************************************");
				System.out.println("Updating Train Info");
				System.out.println("*******************************************");
				System.out.println("Please enter the train number to update the train's info");
				int n = in.nextInt();
				if (ali.trainExists(n))
					ali.updateTrain(n);
				else
					System.out.println("Invalid train number entered");
				break;

			case 3:
				System.out.println("*******************************************");
				System.out.println("Deleting Train");
				System.out.println("*******************************************");

				System.out.println("Please enter the train number to delete the train from the Listing");
				n = in.nextInt();
				if (ali.trainExists(n))
					ali.deleteTrain(n);
				else
					System.out.println("Please select a valid train Number");
				break;

			case 4:
				System.out.println("*******************************************");
				System.out.println("Displaying all the trains");
				System.out.println("*******************************************");

				System.out.println("Display");
				ali.display();

				break;
			case 5:
				System.out.println("...");
				break mainloop;

			default:
				System.out.println("Invalid option selected");
			}
		}

	}

}
