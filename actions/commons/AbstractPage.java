package commons;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import pageObjects.nopCommerce.PageGeneratorManager;
import pageObjects.nopCommerce.UserAddressesPO;
import pageObjects.nopCommerce.UserCustomerInforPO;
import pageObjects.nopCommerce.UserMyProductReviewPO;
import pageObjects.nopCommerce.UserOrdersPO;
import pageUIs.nopCommerce.NopcommerceAbstractPageUI;
import pageUIs.orangeHRM.OrangeHRMAbstractPageUI;

public class AbstractPage {
	public void openPageUrl(WebDriver driver, String url) {
		driver.get(url);
	}

	public String getCurrentPageTitle(WebDriver driver) {
		return driver.getTitle();
	}

	public String getCurrentPageUrl(WebDriver driver) {
		return driver.getCurrentUrl();
	}

	public void backToPage(WebDriver driver) {
		driver.navigate().back();
	}

	public void forwardToPage(WebDriver driver) {
		driver.navigate().forward();
	}

	public void refreshCurrentPage(WebDriver driver) {
		driver.navigate().refresh();
	}

	public void acceptAlert(WebDriver driver) {
		driver.switchTo().alert().accept();
	}

	public void cancelAlert(WebDriver driver) {
		driver.switchTo().alert().dismiss();
	}

	public void getTextAlert(WebDriver driver) {
		driver.switchTo().alert().getText();
	}

	public void setTextAlert(WebDriver driver, String value) {
		driver.switchTo().alert().sendKeys(value);
	}

