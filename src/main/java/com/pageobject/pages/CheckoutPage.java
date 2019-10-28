package com.pageobject.pages;

import com.pageobject.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;


public class CheckoutPage extends AbstractPage {

    @FindBy(xpath = ".//a[@title = 'Add']")
    private WebElement plusButton;

    @FindBy(xpath = ".//span[@id='total_price']")
    private WebElement totalPrice;

    @FindBy(xpath = ".//a[@title='Delete']")
    private WebElement deleteButton;

   // @FindBy(xpath = ".//p[text() = 'Your shopping cart is empty.']")
   // private List<WebElement> emptyShoppingCartAlert;

    @FindBy(xpath = ".//p[text() = 'Your shopping cart is empty.']")
    private WebElement emptyShoppingCartAlert;

    @FindBy(xpath = "//input[@class = 'cart_quantity_input form-control grey']")
    private WebElement productQuantity;


    /**
     * Constructor
     *
     * @param
     */
    CheckoutPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(logo);
    }

    /**
     * Clicking on the plus button for increasing product quantity
     */
    public void plusOneProduct() {
        testClass.waitTillElementIsVisible(plusButton);
        testClass.waitTillElementIsVisible(productQuantity);

        String str = productQuantity.getAttribute("value");
        int quantity = Integer.parseInt(str);
        plusButton.click();
        testClass.waitTillTextToBePresentInElementValue("//td[@class='cart_quantity text-center']/input[@type='hidden']",
                String.valueOf(quantity + 1));
    }


    /**
     * @return first product price
     */
    public String getFirstPrice() {
        testClass.waitTillElementIsVisible(totalPrice);
        return totalPrice.getText();
    }

    /**
     * @return total price
     */
    public String getTotalPrice() {
        testClass.waitTillElementIsVisible(totalPrice);
        return testClass.getDriver().findElement(By.xpath("//span[@id='total_price']")).getText();
    }

    /**
     * Deleting product from basket
     */
    public void deleteProductFromBasket() {
        testClass.waitTillElementIsVisible(deleteButton);
        deleteButton.click();
        testClass.waitForPageIsLoad();
    }

    /**
     * @return alert message
     */
    public String getAlertMessage() {
        testClass.waitTillElementIsVisible(emptyShoppingCartAlert);
        return emptyShoppingCartAlert.getText();
    }

}
