import java.util.ArrayList;
import java.util.Scanner;

public class GuestsController {

    public static void addNewGuest(ArrayList<Guest> guests, Scanner scanner) {
        System.out.println("Enter name:");
        String name = scanner.next();
        System.out.println("Enter email:");
        String email = scanner.next();
        System.out.println("Enter discount:");
        int discount = scanner.nextInt();

        guests.add(new Guest(guests.size(), name, email, discount));
    }

    public static void showAllGuests(ArrayList<Guest> guests) {
        for (Guest g : guests) {
            g.printDetails();
            System.out.println("----------------");
        }
    }
}