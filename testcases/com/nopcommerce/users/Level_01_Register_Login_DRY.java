package com.nopcommerce.users;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterTest;

public class Level_01_Register_Login_DRY {
	WebDriver driver;
	Select select;
	String projectFolder = System.getProperty("user.dir");
	String firstName, lastName, email, company, password;

	@BeforeTest
	public void beforeTest() {
		System.setProperty("webdriver.gecko.driver", projectFolder + "\\browserDriver\\geckodriver.exe");
		driver = new FirefoxDriver();

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

		firstName = "Khang";
		lastName = "Dao";
		email = "DuyKhangKMA" + getRandomNumber() + "@gmail.com";
		company = "DuyKhang KMA";
		password = "123456";
	}

	@Test
	public void TC_01_Register() {
		driver.get("https://demo.nopcommerce.com/");

		driver.findElement(By.className("ico-register")).click();
		driver.findElement(By.id("gender-male")).click();
		driver.findElement(By.id("FirstName")).sendKeys(firstName);
		driver.findElement(By.id("LastName")).sendKeys(lastName);

		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		select.selectByVisibleText("21");

		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		select.selectByVisibleText("August");

		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		select.selectByVisibleText("1996");

		driver.findElement(By.id("Email")).sendKeys(email);
		driver.findElement(By.id("Company")).sendKeys(company);
		driver.findElement(By.id("Password")).sendKeys(password);
		driver.findElement(By.id("ConfirmPassword")).sendKeys(password);

		driver.findElement(By.id("register-button")).click();

		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='result']")).getText(), "Your registration completed");

		driver.findElement(By.className("ico-logout")).click();

	}

	@Test
	public void TC_02_Login() {
		driver.findElement(By.className("ico-login")).click();

		driver.findElement(By.className("email")).sendKeys(email);
		driver.findElement(By.className("password")).sendKeys(password);
		driver.findElement(By.cssSelector(".login-button")).click();
	}

	@Test
	public void TC_03_View_My_Account() {
		driver.findElement(By.className("ico-account")).click();

		Assert.assertTrue(driver.findElement(By.id("gender-male")).isSelected());
		Assert.assertEquals(driver.findElement(By.id("FirstName")).getAttribute("value"), firstName);
		Assert.assertEquals(driver.findElement(By.id("LastName")).getAttribute("value"), lastName);

		select = new Select(driver.findElement(By.name("DateOfBirthDay")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "21");

		select = new Select(driver.findElement(By.name("DateOfBirthMonth")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "August");

		select = new Select(driver.findElement(By.name("DateOfBirthYear")));
		Assert.assertEquals(select.getFirstSelectedOption().getText(), "1996");

		Assert.assertEquals(driver.findElement(By.id("Email")).getAttribute("value"), email);
		Assert.assertEquals(driver.findElement(By.id("Company")).getAttribute("value"), company);
		Assert.assertTrue(driver.findElement(By.id("Newsletter")).isSelected());
	}

	public int getRandomNumber() {
		Random rand = new Random();
		return rand.nextInt(999999);
	}

	@AfterTest
	public void afterTest() {
		driver.quit();
	}

}
