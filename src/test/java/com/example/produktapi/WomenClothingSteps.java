package com.example.produktapi;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WomenClothingSteps {

    WebDriver driver;
    WebDriverWait wait;

    @Given("I am on the product page")
    public void i_am_on_the_product_page() {

        driver = new ChromeDriver();
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products#");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I select {string} from navigation")
    public void i_select_from_navigation(String category) {
        // Wait until the link with the text corresponding to the category is clickable

        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()=\"" + category + "\"]")));

        // Ensure the element is visible
        wait.until(ExpectedConditions.visibilityOf(link));
        System.out.println("Link href: " + link.getText());
        // Try clicking the link using standard click method
        link.click();
    }


    @Then("I should see exactly {int} products listed")
    public void i_should_see_exactly_products_listed(int expectedCount) {
        // Wait until the main tag is visible on the page
        WebElement mainTag = new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOfElementLocated(By.tagName("main")));

        // Find all div children of the main tag
        List<WebElement> divChildren = mainTag.findElements(By.className("card-img-top"));

        // Assert that the number of div elements inside the main tag is exactly as expected
        assertEquals(expectedCount, divChildren.size(), "The main tag should contain exactly " + expectedCount + " div elements.");
    }

    @io.cucumber.java.After
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
