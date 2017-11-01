/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.javalastminute.logic;

/**
 *
 * @author Vittorio
 */
public class TaxExemptStrategy implements TaxStrategy {
    
    @Override
    public double calculateTax(double price) {
        return 0.0;
    }   
}
