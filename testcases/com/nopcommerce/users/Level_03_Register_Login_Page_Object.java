package com.nopcommerce.users;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import pageObjects.nopCommerce.UserCustomerInforPO;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserLoginPO;
import pageObjects.nopCommerce.UserRegisterPO;

public class Level_03_Register_Login_Page_Object {
	WebDriver driver;
	Select select;
	String projectFolder = System.getProperty("user.dir");
	String firstName, lastName, email, company, password;

	@BeforeClass
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		firstName = "Khang";
		lastName = "Dao";
		email = "duykhangkma" + getRandomNumber() + "@gmail.com";
		company = "DuyKhang KMA";
		password = "123456";
	}

	@Test
	public void TC_01_Register() {
		homePage = new UserHomePO(driver);
		
		homePage.clickToRegisterLink();
		registerPage = new UserRegisterPO(driver);

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
		
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		registerPage.ClickToLogoutLink();
		homePage = new UserHomePO(driver);
	}

	@Test
	public void TC_02_Login() {
		homePage.clickToLoginLink();
		loginPage = new UserLoginPO(driver);
		
		loginPage.sendkeyToEmailTextbox(email);
		loginPage.sendkeyToPasswordTextbox(password);
		loginPage.clickToLoginButton();
		
		homePage = new UserHomePO(driver);
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void TC_03_View_My_Account() {
		homePage.clickToMyAccountLink();
		customerInforPage = new UserCustomerInforPO(driver);

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

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}
	
	UserHomePO homePage;
	UserRegisterPO registerPage;
	UserLoginPO loginPage;
	UserCustomerInforPO customerInforPage;
}
