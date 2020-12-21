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

import commons.AbstractPage;

public class Level_02_Register_Login_AbstractPage_2 extends AbstractPage{
	WebDriver driver;
	Select select;
	String projectFolder = System.getProperty("user.dir");
	String firstName, lastName, email, company, password;

	@BeforeClass
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();

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
		openPageUrl(driver, "https://demo.nopcommerce.com/");

		clickToElement(driver, "//a[@class='ico-register']");
		clickToElement(driver, "//input[@id='gender-male']");
		sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		sendkeyToElement(driver, "//input[@id='LastName']", lastName);

		selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "21");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "August");
		selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1996");

		
		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Company']", company);
		sendkeyToElement(driver, "//input[@id='Password']", password);
		sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);

		clickToElement(driver, "//input[@id='register-button']");

		Assert.assertEquals(getTextElement(driver, "//div[@class='result']"), "Your registration completed");

		clickToElement(driver, "//a[@class='ico-logout']");

	}

	@Test
	public void TC_02_Login() {
		clickToElement(driver, "//a[@class='ico-login']");

		sendkeyToElement(driver, "//input[@id='Email']", email);
		sendkeyToElement(driver, "//input[@id='Password']", password);

		clickToElement(driver, "//input[@value='Log in']");
	}

	@Test
	public void TC_03_View_My_Account() {
		clickToElement(driver, "//a[@class='ico-account']");

		Assert.assertTrue(isElementSelected(driver, "//input[@id='gender-male']"));
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);

		Assert.assertEquals(getFirstSelectedText(driver, "//select[@name='DateOfBirthDay']"), "21");
		Assert.assertEquals(getFirstSelectedText(driver, "//select[@name='DateOfBirthMonth']"), "August");
		Assert.assertEquals(getFirstSelectedText(driver, "//select[@name='DateOfBirthYear']"), "1996");

		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Email']", "value"), email);
		Assert.assertEquals(getElementAttribute(driver, "//input[@id='Company']", "value"), company);
		Assert.assertTrue(isElementSelected(driver, "//input[@id='Newsletter']"));
		
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}

}
