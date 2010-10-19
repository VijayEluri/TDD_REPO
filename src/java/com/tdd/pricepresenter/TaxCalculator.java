package com.tdd.pricepresenter;

/**
 * Created by IntelliJ IDEA.
 * User: miha
 * Date: Oct 18, 2010
 * Time: 11:44:31 PM
 * To change this template use File | Settings | File Templates.
 */
public interface TaxCalculator {

    double calculate(double price, boolean isProvincial);
}
