package com.example.javalastminute.logic;

/**
 * Main interface for the tax strategy to be choosen at runtime through 
 * TaxStrategyFactory.
 * 
 * @author Vittorio
 */
public abstract class TaxStrategy {
    
    public abstract double calculateTax(double price);    
    
    // Method for rounding taxes.
    public static double roundTax(double tax) {
        // Get the reminder, calculate delta
        // to the upper .05 and add it to tax
        // value
        double reminder = tax % .05;
        if(reminder != 0.0) {
            double addendum = .05 - reminder;
            tax += addendum;
        }
                
        return tax;
    }
}