	public void waitAlertPresence(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.alertIsPresent());
	}

	public void switchToWindowByID(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindow : allWindows) {
			if (!runWindow.equals(parentID)) {
				driver.switchTo().window(runWindow);
				break;
			}
		}
	}

	public void switchToWindowByTitle(WebDriver driver, String expectedPageTitle) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			driver.switchTo().window(runWindows);
			String actualPageTitle = driver.getTitle();
			if (actualPageTitle.equals(expectedPageTitle)) {
				break;
			}
		}
	}

	public void closeAllWindowsWithoutParent(WebDriver driver, String parentID) {
		Set<String> allWindows = driver.getWindowHandles();
		for (String runWindows : allWindows) {
			if (!runWindows.equals(parentID)) {
				driver.switchTo().window(runWindows);
				driver.close();
			}
		}
		driver.switchTo().window(parentID);
	}

	public By getByXpath(String locator) {
		return By.xpath(locator);
	}

	public String getDynamicLocator(String locator, String... values) {
		locator = String.format(locator, (Object[]) values);
		return locator;
	}

	public WebElement getElement(WebDriver driver, String locator) {
		return driver.findElement(getByXpath(locator));
	}

	public List<WebElement> getElements(WebDriver driver, String locator) {
		return driver.findElements(getByXpath(locator));
	}

	public void clickToElement(WebDriver driver, String locator) {
		if (driver.toString().contains("edge")) {
			sleepInMiliSecond(500);
		}
		element = getElement(driver, locator);
		element.click();
	}

	public void clickToElement(WebDriver driver, String locator, String... values) {
		if (driver.toString().contains("edge")) {
			sleepInMiliSecond(500);
		}
		element = getElement(driver, getDynamicLocator(locator, values));
		element.click();
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value) {

		element = getElement(driver, locator);
		element.clear();
		if (driver.toString().contains("chrome") | driver.toString().contains("edge")) {
			sleepInMiliSecond(500);
		}
		element.sendKeys(value);
	}

	public void sendkeyToElement(WebDriver driver, String locator, String value, String... values) {

		element = getElement(driver, getDynamicLocator(locator, values));
		element.clear();
		if (driver.toString().contains("chrome") | driver.toString().contains("edge")) {
			sleepInMiliSecond(500);
		}
		element.sendKeys(value);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue) {
		element = getElement(driver, locator);
		select = new Select(element);
		select.selectByVisibleText(itemValue);
	}

	public void selectItemInDropdown(WebDriver driver, String locator, String itemValue, String... values) {
		element = getElement(driver, getDynamicLocator(locator, values));
		select = new Select(element);
		select.selectByVisibleText(itemValue);
	}

	public String getFirstSelectedText(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	public boolean isDropdownMultiple(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		select = new Select(element);
		return select.isMultiple();
	}

	public void selectItemInCustomDropdown(WebDriver driver, String parentLocator, String childItemLocator, String expectedItem) {
		getElement(driver, parentLocator).click();
		sleepInSecond(1);

		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByXpath(childItemLocator)));

		elements = getElements(driver, childItemLocator);

		for (WebElement item : elements) {
			if (item.getText().equals(expectedItem)) {
				jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);

				item.click();
				sleepInSecond(1);
				break;
			}
		}
	}

	public void sleepInSecond(long timeout) {
		try {
			Thread.sleep(timeout * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void sleepInMiliSecond(long timeout) {
		try {
			Thread.sleep(timeout);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName) {
		element = getElement(driver, locator);
		return element.getAttribute(attributeName);
	}

	public String getElementAttribute(WebDriver driver, String locator, String attributeName, String... values) {
		element = getElement(driver, getDynamicLocator(locator, values));
		return element.getAttribute(attributeName);
	}

	public String getTextElement(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		return element.getText().trim();
	}

	public String getTextElement(WebDriver driver, String locator, String... values) {
		element = getElement(driver, getDynamicLocator(locator, values));
		return element.getText().trim();
	}

	public int countElementNumber(WebDriver driver, String locator) {
		return getElements(driver, locator).size();
	}

	public int countElementNumber(WebDriver driver, String locator, String values) {
		return getElements(driver, getDynamicLocator(locator, values)).size();
	}

	public void checkTheCheckbox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void checkTheCheckbox(WebDriver driver, String locator, String... values) {
		element = getElement(driver, getDynamicLocator(locator, values));
		if (!element.isSelected()) {
			element.click();
		}
	}

	public void uncheckTheCheckbox(WebDriver driver, String locator) {
		element = getElement(driver, locator);
		if (element.isSelected()) {
			element.click();
		}
	}

	public void uncheckTheCheckbox(WebDriver driver, String locator, String... values) {
		element = getElement(driver, getDynamicLocator(locator, values));
		if (element.isSelected()) {
			element.click();
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator) {
		return getElement(driver, locator).isDisplayed();
	}

	public boolean isElementUndisplayed(WebDriver driver, String locator) {
//		System.out.println("Start time = " + new Date().toString());
		overideImplicitWait(driver, GlobalConstants.SHORT_TIMEOUT);
		elements = getElements(driver, locator);
		overideImplicitWait(driver, GlobalConstants.LONG_TIMEOUT);

		if (elements.size() == 0) {
//			System.out.println("Element is Undisplayed and NOT in DOM");
//			System.out.println("End time = " + new Date().toString());
			return true;
		} else if (elements.size() > 0 && !elements.get(0).isDisplayed()) {
//			System.out.println("Element is Undisplayed and in DOM");
//			System.out.println("End time = " + new Date().toString());
			return true;
		} else {
//			System.out.println("Element is Displayed and in DOM");
//			System.out.println("End time = " + new Date().toString());
			return false;
		}
	}

	public boolean isElementDisplayed(WebDriver driver, String locator, String... values) {
		return getElement(driver, getDynamicLocator(locator, values)).isDisplayed();
	}
	
	public boolean isElementSelected(WebDriver driver, String locator, String... values) {
		return getElement(driver, getDynamicLocator(locator, values)).isSelected();
	}

	public boolean isElementSelected(WebDriver driver, String locator) {
		return getElement(driver, locator).isSelected();
	}

	public boolean isElementEnabled(WebDriver driver, String locator) {
		return getElement(driver, locator).isEnabled();
	}

	public void switchToFrame(WebDriver driver, String locator) {
		driver.switchTo().frame(getElement(driver, locator));
	}

	public void switchToDefaultContent(WebDriver driver) {
		driver.switchTo().defaultContent();
	}

	public void doubleClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.doubleClick(getElement(driver, locator)).perform();
	}

	public void hoverMouseToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.moveToElement(getElement(driver, locator)).perform();
	}

	public void rightClickToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.contextClick(getElement(driver, locator)).perform();
	}

	public void clickAndHoldToElement(WebDriver driver, String locator) {
		action = new Actions(driver);
		action.clickAndHold(getElement(driver, locator)).perform();
	}

	public void dragAndDropElement(WebDriver driver, String sourceLocator, String targetLocator) {
		action = new Actions(driver);
		action.dragAndDrop(getElement(driver, sourceLocator), getElement(driver, targetLocator)).perform();
	}

	public void sendKeyBoardToElement(WebDriver driver, String locator, Keys key) {
		action = new Actions(driver);
		action.sendKeys(getElement(driver, locator), key).perform();
	}

	public Object executeForBrowser(WebDriver driver, String javaScript) {
		jsExecutor = (JavascriptExecutor) driver;
		return jsExecutor.executeScript(javaScript);
	}

	public String getInnerText(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return document.documentElement.innerText;");
	}

	public boolean areExpectedTextInInnerText(WebDriver driver, String textExpected) {
		jsExecutor = (JavascriptExecutor) driver;
		String textActual = (String) jsExecutor.executeScript("return document.documentElement.innerText.match('" + textExpected + "')[0]");
		return textActual.equals(textExpected);
	}

	public void scrollToBottomPage(WebDriver driver) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}

	public void navigateToUrlByJS(WebDriver driver, String url) {
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.location = '" + url + "'");
	}

	public void highlightElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute(arguments[1], arguments[2])", element, "style", originalStyle);
	}

	public void clickToElementByJS(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].click();", element);
	}

	public void scrollToElement(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		sleepInSecond(1);
	}

	public void scrollToElement(WebDriver driver, String locator, String... values) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, getDynamicLocator(locator, values));
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", element);
		sleepInSecond(1);
	}

	public void sendkeyToElementByJS(WebDriver driver, String locator, String value) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].setAttribute('value', '" + value + "')", element);
	}

	public void removeAttributeInDOM(WebDriver driver, String locator, String attributeRemove) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", element);
	}

	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		jsExecutor = (JavascriptExecutor) driver;

		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public boolean isImageLoaded(WebDriver driver, String locator) {
		jsExecutor = (JavascriptExecutor) driver;
		element = getElement(driver, locator);
		boolean status = (boolean) jsExecutor.executeScript("return arguments[0].complete && typeof arguments[0].naturalWidth !=\"undefined\" && arguments[0].naturalWidth > 0", element);
		if (status) {
			return true;
		}
		return false;
	}

	public void waitForElementVisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(locator)));
	}

	public void waitForElementVisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}

	public void waitForElementInvisible(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.SHORT_TIMEOUT);
		overideImplicitWait(driver, GlobalConstants.SHORT_TIMEOUT);

