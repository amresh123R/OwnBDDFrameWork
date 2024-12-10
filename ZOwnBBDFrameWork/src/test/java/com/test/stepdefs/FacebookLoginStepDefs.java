package com.test.stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.test.pageobjects.FacebookLoginPage;
import com.test.utility.DriverFactory;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class FacebookLoginStepDefs {

	WebDriver driver;
    FacebookLoginPage facebookLoginPage;

    @Given("I launch the Facebook website on {string} browser")
    public void launchFacebookWebsite(String browserType) {
        driver = DriverFactory.initializeDriver(browserType); // Initialize driver
        driver.get("https://www.facebook.com/");
        facebookLoginPage = new FacebookLoginPage(driver); // Initialize page object
    }

    @When("I enter {string} as username")
    public void enterUsername(String username) {
        facebookLoginPage.enterUsername(username);
    }

    @And("I enter {string} as password")
    public void enterPassword(String password) {
        facebookLoginPage.enterPassword(password);
    }

    @Then("I should see the error message {string}")
    public void verifyErrorMessage(String expectedErrorMessage) {
        facebookLoginPage.clickLogin();
        String actualErrorMessage = facebookLoginPage.getErrorMessage();
        Assert.assertTrue(actualErrorMessage.contains(expectedErrorMessage),"Wrong error message is displayed");

        // Quit the browser
        DriverFactory.quitDriver();
    }
    
}
