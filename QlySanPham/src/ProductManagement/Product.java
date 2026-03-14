package ProductManagement;

public class Product {
    private String id;
    private String name;
    private double price;
    private int quantity;

    public Product(String id, String name, double price, int quantity){
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }
}

public String geiId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}