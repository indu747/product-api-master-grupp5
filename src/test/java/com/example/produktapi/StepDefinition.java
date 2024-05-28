package com.example.produktapi;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinition {
    WebDriver driver;
    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @After
    public void closeDriver(){
        if (driver != null){
            driver.quit();
        }
    }
    @When("User visits google.se")
    public void user_visits_google_se() {
       driver.get("https://www.google.se/");
    }
    @Then("URL is google.se")
    public void url_is_google_se() {
        String currentURL =driver.getCurrentUrl();
        Assert.assertEquals(currentURL,"https://www.google.se/");
    }

    @Given("user visit https:\\/\\/webshop-agil-testautomatiserare.netlify.app\\/")
    public void user_visit_https_webshop_agil_testautomatiserare_netlify_app() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
    }

    @Then("the title should be {string}")
    public void the_title_should_be(String expectedTitle) {
        String actualTitle = driver.getTitle();
        assertEquals(expectedTitle, actualTitle);
    }


}
