package com.pageobject.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends AbstractPage{

    // Instances of WebDriver and WebDriverWait
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(id = "email")
    private WebElement emailField;

    @FindBy(id = "passwd")
    private WebElement passwordField;

    @FindBy(id = "SubmitLogin")
    public WebElement signInButton;

    /**
     * Constructor
     *
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        PageFactory.initElements(driver, this);
        wait.until(ExpectedConditions.visibilityOf(logo));
    }

    /**
     * Login
     * @return MyAccountPage
     */
    public MyAccountPage login(){
        wait.until(ExpectedConditions.visibilityOf(emailField)).sendKeys("mariia.dibrivnaia@gmail.com");
        wait.until((ExpectedConditions.visibilityOf(passwordField))).sendKeys("123qwe");
        wait.until(ExpectedConditions.elementToBeClickable(signInButton)).click();
        return new MyAccountPage(driver);
    }


}
