package org.example.tests;

import org.example.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {

        return new Object[][] {
                {"testuser123@example.com", "Test@123", true},
                {"wrongemail@gmail.com", "wrongPassword", false},
                {"vibhordeopa794@gmail.com", "wrongPassword", false},
                {"wrongemail@gmail.com", "1234", false}
        };
    }

    @Test(dataProvider = "loginData")
    public void verifyLogin(
            String email,
            String password,
            boolean shouldLogin
    ) {

        driver.get("https://automationexercise.com/login");

        driver.findElement(
                By.xpath("//input[@data-qa='login-email']")
        ).sendKeys(email);

        driver.findElement(
                By.xpath("//input[@data-qa='login-password']")
        ).sendKeys(password);

        driver.findElement(
                By.xpath("//button[@data-qa='login-button']")
        ).click();

        if (shouldLogin) {

            WebElement logout = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath("//a[normalize-space()='Logout']")
                    )
            );

            Assert.assertTrue(
                    logout.isDisplayed(),
                    "Logout option was not displayed after login"
            );

            logout.click();

        } else {

            WebElement error = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(
                            By.xpath(
                                    "//p[contains(text(),'Your email or password is incorrect!')]"
                            )
                    )
            );

            Assert.assertTrue(
                    error.isDisplayed(),
                    "Expected login error message was not displayed"
            );
        }
    }
}