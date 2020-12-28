package pageObjects.nopCommerce;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import commons.AbstractPage;
import pageUIs.nopCommerce.AdminProductsPageUI;

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

	public boolean areProductDetailDisplayed(String productNameOrDefaulName, String productName, String sku, String price, String quantity, String productType, String publishStatus) {
		waitForElementVisible(driver, AdminProductsPageUI.PRODUCT_DETAIL_IN_TABLE, productNameOrDefaulName.toLowerCase().replace(" ", "-"), productName, sku, price, quantity, productType, publishStatus);
		return isElementDisplayed(driver, AdminProductsPageUI.PRODUCT_DETAIL_IN_TABLE, productNameOrDefaulName.toLowerCase().replace(" ", "-"), productName, sku, price, quantity, productType, publishStatus);
	}

	public void selectNumberItemDropdown(String itemValue) {
		waitForElementClickable(driver, AdminProductsPageUI.NUMBER_ITEM_DROPDOWN);
		selectItemInDropdown(driver, AdminProductsPageUI.NUMBER_ITEM_DROPDOWN, itemValue);
		WaitForLoadingIconInvisible(driver);
	}

	public void clickToEditButtonByProductName(String productname) {
		waitForElementClickable(driver, AdminProductsPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productname);
		clickToElement(driver, AdminProductsPageUI.EDIT_BUTTON_BY_PRODUCT_NAME, productname);
		WaitForLoadingIconInvisible(driver);
	}

	public boolean isInformationDisplayedAtColumnNameAndRowNumber(String columnName, String rowIndex, String expectedValue) {
		int columnNameIndex = countElementNumber(driver, AdminProductsPageUI.COLUMN_NAME_SIBLING, columnName) + 1;
		String actualValue = getTextElement(driver, AdminProductsPageUI.CELL_VALUE_MIX_BY_COLUMN_AND_ROW_INDEX, rowIndex, String.valueOf(columnNameIndex));		
		return actualValue.equals(expectedValue);
	}

	public boolean isPublicStatusAtColumnNameAndRowNumber(String columnName, String rowIndex, String publicStatus) {
		int columnNameIndex = countElementNumber(driver, AdminProductsPageUI.COLUMN_NAME_SIBLING, columnName) + 1;
		return isElementDisplayed(driver, AdminProductsPageUI.PUBLIC_STATUS_MIX_BY_COLUMN_AND_ROW_INDEX, rowIndex, String.valueOf(columnNameIndex), publicStatus);
	}

	public void inputProductNameTextbox(String productName) {
		waitForElementVisible(driver, AdminProductsPageUI.PRODUCT_NAME_TEXT_BOX);
		sendkeyToElement(driver, AdminProductsPageUI.PRODUCT_NAME_TEXT_BOX, productName);
	}

	public void clickToSearchButton() {
		waitForElementClickable(driver, AdminProductsPageUI.SEARCH_BUTTON);
		clickToElement(driver, AdminProductsPageUI.SEARCH_BUTTON);
		WaitForLoadingIconInvisible(driver);
	}

	public void scrollToPanelByPanelID(String panelID) {
		scrollToElement(driver, AdminProductsPageUI.PANEL_BY_PANEL_ID, panelID);
	}

	public boolean isNewPictureUploadSuccess(String fileName) {
		waitForElementInvisible(driver, AdminProductsPageUI.SPINNER_UPLOAD);
		return isElementDisplayed(driver, AdminProductsPageUI.UPLOAD_FILE_NAME, fileName);
	}

	public void inputToAltTextbox(String pictureDescription) {
		waitForElementVisible(driver, AdminProductsPageUI.ALT_TEXTBOX);
		sendkeyToElement(driver, AdminProductsPageUI.ALT_TEXTBOX, pictureDescription);
	}

	public void inputToTitleTextbox(String pictureTitle) {
		waitForElementVisible(driver, AdminProductsPageUI.TITLE_TEXTBOX);
		sendkeyToElement(driver, AdminProductsPageUI.TITLE_TEXTBOX, pictureTitle);	}

	public void clickToIconAtOrderTextbox(String iconValue) {
		waitForElementClickable(driver, AdminProductsPageUI.ICON_VALUE_AT_ORDER_TEXTBOX, iconValue);
		clickToElement(driver, AdminProductsPageUI.ICON_VALUE_AT_ORDER_TEXTBOX, iconValue);
	}

	public void clickToAddProductPictureButton() {
		waitForElementClickable(driver, AdminProductsPageUI.ADD_PRODECT_PICTURE_BUTTON);
		clickToElement(driver, AdminProductsPageUI.ADD_PRODECT_PICTURE_BUTTON);
		WaitForLoadingIconInvisible(driver);
	}

	public boolean areProductPictureDetailDisplayed(String productName, String pictureOrder, String pictureAlt, String pictureTitle) {
		waitForElementVisible(driver, AdminProductsPageUI.PRODUCT_PICTURE_UPLOADED_DETAIL, productName.toLowerCase().replace(" ", "-"), pictureOrder, pictureAlt, pictureTitle);
		return isElementDisplayed(driver, AdminProductsPageUI.PRODUCT_PICTURE_UPLOADED_DETAIL, productName.toLowerCase().replace(" ", "-"), pictureOrder, pictureAlt, pictureTitle);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, AdminProductsPageUI.SAVE_BUTTON);
		clickToElement(driver, AdminProductsPageUI.SAVE_BUTTON);
		WaitForLoadingIconInvisible(driver);
	}

	public void clickToDeleteButtonByTitle(String pictureTitle) {
		waitForElementClickable(driver, AdminProductsPageUI.DELETE_BUTTON_BY_TITLE, pictureTitle);
		clickToElement(driver, AdminProductsPageUI.DELETE_BUTTON_BY_TITLE, pictureTitle);
		waitAlertPresence(driver);
		acceptAlert(driver);
		WaitForLoadingIconInvisible(driver);
	}

	
}
