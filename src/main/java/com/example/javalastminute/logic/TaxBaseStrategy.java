package com.example.javalastminute.logic;

/**
 * Basic Tax strategy, for products in the OTHER category.
 * 
 * @author Vittorio
 */
public class TaxBaseStrategy extends TaxStrategy {

    @Override
    public double calculateTax(double price) {
        return (price * 10.0)/100.0;
    }
    
}