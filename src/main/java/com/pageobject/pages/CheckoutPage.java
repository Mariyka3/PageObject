package com.pageobject.pages;

import com.pageobject.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static com.sun.webkit.perf.WCFontPerfLogger.log;

public class CheckoutPage extends AbstractPage {

    @FindBy(xpath = ".//a[@title = 'Add']")
    private WebElement plusButton;

    @FindBy(xpath = ".//span[@id='total_price']")
    private WebElement totalPrice;

    @FindBy(xpath = ".//a[@title='Delete']")
    private WebElement deleteButton;

    @FindBy (xpath = ".//p[text() = 'Your shopping cart is empty.']")
    private List<WebElement> emptyShoppingCartAlert;


    /**
     * Constructor
     *
     * @param
     */
    CheckoutPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(logo);
    }

    public void plusOneProduct() {
        testClass.waitTillElementIsVisible(plusButton);
        plusButton.click();
    }


    public String getFirstPrice() {
        testClass.waitTillElementIsVisible(totalPrice);
        return totalPrice.getText();
    }

    public String getTotalPrice() {
        testClass.log(totalPrice.getText());
        testClass.waitTillTextToBePresentInElementValue(".//span[@id='total_price']", "$35.02");
        return totalPrice.getText();
    }
    public void deleteProductFromBasket(){
        testClass.waitTillElementIsVisible(deleteButton);
        deleteButton.click();
    }

    public Boolean isAlert(){
        return !emptyShoppingCartAlert.isEmpty();
    }

    public String getAlertMessage(){
        testClass.waitTillElementIsVisible(emptyShoppingCartAlert.get(0));
        return emptyShoppingCartAlert.get(0).getText();
    }


}
