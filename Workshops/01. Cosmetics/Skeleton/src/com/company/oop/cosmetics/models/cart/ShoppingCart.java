package com.company.oop.cosmetics.models.cart;

import com.company.oop.cosmetics.models.products.Product;

import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    
    private List<Product> productList;
    
    public ShoppingCart() {
        productList = new ArrayList<Product>();
    }
    
    public List<Product> getProductList() {
        return new ArrayList<>(productList);
    }
    
    public void addProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }

        this.productList.add(product);
    }
    
    public void removeProduct(Product product) {
       if (product == null) {
           throw new IllegalArgumentException("Product cannot be null.");
       }
        if (!this.productList.contains(product)) {
            throw new IllegalArgumentException("Product not found in shopping cart.");
        }

       this.productList.remove(product);
    }
    
    public boolean containsProduct(Product product) {
        if (product == null) {
            throw new IllegalArgumentException("Product cannot be null.");
        }
        return this.productList.contains(product);
    }
    
    public double totalPrice() {
        double total = 0;
        for (Product product: productList) {
            total += product.getPrice();
        }

        return total;
    }
}
