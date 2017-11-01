package com.example.javalastminute.logic;

import com.example.javalastminute.domain.Product;
import com.example.javalastminute.domain.ProductType;

/**
 * Factory class for tax strategies. Strategy selection
 * is based on product type and imported status.
 * 
 * @author Vittorio
 */
public class TaxStrategyFactory {
 
    public static TaxStrategy getRightStrategy(Product product) {
        
        if(product == null) throw new IllegalArgumentException();
        
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