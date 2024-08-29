import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel {
    private List<Room> rooms = new ArrayList<>();
    private List<Reservation> reservations = new ArrayList<>();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    public void initializeRooms() {
        rooms.add(new Room(101, "Single"));
        rooms.add(new Room(102, "Double"));
        rooms.add(new Room(103, "Suite"));
        // Add more rooms as needed
    }

    public Room findAvailableRoom(String type) {
        for (Room room : rooms) {
            if (room.getType().equalsIgnoreCase(type) && room.isAvailable()) {
                return room;
            }
        }
        return null;
    }

    public Reservation findReservationById(int reservationId) {
        for (Reservation reservation : reservations) {
            if (reservation.getReservationID() == reservationId) {
                return reservation;
            }
        }
        return null;
    }

    public Reservation findReservationByRoomNumber(int roomNumber) {
        for (Reservation reservation : reservations) {
            if (reservation.getRoomNumber() == roomNumber) {
                return reservation;
            }
        }
        return null;
    }

    public Room findRoomByNumber(int roomNumber) {
        for (Room room : rooms) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;
    }

    public void bookRoom(String guestName, String contactInfo, String roomType, String checkInDateStr,
            String checkOutDateStr) {
        try {
            Date checkInDate = dateFormat.parse(checkInDateStr);
            Date checkOutDate = dateFormat.parse(checkOutDateStr);

            if (!checkDates(checkInDate, checkOutDate)) {
                return;
            }

            Room availableRoom = findAvailableRoom(roomType);
            if (availableRoom != null) {
                reservations.add(new Reservation(guestName, contactInfo, availableRoom.getRoomNumber(), checkInDate,
                        checkOutDate));
                availableRoom.setAvailable(false);
                System.out.println("Room booked successfully. Reservation ID: "
                        + reservations.get(reservations.size() - 1).getReservationID());
            } else {
                System.out.println("No rooms available for the selected type and dates.");
            }
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please use yyyy-MM-dd.");
        }
    }

    public void checkIn(int reservationId) {
        Reservation reservation = findReservationById(reservationId);

        if (reservation == null) {
            System.out.println("Invalid reservation ID.");
            return;
        }

        Room room = findRoomByNumber(reservation.getRoomNumber());
        if (room != null && !reservation.isCheckedIn()) {
            room.setAvailable(false);
            reservation.setCheckedIn(true);
            System.out.println("Check-in successful for " + reservation.getGuestName());
        } else {
            System.out.println("Room is already occupied or not available.");
        }
    }

    public void checkOut(int roomNumber) {
        Room room = findRoomByNumber(roomNumber);

        if (room != null && !room.isAvailable()) {
            Reservation reservation = findReservationByRoomNumber(roomNumber);
            if (reservation != null) {
                room.setAvailable(true);
                reservations.remove(reservation);
                System.out.println("Check-out successful for room number " + roomNumber);
            } else {
                System.out.println("No active reservation found for this room.");
            }
        } else {
            System.out.println("Invalid room number or the room is not currently occupied.");
        }
    }

    public void viewReservations() {
        if (reservations.isEmpty()) {
            System.out.println("No current reservations.");
            return;
        }

        System.out.println("\n--- Current Reservations ---");
        for (Reservation reservation : reservations) {
            System.out.println("Reservation ID: " + reservation.getReservationID());
            System.out.println("Guest Name: " + reservation.getGuestName());
            System.out.println("Contact Info: " + reservation.getContactInfo());
            System.out.println("Room Number: " + reservation.getRoomNumber());
            System.out.println("Check-In Date: " + dateFormat.format(reservation.getCheckInDate()));
            System.out.println("Check-Out Date: " + dateFormat.format(reservation.getCheckOutDate()));
            System.out.println("Checked-In: " + (reservation.isCheckedIn() ? "Yes" : "No"));
            System.out.println("----------------------------");
        }
    }

    private boolean checkDates(Date checkInDate, Date checkOutDate) {
        if (checkInDate.after(checkOutDate)) {
            System.out.println("Check-out date cannot be before check-in date. Please try again.");
            return false;
        }
        return true;
    }
}
