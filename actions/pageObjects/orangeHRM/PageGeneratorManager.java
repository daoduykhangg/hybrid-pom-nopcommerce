package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static DashBoardPageObject getDashBoardPage(WebDriver driver) {
		return new DashBoardPageObject(driver);
	}
	
	public static EmployeeListPageObject getEmployeeListPage(WebDriver driver) {
		return new EmployeeListPageObject(driver);
	}
	
	public static EmployeeDetailPageObject getEmployeeDetailPage(WebDriver driver) {
		return new EmployeeDetailPageObject(driver);
	}
}
