package com.pageobject.tests;

import com.pageobject.base.BaseTest;
import com.pageobject.pages.*;
import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.MathContext;


public class OpenSiteAndSignInTest extends BaseTest {

    /**
     * Open site
     * sign in
     * check name
     * sign out
     */
    @Test
    public void testOpenSiteAndSignInTest() {

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
    }


    /**
     * Open site
     * sign in
     * Click on Dresses > Summer Dresses
     * Compare goods quantity on the page
     */
    @Test
    public void testVerifyGoodsQuantityTest() {

        //Initialize home page
        HomePage homePage = openSite();
        log("Opened site");

        //Click on SignIn link
        LoginPage loginPage = homePage.clickSignInLink();
        log("Clicked on SignIn link");

        //Login
        MyAccountPage myAccountPage = loginPage.login();
        log("Login");

        //waitTillElementIsVisibleAndClick on Dresses menu
        CategoriesPage categoriesPage = myAccountPage.clickDressesItem();
        log("Clicked on Dresses menu");

        //waitTillElementIsVisibleAndClick on Summer dresses link
        categoriesPage.clickSummerDressesLink();
        log("Clicked on Summer dresses link");

        //compare specified quantity with actual products quantity quantity
        categoriesPage.verifyProductsQuantity();
        log("Compared specified quantity with actual products quantity quantity");
    }

    /**
     * Login
     * Open product
     * Add to basket
     * Increase product quantity
     * Verify price
     */
    @Test
    public void testVerifyPriceAfterIncreasingProductQuantityTest() {
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
        CategoriesPage categoriesPage = myAccountPage.clickTShirtsItem();
        log("Clicked on TShirts Item and move to TSirts page");

        //Open product
        ProductPage productPage = categoriesPage.clickOnProduct();
        log("Opened product page");

        //Verify breadcrumbs
        Assert.assertEquals("> Women>Tops>T-shirts>Faded Short Sleeve T-shirts", productPage.getBreadcrumbs());

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
        Assert.assertEquals(price.round(new MathContext(4)).toString(), checkoutPage.getTotalPrice().substring(1));
        log("Increased product quantity and verify total price");

        //delete product from basket
        checkoutPage.deleteProductFromBasket();
        log("deleted product from basket");

        Assert.assertEquals("Your shopping cart is empty.", checkoutPage.getAlertMessage());
    }

    /**
     * Login
     * Open product in new tab
     * Chang parameters
     * Add to basket
     * Verify product parameters in basket
     * Remove product from basket
     * Verify empty cart
     * Close tab
     * Display cookies
     */
    @Test
    public void testDisplayCart(){
        //Initialize home page
        HomePage homePage = openSite();
        log("Opened site");

        //Click on SignIn link
        LoginPage loginPage = homePage.clickSignInLink();
        log("Clicked on SignIn link");

        //Login
        MyAccountPage myAccountPage = loginPage.login();
        log("Login");

        //Hover on Women category
        myAccountPage.moveToWomenItem();
        log("hovered on Women category");

        // Open Evening Dresses link
        CategoriesPage categoriesPage = myAccountPage.clickOnEveningDressesLink();
        log("EveningDressesLink is opened");

        // Open product in another tab
        ProductPage productPage = categoriesPage.openProductInNewTab();
        switchToAnotherWindow();
        log("Product page is opened in new tab");

        // Choose parameters for product
        productPage.choosePinkColor();
        productPage.chooseSize("L");
        log("The parameters for product are chosen");

        //Add product to cart
        productPage.addToCart();
        log("Added product to cart");

        // Continue shopping
        productPage.continueShopping();

        // Hover mouse on the cart
        productPage.moveToCart();

        //Check product parameters
        Assert.assertEquals("Pink, L", productPage.getProductDetailsText());
        log("product parameters are verified");

        //Remove product from cart
        productPage.removeProductFromCart();
        log("product is removed from cart");

        //Verify cart is empty
        Assert.assertTrue(productPage.isCartEmpty());
        log("Verified that cart is empty");

        //close current tab and return to main
        closeCurrentTabAndSwitchToAnother();
        log("Current tab is closed, focus returned on main window");

        //Display cookies
        getCookies();
    }
}
