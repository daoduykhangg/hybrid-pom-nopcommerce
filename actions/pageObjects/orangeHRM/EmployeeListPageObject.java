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

	public void enterToEmployeeNameTextboxAtEmployeeInformationForm(String employeeName) {
		waitForElementVisible(driver, EmployeeListPageUI.EMPLOYEE_NAME_TEXTBOX);
		sendkeyToElement(driver, EmployeeListPageUI.EMPLOYEE_NAME_TEXTBOX, employeeName);
	}

	public void enterToIdTextboxAtEmployeeInformationForm(String employeeId) {
		waitForElementVisible(driver, EmployeeListPageUI.EMPLOYEE_ID_TEXTBOX);
		sendkeyToElement(driver, EmployeeListPageUI.EMPLOYEE_ID_TEXTBOX, employeeId);
	}

	public void enterToSupervisorNameTextboxAtEmployeeInformationForm(String supervisorName) {
		waitForElementVisible(driver, EmployeeListPageUI.SUPERVISOR_NAME_TEXTBOX);
		sendkeyToElement(driver, EmployeeListPageUI.SUPERVISOR_NAME_TEXTBOX, supervisorName);
	}

	public void selectEmployeeStatusDropdownAtEmployeeInformationForm(String employeeStatus) {
		waitForElementClickable(driver, EmployeeListPageUI.EMPLOYEE_STATUS_DROPDOWN);
		selectItemInDropdown(driver, EmployeeListPageUI.EMPLOYEE_STATUS_DROPDOWN, employeeStatus);
	}

	public void selectIncludeDropdownAtEmployeeInformationForm(String include) {
		waitForElementClickable(driver, EmployeeListPageUI.INCLUDE_DROPDOWN);
		selectItemInDropdown(driver, EmployeeListPageUI.INCLUDE_DROPDOWN, include);
	}

	public void selectJobTitleDropdownAtEmployeeInformationForm(String jobTitle) {
		waitForElementClickable(driver, EmployeeListPageUI.JOB_TITLE_DROPDOWN);
		selectItemInDropdown(driver, EmployeeListPageUI.JOB_TITLE_DROPDOWN, jobTitle);
	}

	public void selectSubUnitDropdownAtEmployeeInformationForm(String subUnit) {
		waitForElementClickable(driver, EmployeeListPageUI.SUB_UNIT_DROPDOWN);
		selectItemInDropdown(driver, EmployeeListPageUI.SUB_UNIT_DROPDOWN, subUnit);
	}
	
	public void WaitForLoadingIconInvisible(WebDriver driver) {
		waitForElementInvisible(driver, EmployeeListPageUI.LOADING_ICON);
	}
}
