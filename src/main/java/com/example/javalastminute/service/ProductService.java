package com.example.javalastminute.service;

import com.example.javalastminute.domain.Product;

/**
 * Service contract.
 * Process item, map input line to a Product
 * Output item, map a Product to an output line
 * 
 * @author Vittorio
 */
public interface ProductService {
    public Product processItem(String item);
    public String outputItem(Product product);    
}
