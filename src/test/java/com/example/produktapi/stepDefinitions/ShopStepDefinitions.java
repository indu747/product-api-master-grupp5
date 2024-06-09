package com.example.produktapi.stepDefinitions;

import com.example.produktapi.hooks.SetupHooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;

public class ShopStepDefinitions {

    private WebDriver driver;

    public ShopStepDefinitions() {
        this.driver = SetupHooks.getDriver();
    }

    @Given("User is on {string}")
    public void user_is_on(String shopPage) {
        driver.get(shopPage);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("card")));
    }
    @When("user clicks on category {string}")
    public void user_clicks_on_category(String category) {
        //Find the category Link
        WebElement categoryLink = driver.findElement(By.xpath("//a[normalize-space()='Jewelery']"));
        //Click category link
        categoryLink.click();
        //Wait until URL & category is correct
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://webshop-agil-testautomatiserare.netlify.app/products#"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("card")));

    }

    @Then("{int} products should be displayed")
    public void products_should_be_displayed(Integer expectedAmountOfProducts) {
        //Get all products into a list
        List <WebElement> allProducts = driver.findElements(By.className("card"));
        //Count size of product list
        int amountOfProducts =  allProducts.size();
        //Assert list is the same size it should be
        Assertions.assertEquals(expectedAmountOfProducts,amountOfProducts);

    }

    @Then("the {int} card should have {string} as image link")
    public void the_card_should_have_as_image_link(Integer nthCard, String expectedImageLink) {
    List <WebElement> productCards = driver.findElements(By.className("card"));
    WebElement specificProductCard = productCards.get(nthCard);
    //Get the image from nth card
    WebElement image = specificProductCard.findElement(By.tagName("img"));
    //Get the image link and assert on it
    String imageLink = image.getAttribute("src");
    Assertions.assertEquals(expectedImageLink,imageLink);

    }
    @Then("the {int} card should have {string} as alt text")
    public void the_card_should_have_as_alt_text(Integer nthCard, String expectedImgAltText) {
        List <WebElement> productCards = driver.findElements(By.className("card"));
        WebElement specificProductCard = productCards.get(nthCard);
        //Get image of specific card
        WebElement image = specificProductCard.findElement(By.tagName("img"));
        //Get the image link and assert on it
        String actualImgAltText = image.getAttribute("alt");
        Assertions.assertEquals(expectedImgAltText,actualImgAltText);
    }

    @Then("the {int} card should have visible image")
    public void the_card_should_have_visible_image(Integer nthCard) {
        List <WebElement> productCards = driver.findElements(By.className("card"));
        WebElement specificProductCard = productCards.get(nthCard);
        //Get image of specific card
        WebElement image = specificProductCard.findElement(By.tagName("img"));
        //Assert visibility of image
        boolean imageIsVisible = image.isDisplayed();
        Assertions.assertTrue(imageIsVisible);
    }
    @Then("the {int} card should have {string} as title")
    public void the_card_should_have_as_title(Integer nthCard, String expectedProductTitle) {
        List <WebElement> productCards = driver.findElements(By.className("card"));
        WebElement specificProductCard = productCards.get(nthCard);

        //Get title and assert against expected title
        String actualProductTitle = specificProductCard.findElement(By.className("card-title")).getText();
        Assertions.assertEquals(expectedProductTitle,actualProductTitle);
    }
    @Then("the {int} card should have \"{double} as price")
    public void the_card_should_have_as_price(Integer nthCard, Double expectedPrice) {
        List <WebElement> productCards = driver.findElements(By.className("card"));
        WebElement specificProductCard = productCards.get(nthCard);

        //Get price of card and remove everything that is not digit or decimal
        String actualPriceText = specificProductCard.findElement(By.className("fs-5")).getText();
        String cleanedPrice = actualPriceText.replaceAll("[^\\d.]", "");
        //Assert against the actual price
        double actualPrice = Double.parseDouble(cleanedPrice);
        Assertions.assertEquals(expectedPrice,actualPrice);

    }
    @Then("the {int} card should have {string} as price")
    public void the_card_should_have_as_price(Integer nthCard, String expectedPrice) {

    }
    @Then("the {int} card should have {string} as description")
    public void the_card_should_have_as_description(Integer nthCard, String expectedDescription) {
        List <WebElement> productCards = driver.findElements(By.className("card"));
        WebElement specificProductCard = productCards.get(nthCard);

        //Get description of card and assert againt expected description
        String actualDescription = specificProductCard.findElement(By.className("card-text")).getText();
    }
    @Then("the {int} card should have a checkout button")
    public void the_card_should_have_a_checkout_button(Integer nthCard) {
        //Get the nth card from displayed cards
        List <WebElement> productCards = driver.findElements(By.className("card"));
        WebElement specificProductCard = productCards.get(nthCard);
        //Get the buyButton
        WebElement addToCartButton = specificProductCard.findElement(By.tagName("button"));
        //Check button is found and is displayed
        Assertions.assertNotNull(addToCartButton);
        Assertions.assertTrue(addToCartButton.isDisplayed(), "Checkout button is not visible in the specified card");
    }
    @Then("the {int} card checkout button should have text {string}")
    public void the_card_checkout_button_should_have_text(Integer nthCard, String expectedButtonText) {
        List <WebElement> productCards = driver.findElements(By.className("card"));
        WebElement specificProductCard = productCards.get(nthCard);
        //Get the add to card button inside specific card
       String actualButtonText = specificProductCard.findElement(By.tagName("button")).getText();
       //Assert button text against expected text
        Assertions.assertEquals(expectedButtonText,actualButtonText);
    }


}
