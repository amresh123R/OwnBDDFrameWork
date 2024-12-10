package com.test.stepdefs;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.test.pageobjects.GoogleLoginPage;
import com.test.utility.DriverFactory;

import io.cucumber.java.After;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class GoogleLoginStepDefs {
	WebDriver driver;
	GoogleLoginPage glp;
	
	
	
	

	@Given("User open the google website {string} in {string} browser")
	public void user_open_the_google_website_in_browser(String url, String browser)
	{
		driver = DriverFactory.initializeDriver(browser);
		driver.get(url);
		glp = new GoogleLoginPage(driver);
			
	}
	
	@When("User type the {string} in search box")
	public void user_type_the_in_search_box(String searchText)
	{
		glp.searchBoxElement(searchText);
	}
	
	@And("Click on search button")
	public void Click_on_search_button()
	{
		glp.searchButtonClick();
	}

	@Then("Verify the searched paged with title {string}")
	public void verify_the_searched_paged_with_title(String expectedPageTitle) throws InterruptedException
	{
		String actualPageTitle = driver.getTitle();
		System.out.println("ActualPageTitle: "+ actualPageTitle);
		//WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		//wait.until(ExpectedConditions.visibilityOf(glp.moreTextElement()));
		//Thread.sleep(10000);
		System.out.println("ActualPageTitleAgain: "+ actualPageTitle);
		Assert.assertTrue(actualPageTitle.contains(expectedPageTitle),"Page Title is not correct");
		
	}
	
	@After
	public void closeBrowser() {
		DriverFactory.quitDriver();
	}
}
