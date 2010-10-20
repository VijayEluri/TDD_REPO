package com.tdd.pricepresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: miha
 * Date: Oct 19, 2010
 * Time: 6:57:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Transaction {

        private double amountPayed;

        private boolean isTaxApplied;

    public Transaction(double finalPrice, boolean istTaxApplied) {
        this.amountPayed = finalPrice;
        this.isTaxApplied = istTaxApplied;
    }

    public double getAmountPayed(){
            return amountPayed;
        }

        public void setAmountPayed(double amountPayed) {
            this.amountPayed = amountPayed;
        }


        public boolean isTaxApplied() {
            return isTaxApplied;
        }

        public void setTaxApplied(boolean taxApplied) {
            this.isTaxApplied = taxApplied;
        }

    public static class Payment {

        final TaxCalculator taxCalculator;

        public Payment(TaxCalculator taxCalculator) {
            this.taxCalculator = taxCalculator;
        }

        Transaction payProduct(Product product) {

            double finalPrice = product.getPrice() + taxCalculator.calculate(product.getPrice(), product.isTaxApplied());
            return new Transaction(finalPrice, product.isTaxApplied());
        }

        public Receipt pay(List<Product> productList) {

            List<Transaction> transactions = new ArrayList<Transaction>();

            double totalAmount = 0;
            double provincialTaxFreeAmount = 0;

            for (Product product : productList) {
                transactions.add(payProduct(product));
                totalAmount += product.getPrice();
                if (product.isTaxApplied())
                    provincialTaxFreeAmount += product.getPrice();
            }

            return new Receipt(transactions, totalAmount, provincialTaxFreeAmount);
        }
    }
}
