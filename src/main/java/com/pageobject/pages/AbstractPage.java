package com.pageobject.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

abstract public class AbstractPage {

    // Instance of WebDriver
    private WebDriver driver;
    // Instance of Wait
    private WebDriverWait wait;


    @FindBy(xpath = ".//a[@title='My Store']")
    protected WebElement logo;
    //
    @FindBy(xpath = ".//a[@class='login']")
    private WebElement signInLink;

    @FindBy(xpath = ".//a[@class='logout']")
    private WebElement signOutLink;

    /**
     * Constructor
     *
     * @param driver
     */
    public AbstractPage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(logo));
    }

    /**
     * wait and click on signIn link
     * @return LoginPage
     */
    public LoginPage clickSignInLink(){
        wait.until(ExpectedConditions.elementToBeClickable(signInLink)).click();
        return new LoginPage(driver);
    }

    /**
     * wait and click on signOut link
     * @return LoginPage
     */
    public LoginPage clickSignOutLink(){
        wait.until(ExpectedConditions.elementToBeClickable(signOutLink)).click();
        return new LoginPage(driver);
    }

}
