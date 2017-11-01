/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.javalastminute.test;

import com.example.javalastminute.logic.TaxBaseImportedStrategy;
import com.example.javalastminute.logic.TaxBaseStrategy;
import com.example.javalastminute.logic.TaxExemptImportedStrategy;
import com.example.javalastminute.logic.TaxExemptStrategy;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Vittorio
 */
public class StrategyTest {

    @Test
    public void testExemptStrategy() {
        assertEquals(new TaxExemptStrategy().calculateTax(19.24), new Double(0));        
    }
    
    @Test
    public void testExemptImportedStrategy() {
        assertEquals(new TaxExemptImportedStrategy().calculateTax(10.0), new Double(0.50));        
    }
    
    @Test
    public void testBaseStrategy() {
        assertEquals(new TaxBaseStrategy().calculateTax(10.00), new Double(1));        
    }
    
    @Test
    public void testBaseImportedStrategy() {
        assertEquals(new TaxBaseImportedStrategy().calculateTax(47.50), new Double(7.15));        
    }
}
