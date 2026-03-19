import model.User;
import service.UserService;
import view.MenuView;
import exception.*;

public class Main {
    public static void main(String[] args) {
        UserService userService = new UserService();
        MenuView menuView = new MenuView();
        java.util.Scanner scanner = new java.util.Scanner(System.in);

        while (true) {
            System.out.println("\n=== QUAN LY KHACH SAN ===");
            System.out.println("1. Dang ky");
            System.out.println("2. Dang nhap");
            System.out.println("3. Thoat");
            System.out.print("Chon chuc nang: ");
            int choice;
            try {
                choice = Integer.parseInt(scanner.nextLine());
            }catch (Exception e) {
                System.out.println("Vui long nhap so");
                continue;
            }

            switch (choice) {
                case 1:
                    try {
                        System.out.println("\n=== DANG KY ===");
                        System.out.print("Username: ");
                        String username = scanner.nextLine();
                        System.out.print("Password: ");
                        String password = scanner.nextLine();
                        System.out.print("Phone Number: ");
                        String phoneNumber = scanner.nextLine();
                        System.out.print("Address: ");
                        String address = scanner.nextLine();
                        System.out.print("Email: ");
                        String email = scanner.nextLine();
                        System.out.print("Full Name: ");
                        String fullName = scanner.nextLine();
                        System.out.print("Age: ");
                        int age = Integer.parseInt(scanner.nextLine());
                        User user = new User(username, password, phoneNumber, address, email, fullName, age);
                        userService.register(user);
                        System.out.println("Dang ky thanh cong!");
                    }catch (Exception e) {
                        System.out.println("Loi: " + e.getMessage());
                    }
                    break;
                case 2:
                    try {
                        System.out.println("\n=== DANG NHAP ===");
                        System.out.print("Username: ");
                        String username = scanner.nextLine();
                        System.out.print("Password: ");
                        String password = scanner.nextLine();
                        User user = userService.login(username, password);
                        System.out.println("Dang nhap thanh cong! Chao mung " + user.getFullName());
                        menuView.showMainMenu(user);
                    }catch (Exception e) {
                        System.out.println("Loi: " + e.getMessage());
                    }
                    break;
                case 3:
                    System.out.println("Cam on ban da su dung chuong trinh!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Vui long chon chuc nang tu 1 den 3");
            }
        }
    }
}