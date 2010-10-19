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

    private boolean isProvincial;

    


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

    public boolean isProvincial() {
        return isProvincial;
    }

    public void setProvincial(boolean provincial) {
        isProvincial = provincial;
    }
}
