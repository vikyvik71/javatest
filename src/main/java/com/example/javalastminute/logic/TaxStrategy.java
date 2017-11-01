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