package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.UserAddressesPageUI;

public class UserAddressesPO extends AbstractPage {
	WebDriver driver;

	public UserAddressesPO(WebDriver driver) {
		this.driver = driver;
	}
	public void ClickToAddNewButton() {
		waitForElementClickable(driver, UserAddressesPageUI.ADD_NEW_BUTTON);
		clickToElement(driver, UserAddressesPageUI.ADD_NEW_BUTTON);
	}
	
	public void sendkeyToFirstNameTextbox(String firstName) {
		waitForElementVisible(driver, UserAddressesPageUI.FIRST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.FIRST_NAME_TEXTBOX, firstName);
	}
	
	public void sendkeyToLastNameTextbox(String lastName) {
		waitForElementVisible(driver, UserAddressesPageUI.LAST_NAME_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.LAST_NAME_TEXTBOX, lastName);
	}
	
	public void sendkeyToEmailTextbox(String email) {
		waitForElementVisible(driver, UserAddressesPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.EMAIL_TEXTBOX, email);
	}
	
	public void sendkeyToCompanyTextbox(String company) {
		waitForElementVisible(driver, UserAddressesPageUI.COMPANY_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.COMPANY_TEXTBOX, company);
	}
	
	public void SelectCounTryDropdown(String counTry) {
		waitForElementClickable(driver, UserAddressesPageUI.COUNTRY_DROPDOWN);
		selectItemInDropdown(driver, UserAddressesPageUI.COUNTRY_DROPDOWN, counTry);
	}
	
	public void SelectStateDropdown(String state) {
		waitForElementClickable(driver, UserAddressesPageUI.STATE_PROVINCE_DROPDOWN);
		selectItemInDropdown(driver, UserAddressesPageUI.STATE_PROVINCE_DROPDOWN, state);
	}
	
	public void sendkeyToCityTextbox(String city) {
		waitForElementVisible(driver, UserAddressesPageUI.CITY_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.CITY_TEXTBOX, city);
	}
	
	public void sendkeyToAddress1Textbox(String address1) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS_1_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ADDRESS_1_TEXTBOX, address1);
	}
	
	public void sendkeyToAddress2Textbox(String address2) {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS_2_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ADDRESS_2_TEXTBOX, address2);
	}
	
	public void sendkeyToZipTextbox(String zip) {
		waitForElementVisible(driver, UserAddressesPageUI.ZIP_POSTAL_CODE_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.ZIP_POSTAL_CODE_TEXTBOX, zip);
	}
	
	public void sendkeyToPhoneNumberTextbox(String phoneNumber) {
		waitForElementVisible(driver, UserAddressesPageUI.PHONE_NUMBER_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.PHONE_NUMBER_TEXTBOX, phoneNumber);
	}
	
	public void sendkeyToFaxNumberTextbox(String faxNumber) {
		waitForElementVisible(driver, UserAddressesPageUI.FAX_NUMBER_TEXTBOX);
		sendkeyToElement(driver, UserAddressesPageUI.FAX_NUMBER_TEXTBOX, faxNumber);
	}

	public void ClickToSaveButton() {
		waitForElementClickable(driver, UserAddressesPageUI.SAVE_BUTTON);
		clickToElement(driver, UserAddressesPageUI.SAVE_BUTTON);
	}
	
	public String getNameValue() {
		waitForElementVisible(driver, UserAddressesPageUI.FULL_NAME);
		return getTextElement(driver, UserAddressesPageUI.FULL_NAME);
	}
	public String getEmailValue() {
		waitForElementVisible(driver, UserAddressesPageUI.EMAIL);
		return getTextElement(driver, UserAddressesPageUI.EMAIL);
	}
	public String getPhoneNumberValue() {
		waitForElementVisible(driver, UserAddressesPageUI.PHONE_NUMBER);
		return getTextElement(driver, UserAddressesPageUI.PHONE_NUMBER);
	}
	public String getFaxNumberValue() {
		waitForElementVisible(driver, UserAddressesPageUI.FAX_NUMBER);
		return getTextElement(driver, UserAddressesPageUI.FAX_NUMBER);
	}
	public String getCompanyValue() {
		waitForElementVisible(driver, UserAddressesPageUI.COMPANY);
		return getTextElement(driver, UserAddressesPageUI.COMPANY);
	}
	public String getAddress1Value() {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS1);
		return getTextElement(driver, UserAddressesPageUI.ADDRESS1);
	}
	public String getAddress2Value() {
		waitForElementVisible(driver, UserAddressesPageUI.ADDRESS2);
		return getTextElement(driver, UserAddressesPageUI.ADDRESS2);
	}
	public String getCityStateZipValue() {
		waitForElementVisible(driver, UserAddressesPageUI.CITY_STATE_ZIP);
		return getTextElement(driver, UserAddressesPageUI.CITY_STATE_ZIP);
	}
	public String getCounTryValue() {
		waitForElementVisible(driver, UserAddressesPageUI.COUNTRY);
		return getTextElement(driver, UserAddressesPageUI.COUNTRY);
	}
	
}
