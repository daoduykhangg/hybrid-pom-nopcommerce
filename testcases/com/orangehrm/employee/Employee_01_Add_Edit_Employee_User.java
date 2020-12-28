package com.orangehrm.employee;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.AbstractTest;
import pageObjects.orangeHRM.DashBoardPageObject;
import pageObjects.orangeHRM.EmployeeDetailPageObject;
import pageObjects.orangeHRM.EmployeeListPageObject;
import pageObjects.orangeHRM.LoginPageObject;
import pageObjects.orangeHRM.PageGeneratorManager;
import pageObjects.orangeHRM.UserDetailPageObject;

public class Employee_01_Add_Edit_Employee_User extends AbstractTest {
	WebDriver driver;
	LoginPageObject loginPage;
	DashBoardPageObject dashboardPage;
	EmployeeListPageObject employeeListPage;
	EmployeeDetailPageObject employeeDetailPage;
	UserDetailPageObject userDetailPage;
	String firstname, lastname, employeeID, image;
	String editFirstName, editLastName, editSSNNumber, editGender, editNationality, editMaritalStatus, editDateOfBirth;
	String payGrade, salaryComponent, payFrequency, currency, amount, comments;
	String address1, address2, city, state, zip, country, homeTelephone, mobile, workTelephone, workEmail, otherEmail;
	String jobTitle, employmentStatus, jobCategory, joinedDate, subUnit, location, startDate, endDate, contractFile;

	@Parameters({ "browser", "url" })
	@BeforeClass
	public void beforeTest(String browserName, String urlValue) {
		driver = getBrowserDriver(browserName, urlValue);
		firstname = "Khang";
		lastname = "Dao" + getRandomNumber();
		image = "HoChiMinh.jpg";

		editFirstName = "Manual";
		editLastName = "FC" + getRandomNumber();
		editSSNNumber = "852-21-6313";
		editGender = "Male";
		editNationality = "Vietnamese";
		editMaritalStatus = "Single";
		editDateOfBirth = "1996-08-21";

		payGrade = "Grade 1";
		salaryComponent = editFirstName + "- Annual Basic Payment	";
		payFrequency = "Monthly on first pay of month.";
		currency = "United States Dollar";
		amount = "55000";
		comments = "salary per month";

		address1 = "72614 Marquette Crossing";
		address2 = "16188 Starling Parkway";
		city = "San Diego";
		state = "California";
		zip = "92191";
		country = "United Kingdom";
		homeTelephone = "757-902-8769";
		mobile = "321-614-6116";
		workTelephone = "619-355-3812";
		workEmail = "edelhay" + getRandomNumber() + "@naver.com";
		otherEmail = "kkulas" + getRandomNumber() + "@webmd.com";

		jobTitle = "QA Engineer";
		employmentStatus = "Full-Time Contract";
		jobCategory = "Technicians";
		joinedDate = "2019-08-21";
		subUnit = "  Quality Assurance";
		location = "HQ - CA, USA";
		startDate = "2019-08-21";
		endDate = "2021-08-21";
		contractFile = "contract_detail.jpg";
		
		loginPage = PageGeneratorManager.getLoginPage(driver);

		log.info("Pre-condition - Step 01: Enter to Username textbox");
		loginPage.enterToUsernameTextbox("Admin");

		log.info("Pre-condition - Step 02: Enter to Password textbox");
		loginPage.enterToPasswordTextbox("admin123");

		log.info("Pre-condition - Step 03: Click to Login button");
		dashboardPage = loginPage.clickToLoginButton();
	}

