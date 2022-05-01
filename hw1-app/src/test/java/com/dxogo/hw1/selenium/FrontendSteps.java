package com.dxogo.hw1.selenium;

import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.seljup.SeleniumJupiter;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static org.junit.jupiter.api.Assertions.*;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import org.junit.jupiter.api.Test;;

@ExtendWith(SeleniumJupiter.class)
public class FrontendSteps {

    private WebDriver driver;
    
    @When("I want to access {string}")
    public void iNavigateTo(String url) {
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(550, 692));
    }

    @Then("The title of the page should be {string}")
    public void theTitleOfThePageShouldBe(String pageTitle) {
        assertEquals(driver.getTitle(), pageTitle);
    }

    @After()
    public void closeBrowser() {
        driver.quit();
    }
}
