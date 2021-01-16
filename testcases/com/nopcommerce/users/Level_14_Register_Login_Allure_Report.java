package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.UserAddressesPO;
import pageObjects.nopCommerce.UserCustomerInforPO;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserLoginPO;
import pageObjects.nopCommerce.UserMyProductReviewPO;
import pageObjects.nopCommerce.UserOrdersPO;
import pageObjects.nopCommerce.UserRegisterPO;
@Feature("User")
public class Level_14_Register_Login_Allure_Report extends AbstractTest{
	WebDriver driver;
	//Select select;
	String firstName, lastName, email, company, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		
		firstName = "Khang";
		lastName = "Dao";
		email = "duykhangkma" + getRandomNumber() + "@gmail.com";
		company = "DuyKhang KMA";
		password = "123456";
	}

	@Description("User 01 - Register to System")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_01_Register() {
		log.info("Register - Step 01: Open Home Page");
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Register - Step 02: Verify 'Register' link displayed");
		verifyTrue(homePage.isRegisterLinkDisplayed());
		
		log.info("Register - Step 03: Verify 'Lgoin' link displayed");
		verifyTrue(homePage.isLoginLinkDisplayed());
		
		log.info("Register - Step 04: Click to 'Register' link at Home Page");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register - Step 05: Click to 'Gender Male' radio button");
		registerPage.clickToGenderMaleRadioButton();
		
		log.info("Register - Step 06: Input data to 'Firstname' textbox");
		registerPage.sendkeyToFirstNameTextbox(firstName);
		
		log.info("Register - Step 07: Input data to 'Lastname' textbox");
		registerPage.sendkeyToLastNameTextbox(lastName);

		log.info("Register - Step 08: Select 'Date' dropdown");
		registerPage.selectDayDropdown("21");
		
		log.info("Register - Step 09: Select 'Month' dropdown");
		registerPage.selectMonthDropdown("August");
		
		log.info("Register - Step 10: Select 'Year' dropdown");
		registerPage.selectYearDropdown("1996");

		log.info("Register - Step 11: Input to 'Email' textbox with value:" + email);
		registerPage.sendkeyToEmailextbox(email);
		
		log.info("Register - Step 12: Input data to 'Company' textbox");
		registerPage.sendkeyToCompanyTextbox(company);
		
		log.info("Register - Step 13: Input to 'Password' textbox with value:" + password);
		registerPage.sendkeyToPasswordTextbox(password);
		registerPage.sendkeyToConfirmPasswordTextbox(password);

		log.info("Register - Step 14: Click to 'Register' button at Register Page");
		registerPage.clickToRegisterButton();
		
		log.info("Register - Step 15: Verify 'Register Success Message' displayed");
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Register - Step 16: Click to 'Log out' link and navigate to Home Page");
		homePage = registerPage.ClickToLogoutLink();
	}
	
	@Description("User 02 - Login to System")
	@Severity(SeverityLevel.NORMAL)
	@Test
	public void TC_02_Login() {
		log.info("Login - Step 01: Click to 'Login' link at Home Page");
		loginPage = homePage.clickToLoginLink();
		log.info("Login - Step 02: Input to 'Email' textbox with value: " + email);
		loginPage.sendkeyToEmailTextbox(email);
		
		log.info("Login - Step 03: Input to 'Password' textbox with value: " + password);
		loginPage.sendkeyToPasswordTextbox(password);
		
		log.info("Login - Step 04: Click to 'Login' button at Login Page");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login - Step 05: Verify 'My Account' link displayed");
		verifyTrue(homePage.isMyAccountLinkDisplayed());
		
		log.info("Login - Step 06: Verify 'Log out' link displayed");
		verifyTrue(homePage.isLogoutLinkDisplayed());
		
		log.info("Login - Step 07: Verify 'Register' link Undisplayed");
		verifyTrue(homePage.isRegisterLinkUndisplayed());
		
		log.info("Login - Step 08: Verify 'Login' link Undisplayed");
		verifyTrue(homePage.isLoginLinkUndisplayed());
		
		log.info("Login - Step 09: Verify 'Shopping Cart No Item Tooltip' link Undisplayed");
		verifyFalse(homePage.isShoppingCartNoItemTooltipUndisplayed(driver));
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}

	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInforPage;
	UserAddressesPO addressesPage;
	UserOrdersPO ordersPage;
	UserMyProductReviewPO myProductReviewPage;
}
