package com.pageobject.pages;

import com.pageobject.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MenuItemPage extends AbstractPage {

    @FindBy (xpath = ".//div[@class = 'subcategory-image']/a[@title = 'Summer Dresses']")
    private WebElement summerDressesLink;

    @FindBy (xpath = ".//div[@class = 'product-container']")
    private WebElement productLink;


    /**
     * Constructor
     *
     * @param testClass
     */
    public MenuItemPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(logo);
    }

    /**
     * Click on the Summer Dresses link
     * @return SummerDressesPage
     */
    public SummerDressesPage clickSummerDressesLink(){
        testClass.waitTillElementIsVisible(summerDressesLink);
        summerDressesLink.click();
        return new SummerDressesPage(testClass);
    }

    public ProductPage clickOnProduct(){
        testClass.waitTillElementIsVisible(productLink);
        productLink.click();
        return new ProductPage(testClass);
    }
}
