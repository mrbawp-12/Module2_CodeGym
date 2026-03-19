package model;

public interface RoomStatus {
    String AVAILABLE = "Sang sang";
    String OCCUPIED = "Dang co khach";
    String MAINTENANCE = "Dang bao tri";

    static boolean isValidStatus(String status) {
        return status.equals(AVAILABLE) ||
                status.equals(OCCUPIED) ||
                status.equals(MAINTENANCE);
    }
}