	@Test
	public void Employee_01_Add_Employee() {
		log.info("Add Employee - Step 01:Click to 'PIM' page menu");
		dashboardPage.openMenuPageByName(driver, "PIM");
		employeeListPage = PageGeneratorManager.getEmployeeListPage(driver);

		log.info("Add Employee - Step 02: Click to 'Add Employee' Page");
		employeeDetailPage = employeeListPage.clickToAddButton();

		log.info("Add Employee - Step 03: Enter to FirstName textbox with value: " + firstname);
		employeeDetailPage.enterToFirstNameTextboxAtAddEmployeeForm(firstname);

		log.info("Add Employee - Step 04: Enter to LastName textbox with value: " + lastname);
		employeeDetailPage.enterToLastNameTextboxAtAddEmployeeForm(lastname);

		log.info("Add Employee - Step 05: Get Employee ID At Add Employee Form");
		employeeID = employeeDetailPage.getEmployeeIDValueAtAddEmployeeForm();

		log.info("Add Employee - Step 06: Upload 1 picture to Photograph");
		employeeDetailPage.uploadMultipleFiles(driver, image);

		log.info("Add Employee - Step 07: Click to Save button");
		employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Add Employee", "Save");

		log.info("Add Employee - Step 08: Verify Fullname at header is displayed");
		verifyTrue(employeeDetailPage.isFullNameDisplayedAtHeader(firstname + " " + lastname));

		log.info("Add Employee - Step 09: Verify Firstname displayed at Personal Detail is correct");
		verifyEquals(employeeDetailPage.getFirstNameValueAtPersonalDetailForm(), firstname);

		log.info("Add Employee - Step 10: Verify Lastname displayed at Personal Detail is correct");
		verifyEquals(employeeDetailPage.getLastNameValueAtPersonalDetailForm(), lastname);

		log.info("Add Employee - Step 11: Verify EmployeeID displayed at Personal Detail is correct");
		verifyEquals(employeeDetailPage.getEmployeeIDValueAtPersonalDetailForm(), employeeID);
	}

	@Test
	public void Employee_02_Edit_Employee() {
		log.info("Edit Employee [Personal] - Step 01: Click to 'Edit' button at 'Personal Details' Form");
		employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Personal Details", "Edit");

		log.info("Edit Employee [Personal] - Step 02: Enter new info To 'First Name' textbox");
		employeeDetailPage.enterToFirstNameTextboxAtPersonalDetailForm(editFirstName);

		log.info("Edit Employee [Personal] - Step 03: Enter new info To 'Last Name' textbox");
		employeeDetailPage.enterToLastNameTextboxAtPersonalDetailForm(editLastName);

		log.info("Edit Employee [Personal] - Step 04: Enter new info To 'SSN Number' textbox");
		employeeDetailPage.enterToSSNNumberTextboxAtPersonalDetailForm(editSSNNumber);

		log.info("Edit Employee [Personal] - Step 05: Click To 'Gender' radio with: " + editGender);
		employeeDetailPage.clickToGenderRadioAtPersonalDetailForm(editGender);

		log.info("Edit Employee [Personal] - Step 06: Select to 'Nationality' dropdown with: " + editNationality);
		employeeDetailPage.selectNationalityDropdownAtPersonalDetailForm(editNationality);

		log.info("Edit Employee [Personal] - Step 07: Select to 'Marital Status' dropdown with: " + editMaritalStatus);
		employeeDetailPage.selectMaritalStatusDropdownAtPersonalDetailForm(editMaritalStatus);

		log.info("Edit Employee [Personal] - Step 08: Enter new info To 'Date of Birth' textbox");
		employeeDetailPage.enterToDateOfBirthTextboxAtPersonalDetailForm(editDateOfBirth);

		log.info("Edit Employee [Personal] - Step 09: Click to 'Save' button at 'Personal Details' Form");
		employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Personal Details", "Save");

		log.info("Edit Employee [Personal] - Step 10: Verify Success message displayed with value 'Successfully Saved'");
		verifyEquals(employeeDetailPage.getSuccessMessageAtPersonalDetailForm(), "Successfully Saved");

		log.info("Edit Employee [Personal] - Step 11: Verify 'First Name' textbox edit successfully");
		verifyEquals(employeeDetailPage.getFirstNameValueAtPersonalDetailForm(), editFirstName);

		log.info("Edit Employee [Personal] - Step 12: Verify 'Last Name' textbox edit successfully");
		verifyEquals(employeeDetailPage.getLastNameValueAtPersonalDetailForm(), editLastName);

		log.info("Edit Employee [Personal] - Step 13: Verify 'SSN Number' textbox edit successfully");
		verifyEquals(employeeDetailPage.getSSNNumberValueAtPersonalDetailForm(), editSSNNumber);

		log.info("Edit Employee [Personal] - Step 14: Verify 'Gender' radio is selected");
		verifyTrue(employeeDetailPage.isGenderRadioButtonSelectedAtPersonalDetailForm(editGender));

		log.info("Edit Employee [Personal] - Step 15: Verify 'Nationality' dropdown edit successfully");
		verifyEquals(employeeDetailPage.getSelectedItemOfNatinalityDropdownAtPersonalDetailForm(), editNationality);

		log.info("Edit Employee [Personal] - Step 16: Verify 'Marital Status' dropdown edit successfully");
		verifyEquals(employeeDetailPage.getSelectedItemOfMaritalStatusDropdownAtPersonalDetailForm(), editMaritalStatus);

		log.info("Edit Employee [Personal] - Step 17: Verify 'Date of Birth' textbox edit successfully");
		verifyEquals(employeeDetailPage.getDateOfBirthValueAtPersonalDetailForm(), editDateOfBirth);
	}

