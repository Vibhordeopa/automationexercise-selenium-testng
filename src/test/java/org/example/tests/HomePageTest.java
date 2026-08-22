package org.example.tests;

import org.example.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class HomePageTest extends BaseTest {

    @Test
    public void verifyProducts() {

        driver.get("https://automationexercise.com/");

        // Locate product links
        List<WebElement> viewProducts = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//a[contains(@href,'/product_details')]")
                )
        );

        Assert.assertFalse(
                viewProducts.isEmpty(),
                "No products were found on the homepage"
        );

        int productCount = viewProducts.size();

        System.out.println(
                "Total products found: " + productCount
        );

        // Open each product
        for (int i = 0; i < productCount; i++) {

            // Re-locate elements after navigating back
            viewProducts = driver.findElements(
                    By.xpath("//a[contains(@href,'/product_details')]")
            );

            WebElement product = viewProducts.get(i);

            // Scroll product into view
            ((JavascriptExecutor) driver).executeScript(
                    "arguments[0].scrollIntoView({block: 'center'});",
                    product
            );

            // Wait for clickable product
            wait.until(
                    ExpectedConditions.elementToBeClickable(product)
            );

            product.click();

            // Verify product details page
            WebElement productInformation = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//div[contains(@class,'product-information')]")
                    )
            );

            Assert.assertTrue(
                    productInformation.isDisplayed(),
                    "Product details page was not displayed"
            );

            // Return to homepage
            driver.navigate().back();

            // Wait for products to return
            wait.until(
                    ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//a[contains(@href,'/product_details')]")
                    )
            );
        }
    }
}