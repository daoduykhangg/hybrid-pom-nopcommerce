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
}
