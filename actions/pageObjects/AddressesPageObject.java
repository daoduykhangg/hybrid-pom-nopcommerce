package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AddressesPageUI;

public class AddressesPageObject extends AbstractPage {
	WebDriver driver;

	public AddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void ClickToAddNewButton() {
		waitForElementClickable(driver, AddressesPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, AddressesPageUI.ADD_NEW_BUTTON);
	}
	
	public void sendkeyToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, AddressesPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	
	public void sendkeyToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, AddressesPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
	public void sendkeyToEmailTextbox(String email) {
		waitForElementVisible(driver, AddressesPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void sendkeyToCompanyTextbox(String company) {
		waitForElementVisible(driver, AddressesPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.COMPANY_TEXTBOX, company);
	}
	
	public void SelectCounTryDropdown(String counTry) {
		waitForElementClickable(driver, AddressesPageUI.COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, AddressesPageUI.COUNTRY_DROPDOWN, counTry);
	}
	
	public void SelectStateDropdown(String state) {
		waitForElementClickable(driver, AddressesPageUI.STATE_PROVINCE_DROPDOWN);
		selectItemInDropdown(driver, AddressesPageUI.STATE_PROVINCE_DROPDOWN, state);
	}
	
	public void sendkeyToCityTextbox(String city) {
		waitForElementVisible(driver, AddressesPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.CITY_TEXTBOX, city);
	}
	
	public void sendkeyToAddress1Textbox(String address1) {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS_1_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.ADDRESS_1_TEXTBOX, address1);
	}
	
	public void sendkeyToAddress2Textbox(String address2) {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS_2_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.ADDRESS_2_TEXTBOX, address2);
	}
	
	public void sendkeyToZipTextbox(String zip) {
		waitForElementVisible(driver, AddressesPageUI.ZIP_POSTAL_CODE_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.ZIP_POSTAL_CODE_TEXTBOX, zip);
	}
	
	public void sendkeyToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(driver, AddressesPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}
	
	public void sendkeyToFaxNumberTextbox(String faxNumber) {
		waitForElementVisible(driver, AddressesPageUI.FAX_NUMBER_TEXTBOX);
		sendkeyToElement(driver, AddressesPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void ClickToSaveButton() {
		waitForElementClickable(driver, AddressesPageUI.SAVE_BUTTON);
		clickToElement(driver, AddressesPageUI.SAVE_BUTTON);
	}
	
	public String getNameValue() {
		waitForElementVisible(driver, AddressesPageUI.FULL_NAME);
		return getTextElement(driver, AddressesPageUI.FULL_NAME);
	}
	public String getEmailValue() {
		waitForElementVisible(driver, AddressesPageUI.EMAIL);
		return getTextElement(driver, AddressesPageUI.EMAIL);
	}
	public String getPhoneNumberValue() {
		waitForElementVisible(driver, AddressesPageUI.PHONE_NUMBER);
		return getTextElement(driver, AddressesPageUI.PHONE_NUMBER);
	}
	public String getFaxNumberValue() {
		waitForElementVisible(driver, AddressesPageUI.FAX_NUMBER);
		return getTextElement(driver, AddressesPageUI.FAX_NUMBER);
	}
	public String getCompanyValue() {
		waitForElementVisible(driver, AddressesPageUI.COMPANY);
		return getTextElement(driver, AddressesPageUI.COMPANY);
	}
	public String getAddress1Value() {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS1);
		return getTextElement(driver, AddressesPageUI.ADDRESS1);
	}
	public String getAddress2Value() {
		waitForElementVisible(driver, AddressesPageUI.ADDRESS2);
		return getTextElement(driver, AddressesPageUI.ADDRESS2);
	}
	public String getCityStateZipValue() {
		waitForElementVisible(driver, AddressesPageUI.CITY_STATE_ZIP);
		return getTextElement(driver, AddressesPageUI.CITY_STATE_ZIP);
	}
	public String getCounTryValue() {
		waitForElementVisible(driver, AddressesPageUI.COUNTRY);
		return getTextElement(driver, AddressesPageUI.COUNTRY);
	}
	
}
