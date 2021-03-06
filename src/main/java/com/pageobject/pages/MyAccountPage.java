package com.pageobject.pages;

import com.pageobject.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends AbstractPage{

    private String NAME = "Mary Dibr";

    @FindBy(xpath = ".//a[@class='account']/span")
    private WebElement accountNameLink;

    @FindBy(xpath = ".//ul[contains(@class,'submenu-container')]/preceding-sibling::a[text()='Dresses']")
    private WebElement dressesButton;

    @FindBy(xpath = "//*[@id='block_top_menu']/ul/li[3]/a")
    private WebElement tShirtsButton;


    /**
     * Constructor
     *
     * @param
     */
    MyAccountPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(logo);
    }

    /**
     * Wait and get text of user
     * @return username
     */
    private String returnName(){
        testClass.waitTillElementIsVisible(accountNameLink);
        return accountNameLink.getText();
    }

    /**
     * Verify name
     */
    public void verifyName() {
        Assert.assertEquals(NAME, returnName());
    }

    /**
     * Click on the dresses menu
     * @return CategoriesPage
     */
    public CategoriesPage clickDressesItem(){
        testClass.waitTillElementIsVisible(dressesButton);
        dressesButton.click();
        return new CategoriesPage(testClass);
    }

    /**
     * Click on the T-Shirts menu
     */
    public CategoriesPage clickTShirtsItem(){
        testClass.waitTillElementIsVisible(tShirtsButton);
        tShirtsButton.click();
        return new CategoriesPage(testClass);
    }


}
