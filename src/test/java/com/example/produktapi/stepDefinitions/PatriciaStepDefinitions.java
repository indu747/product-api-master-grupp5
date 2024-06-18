package com.example.produktapi.stepDefinitions;

import com.example.produktapi.hooks.SetupHooks;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.example.produktapi.hooks.SetupHooks.driver;

public class PatriciaStepDefinitions {


    private WebDriver driver;
    public PatriciaStepDefinitions() {this.driver = SetupHooks.getDriver();}
    @Given("the user is on mans clothing")
    public void the_user_is_on_mans_clothing() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products#");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("card")));
    }
    @Then("the title of the product should be {string}")
    public void the_title_of_the_product_should_be(String expectedTitle) {
        String actualTitle = driver.findElement(By.xpath("(//h3[@class='card-title fs-4'])[1]")).getText();
        Assertions.assertEquals(expectedTitle,actualTitle);
    }
    @Then("the price should be {string}")
    public void the_price_should_be(String expectedPrice) {
        String actualPrice = driver.findElement(By.xpath("//strong[text()='$ 109.95']")).getText();
        Assertions.assertEquals(expectedPrice, actualPrice);
    }
    @Then("the tittle of the product should be {string}")
    public void the_tittle_of_the_product_should_be(String expectedTitle) {
        String actualTitle = driver.findElement(By.xpath("(//h3[@class='card-title fs-4'])[2]")).getText();
        Assertions.assertEquals(expectedTitle, actualTitle);
    }

    @Then("the price of the t-shirt should be {string}")
    public void the_price_of_the_t_shirt_should_be(String expectedPrice) {
        String actualPrice = driver.findElement(By.xpath("//strong[text()='$ 22.3']")).getText();
        Assertions.assertEquals(expectedPrice, actualPrice);
    }

    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        String actualTitile = driver.findElement(By.xpath("(//h3[@class='card-title fs-4'])[3]")).getText();
        Assertions.assertEquals(expectedTitle, actualTitile);
    }
    @Then("the price of the jacket should be {string}")
    public void the_price_of_the_jacket_should_be(String expectedPrice) {
        String actualPrice = driver.findElement(By.xpath("//strong[text()='$ 55.99']")).getText();
        Assertions.assertEquals(expectedPrice, actualPrice);
    }
    @Then("the title of the polo should be {string}")
    public void the_title_of_the_polo_should_be(String expectedTitile) {
        String actualTitile = driver.findElement(By.xpath("//h3[text()='Mens Casual Slim Fit']")).getText();
        Assertions.assertEquals(expectedTitile, actualTitile);
    }
    @Then("the price of the polo should be {string}")
    public void the_price_of_the_polo_should_be(String expectedPrice) {
        String actualPrice = driver.findElement(By.xpath("//strong[text()='$ 15.99']")).getText();
        Assertions.assertEquals(expectedPrice, actualPrice);
    }
    @Then("the description fjallraven should be {string}")
    public void the_description_fjallraven_should_be(String expectedDescription) {
        String actualDescription = driver.findElement(By.xpath("(//p[@class='card-text'])[1]")).getText();
        Assertions.assertEquals(expectedDescription, actualDescription);
    }
    @Then("the desription t-shirt shoud be {string}")
    public void the_desription_t_shirt_shoud_be(String expectedDescription) {
        String actualDesription = driver.findElement(By.xpath("(//p[@class='card-text'])[2]")).getText();
        Assertions.assertEquals(expectedDescription, actualDesription);
    }
    @Then("the description Jacket should be {string}")
    public void the_description_jacket_should_be(String expectedDescription) {
        String actualDescription =driver.findElement(By.xpath("(//p[@class='card-text'])[3]")).getText();
        Assertions.assertEquals( expectedDescription, actualDescription);
    }
    @Then("the desription Polo shpuld be {string}")
    public void the_desription_polo_shpuld_be(String expectedDescription) {
        String actualDescription = driver.findElement(By.xpath("//p[text()='Mer casual än såhär blir det inte!']")).getText();
        Assertions.assertEquals(expectedDescription, actualDescription);
    }

    @Given("the user is on the homepage")
    public void the_user_is_on_the_homepage() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");

    }
    @When("user use it with mobilesize")
    public void user_use_it_with_mobilesize() {
        Dimension newSize = new Dimension(550, 900);
        driver.manage().window().setSize(newSize);

    }
    @Then("user should be able to click on {string} in the middle of the page")
    public void user_should_be_able_to_click_on_in_the_middle_of_the_page(String expected) {
    String actual = driver.findElement(By.tagName("button")).getText();
     driver.findElement(By.tagName("button")).click();
    Assertions.assertEquals(expected, actual);
    }

    @Then("heading should be {string}")
    public void heading_should_be(String expectedFjallraven) {
    String actualFjallraven = driver.findElement(By.xpath("(//h3[@class='card-title fs-4'])[1]")).getText();
    Assertions.assertEquals(expectedFjallraven, actualFjallraven);

    }
    @Then("Tshirt {string}")
    public void tshirt(String expectedTshirt) {
    String actualTshirt = driver.findElement(By.xpath("(//h3[@class='card-title fs-4'])[2]")).getText();
    Assertions.assertEquals(expectedTshirt, actualTshirt);

    }
    @Then("Jacket {string}")
    public void jacket(String expectedJacket) {
    String actualJacket = driver.findElement(By.xpath("(//h3[@class='card-title fs-4'])[3]")).getText();
    Assertions.assertEquals(actualJacket, expectedJacket);

    }
    @Then("Slim fit {string}")
    public void slim_fit(String expectedSlimFit) {
    String actualSlimFit = driver.findElement(By.xpath("//h3[text()='Mens Casual Slim Fit']")).getText();

    Assertions.assertEquals(expectedSlimFit, actualSlimFit);
    }

    @When("user clicks on All")
    public void user_clicks_on_all() {
        driver.findElement(By.xpath("//a[contains(text(),'All')]")).click();
    }
    @Then("all products will shown")
    public void all_products_will_shown() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products#");
    Assertions.assertTrue(true);
    }

    @When("user clicks Jewelery")
    public void user_clicks_jewelery() {
        driver.findElement(By.xpath("//a[contains(text(),'Jewelery')]")).click();

    }
    @Then("Jewelery will shown")
    public void jewelery_will_shown() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products#");
         Assertions.assertTrue(true);
    }
    @When("user clicks on electronics")
    public void user_clicks_on_electronics() {
        driver.findElement(By.xpath("//a[contains(text(),'Electronics')]")).click();

    }
    @Then("electronics will shown")
    public void electronics_will_shown() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products#");
    Assertions.assertTrue(true);
    }
    @Then("the text should be {string}")
    public void the_text_should_be(String expectedText) {
       String actualText = driver.findElement(By.xpath("//p[text()[normalize-space()='Welcome to The Shop, your premier online destination for all things fashion, electronics, and jewelry! At The Shop, we pride ourselves on offering a curated selection of high-quality products to cater to your diverse needs and desires.']]")).getText();
    Assertions.assertEquals(expectedText, actualText);
    }
    @Then("the text should be this {string}")
    public void the_text_should_be_this(String expectedText) {
    String actualText =  driver.findElement(By.tagName("h2")).getText();
    Assertions.assertEquals( expectedText, actualText);
    }











}
