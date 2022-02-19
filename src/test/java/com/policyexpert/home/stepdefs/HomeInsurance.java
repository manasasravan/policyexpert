package com.policyexpert.home.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class HomeInsurance {

	private static WebDriver webDriver;

	@FindBy(css=".question-row-title .questionset-input .form-control")
	private WebElement titleSel;

	@BeforeAll
	public static void initAll(){
		String driverProperty = "webdriver.chrome.driver";
		String driverLocation = System.getProperty(driverProperty);

		if(driverLocation == null || driverLocation.isEmpty()){
			System.setProperty(driverProperty, "src/test/resources/drivers/chromedriver.exe");
		}
		webDriver = new ChromeDriver();
		webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@Before
	public void init(){
		PageFactory.initElements(webDriver, this);
	}

	@Given("I open the home insurance page {string}")
	public void i_open_the_home_insurance_page(String website) {
		webDriver.get(website);
	}

	@And("I enter the title {string}")
	public void i_enter_the_title(String title) {
		Select select = new Select(titleSel);
		select.selectByVisibleText(title);
	}

}
