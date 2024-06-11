package com.example.produktapi.stepDefinitions;

import com.example.produktapi.hooks.SetupHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MilicaStepDefinitions {
    private WebDriver driver;
    private WebElement searchResult;

    public MilicaStepDefinitions() {
        this.driver = SetupHooks.getDriver();
    }

    @Given("User is on the product page")
    public void user_is_on_the_product_page() {
        driver = new ChromeDriver();
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products");
    }

    @When("After user writes {string} in search bar")
    public void after_user_writes_in_search_bar(String query) {
        WebElement searchBar = driver.findElement(By.id("search"));
        searchBar.sendKeys(query);
        searchBar.submit(); // Or use a search button if necessary
    }

    @Then("{string} should be displayed")
    public void should_be_displayed(String expectedProduct) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        searchResult = wait.until(driver -> driver.findElement(By.xpath("//h3[contains(text(),'" + expectedProduct + "')]"))); // Adjust the XPath to match your product display method
        Assertions.assertTrue(searchResult.isDisplayed());
    }
}
