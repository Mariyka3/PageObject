package com.pageobject.pages;

import com.pageobject.base.BaseTest;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DressesPage extends AbstractPage {

    @FindBy (xpath = ".//div[@class = 'subcategory-image']/a[@title = 'Summer Dresses']")
    private WebElement summerDressesLink;


    /**
     * Constructor
     *
     * @param testClass
     */
    public DressesPage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(logo);
    }

    /**
     * Click on the Summer Dresses link
     * @return SummerDressesPage
     */
    public SummerDressesPage clickSummerDressesLink(){
        testClass.waitTillElementIsVisible(summerDressesLink);
        summerDressesLink.click();
        return new SummerDressesPage(testClass);
    }
}
