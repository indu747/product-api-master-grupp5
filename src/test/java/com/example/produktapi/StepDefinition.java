package com.example.produktapi;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StepDefinition {
    WebDriver driver;
    @Before
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--headless");
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
        options.addArguments("--disable-gpu"); // Applicable to Windows OS
        options.addArguments("--remote-debugging-port=9222"); // Remote debugging port
        //options.setBinary("/usr/bin/google-chrome"); // NEEDED FOR CI/CD? Otherwise remove*/
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void closeDriver(){
        if (driver != null){
            driver.quit();
        }
    }
//Erik Östlind
    @Given("user is on homepage")
    public void user_is_on_homepage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("header")));

    }

    //Erik Östlind
    @Then("navbar has four links")
    public void navbar_has_four_links() {
        //Get navbar element
        WebElement navBar = driver.findElement(By.tagName("header"));
        //Put them in a list
        List<WebElement> navBarLinks  = navBar.findElements(By.tagName("a"));
        //Get the size of navbar
        int amountOfLinks = navBarLinks.size();
        Assertions.assertEquals(4,amountOfLinks);
    }
    //Erik Östlind
    @Then("the {int} contains a {string}")
    public void the_contains_a(Integer nthItem, String linkText) {
        //Get navbar element
        WebElement navBar = driver.findElement(By.tagName("header"));
        //Put them in a list
        List<WebElement> navBarLinkList  = navBar.findElements(By.tagName("a"));
        //Get the nth item
        WebElement specificNavBarElement = navBarLinkList.get(nthItem);
        //Get the link text
        String navBarItemText = specificNavBarElement.getText();
        //Assert on text
        Assertions.assertEquals(linkText,navBarItemText );

    }
    //Erik Östlind
    @Then("the {int} contain link to {string}")
    public void the_contain_link_to(Integer nthItem, String href) {
        //Get navbar element
        WebElement navBar = driver.findElement(By.tagName("header"));
        //Put them in a list
        List<WebElement> navBarLinkList  = navBar.findElements(By.tagName("a"));
        //Get the nth item
        WebElement specificNavBarElement = navBarLinkList.get(nthItem);
        //Get the specific href
        String navBarItemHref = specificNavBarElement.getAttribute("href");
        //Assert on Href
        Assertions.assertEquals(href,navBarItemHref);

    }
    //Erik Östlind
    @When("user clicks on the {int}")
    public void user_clicks_on_the(Integer nthItem) {
        //Get navbar element
        WebElement navBar = driver.findElement(By.tagName("header"));
        //Put them in a list
        List<WebElement> navBarLinkList  = navBar.findElements(By.tagName("a"));
        //Get the nth item
        WebElement specificNavBarElement = navBarLinkList.get(nthItem);
        specificNavBarElement.click();

    }
    //Erik Östlind
    @Then("user should get taken to {string}")
    public void user_should_get_taken_to(String href) {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe(href));
    }


    }
