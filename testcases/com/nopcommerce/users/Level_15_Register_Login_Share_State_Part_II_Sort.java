package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.common_01_Register;

import commons.AbstractTest;
import pageObjects.PageGeneratorManager;
import pageObjects.UserHomePO;
import pageObjects.UserLoginPO;

public class Level_15_Register_Login_Share_State_Part_II_Sort extends AbstractTest{
	WebDriver driver;
	//Select select;
	String firstName, lastName, email, company, password;

	@Parameters("browser")
	@BeforeClass
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		
		homePage = PageGeneratorManager.getUserHomePage(driver);
		
		log.info("Precondition - Step 01: Click to 'Login' link at Home Page");
		loginPage = homePage.clickToLoginLink();
		log.info("Precondition - Step 02: Input to 'Email' textbox with value: " + common_01_Register.email);
		loginPage.sendkeyToEmailTextbox(common_01_Register.email);
		
		log.info("Precondition - Step 03: Input to 'Password' textbox with value: " + common_01_Register.password);
		loginPage.sendkeyToPasswordTextbox(common_01_Register.password);
		
		log.info("Precondition - Step 04: Click to 'Login' button at Login Page");
		homePage = loginPage.clickToLoginButton();
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
