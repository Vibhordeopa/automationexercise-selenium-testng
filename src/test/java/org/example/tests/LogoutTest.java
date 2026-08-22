package org.example.tests;

import org.example.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LogoutTest extends BaseTest {

    @Test
    public void verifyLogout() {

        driver.get("https://automationexercise.com/login");

        // Login first
        driver.findElement(
                By.xpath("//input[@data-qa='login-email']")
        ).sendKeys("vibhordeopa794@gmail.com");

        driver.findElement(
                By.xpath("//input[@data-qa='login-password']")
        ).sendKeys("1234");

        driver.findElement(
                By.xpath("//button[@data-qa='login-button']")
        ).click();

        // Verify successful login
        wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[normalize-space()='Logout']")
                )
        );

        // Logout
        driver.findElement(
                By.xpath("//a[normalize-space()='Logout']")
        ).click();

        // Verify logout
        WebElement loginLink = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//a[normalize-space()='Signup / Login']")
                )
        );

        Assert.assertTrue(
                loginLink.isDisplayed(),
                "Signup / Login was not displayed after logout"
        );
    }
}