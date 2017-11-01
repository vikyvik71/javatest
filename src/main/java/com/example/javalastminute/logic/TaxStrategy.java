/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.javalastminute.logic;

/**
 * Main interface for the tax strategy to be choosen at runtime through 
 * TaxStrategyFactory.
 * 
 * @author Vittorio
 */
public interface TaxStrategy {
    public double calculateTax(double price);    
}
