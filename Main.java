import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	static ArrayList<Guest> guests = new ArrayList<>();
	static ArrayList<Employee> employees = new ArrayList<>();
	static ArrayList<Room> rooms = new ArrayList<>();
	static ArrayList<Reservation> reservations = new ArrayList<>();

	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {

		while (true) {
			System.out.println("\n1.Add Room 2.Add Guest 3.Add Employee 4.Book");
			System.out.println("5.Show All 6.Delete 7.Update 8.Exit");

			int c = sc.nextInt();

			switch (c) {
				case 1 -> addRoom();
				case 2 -> addGuest();
				case 3 -> addEmployee();
				case 4 -> book();
				case 5 -> showMenu();
				case 6 -> deleteMenu();
				case 7 -> updateMenu();
				case 8 -> {
					return;
				}
			}
		}
	}

	// ===== ADD =====
	static void addRoom() {
		System.out.print("Floor: ");
		int f = sc.nextInt();
		System.out.print("Capacity: ");
		int c = sc.nextInt();
		System.out.print("Type: ");
		String t = sc.next();
		System.out.print("Price: ");
		double p = sc.nextDouble();

		rooms.add(new Room(rooms.size(), f, c, t, p));
	}

	static void addGuest() {
		System.out.print("Name: ");
		String n = sc.next();
		System.out.print("Email: ");
		String e = sc.next();
		System.out.print("Discount: ");
		int d = sc.nextInt();

		guests.add(new Guest(guests.size(), n, e, d));
	}

	static void addEmployee() {
		System.out.print("Name: ");
		String n = sc.next();
		System.out.print("Salary: ");
		double s = sc.nextDouble();
		System.out.print("Job: ");
		String j = sc.next();

		employees.add(new Employee(employees.size(), n, s, j));
	}

	// ===== BOOK =====
	static void book() {
		if (guests.isEmpty() || rooms.isEmpty()) {
			System.out.println("No data!");
			return;
		}

		System.out.print("Guest ID: ");
		Guest g = guests.get(sc.nextInt());

		System.out.print("Room ID: ");
		Room r = rooms.get(sc.nextInt());

		System.out.print("Arrival (yyyy-mm-dd): ");
		LocalDate a = LocalDate.parse(sc.next());

		System.out.print("Departure: ");
		LocalDate d = LocalDate.parse(sc.next());

		if (!r.isAvailable(a, d)) {
			System.out.println("Room not available!");
			return;
		}

		r.reserve(a, d);
		reservations.add(new Reservation(reservations.size(), g, r, a, d));

		System.out.println("Booked!");
	}

	// ===== SHOW =====
	static void showMenu() {
		System.out.println("1.Room 2.Guest 3.Employee 4.Book");
		int c = sc.nextInt();

		switch (c) {
			case 1 -> rooms.forEach(Room::printDetails);
			case 2 -> guests.forEach(Guest::printDetails);
			case 3 -> employees.forEach(Employee::printDetails);
			case 4 -> reservations.forEach(Reservation::printDetails);
		}
	}

	// ===== DELETE =====
	static void deleteMenu() {
		System.out.println("1.Room 2.Guest 3.Employee 4.Book");
		int c = sc.nextInt();

		System.out.print("Enter ID: ");
		int id = sc.nextInt();

		switch (c) {
			case 1 -> rooms.remove(id);
			case 2 -> guests.remove(id);
			case 3 -> employees.remove(id);
			case 4 -> reservations.remove(id);
		}
	}

	// ===== UPDATE =====
	static void updateMenu() {
		System.out.println("1.Room 2.Guest 3.Employee 4.Reservation");
		int c = sc.nextInt();

		System.out.print("Enter ID: ");
		int id = sc.nextInt();

		switch (c) {

			// ===== UPDATE ROOM =====
			case 1 -> {
				if (id >= rooms.size()) {
					System.out.println("Invalid ID!");
					return;
				}

				Room r = rooms.get(id);

				System.out.print("New Floor: ");
				r.setFloor(sc.nextInt());

				System.out.print("New Capacity: ");
				r.setCapacity(sc.nextInt());

				System.out.print("New Type: ");
				r.setType(sc.next());

				System.out.print("New Price: ");
				r.setPrice(sc.nextDouble());

				System.out.println("Room updated!");
			}

			// ===== UPDATE GUEST =====
			case 2 -> {
				if (id >= guests.size()) {
					System.out.println("Invalid ID!");
					return;
				}

				Guest g = guests.get(id);

				System.out.print("New Name: ");
				g.setName(sc.next());

				System.out.print("New Email: ");
				g.setEmail(sc.next());

				System.out.print("New Discount: ");
				g.setDiscount(sc.nextInt());

				System.out.println("Guest updated!");
			}

			// ===== UPDATE EMPLOYEE =====
			case 3 -> {
				if (id >= employees.size()) {
					System.out.println("Invalid ID!");
					return;
				}

				Employee e = employees.get(id);

				System.out.print("New Name: ");
				e.setName(sc.next());

				System.out.print("New Salary: ");
				e.setSalary(sc.nextDouble());

				System.out.print("New Job: ");
				e.setJob(sc.next());

				System.out.println("Employee updated!");
			}

			// ===== UPDATE RESERVATION =====
			case 4 -> {
				if (id >= reservations.size()) {
					System.out.println("Invalid ID!");
					return;
				}

				Reservation res = reservations.get(id);

				System.out.print("New Arrival (yyyy-mm-dd): ");
				LocalDate a = LocalDate.parse(sc.next());

				System.out.print("New Departure: ");
				LocalDate d = LocalDate.parse(sc.next());

				// NOTE: we only update dates here
				// advanced: recalculate price
				res.updateDates(a, d);

				System.out.println("Reservation updated!");
			}
		}
	}
}
