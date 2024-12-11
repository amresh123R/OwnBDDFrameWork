package com.test.stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.test.utility.DriverFactory;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class Amazon {
	
	WebDriver driver;
	
	@Given("Open the amazon website {string} in {string} browser")
	public void open_the_amazon_website_in_browser(String url, String browser)
	{
		driver = DriverFactory.initializeDriver(browser);
		driver.get(url);
	}
	

	@Then("Validate the title of amazon website with expected title {string}")
	public void validate_the_title_of_amazon_website_with_expected_title(String expectedTitle)
	{
		String actualAmazonTitle = driver.getTitle();
		System.out.println("ActualAmazonTitle: "+ actualAmazonTitle);
		Assert.assertTrue(actualAmazonTitle.contains(expectedTitle));
	}
}
