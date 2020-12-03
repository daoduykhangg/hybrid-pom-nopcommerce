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

public class Login extends AbstractTest{
	WebDriver driver;
	
	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		
	}
	
	@Test
	public void TC_01_Login_Empty_Data() {
		homePage = new HomePageObject(driver);
		homePage.clickToLoginLink();
		
		loginPage = new LoginPageObject(driver);
		loginPage.clickToLoginButton();
		
		Assert.assertEquals(loginPage.getEmailErrorMessage(), "Please enter your email");
	}
	
//	@Test
//	public void TC_02_Login_Empty_Data() {
//		
//	}
//	
//	@Test
//	public void TC_03_Login_Empty_Data() {
//		
//	}
//	
//	@Test
//	public void TC_04_Login_Empty_Data() {
//		
//	}
//	
//	@Test
//	public void TC_05_Login_Empty_Data() {
//		
//	}
//
//	@Test
//	public void TC_06_Login_Empty_Data() {
//		
//	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}
	
	HomePageObject homePage;
	LoginPageObject loginPage;
}
