package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdminDashBoardPageUI;

public class AdminDashBoardPagePO extends AbstractPage {
	WebDriver driver;

	public AdminDashBoardPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public AdminProductsPagePO openProductsPage() {
		waitForElementClickable(driver, AdminDashBoardPageUI.CATALOG_TEXT_AT_SIDEBAR);
		clickToElement(driver, AdminDashBoardPageUI.CATALOG_TEXT_AT_SIDEBAR);
		waitForElementClickable(driver, AdminDashBoardPageUI.PRODUCTS_LINK_AT_SIDEBAR);
		clickToElement(driver, AdminDashBoardPageUI.PRODUCTS_LINK_AT_SIDEBAR);
		WaitForLoadingIconInvisible(driver);
		return PageGeneratorManager.getAdminProductsPage(driver);
	}
}
