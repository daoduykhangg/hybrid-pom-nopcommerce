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

public class Level_12_Register_Login_Assert_Verify extends AbstractTest{
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

	@Test
	public void TC_01_Register() {
		homePage = PageGeneratorManager.getUserHomePage(driver);
		//Failed
		verifyFalse(homePage.isRegisterLinkDisplayed());
		verifyFalse(homePage.isLoginLinkDisplayed());
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderMaleRadioButton();
		registerPage.sendkeyToFirstNameTextbox(firstName);
		registerPage.sendkeyToLastNameTextbox(lastName);

		registerPage.selectDayDropdown("21");
		registerPage.selectMonthDropdown("August");
		registerPage.selectYearDropdown("1996");

		registerPage.sendkeyToEmailextbox(email);
		registerPage.sendkeyToCompanyTextbox(company);
		registerPage.sendkeyToPasswordTextbox(password);
		registerPage.sendkeyToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();
		//Failed
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed...");

		homePage = registerPage.ClickToLogoutLink();
	}

	@Test
	public void TC_02_Login() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.sendkeyToEmailTextbox(email);
		loginPage.sendkeyToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();
		
		verifyFalse(homePage.isMyAccountLinkDisplayed());
		verifyFalse(homePage.isLogoutLinkDisplayed());
		
		verifyTrue(homePage.isRegisterLinkUndisplayed());
		verifyTrue(homePage.isLoginLinkUndisplayed());
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
