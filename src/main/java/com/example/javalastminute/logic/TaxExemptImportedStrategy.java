/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.javalastminute.logic;

import com.example.javalastminute.utils.Utils;

/**
 *
 * @author Vittorio
 */
public class TaxExemptImportedStrategy implements TaxStrategy {

    @Override
    public double calculateTax(double price) {
        return Utils.roundTax((price * 5.0)/100.0);
    }
    
}
