package com.example.produktapi.stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.example.produktapi.hooks.SetupHooks.driver;

public class PatriciaStepDefinitions {

    private WebDriver driver;

    @Given("the user is on mans clothing")
    public void the_user_is_on_mans_clothing() {
        driver = new ChromeDriver();
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





    @After
    public void closeDriver(){
        if (driver != null){
            driver.quit();
        }

}


}