	@Test
	public void Employee_03_Edit_Employee_By_Contact() {
		log.info("Edit Employee [Contact] - Step 01: Click to 'Contact deitals' tab");
		employeeDetailPage.openSideBarTabByName("Contact Details");

		log.info("Edit Employee [Contact] - Step 02: Click to 'Edit' button at 'Contact Details' Form");
		employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Contact Details", "Edit");

		log.info("Edit Employee [Contact] - Step 02: Enter to 'Address Street 1' textbox");
		employeeDetailPage.enterToAddressStreet1TextboxAtContactDetailsForm(address1);

		log.info("Edit Employee [Contact] - Step 03: Enter to 'Address Street 2' textbox");
		employeeDetailPage.enterToAddressStreet2TextboxAtContactDetailsForm(address2);

		log.info("Edit Employee [Contact] - Step 04: Enter to 'City' textbox");
		employeeDetailPage.enterToCityTextboxAtContactDetailsForm(city);

		log.info("Edit Employee [Contact] - Step 05: Enter to 'State/Province' textbox");
		employeeDetailPage.enterToStateTextboxAtContactDetailsForm(state);

		log.info("Edit Employee [Contact] - Step 06: Enter to 'Zip/Postal Code' textbox");
		employeeDetailPage.enterToZipTextboxAtContactDetailsForm(zip);

		log.info("Edit Employee [Contact] - Step 07: select 'Country' dropdown with value '" + country + "'");
		employeeDetailPage.selectCountryDropdownAtContactDetailsForm(country);

		log.info("Edit Employee [Contact] - Step 08: Enter to 'Home Telephone' textbox");
		employeeDetailPage.enterToHomeTelephoneTextboxAtContactDetailsForm(homeTelephone);

		log.info("Edit Employee [Contact] - Step 09: Enter to 'Mobile' textbox");
		employeeDetailPage.enterToMobileTextboxAtContactDetailsForm(mobile);

		log.info("Edit Employee [Contact] - Step 10: Enter to 'Work Telephone' textbox");
		employeeDetailPage.enterToWorkTelephoneTextboxAtContactDetailsForm(workTelephone);

		log.info("Edit Employee [Contact] - Step 11: Enter to 'Work Email' textbox");
		employeeDetailPage.enterToWorkEmailTextboxAtContactDetailsForm(workEmail);

		log.info("Edit Employee [Contact] - Step 12: Enter to 'Other Email' textbox");
		employeeDetailPage.enterToOtherEmailTextboxAtContactDetailsForm(otherEmail);

		log.info("Edit Employee [Contact] - Step 13: Click to 'Save' button at 'Contact Details' Form");
		employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Contact Details", "Save");

		log.info("Edit Employee [Contact] - Step 14: Verify Success Message displayed with value 'Successfully Saved'");
		verifyEquals(employeeDetailPage.getSuccessMessageAtPersonalDetailForm(), "Successfully Saved");

		log.info("Edit Employee [Contact] - Step 15: Verify 'Address Street 1' textbox edit successfully");
		verifyEquals(employeeDetailPage.getAddressStreet1ValueAtContactDetailsForm(), address1);

		log.info("Edit Employee [Contact] - Step 16: Verify 'Address Street 2' textbox edit successfully");
		verifyEquals(employeeDetailPage.getAddressStreet2ValueAtContactDetailsForm(), address2);

		log.info("Edit Employee [Contact] - Step 17: Verify 'City' textbox edit successfully");
		verifyEquals(employeeDetailPage.getCityValueAtContactDetailsForm(), city);

		log.info("Edit Employee [Contact] - Step 18: Verify 'State/Province' textbox edit successfully");
		verifyEquals(employeeDetailPage.getStateValueAtContactDetailsForm(), state);

		log.info("Edit Employee [Contact] - Step 19: Verify 'Zip/Postal Code' textbox edit successfully");
		verifyEquals(employeeDetailPage.getZipValueAtContactDetailsForm(), zip);

		log.info("Edit Employee [Contact] - Step 20: Verify 'Country' textbox edit successfully");
		verifyEquals(employeeDetailPage.getCountryValueAtContactDetailsForm(), country);

		log.info("Edit Employee [Contact] - Step 21: Verify 'Home Telephone' textbox edit successfully");
		verifyEquals(employeeDetailPage.getHomeTelephoneValueAtContactDetailsForm(), homeTelephone);

		log.info("Edit Employee [Contact] - Step 22: Verify 'Mobile' textbox edit successfully");
		verifyEquals(employeeDetailPage.getMobileValueAtContactDetailsForm(), mobile);

		log.info("Edit Employee [Contact] - Step 23: Verify 'Work Telephone' textbox edit successfully");
		verifyEquals(employeeDetailPage.getWorkTelephoneValueAtContactDetailsForm(), workTelephone);

		log.info("Edit Employee [Contact] - Step 24: Verify 'Work Email' textbox edit successfully");
		verifyEquals(employeeDetailPage.getWorkEmailValueAtContactDetailsForm(), workEmail);

		log.info("Edit Employee [Contact] - Step 25: Verify 'Other Email' textbox edit successfully");
		verifyEquals(employeeDetailPage.getOtherEmailValueAtContactDetailsForm(), otherEmail);

	}

