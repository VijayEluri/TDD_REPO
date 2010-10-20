package com.tdd.pricepresenter;


public interface Display {

    void printPriceNotFoundMessage(String barcode);

	void print(String priceAsText);

}
