import java.util.Scanner;

public class HotelManagementSystem {
    private static Hotel hotel = new Hotel();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        hotel.initializeRooms();
        while (true) {
            showMainMenu();
        }
    }

    private static void showMainMenu() {
        System.out.println("\n--- Hotel Management System ---");
        System.out.println("1. Book a Room");
        System.out.println("2. Check-In");
        System.out.println("3. Check-Out");
        System.out.println("4. View Reservations");
        System.out.println("5. Exit");
        System.out.print("Enter your choice: ");
        String choice = scanner.nextLine();

        switch (choice) {
            case "1":
                bookRoom();
                break;
            case "2":
                checkIn();
                break;
            case "3":
                checkOut();
                break;
            case "4":
                hotel.viewReservations();
                break;
            case "5":
                exitSystem();
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    private static void bookRoom() {
        System.out.print("Enter guest name: ");
        String guestName = scanner.nextLine().trim();
        System.out.print("Enter contact info: ");
        String contactInfo = scanner.nextLine().trim();
        System.out.print("Enter room type (Single/Double/Suite): ");
        String roomType = scanner.nextLine().trim();

        if (guestName.isEmpty() || contactInfo.isEmpty() || roomType.isEmpty()) {
            System.out.println("All fields are required. Please try again.");
            return;
        }

        System.out.print("Enter check-in date (yyyy-MM-dd): ");
        String checkInDateStr = scanner.nextLine().trim();
        System.out.print("Enter check-out date (yyyy-MM-dd): ");
        String checkOutDateStr = scanner.nextLine().trim();

        hotel.bookRoom(guestName, contactInfo, roomType, checkInDateStr, checkOutDateStr);
    }

    private static void checkIn() {
        System.out.print("Enter reservation ID: ");
        String input = scanner.nextLine().trim();

        try {
            int reservationId = Integer.parseInt(input);
            hotel.checkIn(reservationId);
        } catch (NumberFormatException e) {
            System.out.println("Invalid reservation ID. Please enter a valid number.");
        }
    }

    private static void checkOut() {
        System.out.print("Enter room number: ");
        String input = scanner.nextLine().trim();

        try {
            int roomNumber = Integer.parseInt(input);
            hotel.checkOut(roomNumber);
        } catch (NumberFormatException e) {
            System.out.println("Invalid room number. Please enter a valid number.");
        }
    }

    private static void exitSystem() {
        System.out.println("Exiting the system. Goodbye!");
        System.exit(0);
    }
}
