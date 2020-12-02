package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.CustomerInforPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class Level_04_Register_Login_Multiple_Browser extends AbstractTest{
	WebDriver driver;
	Select select;
	String firstName, lastName, email, company, password;

	@Parameters("browser")
	@BeforeTest
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
		homePage = new HomePageObject(driver);
		homePage.clickToRegisterLink();
		registerPage = new RegisterPageObject(driver);

		registerPage.clickToGenderMaleRadioButton();
		registerPage.senkeyToFirstNameTextbox(firstName);
		registerPage.senkeyToLastNameTextbox(lastName);

		registerPage.selectDayDropdown("21");
		registerPage.selectMonthDropdown("August");
		registerPage.selectYearDropdown("1996");

		registerPage.senkeyToEmailextbox(email);
		registerPage.senkeyToCompanyTextbox(company);
		registerPage.senkeyToPasswordTextbox(password);
		registerPage.senkeyToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		registerPage.ClickToLogoutLink();
		homePage = new HomePageObject(driver);
	}

	@Test
	public void TC_02_Login() {
		homePage.clickToLoginLink();
		loginPage = new LoginPageObject(driver);

		loginPage.senkeyToEmailTextbox(email);
		loginPage.senkeyToPasswordTextbox(password);
		loginPage.clickToLoginButton();

		homePage = new HomePageObject(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void TC_03_View_My_Account() {
		homePage.clickToMyAccountLink();
		customerInforPage = new CustomerInforPageObject(driver);

		Assert.assertTrue(customerInforPage.isGenderMaleRadioButtonSelected());
		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(), lastName);

		Assert.assertEquals(customerInforPage.getSelectedTextInDayDropdown(), "21");
		Assert.assertEquals(customerInforPage.getSelectedTextInMonthDropdown(), "August");
		Assert.assertEquals(customerInforPage.getSelectedTextInYearDropdown(), "1996");

		Assert.assertEquals(customerInforPage.getEmailTextboxValue(), email);
		Assert.assertEquals(customerInforPage.getCompanyTextboxValue(), company);
		Assert.assertTrue(customerInforPage.isNewsletterCheckboxSelected());

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInforPageObject customerInforPage;
}
