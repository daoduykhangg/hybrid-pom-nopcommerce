package com.nopcommerce.user;

import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Login extends AbstractTest {
	WebDriver driver;
	String invaidEmail, unregisteredEmail, invalidPassword;
	String email, password;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);

		invaidEmail = "duykhangqa";
		unregisteredEmail = "duykhangqavn@gmail.com";
		password = "123123";
		invalidPassword = "123456";
		email = "duykhang@gmail.com";
	}

	@Test
	public void TC_01_Login_Empty_Data() {
		homePage = new HomePageObject(driver);
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
	}

	@Test
	public void TC_02_Login_Invalid_Email() {
		loginPage = new LoginPageObject(driver);
		loginPage.senkeyToEmailTextbox(invaidEmail);
		loginPage.senkeyToPasswordTextbox(password);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Wrong email");
	}

	@Test
	public void TC_03_Login_Unregistered_Email() {
		loginPage = new LoginPageObject(driver);
		loginPage.senkeyToEmailTextbox(unregisteredEmail);
		loginPage.senkeyToPasswordTextbox(password);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "No customer account found");
	}

	@Test
	public void TC_04_Login_Valid_Email_Empty_Password() {
		loginPage = new LoginPageObject(driver);
		loginPage.senkeyToEmailTextbox(email);
		loginPage.clickToLoginButton();

		Assert.assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@Test
	public void TC_05_Login_Valid_Email_invalid_Password() {
		loginPage = new LoginPageObject(driver);
		loginPage.senkeyToEmailTextbox(email);
		loginPage.senkeyToPasswordTextbox(invalidPassword);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getErrorMessage(), "Login was unsuccessful. Please correct the errors and try again.\n" + "The credentials provided are incorrect");
	}

	@Test
	public void TC_06_Login_Valid_Email_And_Password() {
		loginPage = new LoginPageObject(driver);
		loginPage.senkeyToEmailTextbox(email);
		loginPage.senkeyToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	HomePageObject homePage;
	LoginPageObject loginPage;
}
