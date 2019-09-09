package com.pageobject.tests;

import com.pageobject.base.BaseTest;
import com.pageobject.pages.*;
import org.junit.Test;


public class OpenSiteAndSignInTest extends BaseTest {

    /**
     * Open site
     * sign in
     * check name
     * sign out
     */
    @Test
    public void testOpenSiteAndSignInTest(){

        //Initialize home page
        HomePage homePage = openSite();
        //Click on SignIn link
        LoginPage loginPage = homePage.clickSignInLink();
        //Login
        MyAccountPage myAccountPage = loginPage.login();
        //Verify name
        myAccountPage.verifyName();
        //Click on SignOut link
        loginPage = myAccountPage.clickSignOutLink();
        //Verify return to login page
        loginPage.verifySignBtnIsDisplayed();
        //Close site
        closeSite();
    }

    @Test
    public void testVerifyGoodsQuantityTest(){
        //Initialize home page
        HomePage homePage = openSite();
        //Click on SignIn link
        LoginPage loginPage = homePage.clickSignInLink();
        //Login
        MyAccountPage myAccountPage = loginPage.login();
        //click on Dresses menu
        DressesPage dressesPage = myAccountPage.clickDressesItem();
        //click on Summer dresses link
        SummerDressesPage summerDressesPage = dressesPage.clickSummerDressesLink();
        //compare specified quantity with actual products quantity quantity
        summerDressesPage.verifyProductsQuantity();
    }


}
