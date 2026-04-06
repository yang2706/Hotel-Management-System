import java.time.LocalDate;
import java.time.Period;

public class Reservation {

    private LocalDate arrivalDate;
    private LocalDate departureDate;
    private double price;
    private String status;
    private Guest guest;
    private Room room;

    public Reservation(LocalDate a, LocalDate d, double p, String s, Guest g, Room r) {
        arrivalDate = a;
        departureDate = d;
        price = p;
        status = s;
        guest = g;
        room = r;
    }

    public void printDetails() {
        int days = Period.between(arrivalDate, departureDate).getDays();

        System.out.println("Days: " + days);
        guest.printDetails();
        room.printDetails();
        System.out.println("Total: " + price);
        System.out.println("Status: " + status);
    }
}