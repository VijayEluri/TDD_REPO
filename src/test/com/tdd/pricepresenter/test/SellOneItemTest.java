package com.tdd.pricepresenter.test;

import com.tdd.pricepresenter.*;
import org.junit.Before;
import org.junit.Test;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class SellOneItemTest {

    Sale sale;

    @Test
    public void priceFound() throws Exception {
        StringWriter canvas = new StringWriter();
        Sale sale = new Sale(canvas, new MapCatalog(new HashMap<String, Product>() {
            {
                put("456", new Product("456", 7.95, true));
                put("123", new Product("123",12.50, true));
            }
        }));

        sale.onBarcode("123");

        assertEquals("12.5", canvas.toString());
    }

    @Test
    public void anotherPriceFound() throws Exception {
        StringWriter canvas = new StringWriter();
        sale = new Sale(canvas, new MapCatalog(new HashMap<String, Product>() {
            {
                put("456", new Product("456",7.95, true));
                put("123", new Product("123",12.50, true));
            }
        }));

        sale.onBarcode("456");

        assertEquals("7.95", canvas.toString());
    }

    @Test
    public void priceNotFound() throws Exception {
        StringWriter canvas = new StringWriter();
        sale = new Sale(canvas, new MapCatalog(new HashMap<String, Product>() {
            {
                put("456", new Product("456",7.95, true));
                put("123", new Product("123",12.50, true));
            }
        }));

        sale.onBarcode("666");

        assertEquals("No price found for 666", canvas.toString());
    }

    @Test
    public void paymentAmountIncludeFederalTax(){

        List<Product> productList = new ArrayList<Product>(){
            {
                add(new Product("100", 100d, false));
            }
        };

        Receipt receipt = sale.pay(productList);

        assertEquals(105d, receipt.getTransactions().get(0).getAmountPayed(), 0.001);
    }

    @Test
    public void paymentAmountIncludeBothTax(){

        List<Product> productList =  new ArrayList<Product>(){
            {
                add(new Product("100", 100d, true));
            }
        };

        Receipt receipt = sale.pay(productList);

        assertEquals(113d, receipt.getTransactions().get(0).getAmountPayed(), 0.001);
    }


    @Test
    public void paymentForMoreThanOneTransaction(){
        List<Product> productList = new ArrayList<Product>(){
            {
                add(new Product("100",100d, true));
                add(new Product("200",200d, true));
            }
        };

        Receipt receipt = sale.pay(productList);
        assertEquals(2, receipt.getTransactions().size());
    }

    @Test
    public void calculateTotalAmountForProducts(){
        List<Product> products = new ArrayList<Product>(){
            {
                add(new Product("100",100d, true));
                add(new Product("200",20d, true));
            }
        };

        Receipt receipt = sale.pay(products);
        assertEquals(120d, receipt.getTotalAmount(), 0.001);
    }

    @Test
    public void calculateProvincialTaxFreeAmount(){
        List<Product> products = new ArrayList<Product>(){
            {
                add(new Product("100",100d, false));
                add(new Product("200",20d, true));
                add(new Product("300",20d, true));
            }
        };

        Receipt receipt = sale.pay(products);
        assertEquals(40d, receipt.getProvincialTaxFreeAmount(), 0.001);
    }

    @Test
    public void calculateProvincialTaxedAmount(){
        List<Product> products = new ArrayList<Product>(){
            {
                add(new Product("100",100d, false));
                add(new Product("200",20d, true));
                add(new Product("300",20d, true));
            }
        };

        Receipt receipt = sale.pay(products);
        assertEquals(100d, receipt.getTotalAmount()-receipt.getProvincialTaxFreeAmount(), 0.001);
    }

    //create test for displaying the receipt
    @Test
    public void printReceipt(){
        StringWriter canvas = new StringWriter();
        sale = new Sale(canvas, new MapCatalog(new HashMap<String, Product>()));

        Receipt receipt = new Receipt(new ArrayList<Transaction>(){
            {
                add(new Transaction(110d, true));
                add(new Transaction(100d, false));
                add(new Transaction(10d, false));
            }
            }, 220d, 110d);
        sale.printReceipt(receipt);
        //assertEquals("110 GP 100 G 10G", canvas.toString());

        }



    @Before
    public void setup() {
        Display display = new PrintWriterDisplay(new PrintWriter(new StringWriter()));
        TaxCalculator taxCalculator = new TaxCalculatorImpl();
        Transaction.Payment payment = new Transaction.Payment(taxCalculator);
        sale = new Sale(display, payment, new MapCatalog(new HashMap<String, Product>() {
            {
                put("100", new Product("100", 100d, true));
            }
        }));
    }
}
