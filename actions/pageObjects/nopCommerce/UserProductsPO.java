package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.nopCommerce.UserProductsPageUI;

public class UserProductsPO extends AbstractPage {
	WebDriver driver;

	public UserProductsPO(WebDriver driver) {
		this.driver = driver;
	}

	public void selectItemInProductSortDropdown(String itemValue) {
		waitForElementClickable(driver, UserProductsPageUI.SORT_BY_DROPDOWN);
		selectItemInDropdown(driver, UserProductsPageUI.SORT_BY_DROPDOWN, itemValue);
	}

	public boolean areProductNameSortByAscending() {
		waitForAllElementVisible(driver, UserProductsPageUI.ALL_PRODUCT_NAME);
		return isDataStringSortedAscending(driver, UserProductsPageUI.ALL_PRODUCT_NAME);
	}

	public boolean areProductNameSortByDescending() {
		waitForAllElementVisible(driver, UserProductsPageUI.ALL_PRODUCT_NAME);
		return isDataStringSortedDescending(driver, UserProductsPageUI.ALL_PRODUCT_NAME);
	}

	public boolean areProductPriceSortByAscending() {
		waitForAllElementVisible(driver, UserProductsPageUI.ALL_PRODUCT_PRICE);
		return isDataFloatStringSortedAscending(driver, UserProductsPageUI.ALL_PRODUCT_PRICE);
	}

	public boolean areProductPriceSortByDescending() {
		waitForAllElementVisible(driver, UserProductsPageUI.ALL_PRODUCT_PRICE);
		return isDataFloatStringSortedDescending(driver, UserProductsPageUI.ALL_PRODUCT_PRICE);
	}

	public void selectPerPageDisplayedDropdown(String perPageValue) {
		waitForElementClickable(driver, UserProductsPageUI.DISPLAY_PERPAGE_DORPDOWN);
		selectItemInDropdown(driver, UserProductsPageUI.DISPLAY_PERPAGE_DORPDOWN, perPageValue);
	}

	public boolean areThreeProductsDisplayed() {
		waitForAllElementVisible(driver, UserProductsPageUI.ALL_PRODUCT_NAME);
		int elementNumber = countElementNumber(driver, UserProductsPageUI.ALL_PRODUCT_NAME);
		if(elementNumber <= 3) {
			return true;
			
		}else {
			return false;
		}
	}
	public boolean areSixProductsDisplayed() {
		waitForAllElementVisible(driver, UserProductsPageUI.ALL_PRODUCT_NAME);
		int elementNumber = countElementNumber(driver, UserProductsPageUI.ALL_PRODUCT_NAME);
		if(elementNumber <= 6) {
			return true;
			
		}else {
			return false;
		}
	}
	public boolean areNineProductsDisplayed() {
		waitForAllElementVisible(driver, UserProductsPageUI.ALL_PRODUCT_NAME);
		int elementNumber = countElementNumber(driver, UserProductsPageUI.ALL_PRODUCT_NAME);
		if(elementNumber <= 9) {
			return true;
			
		}else {
			return false;
		}
	}

	public boolean isNextIconDisplayed() {
		waitForElementClickable(driver, UserProductsPageUI.NEXT_ICON_LINK);
		return isElementDisplayed(driver, UserProductsPageUI.NEXT_ICON_LINK);
	}

	public void clickToNextIconLink() {
		waitForElementClickable(driver, UserProductsPageUI.NEXT_ICON_LINK);
		clickToElement(driver, UserProductsPageUI.NEXT_ICON_LINK);
	}

	public boolean isPreviousIconDisplayed() {
		waitForElementClickable(driver, UserProductsPageUI.PREVIOUS_ICON_LINK);
		return isElementDisplayed(driver, UserProductsPageUI.PREVIOUS_ICON_LINK);
	}

	public boolean isPagerUndisplayed() {
		return isElementUndisplayed(driver, UserProductsPageUI.PAGER);
	}
}
