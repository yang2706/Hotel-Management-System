import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class ReservationsController {

    public static void createNewReservation(ArrayList<Guest> guests, ArrayList<Room> rooms, ArrayList<Reservation> reservations, Scanner scanner) {

        System.out.println("Enter arrival date (yyyy-MM-dd):");
        LocalDate a = LocalDate.parse(scanner.next());

        System.out.println("Enter departure date:");
        LocalDate d = LocalDate.parse(scanner.next());

        System.out.println("Enter guest id:");
        Guest g = guests.get(scanner.nextInt());

        System.out.println("Enter room id:");
        Room r = RoomsController.getRoomById(scanner.nextInt(), rooms);

        if (r == null || r.isReserved(a, d)) {
            System.out.println("Room not available!");
            return;
        }

        int days = d.getDayOfMonth() - a.getDayOfMonth();
        double total = days * r.getPrice();
        total -= total * g.getDiscount() / 100;

        Reservation res = new Reservation(a, d, total, "Reserved", g, r);
        reservations.add(res);

        r.reserve(a, d); // IMPORTANT FIX

        res.printDetails();
    }
}