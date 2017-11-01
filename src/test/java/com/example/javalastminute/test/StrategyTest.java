package com.example.javalastminute.test;

import com.example.javalastminute.logic.TaxBaseImportedStrategy;
import com.example.javalastminute.logic.TaxBaseStrategy;
import com.example.javalastminute.logic.TaxExemptImportedStrategy;
import com.example.javalastminute.logic.TaxExemptStrategy;
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
        assertEquals(new TaxExemptStrategy().calculateTax(19.24), 0d, 0);        
    }
    
    @Test
    public void testExemptImportedStrategy() {
        assertEquals(new TaxExemptImportedStrategy().calculateTax(11.25), 0.6d, 0);        
    }
    
    @Test
    public void testBaseStrategy() {
        assertEquals(new TaxBaseStrategy().calculateTax(10.00), 1d, 0);        
    }
    
    @Test
    public void testBaseImportedStrategy() {
        assertEquals(new TaxBaseImportedStrategy().calculateTax(47.50), 7.15d, 0);        
    }
}
