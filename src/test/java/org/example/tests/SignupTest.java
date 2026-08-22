package org.example.tests;

import org.example.base.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTest extends BaseTest {

    @Test
    public void verifySignup() {

        // Open signup page
        driver.get("https://automationexercise.com/login");

        // Verify signup form is displayed
        WebElement signupForm = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='signup-form']")
                )
        );

        Assert.assertTrue(
                signupForm.isDisplayed(),
                "Signup form is not displayed"
        );

        // Enter signup information
        driver.findElement(
                By.xpath("//input[@placeholder='Name']")
        ).sendKeys("TestUser");

        driver.findElement(
                By.xpath("//input[@data-qa='signup-email']")
        ).sendKeys("testuser123@example.com");

        driver.findElement(
                By.xpath("//button[normalize-space()='Signup']")
        ).click();

        // Verify account information page
        WebElement signupDetails = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//div[@class='login-form']")
                )
        );

        Assert.assertTrue(
                signupDetails.isDisplayed(),
                "Account information page is not displayed"
        );

        // Select title
        driver.findElement(
                By.xpath("//label[@for='id_gender1']")
        ).click();

        // Verify name
        WebElement name = driver.findElement(
                By.xpath("//input[@id='name']")
        );

        Assert.assertEquals(
                name.getAttribute("value"),
                "TestUser",
                "Name does not match"
        );

        // Verify email
        WebElement email = driver.findElement(
                By.xpath("//input[@id='email']")
        );

        Assert.assertEquals(
                email.getAttribute("value"),
                "testuser123@example.com",
                "Email does not match"
        );

        // Enter password
        driver.findElement(
                By.xpath("//input[@id='password']")
        ).sendKeys("Test@123");

        // Select date of birth
        Select days = new Select(
                driver.findElement(By.xpath("//select[@id='days']"))
        );
        days.selectByVisibleText("16");

        Select months = new Select(
                driver.findElement(By.xpath("//select[@id='months']"))
        );
        months.selectByVisibleText("March");

        Select years = new Select(
                driver.findElement(By.xpath("//select[@id='years']"))
        );
        years.selectByVisibleText("2005");

        // Newsletter and special offers
        driver.findElement(
                By.xpath("//input[@id='newsletter']")
        ).click();

        driver.findElement(
                By.xpath("//input[@id='optin']")
        ).click();

        // Enter address information
        driver.findElement(
                By.xpath("//input[@id='first_name']")
        ).sendKeys("Test");

        driver.findElement(
                By.xpath("//input[@id='last_name']")
        ).sendKeys("User");

        driver.findElement(
                By.xpath("//input[@id='company']")
        ).sendKeys("QA Testing");

        driver.findElement(
                By.xpath("//input[@id='address1']")
        ).sendKeys("Test Address");

        driver.findElement(
                By.xpath("//input[@id='address2']")
        ).sendKeys("12345");

        // Select country
        Select country = new Select(
                driver.findElement(By.xpath("//select[@id='country']"))
        );

        country.selectByVisibleText("India");

        // Enter location details
        driver.findElement(
                By.xpath("//input[@id='state']")
        ).sendKeys("Uttarakhand");

        driver.findElement(
                By.xpath("//input[@id='city']")
        ).sendKeys("Champawat");

        driver.findElement(
                By.xpath("//input[@id='zipcode']")
        ).sendKeys("262528");

        driver.findElement(
                By.xpath("//input[@id='mobile_number']")
        ).sendKeys("9000000000");

        // Create account
        driver.findElement(
                By.xpath("//button[normalize-space()='Create Account']")
        ).click();

        // Verify account creation
        WebElement accountCreated = wait.until(
                ExpectedConditions.visibilityOfElementLocated(
                        By.xpath("//b[normalize-space()='Account Created!']")
                )
        );

        Assert.assertEquals(
                accountCreated.getText(),
                "Account Created!",
                "Account was not created successfully"
        );

        // Continue
        driver.findElement(
                By.xpath("//a[@class='btn btn-primary']")
        ).click();
    }
}