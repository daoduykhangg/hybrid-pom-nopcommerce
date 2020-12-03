package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class CustomerInforPageObject extends AbstractPage {
	WebDriver driver;

	public CustomerInforPageObject(WebDriver driver) {
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
	
	@FindBy(xpath = "//input[@id='Newsletter']")
	WebElement newsletterCheckbox;
	
	public boolean isGenderMaleRadioButtonSelected() {
		waitForElementVisible(driver, genderMaleRadio);
		return isElementSelected(driver, genderMaleRadio);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, firstNameTextbox);
		return getElementAttribute(driver, firstNameTextbox, "value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, lastNameTextbox);
		return getElementAttribute(driver, lastNameTextbox, "value");
	}

	public String getSelectedTextInDayDropdown() {
		waitForElementVisible(driver, dayDropdown);
		return getFirstSelectedText(driver, dayDropdown);
	}

	public String getSelectedTextInMonthDropdown() {
		waitForElementVisible(driver, monthDropdown);
		return getFirstSelectedText(driver, monthDropdown);
	}

	public String getSelectedTextInYearDropdown() {
		waitForElementVisible(driver, yearDropdown);
		return getFirstSelectedText(driver, yearDropdown);
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, emailTextbox);
		return getElementAttribute(driver, emailTextbox, "value");
	}

	public String getCompanyTextboxValue() {
		waitForElementVisible(driver, companyTextbox);
		return getElementAttribute(driver, companyTextbox, "value");
	}

	public boolean isNewsletterCheckboxSelected() {
		waitForElementVisible(driver, newsletterCheckbox);
		return isElementSelected(driver, newsletterCheckbox);
	}

}
