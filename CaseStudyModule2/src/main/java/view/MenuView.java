package view;

import model.*;
import service.*;

import java.util.Scanner;
import java.util.List;
import java.time.LocalDate;

public class MenuView {
    private Scanner scanner;
    private UserService userService;
    private RoomService roomService;
    private InvoiceService invoiceService;

    public MenuView() {
        this.userService = new UserService();
        this.roomService = new RoomService();
        this.invoiceService = new InvoiceService();
        this.scanner = new Scanner(System.in);
    }

    //menu chinh
    public void showMainMenu(User user) {
        while (true) {
            System.out.println("\n === MENU CHINH ===");
            System.out.println("Xin chao, " + user.getFullName());
            System.out.println("1. Xem thong tin tai khoan");
            System.out.println("2. Quan ly phong");
            System.out.println("3. Quan ly hoa don");
            System.out.println("4. Thong ke doanh thu");
            System.out.println("5. Dang xuat");
            System.out.print("Chon chuc nang: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showAccountInfo(user);
                    break;
                case 2:
                    showRoomManagement();
                    break;
                case 3:
                    showInvoiceManagement();
                    break;
                case 4:
                    showRevenueStatistics();
                    break;
                case 5:
                    System.out.println("Dang xuat...");
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        }
    }

    //menu quan ly phong
    private void showRoomManagement() {
        while (true) {
            System.out.println("\n === QUAN LY PHONG ===");
            System.out.println("1. Xem tat ca phong");
            System.out.println("2. Tim kiem phong theo gia");
            System.out.println("3. Them phong moi");
            System.out.println("4. Cap nhat thong tin phong");
            System.out.println("5. Xoa phong");
            System.out.println("6. Quay lai menu chinh");
            System.out.print("Chon chuc nang: ");

            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so!");
                continue;
            }

            switch (choice) {
                case 1:
                    showAllRooms();
                    break;
                case 2:
                    searchRoomsByPrice();
                    break;
                case 3:
                    addNewRoom();
                    break;
                case 4:
                    updateRoomInfo();
                    break;
                case 5:
                    deleteRoom();
                    break;
                case 6:
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        }
    }

    //menu quan ly hoa don
    private void showInvoiceManagement() {
        while (true) {
            System.out.println("\n === QUAN LY HOA DON ===");
            System.out.println("1. Xem tat ca hoa don");
            System.out.println("2. Tim kiem hoa don theo id");
            System.out.println("3. Them hoa don moi");
            System.out.println("4. Cap nhat thong tin hoa don");
            System.out.println("5. Quay lai menu chinh");
            System.out.print("Chon chuc nang: ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    showAllInvoices();
                    break;
                case 2:
                    searchInvoiceById();
                    break;
                case 3:
                    addNewInvoice();
                    break;
                case 4:
                    updateInvoice();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Lua chon khong hop le. Vui long thu lai.");
            }
        }
    }

    //hien thi thong tin tai khoan
    private void showAccountInfo(User user) {
        System.out.println("\n === THONG TIN TAI KHOAN ===");
        System.out.println("Username: " + user.getUsername());
        System.out.println("Full Name: " + user.getFullName());
        System.out.println("Email: " + user.getEmail());
        System.out.println("Phone Number: " + user.getPhoneNumber());
        System.out.println("Address: " + user.getAddress());
        System.out.println("Age: " + user.getAge());
    }

    //cac ham
    private void showAllRooms() {
        List<Room> rooms = roomService.getAllRooms();
        System.out.println("\n === DANH SACH PHONG ===");
        if (rooms.isEmpty()) {
            System.out.println("Chua co phong nao.");
            return;
        }
        for (Room r : rooms) {
            System.out.println(r);
        }
    }

    private void searchRoomsByPrice() {
        System.out.println("\n === TIM KIEM PHONG THEO GIA ===");
        System.out.print("Nhap gia thap nhat: ");
        double minPrice = Double.parseDouble(scanner.nextLine());
        System.out.print("Nhap gia cao nhat: ");
        double maxPrice = Double.parseDouble(scanner.nextLine());

        List<Room> rooms = roomService.findRoomsByPrice(minPrice, maxPrice);
        if (rooms.isEmpty()) {
            System.out.println("Khong tim thay phong nao trong khoang gia nay.");
        } else {
            rooms.forEach(room -> System.out.println(room));
        }
    }

    private void addNewRoom() {
        try {
            Room room = new Room();
            room.setId("R" + System.currentTimeMillis());

            System.out.print("Nhap ten phong: ");
            String roomName = scanner.nextLine();
            if (roomName.trim().isEmpty()) {
                System.out.println("Ten phong khong duoc de trong!");
                return;
            }
            room.setRoomName(roomName);

            System.out.print("Nhap gia phong: ");
            double price;
            try {
                price = Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Gia phong phai la so!");
                return;
            }
            room.setPrice(price);

            System.out.print("Nhap so giuong: ");
            int bedCount;
            try {
                bedCount = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("So giuong phai la so nguyen!");
                return;
            }
            room.setBedCount(bedCount);

            System.out.println("Nhap trang thai: ");
            System.out.println("1. San sang");
            System.out.println("2. Dang su dung");
            System.out.println("3. Dang bao tri");
            System.out.print("Chon: ");

            int statusChoice;
            try {
                statusChoice = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Lua chon khong hop le!");
                return;
            }

            switch (statusChoice) {
                case 1:
                    room.setStatus(RoomStatus.AVAILABLE);
                    break;
                case 2:
                    room.setStatus(RoomStatus.OCCUPIED);
                    break;
                case 3:
                    room.setStatus(RoomStatus.MAINTENANCE);
                    break;
                default:
                    room.setStatus(RoomStatus.AVAILABLE);
            }

            roomService.addRoom(room);
            System.out.println("Them phong thanh cong.");

        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    private void updateRoomInfo() {
        try {
            System.out.println("\n === CAP NHAT THONG TIN PHONG ===");
            System.out.print("Nhap ID phong can cap nhat: ");
            String id = scanner.nextLine();
            Room room = roomService.findRoomById(Integer.parseInt(id));
            System.out.println("Thong tin phong hien tai: " + room);
            System.out.print("Nhap thong tin moi (enter de giu nguyen): ");
            System.out.print("Ten phong:  (" + room.getRoomName() + "): ");
            String roomName = scanner.nextLine();
            if (!roomName.isEmpty()) {
                room.setRoomName(roomName);
            }
            System.out.println("Gia phong: (" + room.getPrice() + "): ");
            String priceInput = scanner.nextLine();
            if (!priceInput.isEmpty()) {
                room.setPrice(Double.parseDouble(priceInput));
                roomService.updateRoom(room);
                System.out.println("Cap nhat phong thanh cong.");
            }
        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    private void deleteRoom() {
        try {
            System.out.println("\n === XOA PHONG ===");
            System.out.print("Nhap ID phong can xoa: ");
            String id = scanner.nextLine();
            roomService.deleteRoom(id);
            System.out.println("Xoa phong thanh cong.");
        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    private void showAllInvoices() {
        List<Invoice> invoices = invoiceService.getAllInvoices();
        System.out.println("\n === DANH SACH HOA DON ===");
        if (invoices.isEmpty()) {
            System.out.println("Chua co hoa don nao.");
            return;
        }
        for (Invoice i : invoices) {
            System.out.println("%s | %s | %s | %s | %s | %s | %.2fVND".formatted(i.getId(), i.getRoomName(), i.getCustomerName(), i.getEmployeeName(), i.getCheckInDate(), i.getCheckOutDate(), i.getTotalMoney()));
        }
    }

    private void addNewInvoice() {
        Invoice invoice = new Invoice();
        System.out.print("Nhap ten phong: ");
        invoice.setRoomName(scanner.nextLine());
        System.out.print("Nhap ten khach hang: ");
        invoice.setCustomerName(scanner.nextLine());
        System.out.print("Nhap ten nhan vien: ");
        invoice.setEmployeeName(scanner.nextLine());
        System.out.print("Nhap ngay check-in (yyyy-MM-dd): ");
        invoice.setCheckInDate(LocalDate.parse(scanner.nextLine()));
        System.out.print("Nhap ngay check-out (yyyy-MM-dd): ");
        invoice.setCheckOutDate(LocalDate.parse(scanner.nextLine()));
        System.out.print("Nhap tong tien: ");
        invoice.setTotalMoney(Double.parseDouble(scanner.nextLine()));

        invoiceService.addInvoice(invoice);
        System.out.println("Them hoa don thanh cong! ID hoa don: " + invoice.getId());
    }

    private void updateInvoice() {
        try {
            System.out.println("\n === CAP NHAT THONG TIN HOA DON ===");
            System.out.print("Nhap ID hoa don can cap nhat: ");
            String id = scanner.nextLine();
            Invoice invoice = invoiceService.findInvoiceById(id);
            System.out.println("Thong tin hoa don hien tai: " + invoice);
            System.out.print("Nhap thong tin moi (enter de giu nguyen): ");
            System.out.print("Ten phong:  (" + invoice.getRoomName() + "): ");
            String roomName = scanner.nextLine();
            if (!roomName.isEmpty()) {
                invoice.setRoomName(roomName);
                invoiceService.updateInvoice(invoice);
                System.out.println("Cap nhat hoa don thanh cong.");
            }
        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    private void searchInvoiceById() {
        try {
            System.out.println("\n === TIM KIEM HOA DON THEO ID ===");
            System.out.print("Nhap ID hoa don: ");
            String id = scanner.nextLine();
            Invoice invoice = invoiceService.findInvoiceById(id);
            System.out.println("Thong tin hoa don: " + invoice);
        } catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }

    private void showRevenueStatistics() {
        System.out.println("\n === THONG KE DOANH THU ===");
        System.out.println("Nhap thang(1-12): ");
        int month = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhap nam: ");
        int year = Integer.parseInt(scanner.nextLine());
        double revenue = invoiceService.calculateMonthlyRevenue(month, year);
        System.out.println("Tong doanh thu thang" + month + "/" + year + ": " + revenue + "VND");
    }

    private int getIntInput() {
        try {
            return Integer.parseInt(scanner.nextLine());
        }catch (Exception e) {
            System.out.println("Loi: " + e.getMessage());
            return -1;
        }
    }
}