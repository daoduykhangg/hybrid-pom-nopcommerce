package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.AdminLoginPageUI;

public class AdminLoginPagePO extends AbstractPage {
	WebDriver driver;

	public AdminLoginPagePO(WebDriver driver) {
		this.driver = driver;
	}

	public void sendkeyToEmailTextbox(String email) {
		waitForElementClickable(driver, AdminLoginPageUI.EMAIL_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.EMAIL_TEXTBOX, email);

	}

	public void sendkeyToPasswordTextbox(String password) {
		waitForElementClickable(driver, AdminLoginPageUI.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, AdminLoginPageUI.PASSWORD_TEXTBOX, password);

	}

	public AdminDashBoardPagePO clickToLoginButton() {
		waitForElementClickable(driver, AdminLoginPageUI.LOGIN_BUTTON);
		clickToElement(driver, AdminLoginPageUI.LOGIN_BUTTON);
		return PageGeneratorManager.getAdminDashBoardPage(driver);
	}

	public AdminDashBoardPagePO loginToSystem(String email, String password) {
		sendkeyToEmailTextbox(email);
		sendkeyToPasswordTextbox(password);
		return clickToLoginButton();
	}

}
