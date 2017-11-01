/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.javalastminute.domain;

/**
 *
 * @author Vittorio
 */
public class Product {
    
    private String name;
    private double price;
    private boolean imported;
    private ProductType type;

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
}
