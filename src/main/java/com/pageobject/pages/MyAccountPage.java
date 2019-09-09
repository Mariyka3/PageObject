package com.pageobject.pages;

import com.pageobject.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class MyAccountPage extends AbstractPage{

    public String name = "Mary Dibr";

    @FindBy(xpath = ".//a[@class='account']/span")
    private WebElement accountNameLink;

    @FindBy(xpath = ".//ul[contains(@class,'submenu-container')]/preceding-sibling::a[text()='Dresses']")
    private WebElement dressesButton;

    /**
     * Constructor /a[text()='Dresses']   .//ul[contains(Class,'menu-content')]
     *
     * @param
     */
    public MyAccountPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(logo);
    }

    /**
     * Wait and get text of user
     * @return username
     */
    public String returnName(){
        testClass.waitTillElementIsVisible(accountNameLink);
        return accountNameLink.getText();
    }

    public void verifyName() {
        Assert.assertEquals(name, returnName());
    }

    /**
     * Click on the dresses menu
     * @return DressesPage
     */
    public DressesPage clickDressesItem(){
        testClass.waitTillElementIsVisible(dressesButton);
        dressesButton.click();
        return new DressesPage(testClass);
    }
}