	@Test
	public void Employee_04_Edit_Employee_By_Job() {
		log.info("Edit Employee [Job] - Step 01: Click to 'Job' tab");
		employeeDetailPage.openSideBarTabByName("Job");

		log.info("Edit Employee [Job] - Step 02: Click to 'Edit' button at 'Job' Form");
		employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Job", "Edit");

		log.info("Edit Employee [Job] - Step 03: Select 'Job Title' dropdown with value ");
		employeeDetailPage.selectJobTitleDropdownAtJobForm(jobTitle);

		log.info("Edit Employee [Job] - Step 04: Select 'Employment Status' dropdown with value ");
		employeeDetailPage.selectEmploymentStatusDropdownAtJobForm(employmentStatus);

		log.info("Edit Employee [Job] - Step 05: Select 'Job Category' dropdown with value ");
		employeeDetailPage.selectJobCategoryDropdownAtJobForm(jobCategory);

		log.info("Edit Employee [Job] - Step 06: Enter to 'Joined Date' textbox");
		employeeDetailPage.enterToJoinedDateTextboxAtJobForm(joinedDate);

		log.info("Edit Employee [Job] - Step 07: Select 'Sub Unit' dropdown with value ");
		employeeDetailPage.selectJSubUnitDropdownAtJobForm(subUnit);

		log.info("Edit Employee [Job] - Step 08: Select 'Location' dropdown with value ");
		employeeDetailPage.selectLocationDropdownAtJobForm(location);

		log.info("Edit Employee [Job] - Step 09: Enter to 'Start Date' textbox");
		employeeDetailPage.enterToStartDateTextboxAtJobForm(startDate);

		log.info("Edit Employee [Job] - Step 10: Enter to 'End Date' textbox");
		employeeDetailPage.enterToEndDateTextboxAtJobForm(endDate);

		log.info("Edit Employee [Job] - Step 11: upload a contract to 'Contract Details' textbox");
		employeeDetailPage.uploadMultipleFiles(driver, contractFile);

		log.info("Edit Employee [Job] - Step 12: Click to 'Save' button at 'Job' Form");
		employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Job", "Save");
		
		log.info("Edit Employee [Job] - Step 13: Verify Success Message displayed with value 'Successfully Updated'");
		verifyEquals(employeeDetailPage.getSuccessMessageAtPersonalDetailForm(), "Successfully Updated");
		
		log.info("Edit Employee [Job] - Step 14: Verify 'Job Title' dropdown edit successfully");
		verifyEquals(employeeDetailPage.getSelectedItemOfJobTitleAtJobForm(), jobTitle);

		log.info("Edit Employee [Job] - Step 15: Verify 'Employment Status' dropdown edit successfully");
		verifyEquals(employeeDetailPage.getSelectedItemOfEmploymentStatusAtJobForm(), employmentStatus);

		log.info("Edit Employee [Job] - Step 16: Verify 'Job Category' dropdown edit successfully");
		verifyEquals(employeeDetailPage.getSelectedItemOfJobCategoryAtJobForm(), jobCategory);

		log.info("Edit Employee [Job] - Step 17: Verify 'Joined Date' textbox edit successfully");
		verifyEquals(employeeDetailPage.getJoinedDateValueAtJobForm(), joinedDate);

		log.info("Edit Employee [Job] - Step 18: Verify 'Sub Unit' dropdown edit successfully");
		verifyEquals(employeeDetailPage.getSelectedItemOfSubUnitAtJobForm(), subUnit);

		log.info("Edit Employee [Job] - Step 19: Verify 'Location' dropdown edit successfully");
		verifyEquals(employeeDetailPage.getSelectedItemOfLocationAtJobForm(), location);

		log.info("Edit Employee [Job] - Step 20: Verify 'Start Date' textbox edit successfully");
		verifyEquals(employeeDetailPage.getStartDateValueAtJobForm(), startDate);

		log.info("Edit Employee [Job] - Step 21: Verify 'End Date' textbox edit successfully");
		verifyEquals(employeeDetailPage.getEndDateValueAtJobForm(), endDate);

		log.info("Edit Employee [Job] - Step 22: Verify  contract is uploaded successfully");
		verifyTrue(employeeDetailPage.isNewContractFileUploadSuccess(contractFile));

	}

