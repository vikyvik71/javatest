/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.javalastminute.logic;

import com.example.javalastminute.domain.Product;
import com.example.javalastminute.domain.ProductType;

/**
 *
 * @author Vittorio
 */
public class StrategyFactory {
 
    public static TaxStrategy getRightStrategy(Product product) {
        
        TaxStrategy result = null;
        ProductType type = product.getType();        
        
        switch(type) {
            case FOOD:
            case MEDICAL:    
            case BOOK:
                result = product.isImported() ? new TaxExemptImportedStrategy() : new TaxExemptStrategy();
                break;
            case OTHER:
                result = product.isImported() ? new TaxBaseImportedStrategy() : new TaxBaseStrategy();
                break;
            default:
                break;
        }
        
        return result;
    }
}
