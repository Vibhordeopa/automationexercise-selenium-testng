# Automation Exercise Selenium TestNG Automation

## 📌 Overview

This project is a web automation test suite developed using **Java, Selenium WebDriver, TestNG, Maven, and WebDriverManager**.

The project automates key functional workflows of the Automation Exercise e-commerce practice application, including user registration, login, logout, product navigation, and category validation.

## 🛠️ Tech Stack

* Java 21
* Selenium WebDriver
* TestNG
* Maven
* WebDriverManager
* XPath
* CSS Selectors
* Chrome
* Microsoft Edge

## 🧪 Automated Test Scenarios

### 1. User Registration

Validates the complete signup workflow:

* Open signup page
* Enter name and email
* Navigate to account information
* Verify pre-filled user information
* Enter password and date of birth
* Enter address information
* Select country
* Create account
* Verify successful account creation

### 2. Login

Uses TestNG `@DataProvider` to execute multiple login scenarios:

* Valid email + valid password
* Invalid email + invalid password
* Valid email + invalid password
* Invalid email + valid password

Both successful and unsuccessful login behavior is validated.

### 3. Logout

Validates the complete logout workflow:

* Login with valid credentials
* Verify successful login
* Click Logout
* Verify that the Signup/Login option is displayed

### 4. Product Navigation

Validates product navigation from the homepage:

* Verify product links are available
* Iterate through products
* Scroll products into view
* Open product details
* Verify product information
* Navigate back to the homepage
* Continue with the next product

### 5. Product Category

Validates category navigation:

* Open Products page
* Select Women category
* Select Dress subcategory
* Verify category page
* Verify products displayed under the selected category

## 🧰 Selenium Features Demonstrated

The project demonstrates practical use of:

* Selenium WebDriver
* XPath locators
* CSS selectors
* Explicit waits
* `WebDriverWait`
* `ExpectedConditions`
* `WebElement`
* Selenium `Select`
* `JavascriptExecutor`
* Browser navigation
* Handling lists of WebElements
* Dynamic element re-location
* TestNG assertions
* TestNG DataProvider
* TestNG lifecycle annotations

## 🧪 Testing Approach

The test suite includes both:

### Positive Testing

Examples:

* Valid login
* Successful account creation
* Successful category navigation
* Successful product navigation

### Negative Testing

Examples:

* Invalid login credentials
* Incorrect password
* Invalid email/password combinations

## 📂 Project Structure

```text
automationexercise-selenium-testng/
│
├── pom.xml
├── testng.xml
├── README.md
├── .gitignore
│
└── src/
    └── test/
        └── java/
            └── org/
                └── example/
                    ├── base/
                    │   └── BaseTest.java
                    │
                    └── tests/
                        ├── SignupTest.java
                        ├── LoginTest.java
                        ├── LogoutTest.java
                        ├── HomePageTest.java
                        └── CategoryTest.java
```

## ⚙️ Prerequisites

Install the following:

* JDK 21
* Maven
* Google Chrome and/or Microsoft Edge
* IntelliJ IDEA or another Java IDE

## 🚀 Running the Tests

Clone the repository and navigate to the project directory.

Run:

```bash
mvn clean test
```

The Maven Surefire plugin executes the TestNG suite defined in `testng.xml`.

## 🌐 Browser Configuration

The framework currently supports:

* Microsoft Edge
* Google Chrome

The browser can be selected in `BaseTest.java`.

```java
protected String browser = "edge";
```

Change it to:

```java
protected String browser = "chrome";
```

to execute the suite using Chrome.

## ⏱️ Synchronization

The project uses Selenium explicit waits instead of relying on fixed `Thread.sleep()` delays.

Example:

```java
wait.until(
    ExpectedConditions.visibilityOfElementLocated(
        By.xpath("//a[normalize-space()='Logout']")
    )
);
```

This helps synchronize test execution with dynamic page elements.

## 📊 TestNG Features

TestNG is used for:

* Test execution
* Assertions
* `@BeforeMethod`
* `@AfterMethod`
* `@DataProvider`
* Test organization
* Suite execution

## 🔮 Future Improvements

Potential future improvements include:

* Page Object Model
* Externalized test data
* Screenshot capture on failure
* HTML reporting
* Logging
* Parameterized browser execution
* CI/CD integration using Jenkins
* Parallel test execution

## 👨‍💻 Author

### Vibhor Singh Deopa

Java | Selenium | TestNG | Maven | QA Automation
