package com.example.javalastminute.test;

import com.example.javalastminute.logic.TaxBaseImportedStrategy;
import com.example.javalastminute.logic.TaxBaseStrategy;
import com.example.javalastminute.logic.TaxExemptImportedStrategy;
import com.example.javalastminute.logic.TaxExemptStrategy;
import com.example.javalastminute.logic.TaxStrategy;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Basic class for testing tax calculation
 * based on different strategies.
 * 
 * @author Vittorio
 */
public class StrategyTest {

    @Test
    public void testExemptStrategy() {
        TaxStrategy strategy = new TaxExemptStrategy();
        double tax = strategy.calculateTax(19.24);
        double roundedTax = TaxStrategy.roundTax(tax);
        
        assertEquals(roundedTax, 0d, 0.05);        
    }
    
    @Test
    public void testExemptImportedStrategy() {
        TaxStrategy strategy = new TaxExemptImportedStrategy();
        double tax = strategy.calculateTax(11.25);
        double roundedTax = TaxStrategy.roundTax(tax);
        
        assertEquals(roundedTax, 0.6d, 0.05);        
    }
    
    @Test
    public void testBaseStrategy() {
        TaxStrategy strategy = new TaxBaseStrategy();
        double tax = strategy.calculateTax(10.00);
        double roundedTax = TaxStrategy.roundTax(tax);
        
        assertEquals(roundedTax, 1d, 0.05);        
    }
    
    @Test
    public void testBaseImportedStrategy() {
        TaxStrategy strategy = new TaxBaseImportedStrategy();
        double tax = strategy.calculateTax(47.50);
        double roundedTax = TaxStrategy.roundTax(tax);
        
        assertEquals(roundedTax, 7.15d, 0.05);        
    }
}