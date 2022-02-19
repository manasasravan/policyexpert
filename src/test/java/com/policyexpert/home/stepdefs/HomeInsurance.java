package com.policyexpert.home.stepdefs;

import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

public class HomeInsurance {

	private static WebDriver webDriver;

	@FindBy(css=".question-row-title .questionset-input .form-control")
	private WebElement titleSel;

	@FindBy(css=".question-row-first-name .questionset-input .form-control")
	private WebElement firstNameTxt;

	@FindBy(css=".question-row-last-name .questionset-input .form-control")
	private WebElement lastNameTxt;

	@FindBy(css=".question-row-what-is-your-date-of .questionset-input .form-control")
	private List<WebElement> dateOfBirthSel;

	@FindBy(css=".question-row-what-is-your-marital .questionset-input .form-control")
	private WebElement maritalStatusSel;


	@FindBy(css=".question-row-what-is-your-occupat .questionset-input .form-control")
	private WebElement occupationTxt;

	@FindBy(css=".question-row-do-you-have-another .questionset-input .btn-group .btn")
	private List<WebElement> otherOccupationBtn;

	@FindBy(css=".question-row-main-phone-number .questionset-input .form-control")
	private WebElement phoneNumberTxt;

	@FindBy(css=".question-row-what-is-your-e-mail .questionset-input .form-control")
	private WebElement emailTxt;

	@FindBy(css=".question-row-you-are-answering-th .questionset-input .btn-group .btn")
	private List<WebElement> financialIssuesBtn;

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
		setSelectValue(titleSel, title);
	}

	@And("I enter the first name {string}")
	public void i_enter_the_first_name(String firstName) {
		setTextBoxValue(firstNameTxt, firstName);
	}

	@And("I enter the last name {string}")
	public void i_enter_the_last_name(String lastName) {
		setTextBoxValue(lastNameTxt, lastName);
	}

	@And("I enter date of birth {string}")
	public void i_enter_date_of_birth(String dateOfBirth) {
		String[] dBirth = dateOfBirth.split("-");
		int i = 0;
		for(WebElement dob: dateOfBirthSel){
			setSelectValue(dob, dBirth[i++]);
		}
	}

	@And("I enter marital status {string}")
	public void i_enter_marital_status(String maritalStatus) {
		setSelectValue(maritalStatusSel, maritalStatus);
	}

	@And("I enter occupation {string}")
	public void i_enter_occupation(String occupation) {
		setTextBoxValue(occupationTxt, occupation);
		occupationTxt.sendKeys(Keys.TAB);
		occupationTxt.sendKeys(Keys.ENTER);
	}


	@And("I enter other occupation {string}")
	public void i_enter_other_occupation(String otherOccupation) {
		Optional<WebElement> webElement = otherOccupationBtn.stream().filter(btn -> otherOccupation.equals(btn.getAccessibleName())).findFirst();
		if(webElement.isPresent()){
			clickButton(webElement.get());
		}
	}

	@And("I enter main phone number {string}")
	public void i_enter_phone_number(String phoneNumber) {
		setTextBoxValue(phoneNumberTxt, phoneNumber);
	}

	@And("I enter email address {string}")
	public void i_enter_email(String email) {
		setTextBoxValue(emailTxt, email);
	}

	@And("I enter financial questions {string}")
	public void i_enter_financial_question(String financialQuestion) {
		Optional<WebElement> webElement = financialIssuesBtn.stream().filter(btn -> financialQuestion.equals(btn.getAccessibleName())).findFirst();
		if(webElement.isPresent()){
			clickButton(webElement.get());
		}
	}

	private void setSelectValue(WebElement webElement, String value){
		Select select = new Select(webElement);
		select.selectByVisibleText(value);
	}

	private void clickButton(WebElement webElement){
		webElement.click();
	}

	private void setTextBoxValue(WebElement webElement, String value){
		webElement.sendKeys(value);
	}

}
