package com.pageobject.pages;

import com.pageobject.base.BaseTest;
import com.pageobject.utils.YamlParser;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class LoginPage extends AbstractPage{

    @FindBy(xpath = ".//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@id='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = ".//button[@id ='SubmitLogin']")
    private WebElement signInButton;

    /**
     * Constructor
     *
     * @param
     */
    LoginPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(logo);
    }

    /**
     * Login
     * @return MyAccountPage
     */
    public MyAccountPage login(){
        testClass.waitTillElementIsVisible(emailField);
        emailField.sendKeys(YamlParser.getYamlData().getEmail());
        testClass.waitTillElementIsVisible(passwordField);
        passwordField.sendKeys(YamlParser.getYamlData().getPassword());
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
