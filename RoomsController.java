import java.util.ArrayList;
import java.util.Scanner;

public class RoomsController {

    public static void addNewRoom(ArrayList<Room> rooms, Scanner scanner) {
        System.out.println("Enter floor:");
        int floor = scanner.nextInt();
        System.out.println("Enter capacity:");
        int capacity = scanner.nextInt();
        System.out.println("Enter type:");
        String type = scanner.next();
        System.out.println("Enter description:");
        String desc = scanner.next();
        System.out.println("Enter price:");
        double price = scanner.nextDouble();

        rooms.add(new Room(1000 + rooms.size(), floor, capacity, type, desc, price));
    }

    public static void showAllRooms(ArrayList<Room> rooms) {
        for (Room r : rooms) {
            r.printDetails();
            System.out.println("----------------");
        }
    }

    public static Room getRoomById(int id, ArrayList<Room> rooms) {
        for (Room r : rooms) {
            if (r.getId() == id) return r;
        }
        return null;
    }
}