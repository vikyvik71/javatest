package com.example.javalastminute.utils;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author Vittorio
 */
public class Utils {
    
    public static double round(double value, int places) {
        if (places < 0) throw new IllegalArgumentException();

        BigDecimal bd = new BigDecimal(value);
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }
    
    public static double roundTax(double tax) {
        double reminder = tax % .05;
        if(reminder != 0.0) {
            double addendum = .05 - reminder;
            tax += addendum;
        }
                
        return Utils.round(tax, 2);
    }
}
