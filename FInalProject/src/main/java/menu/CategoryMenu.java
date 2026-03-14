package menu;

import lib.Input;
import model.Category;
import service.CategoryManager;
import java.util.List;

public class CategoryMenu {
    private CategoryManager categoryManager;

    public CategoryMenu() {
        this.categoryManager = new CategoryManager();
    }

    public void showMainMenu(){
        int choice;
        do {
            System.out.println("======= Category Manager =======");
            System.out.println("1.Add Category");
            System.out.println("2.Edit Category");
            System.out.println("3.Remove Category");
            System.out.println("4.Get All");
            System.out.println("5.Get Detail Category");
            System.out.println("0.Exit");
            System.out.println("Enter your choice: ");
            choice = Input.inputInt();
            switch (choice) {
                case 1:
                    showAddMenu;
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    getAllMenu();
                    break;
                case  5:
                    break;
                case 6:
                    break;
                case  0:
                    break;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }while (choice != 0);
    }

    public void getAllMenu(){
        List<Category> list = categoryManager.getAll();
        System.out.println("List Category: ");
        for( Category c : list){
            System.out.println(c);
        }
    }

    public  void showAddMenu(){
        System.out.println("============ Add Category ===========");
        System.out.println("Enter category name: ");
        String name = Input.inputSring();
        Category newCate = new Category(name);
        categoryManager.add(newCate);
        System.out.println("Add Successfully!");
    }
}
