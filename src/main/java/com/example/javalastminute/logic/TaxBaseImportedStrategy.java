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
public class TaxBaseImportedStrategy extends TaxStrategy {

    @Override
    public Double calculateTax(Double price) {        
        return roundTax((price * 15.0)/100.0);
    }    
}
