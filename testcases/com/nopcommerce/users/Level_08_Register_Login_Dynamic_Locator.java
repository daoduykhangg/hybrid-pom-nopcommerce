package com.nopcommerce.users;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.AddressesPageObject;
import pageObjects.CustomerInforPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyProductReviewPageObject;
import pageObjects.OrdersPageObject;
import pageObjects.PageGeneratorManager;
import pageObjects.RegisterPageObject;

public class Level_08_Register_Login_Dynamic_Locator extends AbstractTest{
	WebDriver driver;
	//Select select;
	String firstName, lastName, email, company, password;

	@Parameters("browser")
	@BeforeTest
	public void beforeTest(String browserName) {
		driver = getBrowserDriver(browserName);
		
		firstName = "Khang";
		lastName = "Dao";
		email = "duykhangkma" + getRandomNumber() + "@gmail.com";
		company = "DuyKhang KMA";
		password = "123456";
	}

	@Test
	public void TC_01_Register() {
		homePage = PageGeneratorManager.getHomePage(driver);
		
		registerPage = homePage.clickToRegisterLink();
		
		registerPage.clickToGenderMaleRadioButton();
		registerPage.sendkeyToFirstNameTextbox(firstName);
		registerPage.sendkeyToLastNameTextbox(lastName);

		registerPage.selectDayDropdown("21");
		registerPage.selectMonthDropdown("August");
		registerPage.selectYearDropdown("1996");

		registerPage.sendkeyToEmailextbox(email);
		registerPage.sendkeyToCompanyTextbox(company);
		registerPage.sendkeyToPasswordTextbox(password);
		registerPage.sendkeyToConfirmPasswordTextbox(password);

		registerPage.clickToRegisterButton();

		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		homePage = registerPage.ClickToLogoutLink();
	}

	@Test
	public void TC_02_Login() {
		loginPage = homePage.clickToLoginLink();
		
		loginPage.sendkeyToEmailTextbox(email);
		loginPage.sendkeyToPasswordTextbox(password);
		homePage = loginPage.clickToLoginButton();

		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		Assert.assertTrue(homePage.isLogoutLinkDisplayed());
	}

	@Test
	public void TC_03_View_My_Account() {
		customerInforPage = homePage.clickToMyAccountLink();

		Assert.assertTrue(customerInforPage.isGenderMaleRadioButtonSelected());
		Assert.assertEquals(customerInforPage.getFirstNameTextboxValue(), firstName);
		Assert.assertEquals(customerInforPage.getLastNameTextboxValue(), lastName);

		Assert.assertEquals(customerInforPage.getSelectedTextInDayDropdown(), "21");
		Assert.assertEquals(customerInforPage.getSelectedTextInMonthDropdown(), "August");
		Assert.assertEquals(customerInforPage.getSelectedTextInYearDropdown(), "1996");

		Assert.assertEquals(customerInforPage.getEmailTextboxValue(), email);
		Assert.assertEquals(customerInforPage.getCompanyTextboxValue(), company);
		Assert.assertTrue(customerInforPage.isNewsletterCheckboxSelected());

	}

	@Test
	public void TC_04_Switch_Page() {
		addressesPage = customerInforPage.clickToAddressesLink(driver);
		
		myProductReviewPage = addressesPage.clickToMyProductReviewLink(driver);
		
		ordersPage = myProductReviewPage.clickToOrdersLink(driver);
		
		myProductReviewPage = ordersPage.clickToMyProductReviewLink(driver);
		
		addressesPage = myProductReviewPage.clickToAddressesLink(driver);
		
		customerInforPage = addressesPage.clickToCustomerInforLink(driver);	
	}
	
	@Test
	public void TC_05_Switch_Page_Dynamic_Locator_Solution_01() {

		addressesPage = (AddressesPageObject) customerInforPage.ClickToLinkByPageName(driver, "Addresses");
		
		myProductReviewPage = (MyProductReviewPageObject) addressesPage.ClickToLinkByPageName(driver, "My product reviews");
		
		ordersPage = (OrdersPageObject) myProductReviewPage.ClickToLinkByPageName(driver, "Orders");
		
		myProductReviewPage = (MyProductReviewPageObject) ordersPage.ClickToLinkByPageName(driver, "My product reviews");
		
		addressesPage = (AddressesPageObject) myProductReviewPage.ClickToLinkByPageName(driver, "Addresses");
		
		customerInforPage = (CustomerInforPageObject) addressesPage.ClickToLinkByPageName(driver, "Customer info");
		
	}

	@Test
	public void TC_06_Switch_Page_Dynamic_Locator_Solution_02() {
		customerInforPage.ClickToLinkWithPageName(driver, "Addresses");
		addressesPage = PageGeneratorManager.getAddressesPage(driver);
		
		addressesPage.ClickToLinkWithPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getMyProductReviewPage(driver);
		
		myProductReviewPage.ClickToLinkWithPageName(driver, "Orders");
		ordersPage = PageGeneratorManager.getOrdersPage(driver);
		
		ordersPage.ClickToLinkWithPageName(driver, "My product reviews");
		myProductReviewPage = PageGeneratorManager.getMyProductReviewPage(driver);
		
		myProductReviewPage.ClickToLinkWithPageName(driver, "Addresses");
		addressesPage = PageGeneratorManager.getAddressesPage(driver);
		
		addressesPage.ClickToLinkWithPageName(driver, "Customer info");
		customerInforPage = PageGeneratorManager.getCustomerInforPage(driver);
	}
	
	@AfterTest
	public void afterTest() {
		driver.quit();
	}

	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	CustomerInforPageObject customerInforPage;
	AddressesPageObject addressesPage;
	OrdersPageObject ordersPage;
	MyProductReviewPageObject myProductReviewPage;
}
