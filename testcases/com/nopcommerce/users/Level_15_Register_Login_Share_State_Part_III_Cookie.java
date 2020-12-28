package com.nopcommerce.users;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.common_02_Cookie;

import commons.AbstractTest;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserLoginPO;

public class Level_15_Register_Login_Share_State_Part_III_Cookie extends AbstractTest{
	WebDriver driver;
	//Select select;
	String firstName, lastName, email, company, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		for (Cookie cookie : common_02_Cookie.allCookies) {
			driver.manage().addCookie(cookie);
		}
		homePage.refreshCurrentPage(driver);
		homePage.sleepInSecond(10);
	}

	@Test
	public void TC_01_Sort_Name_Ascending() {
	}
	
	@Test
	public void TC_02_Sort_Name_Descending() {
	}
	@Test
	public void TC_03_Sort_Price_Ascending() {
	}
	@Test
	public void TC_04_Sort_Name_Descending() {
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}

	UserHomePO homePage;
	UserLoginPO loginPage;
}