	@Test
	public void Employee_05_Edit_Employee_By_Salary() {
		log.info("Edit Employee [Salary] - Step 01: Click to 'Salary' Tab");
		employeeDetailPage.openSideBarTabByName("Salary");

		log.info("Edit Employee [Salary] - Step 02: Click to 'Add' button at 'Assigned Salary Components' Form");
		employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Assigned Salary Components", "Add");

		log.info("Edit Employee [Salary] - Step 03: Select to 'Pay Grade' dropdown with value: " + payGrade);
		employeeDetailPage.selectPayGradeDropdownAtAddSalaryComponentForm(payGrade);

		log.info("Edit Employee [Salary] - Step 04: Enter to 'Salary Component ' textbox");
		employeeDetailPage.enterToSalaryComponentTextboxAtAddSalaryComponentForm(salaryComponent);

		log.info("Edit Employee [Salary] - Step 05: Select to 'Pay Frequency' dropdown with value: " + payFrequency);
		employeeDetailPage.selectPayFrequencyDropdownAtAddSalaryComponentForm(payFrequency);

		log.info("Edit Employee [Salary] - Step 06: Select to 'Currency ' dropdown with value: " + currency);
		employeeDetailPage.selectCurrencyDropdownAtAddSalaryComponentForm(currency);

		log.info("Edit Employee [Salary] - Step 07: Enter to 'Amount' textbox");
		employeeDetailPage.enterToAmountTextboxAtAddSalaryComponentForm(amount);

		log.info("Edit Employee [Salary] - Step 08: Enter to 'Comments' textbox");
		employeeDetailPage.enterToCommentsTextboxAtAddSalaryComponentForm(comments);

		log.info("Edit Employee [Salary] - Step 09: Click to 'Save' button at 'Add Salary Component' Form");
		employeeDetailPage.clickToButtonByNameAtFormHeader(driver, "Add Salary Component", "Save");
	}

	
	@AfterClass(alwaysRun = true)
	public void afterTest() {
		closeBrowserAndDriver(driver);
	}

}
