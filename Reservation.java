import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Reservation {

    private int id;
    private Guest guest;
    private Room room;
    private LocalDate a, d;
    private double total;

    public Reservation(int id, Guest g, Room r, LocalDate a, LocalDate d) {
        this.id = id;
        this.guest = g;
        this.room = r;
        this.a = a;
        this.d = d;

        long days = ChronoUnit.DAYS.between(a, d);
        total = days * r.getPrice();
        total -= total * g.getDiscount() / 100;
    }

    public int getId() { return id; }

    public void printDetails() {
        System.out.println("ResID: " + id + " | Guest: " + guest.getName() +
                " | Room: " + room.getId() + " | Total: $" + total);
    }
}