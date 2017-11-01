package com.example.javalastminute.service;

import com.example.javalastminute.domain.Product;
import com.example.javalastminute.domain.ProductType;
import com.example.javalastminute.logic.TaxStrategyFactory;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Main service implementation, gives clients a 2-direction
 * mapping from an input line to a product and from a product
 * to an output line with updated values and required formatting.
 * 
 * @author Vittorio
 */
public class ProductServiceImpl implements ProductService {

    private final String INPUT_REGEX = "(\\d+)\\s([\\w\\s]+)\\sat\\s(\\d+(\\.\\d+)?)";
    private final String IMPORTED_REGEX = "\\s?imported\\s+";
    private final Map<String, ProductType> typeMapper = new HashMap<>();
    private final String BOOK = "book";
    private final String MUSIC_CD = "music CD";
    private final String CHOCO_BAR = "chocolate bar";
    private final String CHOCO_BOX = "box of chocolates";
    private final String PERFUME_BOTTLE = "bottle of perfume";
    private final String PILLS_PACK = "packet of headache pills";
    private final String IMPORTED = "imported";

    public ProductServiceImpl() {
        typeMapper.put(BOOK, ProductType.BOOK);
        typeMapper.put(MUSIC_CD, ProductType.OTHER);
        typeMapper.put(CHOCO_BAR, ProductType.FOOD);
        typeMapper.put(CHOCO_BOX, ProductType.FOOD);
        typeMapper.put(PERFUME_BOTTLE, ProductType.OTHER);
        typeMapper.put(PILLS_PACK, ProductType.MEDICAL);
    }

    @Override
    public Product processItem(String item) {

        if(item == null) throw new IllegalArgumentException();
                
        Pattern pattern = Pattern.compile(INPUT_REGEX);
        Matcher matcher = pattern.matcher(item);

        Product product = null;

        if (matcher.matches()) {

            Integer quantity = Integer.parseInt(matcher.group(1));
            String name = matcher.group(2);
            double price = Double.parseDouble(matcher.group(3));

            boolean imported = false;
            if (item.contains(IMPORTED)) {
                imported = true;
                name = name.replaceAll(IMPORTED_REGEX, " ").trim();
            }

            product = new Product(name, price, quantity, imported, typeMapper.get(name));
            product.setStrategy(TaxStrategyFactory.getRightStrategy(product));
        }

        return product;
    }

    @Override
    public String outputItem(Product product) {
        
        if(product == null) throw new IllegalArgumentException();
        
        double taxedPrice = product.getTaxedPrice();

        String name = product.getName();
        int quantity = product.getQuantity();

        String imported = product.isImported() ? " imported" : "";

        // Format to use dot as separator for decimals
        String taxedPriceStr = String.format(Locale.ROOT, "%.2f", taxedPrice);

        String result = String.format("%d%s %s: %s%n", quantity, imported, name, taxedPriceStr);
        
        return result.trim();
    }
}