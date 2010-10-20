package com.tdd.pricepresenter;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: miha
 * Date: Oct 19, 2010
 * Time: 6:53:12 PM
 * To change this template use File | Settings | File Templates.
 */
public class Receipt {

public List<Transaction> transactions;
    private double totalAmount;
    private double provincialTaxFreeAmount;

    public Receipt(List<Transaction> transactions, double totalAmount, double provincialTaxFreeAmount) {
        this.transactions = transactions;
        this.totalAmount = totalAmount;
        this.provincialTaxFreeAmount = provincialTaxFreeAmount;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    

    public void setProvincialTaxFreeAmount(double provincialTaxFreeAmount) {
        this.provincialTaxFreeAmount = provincialTaxFreeAmount;
    }

    public double getProvincialTaxFreeAmount() {
        return provincialTaxFreeAmount;
    }
}