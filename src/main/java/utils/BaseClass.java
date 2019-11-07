package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

/* This base class stores webDriver launching and ending.
Class needs to be extended by every test and page class.
*/
public class BaseClass {

    public static WebDriver driver;

    @BeforeMethod
    public static void startTest() {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");

        System.setProperty("webdriver.chrome.driver", "chromedriver");
        driver = new ChromeDriver(options);
    }

    @AfterMethod
    public static void endTest() {
        driver.quit();
    }
}
