package com.pageobject.pages;

import com.pageobject.base.BaseTest;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SummerDressesPage extends AbstractPage {

    @FindBy(xpath = ".//span[@class = 'heading-counter']")
    private WebElement counter;

    @FindBy(xpath = ".//li[contains(@class, 'ajax_block_product')]")
    private List<WebElement> products;

    @FindBy(xpath = ".//input[@id = 'layered_id_attribute_group_8']")
    private WebElement whiteColor;


    /**
     * Constructor
     *
     * @param testClass
     */
    public SummerDressesPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(logo);
    }

    /**
     * Compare the specified quantity on the page with actual products quantity
     */
    public void verifyProductsQuantity(){
        int count = Integer.parseInt(counter.getText().replaceAll("\\D+",""));
        Assert.assertEquals( products.size(), count);
    }
}
