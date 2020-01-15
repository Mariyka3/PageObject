package com.pageobject.pages;

import com.pageobject.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CategoriesPage extends AbstractPage {

    @FindBy (xpath = ".//div[@class = 'subcategory-image']/a[@title = 'Summer Dresses']")
    private WebElement summerDressesLink;

    @FindBy (xpath = ".//div[@class = 'product-container']")
    private WebElement productLink;

    @FindBy(xpath = ".//span[@class = 'heading-counter']")
    private WebElement counter;

    @FindBy(xpath = ".//li[contains(@class, 'ajax_block_product')]")
    private List<WebElement> products;

    @FindBy(xpath = ".//input[@id = 'layered_id_attribute_group_8']")
    private WebElement whiteColor;


    /**
     * Constructor
     *
     * @param testClass
     */
    CategoriesPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(logo);
    }

    /**
     * Click on the Summer Dresses link
     */
    public void clickSummerDressesLink(){
        testClass.waitTillElementIsVisibleAndClick(summerDressesLink);
    }

    /**
     * Open product page
     * @return ProductPage
     */
    public ProductPage clickOnProduct(){
        testClass.waitTillElementIsVisibleAndClick(productLink);
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

    /**
     * Compare the specified quantity on the page with actual products quantity
     */
    public void verifyProductsQuantity(){
        int count = Integer.parseInt(counter.getText().replaceAll("\\D+",""));
        Assert.assertEquals( products.size(), count);
    }

}
