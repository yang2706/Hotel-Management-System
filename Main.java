import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Room> rooms = new ArrayList<>();
        ArrayList<Guest> guests = new ArrayList<>();
        ArrayList<Employee> employees = new ArrayList<>();
        ArrayList<Reservation> reservations = new ArrayList<>();

        Scanner sc = new Scanner(System.in);

        while (true) {
            
			System.out.println("Welcome to system!");
			System.out.println("1.Add Room");
			System.out.println("2.Show Rooms");
			System.out.println("3.Add Guest");
			System.out.println("4.Show Guests");
			System.out.println("5.Add Employee");
			System.out.println("6.Show Employees");
			System.out.println("7.Book");
			System.out.println("8.Exit");
            int c = sc.nextInt();

            switch (c) {
                case 1 -> RoomsController.addNewRoom(rooms, sc);
                case 2 -> RoomsController.showAllRooms(rooms);
                case 3 -> GuestsController.addNewGuest(guests, sc);
                case 4 -> GuestsController.showAllGuests(guests);
                case 5 -> EmployeesController.addNewEmployee(employees, sc);
				case 6 -> EmployeesController.showAllEmployees(employees);
                case 7 -> ReservationsController.createNewReservation(guests, rooms, reservations, sc);
                case 8 -> { return; }
            }
        }
    }
}