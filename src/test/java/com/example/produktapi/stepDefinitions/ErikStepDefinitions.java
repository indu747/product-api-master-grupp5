package com.example.produktapi.stepDefinitions;

import com.example.produktapi.hooks.SetupHooks;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
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
    @When("add a product with title {string} to cart")
    public void add_a_product_with_title_to_checkout(String desiredCardTitle) {
        List <WebElement> allCards = driver.findElements(By.className("card"));
        WebElement desiredCard = null;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        for (WebElement card : allCards) {
                // Find the card-title element within the current card
                WebElement cardTitle = card.findElement(By.className("card-title"));
                // Check if the card-title text is "X"
                if (cardTitle.getText().equals(desiredCardTitle)) {
                    desiredCard = card;
                    break;
                }
        }

        WebElement desiredCheckoutButton = desiredCard.findElement(By.tagName("button"));

        //Scroll down to card´s checkout button
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", desiredCheckoutButton);
        wait.until(ExpectedConditions.visibilityOf(desiredCheckoutButton));
        //Add some extra scroll
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0, 100);");
        //Wait for card to be clickable
        wait.until(ExpectedConditions.elementToBeClickable(desiredCheckoutButton));
        //Click it
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", desiredCheckoutButton);

    }
    @Then("the checkout button should have {int} in it")
    public void the_checkout_button_should_have_in_it(Integer expectedAmoundOfGroceries) {
        WebElement checkOutButton = driver.findElement(By.className("btn-warning"));
        WebElement checkOutSpan =  checkOutButton.findElement(By.tagName("span"));
        String checkOutSpanText = checkOutSpan.getText();
        Assertions.assertEquals(expectedAmoundOfGroceries.toString(),checkOutSpanText);

    }
    @When("user clicks the checkout button")
    public void user_clicks_the_checkout_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement checkOutButton = driver.findElement(By.className("btn-warning"));
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, 0);");
        wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", checkOutButton);


        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("cartList")));

    }
    @Then("the user can see selected product {string} in cart")
    public void the_user_can_see_selected_product_in_cart(String expectedProductTitle) {
        WebElement cartList = driver.findElement(By.id("cartList"));
        String actualProductTitle =cartList.findElement(By.tagName("h6")).getText();

        Assertions.assertEquals(expectedProductTitle.replaceAll("'",""),actualProductTitle);


    }
    @Then("the product should have correct {string} in cartlist")
    public void the_product_should_have_correct_in_cartlist(String expectedCategoryName) {
        WebElement cartList = driver.findElement(By.id("cartList"));
        String actualCategoryName = cartList.findElement(By.tagName("small")).getText();

        Assertions.assertEquals(expectedCategoryName.toLowerCase(),actualCategoryName.toLowerCase());
    }
    @Then("the total price is {double}")
    public void the_total_price_is(double expectedTotalPrice) {
        WebElement cartList = driver.findElement(By.id("cartList"));
        double actualTotalPrice = Double.parseDouble(cartList.findElement(By.tagName("strong")).getText().replaceAll("\\$",""));
        Assertions.assertEquals(expectedTotalPrice,actualTotalPrice);
    }
    @When("user enter nothing into {string} field and press enter")
    public void user_enter_nothing_into_field_and_press_enter(String locatorID) {

        WebElement inputField = driver.findElement(By.id(locatorID));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", inputField);
        //Click on the field
        inputField.click();
        inputField.sendKeys(Keys.ENTER);

    }
    @Then("on the {int} field should have {string} as label")
    public void on_the_field_should_have_as_label(Integer nthLabel, String expectedLabelText) {
        List <WebElement> inputFieldLabels = driver.findElements(By.tagName("label"));
        WebElement specificFieldLabel = inputFieldLabels.get(nthLabel);
        Assertions.assertEquals(expectedLabelText,specificFieldLabel.getText());


    }

    @Then("{string} should be displayed for {int} field")
    public void should_be_displayed_for_field(String expectedFeedback, Integer nth) {
        List <WebElement> inputFieldsFeedback = driver.findElements(By.className("invalid-feedback"));
        WebElement specificInputFeedback = inputFieldsFeedback.get(nth);
        //Assert text is correct and is visible
        Assertions.assertTrue(specificInputFeedback.isDisplayed());
        Assertions.assertEquals(expectedFeedback,specificInputFeedback.getText());

    }
    @Then("validation should pass on {int} field")
    public void validation_should_pass_on_field(Integer nth) {
        List <WebElement> inputFields = driver.findElements(By.tagName("input"));
        WebElement specificField = inputFields.get(nth);
        //assert that the backround image displays link to checkbox
        String backgroundImage = specificField.getCssValue("background-image");
        Assertions.assertEquals("url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 8 8'%3e%3cpath fill='%23198754' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3e%3c/svg%3e\")", backgroundImage, "The input field does not have a background image.");


    }

    @When("user enter {string} into {string} field and press enter")
    public void user_enter_into_field_and_press_enter(String validInput, String locatorID) {
        WebElement inputField = driver.findElement(By.id(locatorID));

        inputField.click();
        inputField.sendKeys(validInput);
        inputField.sendKeys(Keys.ENTER);

    }
    @When("user scrolls down to {int} card field")
    public void user_scrolls_down_to_card_field(int nthField) {
        WebElement cardField = driver.findElement(By.id("card"));
        List <WebElement> inputList = cardField.findElements(By.tagName("input"));
        WebElement specificField = inputList.get(nthField);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", specificField);

        //((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight);");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(specificField));

    }
    @When("user enter nothing into {int} field and press enter")
    public void user_enter_nothing_into_field_and_press_enter(int nthField) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cardField = driver.findElement(By.id("card"));

        List <WebElement> inputList = cardField.findElements(By.tagName("input"));
        WebElement specificField = inputList.get(nthField);

        specificField.click();
        specificField.sendKeys(Keys.ENTER);
    }
    @Then("{string} error message should be displayed for {int} field")
    public void error_message_should_be_displayed_for_field(String expectedFeedback, int nthFeedback) {
        WebElement cardField = driver.findElement(By.id("card"));
        List <WebElement> invalidFeedBackList = cardField.findElements(By.className("invalid-feedback"));
        WebElement specificFeedback = invalidFeedBackList.get(nthFeedback);

        //Assert text is displayed
        boolean isFeedBackDisplayed = specificFeedback.isDisplayed();
        Assertions.assertTrue(isFeedBackDisplayed);
        //Assert on text
        Assertions.assertEquals(expectedFeedback, specificFeedback.getText());

    }
    @Then("on the {int} field should have {string} as label in the card section")
    public void on_the_field_should_have_as_label_in_the_card_section(int nthLabel, String expectedLabel) {
        WebElement cardField = driver.findElement(By.id("card"));
        List <WebElement> labelList = cardField.findElements(By.tagName("label"));
        WebElement specificLabel = labelList.get(nthLabel);
        //Assert the label is correct
        Assertions.assertEquals(expectedLabel,specificLabel.getText());
    }
    @When("When user enter {string} into {int} field and press enter")
    public void when_user_enter_into_field_and_press_enter(String validText, int nthField) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement cardField = driver.findElement(By.id("card"));
        List <WebElement> inputList = cardField.findElements(By.tagName("input"));
        WebElement specificField = inputList.get(nthField);
        wait.until(ExpectedConditions.elementToBeClickable(specificField));
        specificField.click();
        specificField.sendKeys(validText);
        specificField.sendKeys(Keys.ENTER);
    }

    @Then("Then validation should pass on {int} field")
    public void then_validation_should_pass_on_field(int nthField) {
        WebElement cardField = driver.findElement(By.id("card"));
        List <WebElement> inputList = cardField.findElements(By.tagName("input"));
        WebElement specificField = inputList.get(nthField);
        //assert that the backround image displays link to checkbox
        String backgroundImage = specificField.getCssValue("background-image");
        Assertions.assertEquals("url(\"data:image/svg+xml,%3csvg xmlns='http://www.w3.org/2000/svg' viewBox='0 0 8 8'%3e%3cpath fill='%23198754' d='M2.3 6.73L.6 4.53c-.4-1.04.46-1.4 1.1-.8l1.1 1.4 3.4-3.8c.6-.63 1.6-.27 1.2.7l-4 4.6c-.43.5-.8.4-1.1.1z'/%3e%3c/svg%3e\")", backgroundImage, "The input field does not have a background image.");

    }


}
