package model;

import java.time.LocalDate;

public class Invoice {
    private String id;
    private String roomName;
    private String customerName;
    private String employeeName;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private double totalMoney;

    public Invoice() {}

    public Invoice(String id, String roomName, String customerName, String employeeName, LocalDate checkInDate, LocalDate checkOutDate, double totalMoney) {
        this.id = id;
        this.roomName = roomName;
        this.customerName = customerName;
        this.employeeName = employeeName;
        this.checkInDate = checkInDate;
        this.checkOutDate = checkOutDate;
        this.totalMoney = totalMoney;
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

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public LocalDate getCheckInDate() {
        return checkInDate;
    }

    public void setCheckInDate(LocalDate checkInDate) {
        this.checkInDate = checkInDate;
    }

    public LocalDate getCheckOutDate() {
        return checkOutDate;
    }

    public void setCheckOutDate(LocalDate checkOutDate) {
        this.checkOutDate = checkOutDate;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }
}