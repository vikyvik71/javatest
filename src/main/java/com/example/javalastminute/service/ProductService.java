package com.example.javalastminute.service;

import com.example.javalastminute.domain.Product;

/**
 *
 * @author Vittorio
 */
public interface ProductService {
    public Product processItem(String item);
    public String outputItem(Product product);    
}
