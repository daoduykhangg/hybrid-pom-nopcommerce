package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.orangeHRM.EmployeeListPageUI;

public class EmployeeListPageObject extends AbstractPage {
	WebDriver driver;

	public EmployeeListPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public EmployeeDetailPageObject clickToAddButton() {
		waitForElementClickable(driver, EmployeeListPageUI.ADD_BUTTON);
		clickToElement(driver, EmployeeListPageUI.ADD_BUTTON);
		return PageGeneratorManager.getEmployeeDetailPage(driver);
	}
}
