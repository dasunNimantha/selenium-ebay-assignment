package com.ict.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;

public class SelectMobileTest extends Base {
    @Test(priority = 1)
    @Parameters({"url"})
    public void getUrl(String url) {
        driver.get(url);
    }

    @Test(priority = 2)
    @Parameters({"url"})
    public void validateUrl(String url) {
        // Verify page URL
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    // Select "Cell Phones & Accessories" from main dropdown
    @Test(priority = 3)
    public void selectCategory() {
        WebElement categoryDropDown = driver.findElement(By.id("gh-cat"));
        Select select = new Select(categoryDropDown);
        select.selectByVisibleText("Cell Phones & Accessories");
    }

    // Search for "Mobile phone"
    @Test(priority = 4)
    public void searchMobile() {
        WebElement searchBox = driver.findElement(By.id("gh-ac"));
        searchBox.sendKeys("Mobile phone");
        driver.findElement(By.id("gh-btn")).click();
    }


    // Select brand "Apple" from side panel
    @Test(priority = 5)
    public void selectApple() {
        // Select brand "Apple" from side panel
        WebElement appleCheckBox = driver.findElement(By.xpath("//input[@aria-label='Apple']"));
        appleCheckBox.click();
    }

    // Select the first item from the list
    @Test(priority = 6)
    public void selectFirstItem() throws InterruptedException {
        // Select the first search item
        String firstItemXpath = "//*[@id=\"srp-river-results\"]/ul/li[2]/div/div[2]/a/div";

        // wait for the first item to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath(firstItemXpath)));

        // click on the first item
        WebElement firstItem = driver.findElement(By.xpath(firstItemXpath));
        firstItem.click();

        // wait for the new window to open and load web page
        Thread.sleep(5000);

        // switch to the new window
        for (String winHandle : driver.getWindowHandles()) {
            driver.switchTo().window(winHandle);
        }
    }
}