package com.example.javalastminute.logic;

/**
 * Basic Imported Tax strategy, for imported products 
 * in the OTHER category.
 * 
 * @author Vittorio
 */
public class TaxBaseImportedStrategy extends TaxStrategy {

    @Override
    public double calculateTax(double price) {        
        return (price * 15.0)/100.0;
    }    
}