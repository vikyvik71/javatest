package com.example.javalastminute.logic;

import com.example.javalastminute.utils.Utils;

/**
 * Tax Exempt Imported strategy, for imported products
 * in the FOOD, BOOK or MEDICAL category.
 * 
 * @author Vittorio
 */
public class TaxExemptImportedStrategy implements TaxStrategy {

    @Override
    public double calculateTax(double price) {
        return Utils.roundTax((price * 5.0)/100.0);
    }
    
}
