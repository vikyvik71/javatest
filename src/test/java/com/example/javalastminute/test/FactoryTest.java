package com.example.javalastminute.test;

import com.example.javalastminute.domain.Product;
import com.example.javalastminute.domain.ProductType;
import com.example.javalastminute.logic.TaxBaseImportedStrategy;
import com.example.javalastminute.logic.TaxBaseStrategy;
import com.example.javalastminute.logic.TaxExemptImportedStrategy;
import com.example.javalastminute.logic.TaxExemptStrategy;
import com.example.javalastminute.logic.TaxStrategy;
import com.example.javalastminute.logic.TaxStrategyFactory;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * Basic class for testing the tax strategy factory.
 * The factory hides the strategy instantion details 
 * from clients, strategy is choosen based on product
 * type and imported status.
 * 
 * @author Vittorio
 */
public class FactoryTest {

    // Test products data, all possible scenarios
    private static final Product[] PRODUCTS = new Product[4];

    @BeforeClass
    public static void setUpClass() {
        PRODUCTS[0] = new Product("Fake test product#1", 0, 0, false, ProductType.BOOK);
        PRODUCTS[1] = new Product("Fake test product#2", 0, 0, true, ProductType.FOOD);        
        PRODUCTS[2] = new Product("Fake test product#3", 0, 0, false, ProductType.OTHER);
        PRODUCTS[3] = new Product("Fake test product#4", 0, 0, true, ProductType.OTHER);        
    }
    
    @Test
    public void testExempt() {
        TaxStrategy strategy = TaxStrategyFactory.getRightStrategy(PRODUCTS[0]);        
        assertTrue(strategy instanceof TaxExemptStrategy);
    }
    
    @Test
    public void testExemptImported() {
        TaxStrategy strategy = TaxStrategyFactory.getRightStrategy(PRODUCTS[1]);        
        assertTrue(strategy instanceof TaxExemptImportedStrategy);
    }
    
    @Test
    public void testBase() {
        TaxStrategy strategy = TaxStrategyFactory.getRightStrategy(PRODUCTS[2]);        
        assertTrue(strategy instanceof TaxBaseStrategy);
    }
    
    @Test
    public void testBaseImported() {
        TaxStrategy strategy = TaxStrategyFactory.getRightStrategy(PRODUCTS[3]);        
        assertTrue(strategy instanceof TaxBaseImportedStrategy);
    }
}