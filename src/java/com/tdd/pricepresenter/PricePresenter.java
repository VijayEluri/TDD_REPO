package com.tdd.pricepresenter;

/**
 * Created by IntelliJ IDEA.
 * User: miha
 * Date: Oct 18, 2010
 * Time: 9:24:51 PM
 * To change this template use File | Settings | File Templates.
 */
public class PricePresenter {
    private  PriceDisplay priceDisplay;
    private  ProductRepository productRepository;
    private  TaxCalculator taxCalculator;
    private static final double federalTaxPercent = 5;

    public PricePresenter(PriceDisplay priceDisplay, ProductRepository productRepository, TaxCalculator taxCalculator){
        this.productRepository = productRepository;
        this.priceDisplay = priceDisplay;
        this.taxCalculator = taxCalculator;
    }

    public void onScan(String barcode)
    {
        try
        {
            double price = productRepository.getPrice(barcode);

            boolean isProvincialTaxNeeded = productRepository.isProvincial(barcode);
            double finalPrice = taxCalculator.calculate(price, isProvincialTaxNeeded); 

            priceDisplay.showPrice(finalPrice);
        }
        catch (InvalidBarcodeException e)
        {
            priceDisplay.showError();
        }
    }
}
