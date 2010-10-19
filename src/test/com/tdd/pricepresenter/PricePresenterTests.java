package com.tdd.pricepresenter;

import org.junit.Before;
import org.junit.Test;
import org.mockito.internal.verification.Times;

import static org.mockito.Matchers.anyBoolean;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;
import static org.mockito.Mockito.verify;
import static org.mockito.internal.verification.VerificationModeFactory.times;

/**
 * Created by IntelliJ IDEA.
 * User: miha
 * Date: Oct 18, 2010
 * Time: 9:44:38 PM
 * To change this template use File | Settings | File Templates.
 */
public class PricePresenterTests {

    private PriceDisplay priceDisplayMock = mock(PriceDisplay.class);
    private ProductRepository repoStub = mock(ProductRepository.class);
    private TaxCalculator taxCalculator = mock(TaxCalculator.class);


    @Test
    public void PriceDisplayedTest()
    {
        stub(repoStub.getPrice("123")).toReturn(100d);
        stub(taxCalculator.calculate(eq(100d), anyBoolean())).toReturn(100d);
        PricePresenter pos = createNewPricePresenter();

        pos.onScan("123");

        verify(priceDisplayMock, times(1)).showPrice(100d);
    }

    @Test
    public void InvalidBarcodeTest() {

        stub(repoStub.getPrice("12344")).toThrow(new InvalidBarcodeException());

        PricePresenter presenter = createNewPricePresenter();

        presenter.onScan("12344");

        verify(priceDisplayMock, times(1)).showError();
    }

    @Test
    public void PriceWithFederalTaxDisplayedTest()
    {
        stub(repoStub.getPrice("12345")).toReturn(100d);
        stub(repoStub.isProvincial("12345")).toReturn(false);
        stub(taxCalculator.calculate(100d, false)).toReturn(105d);

        PricePresenter pos = createNewPricePresenter();

        pos.onScan("12345");

        verify(priceDisplayMock, times(1)).showPrice(105d);
    }

    @Test
    public void WhenScanned_ProvincialAndFederalTaxDisplayed()
    {
        stub(repoStub.getPrice("90")).toReturn(100d);
        stub(repoStub.isProvincial("90")).toReturn(true);
        stub(taxCalculator.calculate(100d, true)).toReturn(113d);

        PricePresenter pos = createNewPricePresenter();

        pos.onScan("90");

        verify(priceDisplayMock,times(1)).showPrice(113d);
    }

    private PricePresenter createNewPricePresenter()
    {
        return new PricePresenter(priceDisplayMock, repoStub, taxCalculator);
    }

}

