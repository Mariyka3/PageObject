package com.pageobject.tests;

import com.pageobject.base.BaseTest;
import com.pageobject.pages.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;


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
        log("Opened site");
        //Click on SignIn link
        LoginPage loginPage = homePage.clickSignInLink();
        log("Clicked on SignIn link");
        //Login
        MyAccountPage myAccountPage = loginPage.login();
        log("Login");
        //Verify name
        myAccountPage.verifyName();
        log("Verified name");
        //Click on SignOut link
        loginPage = myAccountPage.clickSignOutLink();
        log("Clicked on SignOut link");
        //Verify return to login page
        loginPage.verifySignBtnIsDisplayed();
        log("Verified return to login page");
        //Close site
        closeSite();
        log("Closed site");
    }


    /**
     * Open site
     * sign in
     * Click on Dresses > Summer Dresses
     * Compare goods quantity on the page
     */
    @Test
    public void testVerifyGoodsQuantityTest(){
        //Initialize home page
        HomePage homePage = openSite();
        log("Opened site");
        //Click on SignIn link
        LoginPage loginPage = homePage.clickSignInLink();
        log("Clicked on SignIn link");
        //Login
        MyAccountPage myAccountPage = loginPage.login();
        log("Login");
        //click on Dresses menu
        MenuItemPage menuItemPage = myAccountPage.clickDressesItem();
        log("Clicked on Dresses menu");
        //click on Summer dresses link
        SummerDressesPage summerDressesPage = menuItemPage.clickSummerDressesLink();
        log("Clicked on Summer dresses link");
        //compare specified quantity with actual products quantity quantity
        summerDressesPage.verifyProductsQuantity();
        log("Compared specified quantity with actual products quantity quantity");
        //Close site
        closeSite();
        log("Closed site");
    }

    /**
     *Login
     * Open product
     * Add to basket
     * Increase product quantity
     * Verify price
     */
    @Test
    public void testVerifyPriceAfterIncreasingProductQuantityTest(){
        //Initialize home page
        HomePage homePage = openSite();
        log("Opened site");
        //Click on SignIn link
        LoginPage loginPage = homePage.clickSignInLink();
        log("Clicked on SignIn link");
        //Login
        MyAccountPage myAccountPage = loginPage.login();
        log("Login");
        //Click TShirts Item
        MenuItemPage menuItemPage = myAccountPage.clickTShirtsItem();
        log("Clicked on TShirts Item and move to TSirts page");
        //Open product
        ProductPage productPage = menuItemPage.clickOnProduct();
        log("Opened product page");
        //Add product to cart
        productPage.addToCart();
        log("Added product to cart");
        //Proceed to checkout
        CheckoutPage checkoutPage = productPage.proceedToCheckout();
        log("Clicked on product to checkout button, moved to checkout page");
        //Get price for one product and multiply it by two
        BigDecimal price = new BigDecimal(checkoutPage.getFirstPrice().substring(1));
        BigDecimal two = new BigDecimal(16.51);
        price = price.add(two);
        //Click on plus for increasing product quantity
        checkoutPage.plusOneProduct();
        Assert.assertEquals(price.round(new MathContext(4)).toString(),checkoutPage.getTotalPrice().substring(1));
        log("Increased product quantity and verify total price");
        //delete product from basket
        checkoutPage.deleteProductFromBasket();
        log("deleted product from basket");
        Assert.assertTrue(checkoutPage.isAlert());
        Assert.assertEquals("Your shopping cart is empty." , checkoutPage.getAlertMessage());
    }

}
