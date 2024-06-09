package com.example.produktapi.stepDefinitions;

import com.example.produktapi.hooks.SetupHooks;
import org.openqa.selenium.WebDriver;

public class CheckOutStepDefinitions {

    private WebDriver driver;

    public CheckOutStepDefinitions() {
        this.driver = SetupHooks.getDriver();
    }
}
