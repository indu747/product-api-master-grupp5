package com.example.produktapi.stepDefinitions;

import com.example.produktapi.hooks.SetupHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class OmarStepDefinitions {

    private final WebDriver driver;

    public OmarStepDefinitions() {
        this.driver = SetupHooks.getDriver();
    }
    // Omar
    @Given("user visits webshop-agil-testautomatiserare.netlify.app\\/products")
    public void user_visits_webshop_agil_testautomatiserare_netlify_app_products() {
        // Navigate to products
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products");
    }
    // Omar
    @When("user click on Electronics")
    public void user_click_on_electronics() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div[1]/div/div/h3")));
        // Go to the electronic page
        driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[5]/a")).click();
    }
    // Omar
    @Then("have a catergory-text {string}")
    public void have_a_catergory_text(String expectedWD) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div[1]/div/div/h3")));
        String actualElectronicsProductText = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/h3")).getText();
        // Assertions the electronic SanDisk product
        Assertions.assertEquals(expectedWD, actualElectronicsProductText);
    }
    // Omar
    @When("added to cart a product SanDisk SSD")
    public void added_to_cart_a_product_san_disk_ssd() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div[2]/div/div/button")));
        // Added a product SanDisk
        driver.findElement(By.xpath("//*[@id=\"main\"]/div[2]/div/div/button")).click();
    }
    // Omar
    @Then("shows one product on checkout {string}")
    public void shows_one_product_on_checkout(String expected1) {
        String actualCheckoutTotalItem = driver.findElement(By.id("buttonSize")).getText();
        // Assertions 1 product on checkout
        Assertions.assertEquals(expected1, actualCheckoutTotalItem);
    }
    // Omar
    @When("user click on checkout button")
    public void user_click_on_checkout_button() {
        driver.findElement(By.className("text-end")).click();
    }
    // Omar
    @Then("user get on checkout page have text {string}")
    public void user_get_on_checkout_page_have_text(String expectedCheckoutFormText) {
        String actualCheckoutFormText = driver.findElement(By.xpath("/html/body/main/div[1]/h2")).getText();
        // Assertions on the text on checkout page, Checkout form
        Assertions.assertEquals(expectedCheckoutFormText, actualCheckoutFormText);
    }
    // Omar
    @Then("the product name is {string}")
    public void the_product_name_is(String expectedProductNameSanDisk) {
        String actualProductNameSanDisk = driver.findElement(By.xpath("//h6[@class='my-0 w-75']")).getText();
        // Assertions the name of product, SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s
        Assertions.assertEquals(expectedProductNameSanDisk, actualProductNameSanDisk);
    }
    // Omar
    @Then("the product price is {string}")
    public void the_product_price_is(String expectedProductSanDiskPrice) {
        String actualProductSanDiskPrice = driver.findElement(By.xpath("//*[@id=\"cartList\"]/li[1]/span")).getText();
        // Assertions the price of product, $109
        Assertions.assertEquals(expectedProductSanDiskPrice, actualProductSanDiskPrice);
    }
    // Omar
    @Then("the product Total \\(USD) is {string}")
    public void the_product_total_usd_is(String expectedProductTotalUsdText) {
        String actualProductTotalUsdText = driver.findElement(By.xpath("//span[normalize-space()='Total (USD)']")).getText();
        // Assertions on the text name is Total (USD)
        Assertions.assertEquals(expectedProductTotalUsdText, actualProductTotalUsdText);
    }
    @Then("the product total price is {string}")
    public void the_product_total_price_is(String expectedProductSanDiskTotalPrice) {
        String actualProductSanDiskTotalPrice = driver.findElement(By.xpath("//strong[normalize-space()='$109.00']")).getText();
        // Assertions of the total price of product is $109.00
        Assertions.assertEquals(expectedProductSanDiskTotalPrice, actualProductSanDiskTotalPrice);
    }
}
