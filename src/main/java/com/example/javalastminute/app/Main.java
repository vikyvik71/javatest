package com.example.javalastminute.app;

import com.example.javalastminute.domain.Product;
import com.example.javalastminute.service.ProductService;
import com.example.javalastminute.service.ProductServiceImpl;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

/**
 * Main app. Client invoking service methods which in turn rely
 * on application logic through tax strategy building for specific
 * scenarios (type of product, imported/national product)
 * 
 * @author Vittorio
 */
public class Main {
        
    private final Map<String, List<String>> input = new HashMap<>();
    private final ProductService service;
    private final String INPUT_HEADER = "Input";
    private final String OUTPUT_HEADER = "Output";
        
    public Main() {
        // Setup input data and init service
       Main.setupInputData(input);
       service = new ProductServiceImpl();
    }

    public static void main(String[] args) {   
        // Create new client, parse input and generate output
        // through result
        Main app = new Main();
        Map<String, List<Product>> result = app.parseInput();
        app.generateOutput(result);                 
    }
    
    // Method for parsing input structures. Returns map
    // with each output as key.
    public Map<String, List<Product>> parseInput() {    
        
        Map<String, List<Product>> result = new HashMap<>();
        
        // Iterate over input blocks
        for (String block : input.keySet()) {
            
            // Modify name for output structures
            String newBlock = block.replaceAll(INPUT_HEADER, OUTPUT_HEADER);            
            List<Product> products = new ArrayList<>();
            
            // Iterate on single input lines and map the line
            // to a product through the service.
            for (String item : input.get(block)) {
                Product product = service.processItem(item);             
                // Add to returned structures
                products.add(product);
            }              
            
            // New block of output
            result.put(newBlock, products);
        }
        
        return result;
    }

    // Method to print out the output. Relies on product service
    // to map the product to the output string.
    public void generateOutput(Map<String, List<Product>> result) {
        
        // Get the output blocks sorted by name
        SortedSet<String> keys = new TreeSet<>(result.keySet());
        
        for (String block : keys) { 
            // Output n
            System.out.println(block);
            List<Product> products = result.get(block);
            
            double taxTotal = 0.0;
            double priceTotal = 0.0;
                        
            for (Product product : products) {
                // Get the output string for product
                String item = service.outputItem(product);   
                System.out.println(item);
                
                double price = product.getPrice();
                double taxedPrice = product.getTaxedPrice();
                
                // Update tax and price totals for this output
                taxTotal += (taxedPrice - price);                
                priceTotal += taxedPrice;
            }
            
            // Format to use dot as separator for decimals
            String taxTotalStr = String.format(Locale.ROOT, "%.2f", taxTotal);
            String priceTotalStr = String.format(Locale.ROOT, "%.2f", priceTotal);
            
            System.out.printf("%s: %s%n", "Sales Taxes", taxTotalStr);
            System.out.printf("%s: %s%n", "Total", priceTotalStr);
            System.out.println("");            
        }
    }
    
    // Utility method for setting up input data structures.    
    public static void setupInputData(Map<String, List<String>> input) {
        
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
    }
}