package com.tdd.pricepresenter;

import java.io.PrintWriter;

/**
 * Created by IntelliJ IDEA.
 * User: miha
 * Date: Oct 19, 2010
 * Time: 7:36:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class PrintWriterDisplay implements Display {

    private final PrintWriter canvas;
    

    public PrintWriterDisplay(PrintWriter canvas) {
        this.canvas = canvas;
    }

    public void print(String data)  {
		canvas.print(data);
	}                

    public void printPriceNotFoundMessage(String barcode)  {
		canvas.print("No price found for " + barcode);
	}


    public static class PriceFormatter{
        public static String formatPrice(double price){
            return Double.toString(price);
        }
    }
}
