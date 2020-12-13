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

public class Level_10_Upload_File extends AbstractTest {
	WebDriver driver;
	String filename = "HoChiMinh.jpg";
	String productName = "Adobe Photoshop CS4";
	String pictureAlt = "Alt";
	String pictureTitle = "Title";
	String pictureOrder = "1";

	@Parameters({ "browser", "url" })
	@BeforeTest
	public void beforeTest(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);

		loginPage = PageGeneratorManager.getAdminLoginPage(driver);

		dashboardPage = loginPage.loginToSystem("admin@yourstore.com", "admin");
		productsPage = dashboardPage.openProductsPage();
	}

	@Test
	public void TC_01_Upload_File() {
		productsPage.inputProductNameTextbox(productName);
		productsPage.clickToSearchButton();
		productsPage.clickToEditButtonByProductName(productName);
		productsPage.scrollToPanelByPanelID("product-pictures");
		productsPage.openToPanelByPanelID(driver, "product-pictures");
		
		productsPage.uploadMultipleFiles(driver, "product-pictures", filename);
		Assert.assertTrue(productsPage.isNewPictureUploadSuccess(filename));
		productsPage.inputToAltTextbox(pictureAlt);
		productsPage.inputToTitleTextbox(pictureTitle);
		productsPage.clickToIconAtOrderTextbox("Increase");
		productsPage.clickToAddProductPictureButton();
		Assert.assertTrue(productsPage.areProductPictureDetailDisplayed(productName, pictureOrder, pictureAlt, pictureTitle));
		productsPage.clickToSaveButton();
		
		productsPage.inputProductNameTextbox(productName);
		productsPage.clickToSearchButton();
		Assert.assertTrue(productsPage.areProductDetailDisplayed(productName, productName, "AD_CS4_PH", "75", "10000", "Simple", "true"));
		productsPage.clickToEditButtonByProductName(productName);
		productsPage.scrollToPanelByPanelID("product-pictures");
		productsPage.openToPanelByPanelID(driver, "product-pictures");
		productsPage.clickToDeleteButtonByTitle(pictureTitle);
		productsPage.clickToSaveButton();
		
		productsPage.inputProductNameTextbox(productName);
		productsPage.clickToSearchButton();
		Assert.assertTrue(productsPage.areProductDetailDisplayed("default-image", productName, "AD_CS4_PH", "75", "10000", "Simple", "true"));
		
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	AdminLoginPagePO loginPage;
	AdminDashBoardPagePO dashboardPage;
	AdminProductsPagePO productsPage;
}
