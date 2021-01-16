package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.UserAddressesPO;
import pageObjects.nopCommerce.UserCustomerInforPO;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserLoginPO;
import pageObjects.nopCommerce.UserMyProductReviewPO;
import pageObjects.nopCommerce.UserOrdersPO;
import pageObjects.nopCommerce.UserRegisterPO;
import utilities.FakerConfig;

public class Level_19_Register_Login_Faker_Java extends AbstractTest {
	WebDriver driver;
	FakerConfig fakeData;
	
	// Select select;
	String firstName, lastName, email, company, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);

		fakeData = FakerConfig.getFakerData();
		
		firstName = fakeData.getFirstName();
		lastName = fakeData.getLastName();
		email = fakeData.getEmailAddress();
		company = fakeData.getCompanyName();
		password = fakeData.getPassword();
	}

	@Test
	public void TC_01_Validate() {
		log.info("Validate - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Validate - Step 02: Click to 'Register' link at Home Page");
		registerPage = homePage.clickToRegisterLink();

		log.info("Validate - Step 03: Click to 'Register' button at Register Page");
		registerPage.clickToButtonByValue(driver, "Register");

		log.info("Validate - Step 04: Verify Error Message displayed at FirstName textbox");
		verifyEquals(registerPage.getErrorMessageAtMandantoryfieldByID(driver, "FirstName"), "First name is required.");

		log.info("Validate - Step 05: Verify Error Message displayed at LastName textbox");
		verifyEquals(registerPage.getErrorMessageAtMandantoryfieldByID(driver, "LastName"), "Last name is required.");

		log.info("Validate - Step 06: Verify Error Message displayed at Email textbox");
		verifyEquals(registerPage.getErrorMessageAtMandantoryfieldByID(driver, "Email"), "Email is required.");

		log.info("Validate - Step 07: Verify Error Message displayed at Password textbox");
		verifyEquals(registerPage.getErrorMessageAtMandantoryfieldByID(driver, "Password"), "Password is required.");

		log.info("Validate - Step 08: Verify Error Message displayed at Confirm Password textbox");
		verifyEquals(registerPage.getErrorMessageAtMandantoryfieldByID(driver, "ConfirmPassword"), "Password is required.");
	}

	@Test
	public void TC_02_Register() {
		log.info("Register - Step 01: Refresh current Page");
		registerPage.refreshCurrentPage(driver);

		log.info("Register - Step 02: Click to 'Gender Male' radio button");
		registerPage.clickToRadioButtonByID(driver, "male");

		log.info("Register - Step 03: Input data to 'Firstname' textbox with value:" + firstName);
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);

		log.info("Register - Step 04: Input data to 'LastName' textbox with value:" + lastName);
		registerPage.inputToTextboxByID(driver, "LastName", lastName);

		log.info("Register - Step 05: Select 'Date' dropdown");
		registerPage.selectDropdownByName(driver, "DateOfBirthDay", "21");

		log.info("Register - Step 06: Select 'Month' dropdown");
		registerPage.selectDropdownByName(driver, "DateOfBirthMonth", "August");

		log.info("Register - Step 07: Select 'Year' dropdown");
		registerPage.selectDropdownByName(driver, "DateOfBirthYear", "1996");

		log.info("Register - Step 08: Input to 'Email' textbox with value:" + email);
		registerPage.inputToTextboxByID(driver, "Email", email);

		log.info("Register - Step 09: Input data to 'Company' textbox");
		registerPage.inputToTextboxByID(driver, "Company", company);

		log.info("Register - Step 10: Input to 'Password' textbox with value:" + password);
		registerPage.inputToTextboxByID(driver, "Password", password);
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", password);

		log.info("Register - Step 11: Click to 'Register' button at Register Page");
		registerPage.clickToButtonByValue(driver, "Register");

		log.info("Register - Step 12: Verify 'Register Success Message' displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register - Step 13: Click to 'Log out' link and navigate to Home Page");
		homePage = registerPage.ClickToLogoutLink();
	}

	@Test
	public void TC_03_Login() {
		log.info("Login - Step 01: Click to 'Login' link at Home Page");
		loginPage = homePage.clickToLoginLink();

		log.info("Login - Step 02: Input to 'Email' textbox with value: " + email);
		loginPage.inputToTextboxByID(driver, "Email", email);

		log.info("Login - Step 03: Input to 'Password' textbox with value: " + password);
		loginPage.inputToTextboxByID(driver, "Password", password);

		log.info("Login - Step 04: Click to 'Login' button at Login Page");
		loginPage.clickToButtonByValue(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		log.info("Login - Step 05: Verify 'My Account' link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());

		log.info("Login - Step 06: Verify 'Log out' link displayed");
		verifyTrue(homePage.isLogoutLinkDisplayed());

		log.info("Login - Step 07: Verify 'Register' link Undisplayed");
		verifyTrue(homePage.isRegisterLinkUndisplayed());

		log.info("Login - Step 08: Verify 'Login' link Undisplayed");
		verifyTrue(homePage.isLoginLinkUndisplayed());

		log.info("Login - Step 09: Verify 'Shopping Cart No Item Tooltip' link Undisplayed");
		verifyTrue(homePage.isShoppingCartNoItemTooltipUndisplayed(driver));
	}

	@AfterClass(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInforPage;
	UserAddressesPO addressesPage;
	UserOrdersPO ordersPage;
	UserMyProductReviewPO myProductReviewPage;
}
