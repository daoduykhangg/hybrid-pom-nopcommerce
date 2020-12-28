package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;

public class UserDetailPageObject extends AbstractPage {
	WebDriver driver;

	public UserDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}
}
