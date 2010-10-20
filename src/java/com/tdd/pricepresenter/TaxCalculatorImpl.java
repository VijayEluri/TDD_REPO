package com.tdd.pricepresenter;

/**
 * Created by IntelliJ IDEA.
 * User: miha
 * Date: Oct 19, 2010
 * Time: 4:50:36 PM
 * To change this template use File | Settings | File Templates.
 */
public class TaxCalculatorImpl implements TaxCalculator {


    public double calculate(double price, boolean isProvincial) {

        double finalTax = 5d/100;

        if(isProvincial){
            finalTax = finalTax + 8d/100;
        }
        return price*finalTax;
    }
}
