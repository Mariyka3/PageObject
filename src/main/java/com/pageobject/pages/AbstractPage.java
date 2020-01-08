package com.pageobject.pages;

import com.pageobject.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;


abstract public class AbstractPage {

    // Instances of BaseTest
    protected BaseTest testClass;

    @FindBy(xpath = ".//a[@title='My Store']")
    protected WebElement logo;

    @FindBy(xpath = ".//a[@class='login']")
    private WebElement signInLink;

    @FindBy(xpath = ".//a[@class='logout']")
    private WebElement signOutLink;

    @FindBy(xpath = ".//a[@title='Women']")
    private WebElement womenItem;

    @FindBy(xpath = ".//li[@class = 'sfHoverForce']/descendant::a[@title='Evening Dresses']")
    private WebElement eveningDressesItem;

    @FindBy(xpath = ".//a[@title='Evening Dresses']")
    private WebElement eveningDressesItem1;

    @FindBy(xpath = ".//a[@title = 'View my shopping cart']")
    private WebElement cart;

    @FindBy(xpath = "//div[@class = 'product-atributes']/a[@title='Printed Dress']")
    private WebElement productDetails;

  //  @FindBy(xpath = ".//a[@title = 'remove this product from my cart']")
    @FindBy(xpath = "//span[@class ='remove_link']")
    private WebElement removeProductFromCart;

    @FindBy(xpath = ".//span[@class = 'ajax_cart_no_product']")
    private List <WebElement> cartEmpty;


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

    /**
     * Hover on Women category
     */
    public void moveToWomenItem(){
        testClass.moveToElement(womenItem);
    }


    /**
     * Click on evening dresses link
     * @return MenuItemPage
     */
    public MenuItemPage clickOnEveningDressesLink(){
        testClass.click(eveningDressesItem1);
        return new MenuItemPage(testClass);
    }

    /**
     * Hover mouse on the cart
     */
    public void moveToCart(){
        testClass.moveToElement(cart);
    }

    /**
     * Get information about product in the cart
     * @return
     */
    public String getProductDetailsText()  {
        testClass.waitTillElementIsVisible(productDetails);
        return productDetails.getText();
    }

    /**
     * Remove product from cart
     */
    public void removeProductFromCart(){
        testClass.click(removeProductFromCart);
    }

    /**
     * Check if cart is empty
     * @return result
     */
    public boolean isCartEmpty(){
        testClass.waitForPageIsLoad();
        return cartEmpty.size() != 0;
    }






}
