package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.UserCustomerInforPageUI;

public class UserCustomerInforPO extends AbstractPage {
	WebDriver driver;
	public UserCustomerInforPO(WebDriver driver) {
		this.driver = driver;
	}
	
	public boolean isGenderMaleRadioButtonSelected() {
		waitForElementVisible(driver, UserCustomerInforPageUI.GENDER_MALE_RADIO);
		return isElementSelected(driver, UserCustomerInforPageUI.GENDER_MALE_RADIO);
	}

	public boolean isGenderFemaleRadioButtonSelected() {
		waitForElementVisible(driver, UserCustomerInforPageUI.GENDER_FEMALE_RADIO);
		return isElementSelected(driver, UserCustomerInforPageUI.GENDER_FEMALE_RADIO);
	}

	public String getFirstNameTextboxValue() {
		waitForElementVisible(driver, UserCustomerInforPageUI.FIRST_NAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.FIRST_NAME_TEXTBOX, "value");
	}

	public String getLastNameTextboxValue() {
		waitForElementVisible(driver, UserCustomerInforPageUI.LAST_NAME_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.LAST_NAME_TEXTBOX, "value");
	}

	public String getSelectedTextInDayDropdown() {
		waitForElementVisible(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
		return getFirstSelectedText(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
	}

	public String getSelectedTextInMonthDropdown() {
		waitForElementVisible(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
		return getFirstSelectedText(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
	}

	public String getSelectedTextInYearDropdown() {
		waitForElementVisible(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
		return getFirstSelectedText(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
	}

	public String getEmailTextboxValue() {
		waitForElementVisible(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX, "value");
	}

	public String getCompanyTextboxValue() {
		waitForElementVisible(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX);
		return getElementAttribute(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX, "value");
	}

	public boolean isNewsletterCheckboxSelected() {
		waitForElementVisible(driver, UserCustomerInforPageUI.NEWSLETTER_CHECKBOX);
		return isElementSelected(driver, UserCustomerInforPageUI.NEWSLETTER_CHECKBOX);
	}

	public void clickToGenderFemaleRadioButton() {
		waitForElementClickable(driver, UserCustomerInforPageUI.GENDER_FEMALE_RADIO);
		clickToElement(driver, UserCustomerInforPageUI.GENDER_FEMALE_RADIO);
	}
	
	public void sendkeyToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserCustomerInforPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	
	public void sendkeyToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserCustomerInforPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
	public void selectDayDropdown(String day) {
		waitForElementClickable(driver, UserCustomerInforPageUI.DAY_DROPDOWN);
		selectItemInDropdown(driver, UserCustomerInforPageUI.DAY_DROPDOWN, day);
	}
	
	public void selectMonthDropdown(String month) {
		waitForElementClickable(driver, UserCustomerInforPageUI.MONTH_DROPDOWN);
		selectItemInDropdown(driver, UserCustomerInforPageUI.MONTH_DROPDOWN, month);
	}
	
	public void selectYearDropdown(String year) {
		waitForElementClickable(driver, UserCustomerInforPageUI.YEAR_DROPDOWN);
		selectItemInDropdown(driver, UserCustomerInforPageUI.YEAR_DROPDOWN, year);
	}

	public void sendkeyToEmailTextbox(String email) {
		waitForElementVisible(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void sendkeyToCompanyTextbox(String company) {
		waitForElementVisible(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, UserCustomerInforPageUI.COMPANY_TEXTBOX, company);
	}
	
	public void clickToSaveButton() {
		waitForElementClickable(driver, UserCustomerInforPageUI.SAVE_BUTTON);
		clickToElement(driver, UserCustomerInforPageUI.SAVE_BUTTON);
	}
}
