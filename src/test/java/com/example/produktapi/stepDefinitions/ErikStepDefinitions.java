package com.example.produktapi.stepDefinitions;

import com.example.produktapi.hooks.SetupHooks;
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
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ErikStepDefinitions {
    private WebDriver driver;

    public ErikStepDefinitions() {
        this.driver = SetupHooks.getDriver();
    }

    private static final Map<String, String> PAGE_URLS = Map.of(
            "homepage", "https://webshop-agil-testautomatiserare.netlify.app/",
            "shop_page", "https://webshop-agil-testautomatiserare.netlify.app/products",
            "checkout_page", "https://webshop-agil-testautomatiserare.netlify.app/checkout",
            "about_page", "https://webshop-agil-testautomatiserare.netlify.app/about"
    );

    //HOMEPAGE STEPS
    @Then("h2 is set to {string}")
    public void h2_is_set_to(String expectedH2) {
       WebElement homePageContainer =driver.findElement(By.className("my-5"));
       Assertions.assertEquals(expectedH2,homePageContainer.findElement(By.tagName("h2")).getText());
    }
    @Then("lead is set to {string}")
    public void lead_is_set_to(String expectedLead) {
        WebElement homePageContainer =driver.findElement(By.className("my-5"));
        Assertions.assertEquals(expectedLead,homePageContainer.findElement(By.tagName("p")).getText());
    }
    @Then("{string} button exist with correct text")
    public void button_exist(String expectedButtonText) {
        WebElement homePageContainer =driver.findElement(By.className("my-5"));
        Assertions.assertEquals(expectedButtonText,homePageContainer.findElement(By.tagName("button")).getText());

    }
    @Then("Image is displayed")
    public void image_is_displayed() {
        WebElement homePageContainer =driver.findElement(By.className("my-5"));
        boolean isImageDisplayed = homePageContainer.findElement(By.tagName("img")).isDisplayed();
        Assertions.assertTrue(isImageDisplayed);
    }

    @When("user clicks on {string} - button")
    public void user_clicks_on_button(String string) {
        WebElement homePageContainer =driver.findElement(By.className("my-5"));
        homePageContainer.findElement(By.tagName("button")).click();
    }

    @Then("user should get taken to Shop page")
    public void user_should_get_taken_to_shop_page() {
        WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://webshop-agil-testautomatiserare.netlify.app/products.html"));
    }

    @Then("product cards should be displayed")
    public void product_cards_should_be_displayed() {
       WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.presenceOfElementLocated(By.className("card")));
    }
    //NAVBAR STEPS
    //Erik Östlind
    @Given("user is on {string}")
    public void user_is_on(String pageName) {
        String url = PAGE_URLS.get(pageName);
        if (url != null) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.get(url);
            wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("header")));
        } else {
            throw new IllegalArgumentException("Unknown page name: " + pageName);
        }
    }

    @Then("navbar has {int} links")
    public void navbar_has_links(Integer int1) {
        WebElement navBar = driver.findElement(By.tagName("header"));
        //Put them in a list
        List<WebElement> navBarLinks  = navBar.findElements(By.tagName("a"));
        //Get the size of navbar
        int amountOfLinks = navBarLinks.size();
        Assertions.assertEquals(int1,amountOfLinks);
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
    //Erik Östlind
    @Given("user is on Shop Page")
    public void user_is_on_shop_page() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/products");
    }
    //Erik Östlind
    @Given("user is on Checkout Page")
    public void user_is_on_checkout_page() {
        driver.get("https://webshop-agil-testautomatiserare.netlify.app/checkout");
    }

    //Erik Östlind
    @Given("User is on page {string}")
    public void user_is_on_page(String shopPage) {
        driver.get(shopPage);
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("card")));
    }
    //SHOP STEPS
    //Erik Östlind
    @When("user clicks on category {string}")
    public void user_clicks_on_category(String category) {
        //Find the category Link
        WebElement categoryLink = driver.findElement(By.xpath("//a[normalize-space()='"+category+"']"));
        //Click category link
        categoryLink.click();
        //Wait until URL & category is correct
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlToBe("https://webshop-agil-testautomatiserare.netlify.app/products#"));
        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("card")));

    }
    //Erik Östlind
    @Then("{int} products should be displayed")
    public void products_should_be_displayed(Integer expectedAmountOfProducts) {
        //Get all products into a list
        List <WebElement> allProducts = driver.findElements(By.className("card"));
        //Count size of product list
        int amountOfProducts =  allProducts.size();
        //Assert list is the same size it should be
        Assertions.assertEquals(expectedAmountOfProducts,amountOfProducts);

    }
    //Erik Östlind
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
    //Erik Östlind
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
    //Erik Östlind
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
    //Erik Östlind
    @Then("the {int} card should have {string} as title")
    public void the_card_should_have_as_title(Integer nthCard, String expectedProductTitle) {
        List <WebElement> productCards = driver.findElements(By.className("card"));
        WebElement specificProductCard = productCards.get(nthCard);

        //Get title and assert against expected title
        String actualProductTitle = specificProductCard.findElement(By.className("card-title")).getText();
        Assertions.assertEquals(expectedProductTitle,actualProductTitle);
    }

    @Then("the {int} card should have {string} as price")
    public void the_card_should_have_as_price(Integer nthCard, String expectedPrice) {
        List <WebElement> productCards = driver.findElements(By.className("card"));
        WebElement specificProductCard = productCards.get(nthCard);

        //Get price of card and remove everything that is not digit or decimal
        String actualPriceText = specificProductCard.findElement(By.className("fs-5")).getText();
        //Assert against the actual price
        Assertions.assertEquals(expectedPrice,actualPriceText);
    }

    //Erik Östlind
    @Then("the {int} card should have {string} as description")
    public void the_card_should_have_as_description(Integer nthCard, String expectedDescription) {
        List <WebElement> productCards = driver.findElements(By.className("card"));
        WebElement specificProductCard = productCards.get(nthCard);

        //Get description of card and assert againt expected description
        String actualDescription = specificProductCard.findElement(By.className("card-text")).getText();
        Assertions.assertEquals(expectedDescription,actualDescription);
    }
    //Erik Östlind
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
    //Erik Östlind
    @Then("the {int} card checkout button should have text {string}")
    public void the_card_checkout_button_should_have_text(Integer nthCard, String expectedButtonText) {
        List <WebElement> productCards = driver.findElements(By.className("card"));
        WebElement specificProductCard = productCards.get(nthCard);
        //Get the add to card button inside specific card
        String actualButtonText = specificProductCard.findElement(By.tagName("button")).getText();
        //Assert button text against expected text
        Assertions.assertEquals(expectedButtonText,actualButtonText);
    }

    @When("user searches for {string}")
    public void user_searches_for(String title) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("card")));
        WebElement searchBox = driver.findElement(By.id("search"));
        searchBox.sendKeys(title);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.className("card")));

    }

    @Then("only cards containing {string} should be visible")
    public void only_cards_containing_should_be_visible(String expectedTitle) {
        // Adjust locator as needed

        List <WebElement> cards = driver.findElements(By.className("card"));
        List<String> cardTitles = new ArrayList<>();

        for (WebElement card : cards) {
            List<WebElement> titles = card.findElements(By.className("card-title"));
            for (WebElement cardTitle : titles) {
                cardTitles.add(cardTitle.getText().toLowerCase());
            }
        }
        for (String cardTitle:cardTitles){
            Assertions.assertTrue(cardTitle.contains(expectedTitle));
        }


    }
}
