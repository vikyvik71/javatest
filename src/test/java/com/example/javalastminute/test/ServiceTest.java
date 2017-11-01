package com.example.javalastminute.test;

import com.example.javalastminute.domain.Product;
import com.example.javalastminute.domain.ProductType;
import com.example.javalastminute.logic.TaxExemptImportedStrategy;
import com.example.javalastminute.logic.TaxStrategyFactory;
import com.example.javalastminute.service.ProductService;
import com.example.javalastminute.service.ProductServiceImpl;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vittorio
 */
public class ServiceTest {

    private static ProductService service;
        
    @BeforeClass
    public static void setUpClass() {
        service = new ProductServiceImpl();        
    }    
    
    @Test
    public void testSingleItem() {        
        Product p = service.processItem("3 imported box of chocolates at 10.00");
        assertEquals(p.getTaxedPrice(), 31.5, 0.05);
        assertEquals(p.getName(), "box of chocolates");
        assertEquals(p.getPrice(), 10.00, 0.0);
        assertEquals(p.isImported(), true);
        assertEquals(p.getQuantity(), 3);
        assertTrue(p.getStrategy() instanceof TaxExemptImportedStrategy);
    }
    
    @Test
    public void testOutputItems() {  
        // 1 music CD at 14.99
        Product p1 = new Product("music CD", 14.99, 1, false, ProductType.OTHER);
        p1.setStrategy(TaxStrategyFactory.getRightStrategy(p1));
        assertEquals(service.outputItem(p1), "1 music CD: 16.49");        
        
        // 1 box of imported chocolates at 11.25
        Product p2 = new Product("box of chocolates", 11.25, 1, true, ProductType.FOOD);
        p2.setStrategy(TaxStrategyFactory.getRightStrategy(p2));
        assertEquals(service.outputItem(p2), "1 imported box of chocolates: 11.85");        
    }
}