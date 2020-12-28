package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.common_01_Register;

import commons.AbstractTest;
import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.UserHomePO;
import pageObjects.nopCommerce.UserLoginPO;

public class Level_15_Register_Login_Share_State_Part_I_Search extends AbstractTest{
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
	public void TC_01_Search_By_Category() {
	}
	
	@Test
	public void TC_02_Search_By_Sub_Category() {
	}
	@Test
	public void TC_03_Search_By_Manufacturer() {
	}
	@Test
	public void TC_04_Search_By_Price() {
	}

	@AfterClass
	public void afterTest() {
		driver.quit();
	}

	UserHomePO homePage;
	UserLoginPO loginPage;
}
