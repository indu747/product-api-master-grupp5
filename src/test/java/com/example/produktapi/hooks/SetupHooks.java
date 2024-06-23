package com.example.produktapi.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class SetupHooks {

    public static WebDriver driver;
    @Before
    public void setup(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments(
                "--headless",
                "--window-size=1920,1080",
                "--disable-gpu",
                "--no-sandbox"
                );

        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    @After
    public void closeDriver(){
        if (driver != null){
            driver.quit();
        }
    }
    public static WebDriver getDriver() {
        return driver;
    }
}
