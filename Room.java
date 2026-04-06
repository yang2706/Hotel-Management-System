import java.time.LocalDate;
import java.util.ArrayList;

public class Room {

    private int id, floor, capacity;
    private String type;
    private double price;
    private ArrayList<LocalDate> reserved = new ArrayList<>();

    public Room(int id, int floor, int capacity, String type, double price) {
        this.id = id;
        this.floor = floor;
        this.capacity = capacity;
        this.type = type;
        this.price = price;
    }

    public int getId() { return id; }
    public double getPrice() { return price; }

    public void setFloor(int floor) { this.floor = floor; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setType(String type) { this.type = type; }
    public void setPrice(double price) { this.price = price; }

    public boolean isAvailable(LocalDate a, LocalDate d) {
        for (LocalDate date : reserved) {
            if (!date.isBefore(a) && date.isBefore(d)) return false;
        }
        return true;
    }

    public void reserve(LocalDate a, LocalDate d) {
        for (LocalDate date = a; date.isBefore(d); date = date.plusDays(1)) {
            reserved.add(date);
        }
    }

    public void printDetails() {
        System.out.println("ID:"+id + " | Floor: " + floor + " | Cap: " + capacity + " | " + type + " | $" + price);
    }
}