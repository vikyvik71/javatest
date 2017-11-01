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
public abstract class TaxStrategy {
    public abstract Double calculateTax(Double price);
    public Double roundTax(Double tax) {
        double realValue = tax * 20.0;
        long rounded = Math.round(realValue);        
        return rounded / 20.0;
    }
}
