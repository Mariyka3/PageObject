package com.pageobject.Tests;

import com.pageobject.Pages.HomePage;
import com.pageobject.Pages.LoginPage;
import com.pageobject.Pages.MyAccountPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OpenSiteAndSignInTest {

    // Instance of WebDriver
    private WebDriver driver;

    // URL to open and test
    private final String URL = "http://automationpractice.com/index.php";

    /**
     * Set up method
     */
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    /**
     * Open site
     * sign in
     * check name
     * sign out
     */
    @Test
    public void testOpenSiteAndSignInTest(){
        // Open site
        driver.get(URL);
        //Initialize home page
        HomePage homePage = new HomePage(driver);
        //Click on SignIn link
        LoginPage loginPage = homePage.clickSignInLink();
        //Login
        MyAccountPage myAccountPage = loginPage.login();
        //Verify name
        Assert.assertEquals(myAccountPage.name, myAccountPage.returnName());
        //Click on SignOut link
        LoginPage loginPage1 = myAccountPage.clickSignOutLink();
        //Verify return to login page
        Assert.assertTrue(loginPage1.signInButton.isDisplayed());

    }
    /**
     * Quit the driver
     */
    @After
    public void tearDown() {
        driver.quit();
    }

}
