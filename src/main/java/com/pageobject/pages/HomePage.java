package com.pageobject.pages;

import com.pageobject.base.BaseTest;

public class HomePage extends AbstractPage{

    /**
     * Constructor
     *
     * @param
     */
    public HomePage(BaseTest testClass) {
        super(testClass);
        testClass.waitTillElementIsVisible(logo);
    }
}
