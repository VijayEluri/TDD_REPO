package com.tdd.pricepresenter;

/**
 * Created by IntelliJ IDEA.
 * User: miha
 * Date: Oct 18, 2010
 * Time: 10:30:30 PM
 * To change this template use File | Settings | File Templates.
 */
public interface ProductRepository {
    double getPrice(String productCode) throws InvalidBarcodeException;
    boolean isProvincial(String productCode);

}
