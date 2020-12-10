package pageObjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.AbstractPage;
import pageUIs.AdminProductsPageUI;

public class AdminProductsPagePO extends AbstractPage {
	WebDriver driver;

	public AdminProductsPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public void openPageAtTableByIndex(String indexPage) {
		waitForElementClickable(driver, AdminProductsPageUI.PAGGING_AT_TABLE_BY_INDEX, indexPage);
		clickToElement(driver, AdminProductsPageUI.PAGGING_AT_TABLE_BY_INDEX, indexPage);
	}

	public boolean isPageActivedAtTableByIndex(String indexPage) {
		waitForElementVisible(driver, AdminProductsPageUI.PAGGING_ACTIVE_AT_TABLE_BY_INDEX, indexPage);
		return isElementDisplayed(driver, AdminProductsPageUI.PAGGING_ACTIVE_AT_TABLE_BY_INDEX, indexPage);
	}

	public void checkToSelectAllCheckbox() {
		waitForElementClickable(driver, AdminProductsPageUI.SELECT_ALL_CHECKBOX);
		checkTheCheckbox(driver, AdminProductsPageUI.SELECT_ALL_CHECKBOX);
	}

	public void unCheckToSelectAllCheckbox() {
		waitForElementClickable(driver, AdminProductsPageUI.SELECT_ALL_CHECKBOX);
		uncheckTheCheckbox(driver, AdminProductsPageUI.SELECT_ALL_CHECKBOX);
	}

	public void allProductsCheckBoxChecked() {
		List<WebElement> AllProductCheckBoxes = getElements(driver, AdminProductsPageUI.SELECT_ALL_CHECKBOX);
		for (WebElement productCheckbox : AllProductCheckBoxes) {
			Assert.assertTrue(productCheckbox.isSelected());
		}
		
	}

	public void allProductsCheckBoxUnChecked() {
		List<WebElement> AllProductCheckBoxes = getElements(driver, AdminProductsPageUI.SELECT_ALL_CHECKBOX);
		for (WebElement productCheckbox : AllProductCheckBoxes) {
			Assert.assertFalse(productCheckbox.isSelected());
		}
	}

	public void CheckToProductCheckboxByName(String productname) {
		waitForElementClickable(driver, AdminProductsPageUI.PRODUCT_CHECKBOX, productname);
		checkTheCheckbox(driver, AdminProductsPageUI.PRODUCT_CHECKBOX, productname);
	}
	
}
