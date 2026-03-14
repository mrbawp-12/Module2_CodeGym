import model.Contact;
import service.ContactService;
import database.CsvHandler;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Contact> contactList = new ArrayList<>();

        try {
            contactList = CsvHandler.readFromCsv();
            System.out.println("Da tai " + contactList.size() + " danh ba tu file.");
        } catch (IOException e) {
            System.out.println("Khong tim thay file CSV, bat dau voi danh ba rong.");
        }

        ContactService service = new ContactService(contactList, sc);

        int choice;
        do {
            showMenu();
            System.out.print("Chon chuc nang: ");
            String input = sc.nextLine().trim();

            // kiem tra xem co nhap so khong, neu khong thi hien thong bao loi va quay lai menu
            try {
                choice = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Vui long nhap so tu 1 den 8.");
                choice = 0;
                continue;
            }

            switch (choice) {
                case 1:
                    service.showAll();
                    break;
                case 2:
                    service.addContact();
                    break;
                case 3:
                    service.updateContact();
                    break;
                case 4:
                    service.deleteContact();
                    break;
                case 5:
                    service.search();
                    break;
                case 6:
                    readFromFile(service, sc);
                    break;
                case 7:
                    writeToFile(service, sc);
                    break;
                case 8:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Chuc nang khong hop le, vui long chon lai.");
            }

        } while (choice != 8);

        sc.close();
    }

    // in menu ra man hinh
    private static void showMenu() {
        System.out.println("\n----- CHUONG TRINH QUAN LY DANH BA -----");
        System.out.println("Chon chuc nang theo so (de tiep tuc):");
        System.out.println("1. Xem danh sach");
        System.out.println("2. Them moi");
        System.out.println("3. Cap nhat");
        System.out.println("4. Xoa");
        System.out.println("5. Tim kiem");
        System.out.println("6. Doc tu file");
        System.out.println("7. Ghi vao file");
        System.out.println("8. Thoat");
    }

    // doc danh ba tu file CSV
    private static void readFromFile(ContactService service, Scanner sc) {
        System.out.println("CANH BAO: Toan bo danh ba trong bo nho se bi xoa va thay bang du lieu tu file.");
        System.out.print("Ban co chac muon tiep tuc? (Y de dong y): ");
        String confirm = sc.nextLine().trim();

        if (!confirm.equalsIgnoreCase("Y")) {
            System.out.println("Da huy thao tac.");
            return;
        }

        try {
            List<Contact> loaded = CsvHandler.readFromCsv();
            service.setContactList(loaded);
            System.out.println("Doc file thanh cong! Da tai " + loaded.size() + " danh ba.");
        } catch (IOException e) {
            System.out.println("Loi khi doc file: " + e.getMessage());
        }
    }

    // ghi danh ba hien tai trong bo nho vao file CSV (ghi de, khong them moi)
    private static void writeToFile(ContactService service, Scanner sc) {
        System.out.println("CANH BAO: Noi dung file se bi ghi de boi danh ba hien tai trong bo nho.");
        System.out.print("Ban co chac muon tiep tuc? (Y de dong y, ENTER de thoat): ");
        String confirm = sc.nextLine().trim();

        if (!confirm.equalsIgnoreCase("Y")) {
            System.out.println("Da huy thao tac.");
            return;
        }

        try {
            CsvHandler.writeToCsv(service.getContactList());
            System.out.println("Ghi file thanh cong!");
        } catch (IOException e) {
            System.out.println("Loi khi ghi file: " + e.getMessage());
        }
    }
}