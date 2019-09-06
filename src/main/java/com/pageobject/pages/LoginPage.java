package com.pageobject.pages;

import com.pageobject.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends AbstractPage{

    @FindBy(xpath = ".//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@id='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = ".//button[@id ='SubmitLogin']")
    public WebElement signInButton;

    /**
     * Constructor
     *
     * @param
     */
    public LoginPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(logo);
    }

    /**
     * Login
     * @return MyAccountPage
     */
    public MyAccountPage login(){
        testClass.waitTillElementIsVisible(emailField);
        emailField.sendKeys("mariia.dibrivnaia@gmail.com");
        testClass.waitTillElementIsVisible(passwordField);
        passwordField.sendKeys("123qwe");
        testClass.waitTillElementIsVisible(signInButton);
        signInButton.click();
        return new MyAccountPage(testClass);
    }

    /**
     * verify SignIn button is displayed on the page
     */
    public void verifySignBtnIsDisplayed(){
        Assert.assertTrue(signInButton.isDisplayed());
    }


}
