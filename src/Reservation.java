import java.util.Date;

public class Reservation {
    private static int idCounter = 1;
    private int reservationID;
    private String guestName;
    private String contactInfo;
    private int roomNumber;
    private Date checkInDate;
    private Date checkOutDate;
    private boolean isCheckedIn;

    public Reservation(String guestName, String contactInfo, int roomNumber, Date checkInDate, Date checkOutDate) {
        this.reservationID = idCounter++;
        this.guestName = guestName;
        this.contactInfo = contactInfo;
        this.roomNumber = roomNumber;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.isCheckedIn = false;
    }

    public int getReservationID() {
        return reservationID;
    }

    public String getGuestName() {
        return guestName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public int getRoomNumber() {
        return roomNumber;
    }

    public Date getCheckInDate() {
        return checkInDate;
    }

    public Date getCheckOutDate() {
        return checkOutDate;
    }

    public boolean isCheckedIn() {
        return isCheckedIn;
    }

    public void setCheckedIn(boolean checkedIn) {
        isCheckedIn = checkedIn;
    }
}
