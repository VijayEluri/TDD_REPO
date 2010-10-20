package com.tdd.pricepresenter;

/**
 * Created by IntelliJ IDEA.
 * User: miha
 * Date: Oct 19, 2010
 * Time: 10:27:56 PM
 * To change this template use File | Settings | File Templates.
 */
public interface Catalog {

    public boolean hasBarcode(String barcode);

    public double lookupPrice(String barcode);

}
