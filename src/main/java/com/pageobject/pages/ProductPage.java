package com.pageobject.pages;

import com.pageobject.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class ProductPage extends AbstractPage {

    @FindBy(xpath = ".//span[text() = 'Add to cart']")
    private WebElement addToCartButton;

    @FindBy(xpath = ".//a[@title = 'Proceed to checkout']")
    private WebElement proceedToCheckout;

    @FindBy(xpath = "//div[@class='breadcrumb clearfix']")
    private WebElement breadcrumbs;

    @FindBy(xpath = "//a[@name = 'Pink']")
    private WebElement pinkColor;

    @FindBy(xpath = "//select[@id = 'group_1']" )
    private WebElement sizeSelect;

    @FindBy(xpath = "//span[@title = 'Continue shopping']" )
    private WebElement continueShoppingButton;

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
    public void addToCart() {
        testClass.waitTillElementIsVisibleAndClick(addToCartButton);
    }

    /**
     * Click on the Proceed To Checkout Button
     *
     * @return CheckoutPage
     */
    public CheckoutPage proceedToCheckout() {
        testClass.waitTillElementIsVisibleAndClick(proceedToCheckout);
        return new CheckoutPage(testClass);
    }

    /**
     * @return breadcrumbs
     */
    public String getBreadcrumbs() {
        testClass.waitForPageIsLoad();
        return breadcrumbs.getText();
    }

    /**
     * Choose size of the product (S, M ,L)
     */
    public void chooseSize(String size){
        Select sizeDropDown = new Select(sizeSelect);
        switch (size){
            case "S":
                sizeDropDown.selectByValue("1");
                break;
            case "M":
                sizeDropDown.selectByValue("2");
                break;
            case "L":
                sizeDropDown.selectByValue("3");
                break;
        }
    }

    /**
     * Chose product with pink color
     */
    public void choosePinkColor(){
        pinkColor.click();
        testClass.waitForPageIsLoad();
    }

    /**
     * Click on the Continue shopping Button
     */
    public void continueShopping() {
        testClass.waitTillElementIsVisibleAndClick(continueShoppingButton);
    }

}
