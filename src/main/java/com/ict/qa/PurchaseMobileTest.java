package com.ict.qa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PurchaseMobileTest extends Base {

    private String model, carrier, storageCapacity, color, cosmetic; // dropdown values
    private String itemTitleText;
    private String priceValue;
    private String quantity;


    // select model of the device
    @Test(priority = 8)
    public void selectModel() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Model']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
            model = selectBoxLabel.getFirstSelectedOption().getText();
        } catch (Exception e) {
            System.out.println("Model dropdown not found");
        }
    }

    // select carrier of the device
    @Test(priority = 9)
    public void selectCarrier() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Carrier']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
            carrier = selectBoxLabel.getFirstSelectedOption().getText();
        } catch (Exception e) {
            System.out.println("Carrier dropdown not found");
        }
    }

    // select storage capacity of the device
    @Test(priority = 10)
    public void selectStorageCapacity() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Storage Capacity'], select[selectboxlabel='Storage']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
            storageCapacity = selectBoxLabel.getFirstSelectedOption().getText();
        } catch (Exception e) {
            System.out.println("Storage Capacity dropdown not found");
        }
    }

    @Test(priority = 11)
    public void selectColor() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Color'], select[selectboxlabel='Colour']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
            color = selectBoxLabel.getFirstSelectedOption().getText();
        } catch (Exception e) {
            System.out.println("Color dropdown not found");
        }
    }

    // select cosmetic of the device
    @Test(priority = 12)
    public void selectCosmetic() {
        try {
            WebElement selectBox = driver.findElement(By.cssSelector("select[selectboxlabel='Cosmetic']"));
            Select selectBoxLabel = new Select(selectBox);
            selectBoxLabel.selectByIndex(1);
            cosmetic = selectBoxLabel.getFirstSelectedOption().getText();
        } catch (Exception e) {
            System.out.println("Cosmetic dropdown not found");
        }
    }

    @Test(priority = 13)
    public void verifySelectedOptions() {
        // check if all the options are null
        if (model == null && carrier == null && storageCapacity == null && color == null && cosmetic == null) {
            Assert.fail("Selected device specification options are null");
        }
    }

    // get item name
    @Test(priority = 14)
    public void getItemName() {
        itemTitleText = driver.findElement(By.cssSelector("h1.x-item-title__mainTitle")).getText().trim();
        System.out.println("Item title: " + itemTitleText);
    }

    // get item price
    @Test(priority = 15)
    public void getItemPrice() {
        priceValue = driver.findElement(By.xpath("//span[@itemprop='price']//span[@class='ux-textspans']")).getText().trim();
        System.out.println("Item price : " + priceValue);
    }

    // get item condition
    @Test(priority = 16)
    public void getItemCondition() {
        String condition = driver.findElement(By.xpath("//div[@class='x-item-condition-text']//span[@class='ux-textspans']")).getText().trim();
        System.out.println("Item condition : " + condition);
    }

    // get item quantity
    @Test(priority = 17)
    public void getItemQuantity() {
        quantity = driver.findElement(By.id("qtyTextBox")).getAttribute("value");
        System.out.println("Item quantity : " + quantity);
    }

    // add item to the cart
    @Test(priority = 18)
    public void addItemToCart() {
        WebElement addToCartButton = driver.findElement(By.xpath("//a[@class='ux-call-to-action fake-btn fake-btn--fluid fake-btn--primary']//span[@class='ux-call-to-action__text' and text()='Add to cart']"));
        addToCartButton.click();
    }

    // check item name is the same
    @Test(priority = 19)
    public void checkItemName() {
        String title = driver.findElement(By.className("item-title")).getText().trim();
        Assert.assertEquals(title, itemTitleText, "Title is not the same");
    }

    // check item price is the same
    @Test(priority = 20)
    public void checkItemPrice() {
        String subtotalValue = driver.findElement(By.cssSelector("div[data-test-id='SUBTOTAL']")).getText().trim();
        Assert.assertEquals(subtotalValue, priceValue, "Price is not the same");
    }

    // check quantity is the same
    @Test(priority = 21)
    public void checkQuantity() {
        WebElement dropdown = driver.findElement(By.xpath("//label[text()='Qty']/following-sibling::span/select"));
        String selectedOption = dropdown.getAttribute("value");
        Assert.assertEquals(selectedOption, quantity, "Quantity is not the same");
    }

    // get shipping value
    @Test(priority = 22)
    public void getShippingValue() {
        WebElement shippingElement = driver.findElement(By.cssSelector("div[data-test-id='SHIPPING']"));
        String shippingValue = shippingElement.getText().trim();
        System.out.println("Shipping value : " + shippingValue);
    }

    // get price
    @Test(priority = 23)
    public void getP() {
        WebElement priceElement = driver.findElement(By.xpath("//div[@class='price-details']/div[@class='item-price font-title-3']/span[@class='text-display-span']/span/span/text()"));
        String priceValue = priceElement.getText().trim();
        System.out.println("Price value : " + priceValue);
    }
}
