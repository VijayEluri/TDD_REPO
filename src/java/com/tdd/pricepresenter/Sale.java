package com.tdd.pricepresenter;

import java.io.PrintWriter;
import java.io.Writer;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: miha
 * Date: Oct 20, 2010
 * Time: 9:31:09 AM
 * To change this template use File | Settings | File Templates.
 */
public class Sale {
    private final PrintWriter canvas;
        private final Catalog catalog;
        private final Display display;
        private final Transaction.Payment payment;

        public Sale(Writer canvas, Catalog catalog) {
            this.canvas = new PrintWriter(canvas, true);
            this.catalog = catalog;
            this.display = new PrintWriterDisplay(this.canvas);
            this.payment = null;//todo Watch out!
        }

        public Sale(Display display, Transaction.Payment payment, Catalog catalog) {
            this.display = display;
            this.catalog = catalog;
            this.canvas = null; //todo Watch out!
            this.payment = payment;
        }


        public void onBarcode(String barcode) {
            if (catalog.hasBarcode(barcode)) {
                display.print(PrintWriterDisplay.PriceFormatter.formatPrice(catalog.lookupPrice(barcode)));
            } else
                display.printPriceNotFoundMessage(barcode);
        }


        public Receipt pay(List<Product> productList){

            return payment.pay(productList);
        }

        public void printReceipt(Receipt receipt) {
            //display.printReceipt(receipt);
        }
}
