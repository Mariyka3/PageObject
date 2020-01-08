package com.pageobject.base;

import com.pageobject.pages.HomePage;
import com.pageobject.utils.YamlParser;
import org.junit.Rule;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Set;


import static org.openqa.selenium.support.ui.ExpectedConditions.textToBePresentInElementValue;


public class BaseTest {

    // Instance of WebDriver and wait
    private WebDriver driver;
    private WebDriverWait wait;

    //Logger
    private Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);

    // Rule
    @Rule
    public RunTestRule runTestRule = new RunTestRule(this);

    /**
     * Constructor
     */
    public BaseTest() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 50);
    }

    /**
     * Return instance of Driver
     *
     * @return WebDriver
     */
    public WebDriver getDriver() {
        return driver;
    }

    /**
     * Open site and return instance of HomePage
     *
     * @return HomePage
     */
    protected HomePage openSite() {
        driver.get(YamlParser.getYamlData().getUrl());
        return new HomePage(this);
    }

    /**
     * Close site with driver.quit()
     */
    protected void closeSite() {
        driver.quit();
    }

    /**
     * Wait till element is visible
     *
     * @param element
     */
    public void waitTillElementIsVisible(WebElement element) {
        wait.until(ExpectedConditions.visibilityOf(element));
       // wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    /**
     * Write down info message
     *
     * @param message
     */
    protected void log(String message) {
        logger.info(message);
    }

    /**
     * Write down error message
     *
     * @param error
     */
    void error(String error) {
        logger.error(error);
    }

    /**
     * Get current date and time
     *
     * @return current date and time
     */
    String getDateTime() {
        return new SimpleDateFormat("YYYY-MM-dd_HH-mm-ss").format(Calendar.getInstance().getTime());
    }

    /**
     * wait until text to be presented
     *
     * @param locator
     * @param expectedValue
     */
    public void waitTillTextToBePresentInElementValue(String locator, String expectedValue) {

        wait.until(
                textToBePresentInElementValue(
                        By.xpath(locator), expectedValue));
    }

    /**
     * wait until page is loaded
     */
    public void waitForPageIsLoad() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("return document.readyState").toString().equals("complete");
    }

    /**
     * hover on element
     * @param element
     */
    public void moveToElement(WebElement element){
        Actions actions = new Actions(driver);
        waitTillElementIsVisible(element);
        actions.moveToElement(element).build().perform();
    }

    /**
     * Open link in new tab
     * @param element
     */
    public void openInNewTab(WebElement element){
        Actions actions = new Actions(driver);
        actions.keyDown(Keys.CONTROL).moveToElement(element).click().perform();
    }

    /**
     * Switch to specified window
     * @param window
     */
    protected void switchToHandle(String window){
        for (String windowID : driver.getWindowHandles()){
            if(driver.switchTo().window(windowID).getTitle().equals(window)) {
                log("switch to " + window + " handle");
                waitForPageIsLoad();
                break;
            }else {
                log("Window Title is " + driver.getTitle());
            }
        }
    }

    /**
     * Wait and click on element
     * @param element
     */
    public void click(WebElement element){
        waitTillElementIsVisible(element);
        element.click();
    }

    /**
     * Close current tab
     */
    protected void closeCurrentTab(){
        getDriver().close();
        switchToHandle("Evening Dresses - My Store");
    }


    /**
     * Display cookie's names
     */
    protected void getCookies(){
        Set <Cookie> cookies = getDriver().manage().getCookies();
        cookies.forEach((n) -> log(n.getName()));
    }
}
