/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.javalastminute.logic;

/**
 * Tax Exempt strategy, for products in the FOOD,
 * BOOK or MEDICAL category.
 * 
 * @author Vittorio
 */
public class TaxExemptStrategy implements TaxStrategy {
    
    @Override
    public double calculateTax(double price) {
        return 0.0;
    }   
}
