package model;

public class Room implements RoomStatus {
    private String id;
    private String roomName;
    private double price;
    private int bedCount;
    private String status;

    public Room() {}

    public Room(String id, String roomName, double price, int bedCount, String status) {
        this.id = id;
        this.roomName = roomName;
        this.price = price;
        this.bedCount = bedCount;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRoomName() {
        return roomName;
    }

    public void setRoomName(String roomName) {
        this.roomName = roomName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getBedCount() {
        return bedCount;
    }

    public void setBedCount(int bedCount) {
        this.bedCount = bedCount;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | %.2fVND | %d giuong | %s", id, roomName, price, bedCount, status);
    }
}