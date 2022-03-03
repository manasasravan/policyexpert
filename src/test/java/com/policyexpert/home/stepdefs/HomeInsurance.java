package com.policyexpert.home.stepdefs;

import io.cucumber.java.AfterAll;
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

    @FindBy(css = ".question-row-title .questionset-input .form-control")
    private WebElement titleSel;

    @FindBy(css = ".question-row-first-name .questionset-input .form-control")
    private WebElement firstNameTxt;

    @FindBy(css = ".question-row-last-name .questionset-input .form-control")
    private WebElement lastNameTxt;

    @FindBy(css = ".question-row-what-is-your-date-of .questionset-input .form-control")
    private List<WebElement> dateOfBirthSel;

    @FindBy(css = ".question-row-what-is-your-marital .questionset-input .form-control")
    private WebElement maritalStatusSel;

    @FindBy(css = ".question-row-what-is-your-occupat .questionset-input .form-control")
    private WebElement occupationTxt;

    @FindBy(css = ".question-row-what-is-your-occupat .questionset-input .list-group")
    private WebElement occupationLG;

    @FindBy(css = ".question-row-do-you-have-another .questionset-input .btn-group .btn")
    private List<WebElement> otherOccupationBtn;

    @FindBy(css = ".question-row-main-phone-number .questionset-input .form-control")
    private WebElement phoneNumberTxt;

    @FindBy(css = ".question-row-what-is-your-e-mail .questionset-input .form-control")
    private WebElement emailTxt;

    @FindBy(css = ".question-row-you-are-answering-th .questionset-input .btn-group .btn")
    private List<WebElement> financialIssuesBtn;

    @FindBy(css = ".question-row-address-of-the-prope .questionset-input .list-group")
    private WebElement addressLG;

    @FindBy(css = ".question-row-address-of-the-prope .questionset-input .form-control")
    private WebElement addressTxt;

    @FindBy(css = ".question-row-is-this-the-same-as .questionset-input .btn-group .btn")
    private List<WebElement> correspondenceBtn;

    @FindBy(css = ".question-row-what-type-of-propert .questionset-input .form-control")
    private WebElement propertyTypeTxt;

    @FindBy(css = ".question-row-which-of-these-best .form-control")
    private WebElement typeOfHouseSel;

    @FindBy(css = ".question-row-approximately-in-whi .questionset-input .form-control")
    private WebElement propertyYearTxt;

    @FindBy(css = ".question-row-how-many-bedrooms-do .questionset-input .form-control")
    private WebElement numberOfBedroomsSel;

    @FindBy(css = ".question-row-how-many-bathrooms .form-control")
    private WebElement numberOfBathroomsSel;

    @FindBy(xpath = "//div[@class='row question-row-is-the-property-your']//button[@type='button']")
    private List<WebElement> propertyMainResidenceBtn;


    @BeforeAll
    public static void initAll() {
        String driverProperty = "webdriver.chrome.driver";
        String driverLocation = System.getProperty(driverProperty);

        if (driverLocation == null || driverLocation.isEmpty()) {
            System.setProperty(driverProperty, "src/test/resources/drivers/chromedriver.exe");
        }
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }



    @Before
    public void init() {
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
        for (WebElement dob : dateOfBirthSel) {
            setSelectValue(dob, dBirth[i++]);
        }
    }

    @And("I enter marital status {string}")
    public void i_enter_marital_status(String maritalStatus) {
        setSelectValue(maritalStatusSel, maritalStatus);
    }

    @And("I enter occupation {string}")
    public void i_enter_occupation(String occupation) throws InterruptedException {
        setTextBoxValue(occupationTxt, occupation);
        try {
            occupationLG.sendKeys(Keys.ENTER);
        }catch (Exception ex){
            //Do nothing
        }
    }


    @And("I enter other occupation {string}")
    public void i_enter_other_occupation(String otherOccupation) {
        Optional<WebElement> webElement = otherOccupationBtn.stream().filter(btn -> otherOccupation.equals(btn.getAccessibleName())).findFirst();
        if (webElement.isPresent()) {
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

    @And("I enter address {string}")
    public void i_enter_address(String address) throws InterruptedException {
        setTextBoxValue(addressTxt, address);
        try{
            addressLG.sendKeys(Keys.ENTER) ;
        }catch (Exception ex) {

        }
    }

    @And("I corresponding address {string}")
    public void i_enter_corres_address(String corresAddress) {
        Optional<WebElement> webElement = correspondenceBtn.stream().filter(btn -> corresAddress.equals(btn.getAccessibleName())).findFirst();
        if (webElement.isPresent()) {
            clickButton(webElement.get());
        }
    }

    @And("I enter property type {string}")
    public void i_enter_prop_type(String propType) {
        setTextBoxValue(propertyTypeTxt, propType);
        addressTxt.sendKeys(Keys.TAB);
        addressTxt.sendKeys(Keys.ENTER);
    }

    @And("I enter financial questions {string}")
    public void i_enter_financial_question(String financialQuestion) {
        Optional<WebElement> webElement = financialIssuesBtn.stream().filter(btn -> financialQuestion.equals(btn.getAccessibleName())).findFirst();
        if (webElement.isPresent()) {
            clickButton(webElement.get());
        }
    }

    @And("I enter type of house {string}")
    public void i_enter_type_of_house(String typeOfHouse) {
        setSelectValue(typeOfHouseSel, typeOfHouse);
    }

    @And("I enter property year {string}")
    public void i_enter_property_year (String propYear) {
        setTextBoxValue(propertyYearTxt, propYear);
    }

    @And("I enter number of bedrooms {string}")
    public void i_enter_number_Of_Bedrooms(String numberOfBedrooms){
        setSelectValue(numberOfBedroomsSel,numberOfBedrooms) ;
    }

    @And("I enter number of bathrooms {string}")
    public void i_enter_number_Of_Bathrooms(String numberOfBathrooms){
        setSelectValue(numberOfBathroomsSel,numberOfBathrooms) ;
    }

    @And("I enter property main residence {string}")
    public void i_enter_property_Main_Residence(String propertyMainResidence) {
        Optional<WebElement> webElement = propertyMainResidenceBtn.stream().filter(btn -> propertyMainResidence.equals(btn.getAccessibleName())).findFirst();
        if (webElement.isPresent()) {
            clickButton(webElement.get());
        }
    }

    private void setSelectValue(WebElement webElement, String value) {
        Select select = new Select(webElement);
        select.selectByVisibleText(value);
    }

    private void clickButton(WebElement webElement) {
        webElement.click();
    }

    private void setTextBoxValue(WebElement webElement, String value) {
        webElement.sendKeys(value);
    }


    @AfterAll
    public static void tearDown() {
        //webDriver.close();
    }
}
