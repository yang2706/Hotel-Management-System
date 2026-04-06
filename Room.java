import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Room {

    private int id;
    private int floor;
    private int capacity;
    private String type;
    private String description;
    private double price;
    private ArrayList<String> reservedDates;

    public Room(int id, int floor, int capacity, String type, String description, double price) {
        this.id = id;
        this.floor = floor;
        this.capacity = capacity;
        this.type = type;
        this.description = description;
        this.price = price;
        reservedDates = new ArrayList<>();
    }

    public Room() {
        reservedDates = new ArrayList<>();
    }

    public int getId() { return id; }
    public int getFloor() { return floor; }
    public int getCapacity() { return capacity; }
    public String getType() { return type; }
    public String getDescription() { return description; }
    public double getPrice() { return price; }

    public void setId(int id) { this.id = id; }
    public void setFloor(int floor) { this.floor = floor; }
    public void setCapacity(int capacity) { this.capacity = capacity; }
    public void setType(String type) { this.type = type; }
    public void setDescription(String description) { this.description = description; }
    public void setPrice(double price) { this.price = price; }

    public boolean isReserved(LocalDate start, LocalDate end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (LocalDate d = start; d.isBefore(end); d = d.plusDays(1)) {
            if (reservedDates.contains(d.format(formatter))) return true;
        }
        return false;
    }

    public void reserve(LocalDate start, LocalDate end) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        for (LocalDate d = start; d.isBefore(end); d = d.plusDays(1)) {
            reservedDates.add(d.format(formatter));
        }
    }

    public void printDetails() {
        System.out.println("ID: " + id);
        System.out.println("Floor: " + floor);
        System.out.println("Capacity: " + capacity);
        System.out.println("Type: " + type);
        System.out.println("Description: " + description);
        System.out.println("Price: " + price);
    }
}