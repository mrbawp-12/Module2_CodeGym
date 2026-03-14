package menu;

import lib.Input;
import model.Category;
import model.Product;
import service.CategoryManager;
import service.ProductManager;

import java.util.List;

public class ProductMenu {
    private ProductManager productManager;
    private  CategoryManager categoryManager;

    public ProductMenu(){
        this.productManager = new ProductManager();
        this.categoryManager = new CategoryManager();
    }

    public void showMainMenu(){
        int choice;
        do {
            System.out.println("============ Product Manager ============");
            System.out.println("1.Add Product");
            System.out.println("2.Edit Product");
            System.out.println("3.Remove Product");
            System.out.println("4.Get All");
            System.out.println("5.Get Detail Product");
            System.out.println("0.Exit");
            System.out.println("Enter your choice: ");
            choice = Input.inputInt();
            switch(choice){
                case 1:
                    showAddMenu();
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    getAllMenu();
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Invalid choice! Pls try again.");
            }
        }while (choice != 0);
    }

    public void getAllMenu() {
        List<Product> list = productManager.getAll();
        System.out.println("List Prodcut: ");
        for (Product p : list) {
            Category category = categoryManager.findById(p.getIdCategory());
            System.out.println("Id: " + p.getId() + "; Name: " + p.getName() + "; Price: " + p.getPrice() + " Category: " + category.getName());
        }
    }

    public  void showAddMenu() {
        System.out.println("============ Add Product ============");
        System.out.println("Enter Product name: ");
        String name = Input.inputString();
        System.out.println("Enter Product Quantity: ");
        int quantity = Input.inputInt();
        System.out.println("Enter Product Price: ");
        double price = Input.inputDouble();
//        System.out.println("Enter Product Id Category: ");
//        int idCategory = Input.inputInt();
        // lấy ra danh category ở đây tương tự 1 như ô input select option
        List<Category> listCate = this.categoryManager.getAll();
        int index = 1;
        System.out.println("====> List Category");
        for (Category c : listCate) {
            System.out.println(index + "- " + "Id: " + c.getId() + "; Name" + c.getName());
            index++;
        }
        System.out.println("Pls enter category id: ");
        int idCategory = Input.inputInt();
        Product newProduct = new Product(name, quantity, price, idCategory);
        productManager.add(newProduct);
        System.out.println("Add Sucessfully!");
    }

}