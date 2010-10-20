package com.tdd.pricepresenter;

import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;

public class Driver {
	public static void main(String[] args) throws Exception {
		OutputStreamWriter canvas = new OutputStreamWriter(System.out);
		Sale sale = new Sale(new PrintWriterDisplay(new PrintWriter(canvas, true)),
                new Transaction.Payment(new TaxCalculatorImpl()),
                new MapCatalog(new HashMap<String, Product>() {
                    {
                        put("456", new Product("456",7.95, true));
                        put("123", new Product("123",12.50, true));
                    }
                }));
		sale.onBarcode("123");
		sale.onBarcode("456");
		sale.onBarcode("ksdjfhgla");
		canvas.flush();


        sale.pay(new ArrayList<Product>(){
            {
                new Product("456",7.95, true);
                new Product("123",12.50, true);
            }
        });
	}

}
