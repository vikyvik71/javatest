/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.javalastminute.app;

import com.example.javalastminute.domain.Product;
import com.example.javalastminute.domain.ProductType;
import com.example.javalastminute.logic.TaxStrategyFactory;
import com.example.javalastminute.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Vittorio
 */
public class Main {
    
    private final Map<String, ProductType> typeMapper = new HashMap<>();
    private final Map<String, List<String>> input = new HashMap<>();

    public Main() {
        
        List<String> input1 = new ArrayList<>();
        input1.add("1 book at 12.49");
        input1.add("1 music CD at 14.99");
        input1.add("1 chocolate bar at 0.85");
                
        List<String> input2 = new ArrayList<>();
        input2.add("1 imported box of chocolates at 10.00");
        input2.add("1 imported bottle of perfume at 47.50");
                
        List<String> input3 = new ArrayList<>();
        input3.add("1 imported bottle of perfume at 27.99");
        input3.add("1 bottle of perfume at 18.99");
        input3.add("1 packet of headache pills at 9.75");
        input3.add("1 box of imported chocolates at 11.25");
        
        input.put("Input 1", input1);
        input.put("Input 2", input2);
        input.put("Input 3", input3);
        
        typeMapper.put("book", ProductType.BOOK);
        typeMapper.put("music CD", ProductType.OTHER);
        typeMapper.put("chocolate bar", ProductType.FOOD);
        typeMapper.put("box of chocolates", ProductType.FOOD);
        typeMapper.put("bottle of perfume", ProductType.OTHER);        
        typeMapper.put("packet of headache pills", ProductType.MEDICAL);        
    }
    
    

    public static void main(String[] args) {   
        Main app = new Main();
        Map<String, List<Product>> result = app.parseInput();
        app.generateOutput(result);         
    }
    
    public Map<String, List<Product>> parseInput() {    
        
        Map<String, List<Product>> result = new HashMap<>();
        String regex = "(\\d+)\\s([\\w\\s]+)\\sat\\s(\\d+(\\.\\d+)?)";
                
        Pattern pattern = Pattern.compile(regex);        
        Matcher matcher = null;
               
        for (String block : input.keySet()) {
            String newBlock = block.replaceAll("Input", "Output");
            
            List<Product> products = new ArrayList<>();
            
            for (String item : input.get(block)) {
                matcher = pattern.matcher(item);
                
                if (matcher.matches()) {           
            
                    Integer quantity = Integer.parseInt(matcher.group(1));                    
                    String name = matcher.group(2);    
                    double price = Double.parseDouble(matcher.group(3));   
                    
                    boolean imported = false;                    
                    if(item.contains("imported")) {
                        imported = true;
                        name = name.replaceAll("\\s?imported\\s+", " ").trim();
                    }   
                    
                    Product product = new Product(name, price, quantity, imported, typeMapper.get(name));
                    product.setStrategy(TaxStrategyFactory.getRightStrategy(product));
                    
                    products.add(product);            
                }
                
            }              
            result.put(newBlock, products);
        }
        
        return result;
    }
    
    public void generateOutput(Map<String, List<Product>> result) {
        
        SortedSet<String> keys = new TreeSet<>(result.keySet());
        for (String block : keys) { 
            System.out.println(block);
            List<Product> products = result.get(block);
            
            double taxTotal = 0.0;
            double priceTotal = 0.0;
                        
            for (Product product : products) {
                String imported = product.isImported() ? " imported " : "";
                taxTotal += (product.getTaxedPrice() - product.getPrice());
                priceTotal += product.getTaxedPrice();
                System.out.printf("%d%s %s: %.2f%n", product.getQuantity(), imported, product.getName(), product.getTaxedPrice());
            }
            System.out.printf("%s: %.2f%n", "Sales Taxes", Utils.round(taxTotal, 2));
            System.out.printf("%s: %.2f%n", "Total", Utils.round(priceTotal, 2));
            System.out.println("");
        }
    }   
}
