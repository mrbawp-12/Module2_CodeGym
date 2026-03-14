package model;

public class Product {
    private int id;
    private String name;
    private int quantity;
    private double price;
    private int idCategory;

    public Product(int id, String name, int quantity, double price, int idCategory) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.idCategory = idCategory;
    }

    public Product(String name, int quantity, double price, int idCategory) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
        this.idCategory = idCategory;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public Product(){
    }

    public int getId() {
        return id;
    }

    public  void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public  void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + ", Name: " + this.name + ", Quantity: " + this.quantity + ", Price: " + this.price + ", IdCategory: " + this.idCategory;
    }

}