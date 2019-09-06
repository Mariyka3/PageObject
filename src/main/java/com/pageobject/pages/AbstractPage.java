package com.pageobject.pages;

import com.pageobject.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


abstract public class AbstractPage {

    // Instances of BaseTest
    protected BaseTest testClass;

    @FindBy(xpath = ".//a[@title='My Store']")
    protected WebElement logo;

    @FindBy(xpath = ".//a[@class='login']")
    private WebElement signInLink;

    @FindBy(xpath = ".//a[@class='logout']")
    private WebElement signOutLink;

    /**
     * Constructor
     *
     * @param
     */
    public AbstractPage(BaseTest testClass) {
        this.testClass = testClass;
        PageFactory.initElements(testClass.getDriver(), this);
        testClass.waitTillElementIsVisible(logo);
    }

    /**
     * wait and click on signIn link
     * @return LoginPage
     */
    public LoginPage clickSignInLink(){
        testClass.waitTillElementIsVisible(signInLink);
        signInLink.click();
        return new LoginPage(testClass);
    }

    /**
     * wait and click on signOut link
     * @return LoginPage
     */
    public LoginPage clickSignOutLink(){
        testClass.waitTillElementIsVisible(signOutLink);
        signOutLink.click();
        return new LoginPage(testClass);
    }

}
