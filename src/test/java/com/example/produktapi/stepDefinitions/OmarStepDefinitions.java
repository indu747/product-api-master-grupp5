package com.example.produktapi.stepDefinitions;

import com.example.produktapi.hooks.SetupHooks;
import io.cucumber.java.en.And;
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
    @Then("have a category-text {string}")
    public void have_a_category_text(String expectedWD) throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div[1]/div/div/h3")));
        String actualElectronicsProductText = driver.findElement(By.xpath("//*[@id=\"main\"]/div[1]/div/div/h3")).getText();
        // Assertions the electronic WD product
        Assertions.assertEquals(expectedWD, actualElectronicsProductText);
    }
    // Omar
    @When("user click a SanDisk SSD product for add to cart")
    public void user_click_a_san_disk_ssd_product_for_add_to_cart() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("card")));
        // Click for added a product SanDisk
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
    // Omar
    @Then("the product total price is {string}")
    public void the_product_total_price_is(String expectedProductSanDiskTotalPrice) {
        String actualProductSanDiskTotalPrice = driver.findElement(By.xpath("//strong[normalize-space()='$109.00']")).getText();
        // Assertions of the total price of product is $109.00
        Assertions.assertEquals(expectedProductSanDiskTotalPrice, actualProductSanDiskTotalPrice);
    }
    // Omar
    @Then("the cart size is shown {string}")
    public void the_cart_size_is_shown(String expectedCartSizeShown1) {
        String actualCartSizeShown1 = driver.findElement(By.id("cartSize")).getText();
        // Assertions for the cart size 1 shows
        Assertions.assertEquals(expectedCartSizeShown1, actualCartSizeShown1);
    }
    // Omar
    @When("user click on delete button")
    public void user_click_on_delete_button() {
        driver.findElement(By.xpath("//*[@id=\"cartList\"]/li[1]/div/button")).click();
    }
    // Omar
    @Then("the product {string} should not be visited")
    public void the_product_should_not_be_visited(String expectNotToBeVisitedProductSanDisk) {
        String actualNotToBeVisitedProductSanDisk = driver.findElement(By.xpath("/html/body/main/div[2]/div[1]")).getText();
        // Assertions for the product "SanDisk SSD PLUS 1TB Internal SSD - SATA III 6 Gb/s" should not be visited after deleted it
        Assertions.assertNotEquals(expectNotToBeVisitedProductSanDisk, actualNotToBeVisitedProductSanDisk);
    }
    // Omar
    @Then("shows zero product on checkout {string}")
    public void shows_zero_product_on_checkout(String expectedCartSizeShown0) {
        String actualCartSizeShown0 = driver.findElement(By.id("cartSize")).getText();
        // Assertions for no product should shows in checkout after delete the product
        Assertions.assertEquals(expectedCartSizeShown0, actualCartSizeShown0);
    }
    // Omar
    @Then("the product total price is zero {string}")
    public void the_product_total_price_is_zero(String expectedProductSanDiskTotalPriceZero) {
        String actualProductSanDiskTotalPriceZero = driver.findElement(By.xpath("//strong[normalize-space()='$0.00']")).getText();
        // Assertions of the total price of product is $0.00
        Assertions.assertEquals(expectedProductSanDiskTotalPriceZero, actualProductSanDiskTotalPriceZero);
    }
    // Omar
    @When("user type Pierced in the search field")
    public void user_type_pierced_in_the_search_field() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div/div/div/h3")));
        // Type "Pierced" in a search field in all categories
        driver.findElement(By.id("search")).sendKeys("Pierced");
    }
    // Omar
    @Then("the product {string} should be visited")
    public void the_product_should_be_visited(String expectedProductPiercedShouldBeVisited) {
        String actualProductPiercedShouldBeVisited = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/h3")).getText();
        // Assertions the Product "Pierced Owl Rose Gold Plated Stainless Steel Double" should be visited after typing "Pierced" in a search field
        Assertions.assertEquals(expectedProductPiercedShouldBeVisited, actualProductPiercedShouldBeVisited);
    }
    // Omar
    @Then("the product, item {string} should not be visited")
    public void the_product_item_should_not_be_visited(String expectNotToBeVisitedProductMensCausal) {
        String actualProductMensCausalShouldNotBeVisited = driver.findElement(By.className("col")).getText();
        // Assertions the product "Mens Casual Premium Slim Fit T-Shirts" should not be visited after typing "Pierced" in the search field
        Assertions.assertNotEquals(expectNotToBeVisitedProductMensCausal, actualProductMensCausalShouldNotBeVisited);
    }
    // Omar
    @When("user type Silicon in the search field")
    public void user_type_silicon_in_the_search_field() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]/div[3]/div/div/h3")));
        // Type "Silicon" in a search field in category Electronics
        driver.findElement(By.id("search")).sendKeys("Silicon");
    }
    // Omar
    @Then("the product Silicon Power {string} should be visited")
    public void the_product_silicon_power_should_be_visited(String expectedProductSiliconPowerShouldBeVisited) {
        String actualProductSiliconPowerShouldBeVisited = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/h3")).getText();
        // Assertions the Product "Silicon Power 256GB SSD 3D NAND A55 SLC Cache Performance Boost SATA III 2.5" should be visited after typing "Silicon" in a search field
        Assertions.assertEquals(expectedProductSiliconPowerShouldBeVisited, actualProductSiliconPowerShouldBeVisited);
    }
    // Omar
    @When("user click on Mens Clothing")
    public void user_click_on_mens_clothing() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]")));
        // Go to the Mens Clothing page
        driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[2]/a")).click();
    }
    // Omar
    @When("user type Mens Casual Slim in the search field")
    public void user_type_mens_casual_slim_in_the_search_field() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        // Type "Mens Casual Slim" in a search field in category Mens clothing
        driver.findElement(By.id("search")).sendKeys("Mens Casual Slim");
    }
    // Omar
    @Then("the product Mens Causal Slim {string} should be visited")
    public void the_product_mens_causal_slim_should_be_visited(String expectedProductMensCasualSlimShouldBeVisited) {
        String actualProductMensCasualSlimShouldBeVisited = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/h3")).getText();
        // Assertions the Product "Mens Casual Slim Fit" should be visited after typing "Silicon" in a search field
        Assertions.assertEquals(expectedProductMensCasualSlimShouldBeVisited, actualProductMensCasualSlimShouldBeVisited);
    }
    // Omar
    @When("user click on Womens Clothing")
    public void user_click_on_womens_clothing() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]")));
        // Go to the Womens Clothing page
        driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[3]/a")).click();
    }
    // Omar
    @When("user type Opna in the search field")
    public void user_type_opna_in_the_search_field() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        // Type "opna" in a search field in category Womens clothing
        driver.findElement(By.id("search")).sendKeys("opna");
    }
    // Omar
    @Then("the product Opna in Womens clothing {string} should be visited")
    public void the_product_opna_in_womens_clothing_should_be_visited(String expectedProductOpnaShouldBeVisited) {
        String actualProductProductOpnaShouldBeVisited = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/h3")).getText();
        // Assertions the Product "Opna Women's Short Sleeve Moisture" should be visited after typing "opna" in a search field
        Assertions.assertEquals(expectedProductOpnaShouldBeVisited, actualProductProductOpnaShouldBeVisited);
    }
    // Omar
    @When("user click on category Jewelery")
    public void user_click_on_category_jewelery() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"main\"]")));
        // Go to the category Jewelery page
        driver.findElement(By.xpath("/html/body/div[1]/div/ul/li[4]/a")).click();
    }
    // Omar
    @When("user type White Gold in the search field")
    public void user_type_white_gold_in_the_search_field() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("search")));
        // Type "White Gold" in a search field in category Jewelery
        driver.findElement(By.id("search")).sendKeys("White Gold");
    }
    // Omar
    @Then("the product White Gold in Jewelery {string} should be visited")
    public void the_product_white_gold_in_jewelery_should_be_visited(String expectedProductWhiteGoldShouldBeVisited) {
        String actualProductWhiteGoldShouldBeVisited = driver.findElement(By.xpath("//*[@id=\"main\"]/div/div/div/h3")).getText();
        // Assertions the Product "White Gold Plated Princess" should be visited after typing "White Gold" in a search field
        Assertions.assertEquals(expectedProductWhiteGoldShouldBeVisited, actualProductWhiteGoldShouldBeVisited);
    }
}


