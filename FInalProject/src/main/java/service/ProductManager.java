package service;

import model.Product;

import java.util.List;

public class ProductManager implements IManager<Product> {
    @Override
    public void add(Product product) {
        System.out.println("Product added: " + product.getName());
    }

    @Override
    public void delete(int id) {
        System.out.println("Product deleted with id: " + id);
    }

    @Override
    public void update(int id, Product product) {
        System.out.println("Product updated with id: " + id + ", new name: " + product.getName());
    }

    @Override
    public List<Product> getAll() {
        return null;
    }
}
