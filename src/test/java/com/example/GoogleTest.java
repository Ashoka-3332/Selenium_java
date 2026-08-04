package com.example;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

import java.time.Duration;

import org.openqa.selenium.By;

public class GoogleTest extends BaseTest {

    @Test
    public void googlePageLoads() {
        driver.get("https://sauce-demo.myshopify.com/");

        Assert.assertTrue(driver.getTitle().toLowerCase().contains("sauce demo"),
                "Page title does not contain 'sauce demo'");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement element = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//section[@class='product-grid twelve columns alpha omega']")));

        element.click();
    }
}
