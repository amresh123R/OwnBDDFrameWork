package com.test.utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class DriverFactory {

	private static WebDriver driver;

	/**
	 * Initialize WebDriver based on the browser type.
	 * 
	 * @param browserType - The type of browser (chrome, firefox, edge)
	 * @return WebDriver instance
		 */
	
	public static WebDriver initializeDriver(String browserType) {
		if (driver == null) {
			switch (browserType.toLowerCase()) {
			case "chrome":
				//System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
				driver = new ChromeDriver();
				break;

			case "firefox":
				//System.setProperty("webdriver.gecko.driver", "path/to/geckodriver");
				driver = new FirefoxDriver();
				break;

			case "edge":
				//System.setProperty("webdriver.edge.driver", "path/to/edgedriver");
				driver = new EdgeDriver();
				break;

			default:
				throw new IllegalArgumentException("Invalid browser type: " + browserType);
			}
		}

		// Set browser properties (e.g., timeouts, window size)
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		return driver;
	}

	/**
	 * Quit the driver.
	 */
	
	public static void quitDriver() {
		
			
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}

}
