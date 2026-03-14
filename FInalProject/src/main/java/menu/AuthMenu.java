package menu;

import lib.Input;
import model.User;
import service.UserManager;

public class AuthMenu {

    private UserManager userManager;
    private CategoryMenu categoryMenu;
    private ProductMenu productMenu;

    public AuthMenu(){
        this.userManager = new UserManager();
        this.categoryMenu = new CategoryMenu();
        this.productMenu = new ProductMenu();
    }

    public void showAuthMenu(){
        int choice;
        do {
            System.out.println("====== Auth Menu ======");
            System.out.println("1. Register");
            System.out.println("2. Login");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Input.inputInt();
            switch (choice) {
                case 1:
                    showRegisterMenu();
                    break;
                case 2:
                    showLogin();
                    break;
                case 0:
                    System.out.println("See you again!");
                    break;
                default:
                    System.out.println("Pls enter choice in the menu!");
            }
        }while (choice != 0 );
    }

    public void showLoginMenu(){
        System.out.println("Enter your username: ");
        String username = Input.inputSring();
        System.out.println("Enter your password: ");
        String password = Input.inputSring();
        User user = new User(username, password);
        userManager.register(user);
        System.out.println("Register successfully!");
    }

    public void showLogin(){
        System.out.println("Enter your username: ");
        String username = Input.inputSring();
        System.out.println("Enter your password: ");
        String password = Input.inputSring();
        boolean isSystemUser = userManager.login(username, password);
        if (isSystemUser) {
            showSystemMenu();
        }else {
            System.out.println("Your username or password is wrong, pls try again!");
        }
    }

    public void showSystemMenu(){
        int choice;
        do {
            System.out.println("====== Admin Menu ======");
            System.out.println("1. Manager Product");
            System.out.println("2. Manager Category");
            System.out.println("3. Manager User");
            System.out.println("0. Exit");
            System.out.print("Enter your choice: ");
            choice = Input.inputInt();
            switch (choice) {
                case 1:
                    productMenu.showMainMenu();
                    break;
                case 2:
                    categoryMenu.showMainMenu();
                    break;
                case 3:
                    System.out.println("vao user");
                    break;
                case 0:
                    System.out.println("Bye, see you again!");
                    break;
                default:
                    System.out.println("Pls enter choice in the menu!");
            }
        }while (choice != 0)
    }
}
