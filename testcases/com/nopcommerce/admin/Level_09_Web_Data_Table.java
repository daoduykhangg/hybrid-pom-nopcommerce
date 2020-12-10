package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AdminDashBoardPagePO;
import pageObjects.AdminLoginPagePO;
import pageObjects.AdminProductsPagePO;
import pageObjects.PageGeneratorManager;

public class Level_09_Web_Data_Table extends AbstractTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);

		loginPage = PageGeneratorManager.getAdminLoginPage(driver);

		dashboardPage = loginPage.loginToSystem("admin@yourstore.com", "admin");
		productsPage = dashboardPage.openProductsPage();
	}


	public void TC_01_Pagging() {
		productsPage.openPageAtTableByIndex("2");
		Assert.assertTrue(productsPage.isPageActivedAtTableByIndex("2"));
		
		productsPage.openPageAtTableByIndex("3");
		Assert.assertTrue(productsPage.isPageActivedAtTableByIndex("3"));
		
		productsPage.openPageAtTableByIndex("1");
		Assert.assertTrue(productsPage.isPageActivedAtTableByIndex("1"));
		
		productsPage.openPageAtTableByIndex("3");
		Assert.assertTrue(productsPage.isPageActivedAtTableByIndex("3"));
		
		productsPage.openPageAtTableByIndex("1");
		Assert.assertTrue(productsPage.isPageActivedAtTableByIndex("1"));
	}

	@Test
	public void TC_02_Select_Deselect_All() {
		productsPage.checkToSelectAllCheckbox();
		productsPage.sleepInSecond(1);
		productsPage.allProductsCheckBoxChecked();
		
		productsPage.unCheckToSelectAllCheckbox();
		productsPage.sleepInSecond(1);
		productsPage.allProductsCheckBoxUnChecked();
		
		productsPage.CheckToProductCheckboxByName("$100 Physical Gift Card");
		productsPage.sleepInSecond(1);
		
		productsPage.CheckToProductCheckboxByName("$25 Virtual Gift Card");
		productsPage.sleepInSecond(1);
		
		productsPage.CheckToProductCheckboxByName("$50 Physical Gift Card");
		productsPage.sleepInSecond(1);
		
		
	}

	@Test
	public void TC_03_Pagging() {

	}

	@Test
	public void TC_04_Pagging() {

	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	AdminLoginPagePO loginPage;
	AdminDashBoardPagePO dashboardPage;
	AdminProductsPagePO productsPage;
}