//		System.out.println("Start time for wait invisible = " + new Date().toString());
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(locator)));
//		System.out.println("End time for wait invisible = " + new Date().toString());

		overideImplicitWait(driver, GlobalConstants.LONG_TIMEOUT);
	}

	public void overideImplicitWait(WebDriver driver, long timeInSecond) {
		driver.manage().timeouts().implicitlyWait(timeInSecond, TimeUnit.SECONDS);
	}

	public void waitForElementInvisible(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByXpath(getDynamicLocator(locator, values))));
	}

	public void waitForElementClickable(WebDriver driver, String locator) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(locator)));
	}

	public void waitForElementClickable(WebDriver driver, String locator, String... values) {
		explicitWait = new WebDriverWait(driver, GlobalConstants.LONG_TIMEOUT);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByXpath(getDynamicLocator(locator, values))));
	}

	public void uploadMultipleFiles(WebDriver driver, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_FOLDER;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getElement(driver, OrangeHRMAbstractPageUI.UPLOAD_FILE_TYPE).sendKeys(fullFileName);
	}

	/* NopCommerce project */
	public UserAddressesPO clickToAddressesLink(WebDriver driver) {
		waitForElementVisible(driver, NopcommerceAbstractPageUI.ADDRESSES_LINK);
		clickToElement(driver, NopcommerceAbstractPageUI.ADDRESSES_LINK);
		return PageGeneratorManager.getUserAddressesPage(driver);
	}

	public UserCustomerInforPO clickToCustomerInforLink(WebDriver driver) {
		waitForElementClickable(driver, NopcommerceAbstractPageUI.CUSTOMER_INFOR_LINK);
		clickToElement(driver, NopcommerceAbstractPageUI.CUSTOMER_INFOR_LINK);
		return PageGeneratorManager.getUserCustomerInforPage(driver);
	}

	public UserOrdersPO clickToOrdersLink(WebDriver driver) {
		waitForElementClickable(driver, NopcommerceAbstractPageUI.ORDERS_LINK);
		clickToElement(driver, NopcommerceAbstractPageUI.ORDERS_LINK);
		return PageGeneratorManager.getUserOrdersPage(driver);
	}

	public UserMyProductReviewPO clickToMyProductReviewLink(WebDriver driver) {
		waitForElementClickable(driver, NopcommerceAbstractPageUI.MY_PRODUCT_REVIEW_LINK);
		clickToElement(driver, NopcommerceAbstractPageUI.MY_PRODUCT_REVIEW_LINK);
		return PageGeneratorManager.getUserMyProductReviewPage(driver);
	}

	public AbstractPage ClickToLinkByPageName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, NopcommerceAbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, NopcommerceAbstractPageUI.DYNAMIC_LINK, pageName);
		switch (pageName) {
		case "Addresses":
			return PageGeneratorManager.getUserAddressesPage(driver);
		case "Customer info":
			return PageGeneratorManager.getUserCustomerInforPage(driver);
		case "My product reviews":
			return PageGeneratorManager.getUserMyProductReviewPage(driver);
		default:
			return PageGeneratorManager.getUserOrdersPage(driver);
		}
	}

	public void ClickToLinkWithPageName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, NopcommerceAbstractPageUI.DYNAMIC_LINK, pageName);
		clickToElement(driver, NopcommerceAbstractPageUI.DYNAMIC_LINK, pageName);
	}

	public void WaitForLoadingIconInvisible(WebDriver driver) {
		waitForElementInvisible(driver, NopcommerceAbstractPageUI.LOADING_ICON);
	}

	public void openToPanelByPanelID(WebDriver driver, String panelID) {
		waitForElementClickable(driver, NopcommerceAbstractPageUI.PANEL_STATUS_BY_PANEL_ID, panelID);
		String panel_Status = getElementAttribute(driver, NopcommerceAbstractPageUI.PANEL_STATUS_BY_PANEL_ID, "class", panelID);
		if (!panel_Status.contains("opened")) {
			clickToElement(driver, NopcommerceAbstractPageUI.PANEL_STATUS_BY_PANEL_ID, panelID);
		}
	}

	public void uploadMultipleFilesByPanelID(WebDriver driver, String panelID, String... fileNames) {
		String filePath = GlobalConstants.UPLOAD_FOLDER;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getElement(driver, getDynamicLocator(NopcommerceAbstractPageUI.UPLOAD_FILE_BY_PANELID_BUTTON, panelID)).sendKeys(fullFileName);
	}

	public void clickToRadioButtonByID(WebDriver driver, String radiobuttonID) {
		waitForElementClickable(driver, NopcommerceAbstractPageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radiobuttonID);
		clickToElement(driver, NopcommerceAbstractPageUI.DYNAMIC_RADIO_BUTTON_BY_ID, radiobuttonID);
	}

	public void inputToTextboxByID(WebDriver driver, String textboxID, String value) {
		waitForElementVisible(driver, NopcommerceAbstractPageUI.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, NopcommerceAbstractPageUI.DYNAMIC_TEXTBOX_BY_ID, value, textboxID);
	}

	public void selectDropdownByName(WebDriver driver, String DropdownName, String value) {
		waitForElementClickable(driver, NopcommerceAbstractPageUI.DYNAMIC_DROPDOWN_BY_NAME, DropdownName);
		selectItemInDropdown(driver, NopcommerceAbstractPageUI.DYNAMIC_DROPDOWN_BY_NAME, value, DropdownName);
	}

	public void clickToButtonByValue(WebDriver driver, String buttonValue) {
		waitForElementClickable(driver, NopcommerceAbstractPageUI.DYNAMIC_BUTTON_BY_VALUE, buttonValue);
		clickToElement(driver, NopcommerceAbstractPageUI.DYNAMIC_BUTTON_BY_VALUE, buttonValue);
	}

	public String getErrorMessageAtMandantoryfieldByID(WebDriver driver, String fieldID) {
		waitForElementVisible(driver, NopcommerceAbstractPageUI.DYNAMIC_ERROR_MESSAGE_BY_ID, fieldID);
		return getTextElement(driver, NopcommerceAbstractPageUI.DYNAMIC_ERROR_MESSAGE_BY_ID, fieldID);
	}
	
	/* OrangeHRM project */
	public void openMenuPageByName(WebDriver driver, String pageName) {
		waitForElementClickable(driver, OrangeHRMAbstractPageUI.DYNAMIC_MENU_PAGE_BY_NAME, pageName);
		clickToElement(driver, OrangeHRMAbstractPageUI.DYNAMIC_MENU_PAGE_BY_NAME, pageName);
	}
	
	public void clickToButtonByNameAtFormHeader(WebDriver driver, String formHeader, String buttonName) {
		waitForElementClickable(driver, OrangeHRMAbstractPageUI.DYNAMIC_BUTTON_BY_NAME_AT_FORM_HEADER, formHeader, buttonName);
		clickToElement(driver, OrangeHRMAbstractPageUI.DYNAMIC_BUTTON_BY_NAME_AT_FORM_HEADER, formHeader, buttonName);
	}
	
	private WebElement element;
	private JavascriptExecutor jsExecutor;
	private WebDriverWait explicitWait;
	private Actions action;
	private List<WebElement> elements;
	private Select select;
}