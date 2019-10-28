package com.pageobject.base;

import com.pageobject.pages.HomePage;
import com.pageobject.utils.YamlParser;
import org.junit.Rule;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.plaf.PanelUI;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

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
    }

    public void waitTillAlertIsPresent(){
        wait.until(ExpectedConditions.alertIsPresent());
    }

    /**
     * Write down info message
     *
     * @param message
     */
    public void log(String message) {
        logger.info(message);
    }

    /**
     * Write down error message
     *
     * @param error
     */
    public void error(String error) {
        logger.error(error);
    }

    /**
     * Get current date and time
     *
     * @return current date and time
     */
    public String getDateTime() {
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

}
