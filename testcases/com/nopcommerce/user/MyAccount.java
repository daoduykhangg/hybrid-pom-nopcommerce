package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AddressesPageObject;
import pageObjects.CustomerInforPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.PageGeneratorManager;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class MyAccount extends AbstractTest {
	WebDriver driver;
	String email, password;
	String date, month, year, company;
	String firstName, lastName, counTry, state, city, address1, address2, zip, phoneNumber, faxNumber;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);

		email = "duykhang@gmail.com";
		password = "123123";

		firstName = "Automation";
		lastName = "FC";
		date = "1";
		month = "January";
		year = "1999";
		company = "Automation FC";
		counTry = "Viet Nam";
		state = "Other";
		city = "Ho Chi Minh";
		address1 = "69/10 Dang Minh Tru";
		address2 = "2185b Hong Truong Mam Non";
		zip = "550000";
		phoneNumber = "0938661451";
		faxNumber = "1234567890";
	}

	@Test
	public void Pre_Condition() {
		homePage = PageGeneratorManager.getHomePage(driver);
		loginPage = homePage.clickToLoginLink();

		loginPage.sendkeyToEmailTextbox(email);
		loginPage.sendkeyToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();

		customerInforPage = homePage.clickToMyAccountLink();
	}

	@Test
	public void TC_01_Customer_Infor() {
		customerInforPage.clickToGenderFemaleRadioButton();
		customerInforPage.sendkeyToFirstNameTextbox(firstName);
		customerInforPage.sendkeyToLastNameTextbox(lastName);
		customerInforPage.selectDayDropdown(date);
		customerInforPage.selectMonthDropdown(month);
		customerInforPage.selectYearDropdown(year);
		customerInforPage.sendkeyToEmailTextbox(email);
		customerInforPage.sendkeyToCompanyTextbox(company);

		customerInforPage.clickToSaveButton();

		Assert.assertTrue(customerInforPage.isGenderFemaleRadioButtonSelected());
		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(), lastName);
		Assert.assertEquals(customerInforPage.getSelectedTextInDayDropdown(), date);
		Assert.assertEquals(customerInforPage.getSelectedTextInMonthDropdown(), month);
		Assert.assertEquals(customerInforPage.getSelectedTextInYearDropdown(), year);
		Assert.assertEquals(customerInforPage.getEmailTextboxValue(), email);
		Assert.assertEquals(customerInforPage.getCompanyTextboxValue(), company);
		Assert.assertTrue(customerInforPage.isNewsletterCheckboxSelected());
		
		customerInforPage.ClickToLinkWithPageName(driver, "Addresses");
		addressesPage = PageGeneratorManager.getAddressesPage(driver);
	}
	
	@Test
	public void TC_02_Addresses() {
		addressesPage.ClickToAddNewButton();
		
		addressesPage.sendkeyToFirstNameTextbox(firstName);
		addressesPage.sendkeyToLastNameTextbox(lastName);
		addressesPage.sendkeyToEmailTextbox(email);
		addressesPage.sendkeyToCompanyTextbox(company);
		addressesPage.SelectCounTryDropdown(counTry);
		addressesPage.SelectStateDropdown(state);
		addressesPage.sendkeyToCityTextbox(city);
		addressesPage.sendkeyToAddress1Textbox(address1);
		addressesPage.sendkeyToAddress2Textbox(address2);
		addressesPage.sendkeyToZipTextbox(zip);
		addressesPage.sendkeyToPhoneNumberTextbox(phoneNumber);
		addressesPage.sendkeyToFaxNumberTextbox(faxNumber);

		addressesPage.ClickToSaveButton();
		
		Assert.assertEquals(addressesPage.getNameValue(), firstName + " " + lastName);
		Assert.assertEquals(addressesPage.getEmailValue(), "Email: " + email);
		Assert.assertEquals(addressesPage.getPhoneNumberValue(), "Phone number: " + phoneNumber);
		Assert.assertEquals(addressesPage.getFaxNumberValue(), "Fax number: " + faxNumber);
		Assert.assertEquals(addressesPage.getCompanyValue(), company);
		Assert.assertEquals(addressesPage.getAddress1Value(), address1);
		Assert.assertEquals(addressesPage.getAddress2Value(), address2);
		Assert.assertEquals(addressesPage.getCityStateZipValue(), city+ ", " + zip);
		Assert.assertEquals(addressesPage.getCounTryValue(), counTry);
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
	CustomerInforPageObject customerInforPage;
	AddressesPageObject addressesPage;
}
