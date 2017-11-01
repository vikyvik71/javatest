package com.example.javalastminute.logic;

import com.example.javalastminute.utils.Utils;

/**
 * Basic Tax strategy, for products in the OTHER category.
 * 
 * @author Vittorio
 */
public class TaxBaseStrategy implements TaxStrategy {

    @Override
    public double calculateTax(double price) {
        return Utils.roundTax((price * 10.0)/100.0);
    }
    
}
