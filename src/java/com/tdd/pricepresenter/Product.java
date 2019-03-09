package com.tdd.pricepresenter;

/**
 * Created by IntelliJ IDEA.
 * User: miha
 * Date: Oct 18, 2010
 * Time: 10:35:00 PM
 * To change this template use File | Settings | File Templates.
 */
public class Product {

    private String code;

    private double price;

    private String description;

    private  boolean isTaxApplied;

    public Product(String code, double price, boolean isTaxApplied) {
        this.code = code;
        this.price = price;
        this.isTaxApplied = isTaxApplied;
    }


    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isTaxApplied() {
        return isTaxApplied;
    }

    public void setTaxApplied(boolean taxApplied) {
        this.isTaxApplied = taxApplied;
    }

    private void methodNotInBranch(){}
}
