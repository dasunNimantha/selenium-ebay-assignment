package com.ict.qa;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import java.time.Duration;

public class Base {
     protected static WebDriver driver;
     protected static WebDriverWait wait;

    @BeforeTest
    @Parameters({"browser", "url"})
    public void setUp(String browser, String url){
       if (browser.equalsIgnoreCase("chrome")) {
           System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver");
           driver = new ChromeDriver();
       } else if (browser.equalsIgnoreCase("firefox")) {
           System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver");
           driver = new FirefoxDriver();
       } else {
           System.out.println("Browser not supported");
           // end program
           System.exit(0);
       }

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

}
