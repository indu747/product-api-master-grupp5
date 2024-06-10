package com.example.produktapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class WomenClothingApi {

    @Autowired
    private TestRestTemplate restTemplate;

    private ResponseEntity<String> response;

    @When("I request the {string} category")
    public void i_request_the_category(String category) {
        response = restTemplate.getForEntity("/products/categories/" + category, String.class);
    }

    @Then("the response status should be {int}")
    public void the_response_status_should_be(int status) {
        assertEquals(status, response.getStatusCode().value());
    }

    @Then("the response should contain {string}")
    public void the_response_should_contain(String expectedContent) {
        assertTrue(Objects.requireNonNull(response.getBody()).contains(expectedContent));
    }
}
