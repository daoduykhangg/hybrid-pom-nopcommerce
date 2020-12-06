package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class Register extends AbstractTest {
	WebDriver driver;
	String firstName, lastName, email, company, password, date, month, year;
	String invaidEmail, existEmail, invalidPassword;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);

		firstName = "Duy";
		lastName = "Khang";
		date = "21";
		month = "August";
		year = "1996";
		email = "duykhang" + getRandomNumber() + "@gmail.com";
		company = "Duy Khang KMA";
		password = "123123";

		invaidEmail = "duykhangqa";
		existEmail = "duykhang@gmail.com";
		invalidPassword = "123";
	}
	
	@Test
	public void TC_01_Register_Empty_Data() {
		homePage = PageGeneratorManager.getHomePage(driver);
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getFirstNameErrorMessage(), "First name is required.");
		Assert.assertEquals(registerPage.getLastNameErrorMessage(), "Last name is required.");
		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Email is required.");
		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password is required.");
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "Password is required.");
	}
	
	@Test
	public void TC_02_Register_Invalid_Email() {
//		registerPage = PageGeneratorManager.getRegisterPage(driver);

		registerPage.clickToGenderMaleRadioButton();
		registerPage.sendkeyToFirstNameTextbox(firstName);
		registerPage.sendkeyToLastNameTextbox(lastName);
		registerPage.selectDayDropdown(date);
		registerPage.selectMonthDropdown(month);
		registerPage.selectYearDropdown(year);
		registerPage.sendkeyToEmailextbox(invaidEmail);
		registerPage.sendkeyToCompanyTextbox(company);
		registerPage.sendkeyToPasswordTextbox(password);
		registerPage.sendkeyToConfirmPasswordTextbox(password);

		Assert.assertEquals(registerPage.getEmailErrorMessage(), "Wrong email");

	}

	@Test
	public void TC_03_Register_Exist_Email() {
//		registerPage = PageGeneratorManager.getRegisterPage(driver);

		registerPage.clickToGenderMaleRadioButton();
		registerPage.sendkeyToFirstNameTextbox(firstName);
		registerPage.sendkeyToLastNameTextbox(lastName);
		registerPage.selectDayDropdown(date);
		registerPage.selectMonthDropdown(month);
		registerPage.selectYearDropdown(year);
		registerPage.sendkeyToEmailextbox(existEmail);
		registerPage.sendkeyToCompanyTextbox(company);
		registerPage.sendkeyToPasswordTextbox(password);
		registerPage.sendkeyToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getExistEmailMessage(), "The specified email already exists");
	}

	@Test
	public void TC_04_Register_Password_Less_than_6_Characters() {
//		registerPage = PageGeneratorManager.getRegisterPage(driver);

		registerPage.clickToGenderMaleRadioButton();
		registerPage.sendkeyToFirstNameTextbox(firstName);
		registerPage.sendkeyToLastNameTextbox(lastName);
		registerPage.selectDayDropdown(date);
		registerPage.selectMonthDropdown(month);
		registerPage.selectYearDropdown(year);
		registerPage.sendkeyToEmailextbox(existEmail);
		registerPage.sendkeyToCompanyTextbox(company);
		registerPage.sendkeyToPasswordTextbox(invalidPassword);
		registerPage.sendkeyToConfirmPasswordTextbox(invalidPassword);

		Assert.assertEquals(registerPage.getPasswordErrorMessage(), "Password must meet the following rules:\n" + "must have at least 6 characters");
	}
	
	@Test
	public void TC_05_Register_Password_And_Confirm_Password_Not_Match() {
//		registerPage = PageGeneratorManager.getRegisterPage(driver);

		registerPage.clickToGenderMaleRadioButton();
		registerPage.sendkeyToFirstNameTextbox(firstName);
		registerPage.sendkeyToLastNameTextbox(lastName);
		registerPage.selectDayDropdown(date);
		registerPage.selectMonthDropdown(month);
		registerPage.selectYearDropdown(year);
		registerPage.sendkeyToEmailextbox(existEmail);
		registerPage.sendkeyToCompanyTextbox(company);
		registerPage.sendkeyToPasswordTextbox(password);
		registerPage.sendkeyToConfirmPasswordTextbox(invalidPassword);
		
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getConfirmPasswordErrorMessage(), "The password and confirmation password do not match.");
	}

	@Test
	public void TC_06_Register_Valid_Data() {
//		registerPage = PageGeneratorManager.getRegisterPage(driver);

		registerPage.clickToGenderMaleRadioButton();
		registerPage.sendkeyToFirstNameTextbox(firstName);
		registerPage.sendkeyToLastNameTextbox(lastName);
		registerPage.selectDayDropdown(date);
		registerPage.selectMonthDropdown(month);
		registerPage.selectYearDropdown(year);
		registerPage.sendkeyToEmailextbox(email);
		registerPage.sendkeyToCompanyTextbox(company);
		registerPage.sendkeyToPasswordTextbox(password);
		registerPage.sendkeyToConfirmPasswordTextbox(password);
		
		registerPage.clickToRegisterButton();
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	RegisterPageObject registerPage;
	HomePageObject homePage;
}
