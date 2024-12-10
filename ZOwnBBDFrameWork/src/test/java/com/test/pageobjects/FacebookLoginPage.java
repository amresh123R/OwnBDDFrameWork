package com.test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FacebookLoginPage {

	WebDriver driver;

    // Locators
    private By usernameField = By.id("email");
    private By passwordField = By.id("pass");
    private By loginButton = By.name("login");
    private By errorMessage = By.xpath("//div[@class='_9axz']");

    // Constructor
    public FacebookLoginPage(WebDriver driver) {
        this.driver = driver;
    }

    // Actions
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        driver.findElement(loginButton).click();
    }

    public String getErrorMessage() {
    	
		String errorMsg = driver.findElement(errorMessage).getText();
    	System.out.println("Error Message: "+errorMsg);
    	
        return errorMsg;
    }
}
