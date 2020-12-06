package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.CustomerInforPageUI;

public class CustomerInforPageObject extends AbstractPage {
	WebDriver driver;
	public CustomerInforPageObject(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isGenderMaleRadioButtonSelected() {
		waitForElementVisible(driver, CustomerInforPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, CustomerInforPageUI.GENDER_MALE_RADIO);
	}

	public boolean isGenderFemaleRadioButtonSelected() {
		waitForElementVisible(driver, CustomerInforPageUI.GENDER_FEMALE_RADIO);
		return isElementSelected(driver, CustomerInforPageUI.GENDER_FEMALE_RADIO);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInforPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, CustomerInforPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getSelectedTextInDayDropdown() {
		waitForElementVisible(driver, CustomerInforPageUI.DAY_DROPDOWN);
		return getFirstSelectedText(driver, CustomerInforPageUI.DAY_DROPDOWN);
	}

	public String getSelectedTextInMonthDropdown() {
		waitForElementVisible(driver, CustomerInforPageUI.MONTH_DROPDOWN);
		return getFirstSelectedText(driver, CustomerInforPageUI.MONTH_DROPDOWN);
	}

	public String getSelectedTextInYearDropdown() {
		waitForElementVisible(driver, CustomerInforPageUI.YEAR_DROPDOWN);
		return getFirstSelectedText(driver, CustomerInforPageUI.YEAR_DROPDOWN);
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, CustomerInforPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyTextboxValue() {
		waitForElementVisible(driver, CustomerInforPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, CustomerInforPageUI.COMPANY_TEXTBOX, "value");
	}

	public boolean isNewsletterCheckboxSelected() {
		waitForElementVisible(driver, CustomerInforPageUI.NEWSLETTER_CHECKBOX);
		return isElementSelected(driver, CustomerInforPageUI.NEWSLETTER_CHECKBOX);
	}

	public void clickToGenderFemaleRadioButton() {
		waitForElementClickable(driver, CustomerInforPageUI.GENDER_FEMALE_RADIO);
		clickToElement(driver, CustomerInforPageUI.GENDER_FEMALE_RADIO);
	}
	
	public void sendkeyToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, CustomerInforPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInforPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	
	public void sendkeyToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, CustomerInforPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, CustomerInforPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
	public void selectDayDropdown(String day) {
		waitForElementClickable(driver, CustomerInforPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, CustomerInforPageUI.DAY_DROPDOWN, day);
	}
	
	public void selectMonthDropdown(String month) {
		waitForElementClickable(driver, CustomerInforPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, CustomerInforPageUI.MONTH_DROPDOWN, month);
	}
	
	public void selectYearDropdown(String year) {
		waitForElementClickable(driver, CustomerInforPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, CustomerInforPageUI.YEAR_DROPDOWN, year);
	}

	public void sendkeyToEmailTextbox(String email) {
		waitForElementVisible(driver, CustomerInforPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, CustomerInforPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void sendkeyToCompanyTextbox(String company) {
		waitForElementVisible(driver, CustomerInforPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, CustomerInforPageUI.COMPANY_TEXTBOX, company);
	}
	
	public void clickToSaveButton() {
		waitForElementClickable(driver, CustomerInforPageUI.SAVE_BUTTON);
		clickToElement(driver, CustomerInforPageUI.SAVE_BUTTON);
	}
}
