package com.example.javalastminute.logic;

import com.example.javalastminute.utils.Utils;

/**
 * Basic Imported Tax strategy, for imported products 
 * in the OTHER category.
 * 
 * @author Vittorio
 */
public class TaxBaseImportedStrategy implements TaxStrategy {

    @Override
    public double calculateTax(double price) {        
        return Utils.roundTax((price * 15.0)/100.0);
    }    
}
