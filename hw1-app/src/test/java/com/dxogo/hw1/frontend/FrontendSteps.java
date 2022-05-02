package com.dxogo.hw1.frontend;

import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.seljup.SeleniumJupiter;
import io.github.bonigarcia.wdm.WebDriverManager;


import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.After;


import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@ExtendWith(SeleniumJupiter.class)
public class FrontendSteps {

    private WebDriver driver;
        
    @When("I want to access {string}")
    public void iNavigateTo(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().setSize(new Dimension(550, 692));
    }

    @And("I click in {string} select button")
    public void iSelectCountry(String country) {
        Select dropdown = new Select(driver.findElement(By.xpath("/html/body/div/div[1]/div[1]/select")));
        dropdown.selectByValue(country);
    }

    @Then("I should see {string}")
    public void iRedirectTo(String element) throws InterruptedException {
        Thread.sleep(3000); // wait for data
        assertThat(driver.findElement(By.cssSelector("h1")).getText(), containsString(element));
    }

    @After()
    public void closeBrowser() { driver.quit(); }
}
