package com.example.produktapi.stepDefinitions;

import com.example.produktapi.hooks.SetupHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.After;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MilicaStepDefinitions {
    private WebDriver driver;
    WebDriverWait wait;

    public MilicaStepDefinitions() {
        this.driver = SetupHooks.getDriver();
    }

    @Given("User is on the product page")
    public void user_is_on_the_product_page() {
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
        WebElement searchResult = wait.until(driver -> driver.findElement(By.xpath("//h3[contains(text(),'" + expectedProduct + "')]"))); // Adjust the XPath to match your product display method
        Assertions.assertTrue(searchResult.isDisplayed());
    }

    @Given("I am on the product page")
    public void i_am_on_the_product_page() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products#");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @When("I select {string} from navigation")
    public void i_select_from_navigation(String category) {
        // Correct the XPath to avoid issues with single quotes
        WebElement link = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//a[contains(@class, 'nav-link') and text()=\"" + category + "\"]")
        ));
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


}
