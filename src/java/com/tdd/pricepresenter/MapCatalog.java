package com.tdd.pricepresenter;

import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: miha
 * Date: Oct 19, 2010
 * Time: 10:29:53 PM
 * To change this template use File | Settings | File Templates.
 */
public class MapCatalog implements Catalog {
    private Map<String, Product> productsByBarcode;

    public MapCatalog(Map<String, Product> pricesByBarcode) {
        this.productsByBarcode = pricesByBarcode;
    }

    public boolean hasBarcode(String barcode) {
        return productsByBarcode.containsKey(barcode);
    }

    public double lookupPrice(String barcode) {
        return productsByBarcode.get(barcode).getPrice();
    }
    public void ihaveanothermethod(){
        System.out.println("sdwoiueyfw");
    }

}
