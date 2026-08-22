package org.example.tests;

import org.example.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class Categorytest extends BaseTest {

    @Test
    public void verifyWomenDressCategory() {

        driver.get("https://automationexercise.com/products");

        // Select Women category
        WebElement womenCategory = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[normalize-space()='Women']")
                )
        );

        womenCategory.click();

        // Select Dress subcategory
        WebElement dressSubcategory = wait.until(
                ExpectedConditions.elementToBeClickable(
                        By.xpath("//a[@href='/category_products/1']")
                )
        );

        String subcategoryName =
                dressSubcategory.getText().trim();

        Assert.assertFalse(
                subcategoryName.isEmpty(),
                "Subcategory name was not displayed"
        );

        dressSubcategory.click();

        // Wait for category heading
        WebElement categoryHeading = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath(
                                "//h2[normalize-space()='Women - Dress Products']"
                        )
                )
        );

        Assert.assertTrue(
                categoryHeading.isDisplayed(),
                "Women - Dress Products heading was not displayed"
        );

        // Find displayed products
        List<WebElement> products = wait.until(
                ExpectedConditions.visibilityOfAllElementsLocatedBy(
                        By.xpath("//div[contains(@class,'productinfo')]/p")
                )
        );

        Assert.assertFalse(
                products.isEmpty(),
                "No products were displayed for the Dress category"
        );

        // Validate product names
        for (WebElement product : products) {

            String productName =
                    product.getText().trim();

            Assert.assertTrue(
                    productName.toLowerCase()
                            .contains(subcategoryName.toLowerCase()),
                    "Product does not match selected category: "
                            + productName
            );
        }
    }
}