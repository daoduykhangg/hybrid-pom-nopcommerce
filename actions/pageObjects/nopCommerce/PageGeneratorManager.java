package pageObjects.nopCommerce;

import org.openqa.selenium.WebDriver;

public class PageGeneratorManager {
	public static UserHomePO getUserHomePage(WebDriver driver) {
		return new UserHomePO(driver);
	}
	
	public static UserLoginPO getUserLoginPage(WebDriver driver) {
		return new UserLoginPO(driver);
	}
	
	public static UserRegisterPO getUserRegisterPage(WebDriver driver) {
		return new UserRegisterPO(driver);
	}
	
	public static UserCustomerInforPO getUserCustomerInforPage(WebDriver driver) {
		return new UserCustomerInforPO(driver);
	}
	
	public static UserAddressesPO getUserAddressesPage(WebDriver driver) {
		return new UserAddressesPO(driver);
	}
	
	public static UserOrdersPO getUserOrdersPage(WebDriver driver) {
		return new UserOrdersPO(driver);
	}
	
	public static UserMyProductReviewPO getUserMyProductReviewPage(WebDriver driver) {
		return new UserMyProductReviewPO(driver);
	}
	
	public static UserChangePasswordPagePO getUserChangePasswordPage(WebDriver driver) {
		return new UserChangePasswordPagePO(driver);
	}
	
	public static AdminLoginPagePO getAdminLoginPage(WebDriver driver) {
		return new AdminLoginPagePO(driver);
	}
	
	public static AdminDashBoardPagePO getAdminDashBoardPage(WebDriver driver) {
		return new AdminDashBoardPagePO(driver);
	}
	
	public static AdminProductsPagePO getAdminProductsPage(WebDriver driver) {
		return new AdminProductsPagePO(driver);
	}
	public static UserProductsPO getUserProductsPage(WebDriver driver) {
		return new UserProductsPO(driver);
	}
}
