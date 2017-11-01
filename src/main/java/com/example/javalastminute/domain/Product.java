package com.example.javalastminute.domain;

import com.example.javalastminute.logic.TaxStrategy;

/**
 * Base domain object. Represents a product.
 * It is composed of the tax strategy which helps
 * determine the taxed price for this item.
 * 
 * @author Vittorio
 */
public class Product {
    
    private int quantity;
    private String name;
    private double price;
    private boolean imported;
    private ProductType type;
    private TaxStrategy strategy;

    public Product(String name, double price, int quantity, boolean imported, ProductType type) {
        this.name = name;
        this.price = price;
        this.imported = imported;
        this.type = type;        
        this.quantity = quantity;
    }
    
    public double getTaxedPrice() {
        double tax = strategy.calculateTax(price);
        double roundedTax = TaxStrategy.roundTax(tax);
                
        return (price + roundedTax)*quantity;
    }

    public void setStrategy(TaxStrategy strategy) {
        this.strategy = strategy;
    }

    public TaxStrategy getStrategy() {
        return strategy;
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isImported() {
        return imported;
    }

    public void setImported(boolean imported) {
        this.imported = imported;
    } 

    public ProductType getType() {
        return type;
    }

    public void setType(ProductType type) {
        this.type = type;
    }     

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }   
}