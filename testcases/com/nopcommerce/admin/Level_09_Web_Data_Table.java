package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.nopCommerce.AdminDashBoardPagePO;
import pageObjects.nopCommerce.AdminLoginPagePO;
import pageObjects.nopCommerce.AdminProductsPagePO;
import pageObjects.nopCommerce.PageGeneratorManager;

public class Level_09_Web_Data_Table extends AbstractTest {
	WebDriver driver;

	@Parameters({ "browser", "url" })
	@BeforeClass
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
	public void TC_03_Displayed_All() {
		Assert.assertTrue(productsPage.areProductDetailDisplayed("Adobe Photoshop CS4", "Adobe Photoshop CS4", "AD_CS4_PH", "75", "10000", "Simple", "true"));
		Assert.assertTrue(productsPage.areProductDetailDisplayed("Apple iCam", "Apple iCam", "APPLE_CAM", "1300", "10000", "Simple", "true"));
		Assert.assertTrue(productsPage.areProductDetailDisplayed("Apple MacBook Pro 13-inch", "Apple MacBook Pro 13-inch", "AP_MBP_13", "1800", "10000", "Simple", "true"));
		
		productsPage.selectNumberItemDropdown("50");
		Assert.assertTrue(productsPage.areProductDetailDisplayed("Windows 8 Pro", "Windows 8 Pro", "MS_WIN_8P", "65", "10000", "Simple", "false"));
	}


	public void TC_04_Edit() {
		productsPage.clickToEditButtonByProductName("Adobe Photoshop CS4");
		productsPage.backToPage(driver);
		
		productsPage.clickToEditButtonByProductName("Apple iCam");
		productsPage.backToPage(driver);
		
		productsPage.selectNumberItemDropdown("50");
		productsPage.clickToEditButtonByProductName("Windows 8 Pro");
		productsPage.backToPage(driver);
		

	}

	@Test
	public void TC_05_Position() {
		Assert.assertTrue(productsPage.isInformationDisplayedAtColumnNameAndRowNumber("Product name", "1", "$100 Physical Gift Card"));
		Assert.assertTrue(productsPage.isInformationDisplayedAtColumnNameAndRowNumber("SKU", "1", "PG_CR_100"));
		Assert.assertTrue(productsPage.isInformationDisplayedAtColumnNameAndRowNumber("Price", "1", "100"));
		Assert.assertTrue(productsPage.isInformationDisplayedAtColumnNameAndRowNumber("Stock quantity", "1", ""));
		Assert.assertTrue(productsPage.isInformationDisplayedAtColumnNameAndRowNumber("Product type", "1", "Simple"));

		Assert.assertTrue(productsPage.isPublicStatusAtColumnNameAndRowNumber("Published", "1", "true"));
	}
	
	@AfterClass
	public void afterTest() {
		driver.quit();
	}

	AdminLoginPagePO loginPage;
	AdminDashBoardPagePO dashboardPage;
	AdminProductsPagePO productsPage;
}
