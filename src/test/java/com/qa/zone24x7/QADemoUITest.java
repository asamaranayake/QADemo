package com.qa.zone24x7;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.io.File;
import java.io.IOException;
import java.time.Duration;
import org.apache.commons.io.FileUtils;

public class QADemoUITest {
    WebDriver driver;

    @BeforeClass
    public void setup() {
        // Setup WebDriverManager for ChromeDriver
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }

    @Test
    public void testSearchForCars() {
        // 1. Navigate to the website
        driver.get("https://faoschwarz.com/");

        // 2. Example: Locating Elements
        // Locate the search input box by Name and enter a search term
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.clear();
        searchInput.sendKeys("cars");

        // Locate the search button by CSS Selector and click
        WebElement searchButton = driver.findElement(By.cssSelector("button[type='submit']"));
        searchButton.click();

        // 3. Browser Interactions
        // Wait for results to load using Explicit Wait
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("search-results-title")));

        // Capture the title of search results
        WebElement resultsTitle = driver.findElement(By.className("search-results-title"));
        System.out.println("Results Title: " + resultsTitle.getText());

        // 4. Take a Screenshot of the Results Page
        takeScreenshot("search-results");

        // 5. Clicking on an Element (Example using Partial Link Text)
        WebElement firstProductLink = driver.findElement(By.partialLinkText("Car"));
        firstProductLink.click();

        // 6. State-Based Synchronization with Explicit Waits
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("product-title")));
        WebElement productTitle = driver.findElement(By.id("product-title"));
        System.out.println("Product Title: " + productTitle.getText());

        // Additional Interaction: Handling Alerts (if applicable)
        // Example only if an alert appears on the site:
        try {
            Alert alert = driver.switchTo().alert();
            System.out.println("Alert Text: " + alert.getText());
            alert.accept();
        } catch (NoAlertPresentException e) {
            System.out.println("No alert present.");
        }
    }

    public void takeScreenshot(String fileName) {
        // Take Screenshot and save
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screenshot, new File(fileName + ".png"));
            System.out.println("Screenshot saved: " + fileName + ".png");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @AfterClass
    public void tearDown() {
        // Close the browser
        if (driver != null) {
            driver.quit();
        }
    }
}