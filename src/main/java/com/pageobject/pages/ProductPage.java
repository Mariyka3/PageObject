package com.pageobject.pages;

import com.pageobject.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.xml.xpath.XPath;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = ".//span[text() = 'Add to cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = ".//a[@title = 'Proceed to checkout']")
    private WebElement proceedToCheckout;

    /**
     * Constructor
     *
     * @param
     */
    ProductPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(logo);
    }

    /**
     * Click on the Add to cart button
     */
    public void addToCart(){
        testClass.waitTillElementIsVisible(addToCartButton);
        addToCartButton.click();
    }

    /**
     * Click on the Proceed To Checkout Button
     * @return CheckoutPage
     */
    public CheckoutPage proceedToCheckout(){
        testClass.waitTillElementIsVisible(proceedToCheckout);
        proceedToCheckout.click();
        return new CheckoutPage(testClass);
    }


}
