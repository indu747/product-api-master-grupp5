package com.example.produktapi;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class StepDefinition {
    WebDriver driver;
    @Before
    public void setup(){
        driver = new FirefoxDriver();
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

}
