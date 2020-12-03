package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPageObject extends AbstractPage {
	WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath = "//input[@id='gender-male']")
	WebElement genderMaleRadio;
	
	@FindBy(xpath = "//input[@id='FirstName']")
	WebElement firstNameTextbox;
	
	@FindBy(xpath = "//input[@id='LastName']")
	WebElement lastNameTextbox;
	
	@FindBy(xpath = "//select[@name='DateOfBirthDay']")
	WebElement dayDropdown;
	
	@FindBy(xpath = "//select[@name='DateOfBirthMonth']")
	WebElement monthDropdown;
	
	@FindBy(xpath = "//select[@name='DateOfBirthYear']")
	WebElement yearDropdown;
	
	@FindBy(xpath = "//input[@id='Email']")
	WebElement emailTextbox;
	
	@FindBy(xpath = "//input[@id='Company']")
	WebElement companyTextbox;
	
	@FindBy(xpath = "//input[@id='Password']")
	WebElement passwordTextbox;
	
	@FindBy(xpath = "//input[@id='ConfirmPassword']")
	WebElement confirmPasswordTextbox;
	
	@FindBy(xpath = "//input[@id='register-button']")
	WebElement registerButton;
	
	@FindBy(xpath = "//div[@class='result']")
	WebElement registerSuccessMessage;
	
	@FindBy(xpath = "//a[@class='ico-logout']")
	WebElement logoutLink;
	
	public void clickToGenderMaleRadioButton() {
		waitForElementClickable(driver, genderMaleRadio);
		clickToElement(driver, genderMaleRadio);
	}

	public void sendkeyToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, firstName);
	}

	public void sendkeyToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
	}

	public void selectDayDropdown(String day) {
		waitForElementClickable(driver, dayDropdown);
		selectItemInDropdown(driver, dayDropdown, day);

	}

	public void selectMonthDropdown(String month) {
		waitForElementClickable(driver, monthDropdown);
		selectItemInDropdown(driver, monthDropdown, month);
	}

	public void selectYearDropdown(String year) {
		waitForElementClickable(driver, yearDropdown);
		selectItemInDropdown(driver, yearDropdown, year);

	}

	public void sendkeyToEmailextbox(String email) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, email);

	}

	public void sendkeyToCompanyTextbox(String company) {
		waitForElementVisible(driver, companyTextbox);
		sendkeyToElement(driver, companyTextbox, company);

	}

	public void sendkeyToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);

	}

	public void sendkeyToConfirmPasswordTextbox(String password) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, password);

	}

	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMessage);
		return getTextElement(driver, registerSuccessMessage);
	}

	public void ClickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}
}
