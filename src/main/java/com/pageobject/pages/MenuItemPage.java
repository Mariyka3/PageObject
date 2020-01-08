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

    /**
     * Open product page
     * @return ProductPage
     */
    public ProductPage clickOnProduct(){
        testClass.click(productLink);
        return new ProductPage(testClass);
    }

    /**
     * Open product page in new tab
     * @return ProductPage
     */
    public ProductPage openProductInNewTab(){
        testClass.waitTillElementIsVisible(productLink);
        testClass.openInNewTab(productLink);
        return new ProductPage(testClass);
    }


}
