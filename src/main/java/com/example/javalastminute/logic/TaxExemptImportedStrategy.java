package com.example.javalastminute.logic;

/**
 * Tax Exempt Imported strategy, for imported products
 * in the FOOD, BOOK or MEDICAL category.
 * 
 * @author Vittorio
 */
public class TaxExemptImportedStrategy extends TaxStrategy {

    @Override
    public double calculateTax(double price) {
        return (price * 5.0)/100.0;
    }
    
}