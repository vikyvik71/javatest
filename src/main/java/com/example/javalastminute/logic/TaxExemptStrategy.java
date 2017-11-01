package com.example.javalastminute.logic;

/**
 * Tax Exempt strategy, for products in the FOOD,
 * BOOK or MEDICAL category.
 * 
 * @author Vittorio
 */
public class TaxExemptStrategy extends TaxStrategy {
    
    @Override
    public double calculateTax(double price) {
        return 0.0;
    }   
}