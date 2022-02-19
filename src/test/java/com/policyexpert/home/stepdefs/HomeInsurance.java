package com.policyexpert.home.stepdefs;

import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;

public class HomeInsurance {

	private static WebDriver webDriver;

	@BeforeAll
	public static void initAll(){
		String driverProperty = "webdriver.chrome.driver";
		String driverLocation = System.getProperty(driverProperty);

		if(driverLocation == null || driverLocation.isEmpty()){
			System.setProperty(driverProperty, "src/test/resources/drivers/chromedriver.exe");
		}
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		PageFactory.initElements(webDriver, new HomeInsurance());
	}

	@Given("I open the home insurance page {string}")
	public void i_open_the_home_insurance_page(String website) {
		webDriver.get(website);
	}
}
