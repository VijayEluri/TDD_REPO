package com.tdd.pricepresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: miha
 * Date: Oct 18, 2010
 * Time: 10:41:25 PM
 * To change this template use File | Settings | File Templates.
 */
public class ProductRepositoryImpl implements ProductRepository {

    private Map<String, Product> productStore = new HashMap<String, Product>();

    public double getPrice(String productCode) throws InvalidBarcodeException {
        return productStore.get(productCode).getPrice();
    }

    public boolean isProvincial(String productCode) {
        return productStore.get(productCode).isProvincial();
    }
}
