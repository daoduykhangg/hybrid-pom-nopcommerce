package com.nopcommerce.common;

import java.util.Set;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.AbstractTest;
import pageObjects.PageGeneratorManager;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;
import pageObjects.UserRegisterPO;
public class common_02_Cookie extends AbstractTest{
	WebDriver driver;
	//Select select;
	String firstName, lastName,company;
	public static String email, password;
	public static Set<Cookie> allCookies;
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		
		firstName = "Khang";
		lastName = "Dao";
		email = "duykhangkma" + getRandomNumber() + "@gmail.com";
		company = "DuyKhang KMA";
		password = "123456";
		
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
		
		allCookies = driver.manage().getCookies();
		
		driver.quit();
	}

	@AfterTest
	public void afterTest() {
		
	}

	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
}
