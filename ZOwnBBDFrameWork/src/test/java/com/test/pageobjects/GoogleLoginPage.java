package com.test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class GoogleLoginPage {
	
	WebDriver driver;
	
	public By searchBox = By.xpath("//textarea[@id='APjFqb']");
	public By searchButton = By.name("btnK");
	public By moreText = By.xpath("//div[@class='Lu57id']");
	
	public GoogleLoginPage(WebDriver driver)
	{
		this.driver = driver;
	}
	
	public void searchBoxElement(String searchText) {
		driver.findElement(searchBox).sendKeys(searchText);
	}
	
	public void searchButtonClick() {
		driver.findElement(searchButton).submit();
	}

	public WebElement moreTextElement() {
		return driver.findElement(moreText);
	}
}
