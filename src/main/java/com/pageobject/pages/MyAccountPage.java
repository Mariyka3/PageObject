package com.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends AbstractPage{

    private WebDriver driver;
    private WebDriverWait wait;
    public String name = "Mary Dibr";

    @FindBy(xpath = ".//a[@class='account']/span")
    private WebElement accountNameLink;

    /**
     * Constructor
     *
     * @param driver
     */
    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(logo));
    }

    /**
     * Wait and get text of user
     * @return username
     */
    public String returnName(){
        return wait.until(ExpectedConditions.visibilityOf(accountNameLink)).getText();
    }

}
