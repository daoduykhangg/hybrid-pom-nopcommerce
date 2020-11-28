package com.nopcommerce.users;

import org.testng.annotations.Test;

import commons.AbstractPage;

import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_02_Register_Login_AbstractPage_1 {
	WebDriver driver;
	Select select;
	String projectFolder = System.getProperty("user.dir");
	String firstName, lastName, email, company, password;
	AbstractPage abstractPage;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();
		abstractPage = new AbstractPage();

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
		abstractPage.openPageUrl(driver, "https://demo.nopcommerce.com/");

		abstractPage.clickToElement(driver, "//a[@class='ico-register']");
		abstractPage.clickToElement(driver, "//input[@id='gender-male']");
		abstractPage.sendkeyToElement(driver, "//input[@id='FirstName']", firstName);
		abstractPage.sendkeyToElement(driver, "//input[@id='LastName']", lastName);

		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthDay']", "21");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthMonth']", "August");
		abstractPage.selectItemInDropdown(driver, "//select[@name='DateOfBirthYear']", "1996");

		
		abstractPage.sendkeyToElement(driver, "//input[@id='Email']", email);
		abstractPage.sendkeyToElement(driver, "//input[@id='Company']", company);
		abstractPage.sendkeyToElement(driver, "//input[@id='Password']", password);
		abstractPage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", password);

		abstractPage.clickToElement(driver, "//input[@id='register-button']");

		Assert.assertEquals(abstractPage.getTextElement(driver, "//div[@class='result']"), "Your registration completed");

		abstractPage.clickToElement(driver, "//a[@class='ico-logout']");

	}

	@Test
	public void TC_02_Login() {
		abstractPage.clickToElement(driver, "//a[@class='ico-login']");

		abstractPage.sendkeyToElement(driver, "//input[@id='Email']", email);
		abstractPage.sendkeyToElement(driver, "//input[@id='Password']", password);

		abstractPage.clickToElement(driver, "//input[@value='Log in']");
	}

	@Test
	public void TC_03_View_My_Account() {
		abstractPage.clickToElement(driver, "//a[@class='ico-account']");

		Assert.assertTrue(abstractPage.isElementSelected(driver, "//input[@id='gender-male']"));
		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='FirstName']", "value"), firstName);
		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='LastName']", "value"), lastName);

		Assert.assertEquals(abstractPage.getFirstSelectedText(driver, "//select[@name='DateOfBirthDay']"), "21");
		Assert.assertEquals(abstractPage.getFirstSelectedText(driver, "//select[@name='DateOfBirthMonth']"), "August");
		Assert.assertEquals(abstractPage.getFirstSelectedText(driver, "//select[@name='DateOfBirthYear']"), "1996");

		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='Email']", "value"), email);
		Assert.assertEquals(abstractPage.getElementAttribute(driver, "//input[@id='Company']", "value"), company);
		Assert.assertTrue(abstractPage.isElementSelected(driver, "//input[@id='Newsletter']"));
		
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
