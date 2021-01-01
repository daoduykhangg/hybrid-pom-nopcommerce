package pageObjects.orangeHRM;

import org.openqa.selenium.WebDriver;

import commons.AbstractPage;
import pageUIs.orangeHRM.EmployeeDetailPageUI;

public class EmployeeDetailPageObject extends AbstractPage {
	WebDriver driver;

	public EmployeeDetailPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToFirstNameTextboxAtAddEmployeeForm(String firstname) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM, firstname);
	}

	public void enterToLastNameTextboxAtAddEmployeeForm(String lastname) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM, lastname);
	}

	public String getEmployeeIDValueAtAddEmployeeForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_ADD_EMPLOYEE_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_ADD_EMPLOYEE_FORM, "value");
	}

	public boolean isFullNameDisplayedAtHeader(String fullname) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FULLNAME_HEADER_AT_PERSONAL_DETAIL_FORM, fullname);
		return isElementDisplayed(driver, EmployeeDetailPageUI.FULLNAME_HEADER_AT_PERSONAL_DETAIL_FORM, fullname);
	}

	public String getFirstNameValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM, "value");
	}

	public String getLastNameValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM, "value");
	}

	public String getEmployeeIDValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.EMPLOYEE_ID_TEXTBOX_AT_PERSONAL_DETAIL_FORM, "value");
	}
	

	public void enterToFirstNameTextboxAtPersonalDetailForm(String firstName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM, firstName);
	}

	public void enterToLastNameTextboxAtPersonalDetailForm(String lastName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM, lastName);
	}

	public void enterToSSNNumberTextboxAtPersonalDetailForm(String SSNValue) {
		waitForElementVisible(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FORM, SSNValue);
	}

	public void clickToGenderRadioAtPersonalDetailForm(String genderValue) {
		waitForElementClickable(driver, EmployeeDetailPageUI.GENDER_RADIO_BUTTON_AT_PERSONAL_DETAIL_FORM, genderValue);
		checkTheCheckbox(driver, EmployeeDetailPageUI.GENDER_RADIO_BUTTON_AT_PERSONAL_DETAIL_FORM, genderValue);
	}

	public void selectNationalityDropdownAtPersonalDetailForm(String nationality) {
		waitForElementClickable(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOWN_AT_PERSONAL_DETAIL_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOWN_AT_PERSONAL_DETAIL_FORM, nationality);
		
	}

	public void selectMaritalStatusDropdownAtPersonalDetailForm(String maritalStatus) {
		waitForElementClickable(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAIL_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAIL_FORM, maritalStatus);
	}

	public void enterToDateOfBirthTextboxAtPersonalDetailForm(String dateOfBirth) {
		waitForElementVisible(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXTBOX_AT_PERSONAL_DETAIL_FORM, dateOfBirth);
	}

	public String getSuccessMessageAtEmployeeDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.SUCCESS_MESSAGE_AT_PERSONAL_DETAIL_FORM);
		return getTextElement(driver, EmployeeDetailPageUI.SUCCESS_MESSAGE_AT_PERSONAL_DETAIL_FORM);
	}

	public String getSSNNumberValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FORM, "value");
	}

	public boolean isGenderRadioButtonSelectedAtPersonalDetailForm(String genderValue) {
		waitForElementVisible(driver, EmployeeDetailPageUI.GENDER_RADIO_BUTTON_AT_PERSONAL_DETAIL_FORM, genderValue);
		return isElementSelected(driver, EmployeeDetailPageUI.GENDER_RADIO_BUTTON_AT_PERSONAL_DETAIL_FORM, genderValue);
	}

	public String getSelectedItemOfNatinalityDropdownAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOWN_AT_PERSONAL_DETAIL_FORM);
		return getFirstSelectedText(driver, EmployeeDetailPageUI.NATIONALITY_DROPDOWN_AT_PERSONAL_DETAIL_FORM);
	}

	public String getSelectedItemOfMaritalStatusDropdownAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAIL_FORM);
		return getFirstSelectedText(driver, EmployeeDetailPageUI.MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAIL_FORM);
	}

	public String getDateOfBirthValueAtPersonalDetailForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXTBOX_AT_PERSONAL_DETAIL_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.DATE_OF_BIRTH_TEXTBOX_AT_PERSONAL_DETAIL_FORM, "value");
	}

	public void openSideBarTabByName(String tabName) {
		waitForElementClickable(driver, EmployeeDetailPageUI.DYNAMIC_SIDEBAR_TAB_BY_NAME, tabName);
		clickToElement(driver, EmployeeDetailPageUI.DYNAMIC_SIDEBAR_TAB_BY_NAME, tabName);
	}

	public void selectPayGradeDropdownAtAddSalaryComponentForm(String payGrade) {
		waitForElementClickable(driver, EmployeeDetailPageUI.PAY_GRADE_DROPDOWN_AT_ADD_SALARY_COMPONENT_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.PAY_GRADE_DROPDOWN_AT_ADD_SALARY_COMPONENT_FORM, payGrade);
	}

	public void enterToSalaryComponentTextboxAtAddSalaryComponentForm(String salaryComponent) {
		waitForElementVisible(driver, EmployeeDetailPageUI.SALARY_COMPONENT_TEXTBOX_AT_ADD_SALARY_COMPONENT_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.SALARY_COMPONENT_TEXTBOX_AT_ADD_SALARY_COMPONENT_FORM, salaryComponent);
	}

	public void selectPayFrequencyDropdownAtAddSalaryComponentForm(String payFrequency) {
		waitForElementClickable(driver, EmployeeDetailPageUI.PAY_FREQUENCY_DROPDOWN_AT_ADD_SALARY_COMPONENT_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.PAY_FREQUENCY_DROPDOWN_AT_ADD_SALARY_COMPONENT_FORM, payFrequency);
	}

	public void selectCurrencyDropdownAtAddSalaryComponentForm(String currency) {
		waitForElementClickable(driver, EmployeeDetailPageUI.CURRENCY_DROPDOWN_AT_ADD_SALARY_COMPONENT_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.CURRENCY_DROPDOWN_AT_ADD_SALARY_COMPONENT_FORM, currency);
	}

	public void enterToAmountTextboxAtAddSalaryComponentForm(String amount) {
		waitForElementVisible(driver, EmployeeDetailPageUI.AMOUNT_TEXTBOX_AT_ADD_SALARY_COMPONENT_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.AMOUNT_TEXTBOX_AT_ADD_SALARY_COMPONENT_FORM, amount);
	}

	public void enterToCommentsTextboxAtAddSalaryComponentForm(String comments) {
		waitForElementVisible(driver, EmployeeDetailPageUI.COMMENTS_TEXTBOX_AT_ADD_SALARY_COMPONENT_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.COMMENTS_TEXTBOX_AT_ADD_SALARY_COMPONENT_FORM, comments);
	}

	public void enterToAddressStreet1TextboxAtContactDetailsForm(String addressStreet1) {
		waitForElementVisible(driver, EmployeeDetailPageUI.ADDRESS_STREET_1_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.ADDRESS_STREET_1_TEXTBOX_AT_CONTACT_DETAILS_FORM, addressStreet1);
	}

	public void enterToAddressStreet2TextboxAtContactDetailsForm(String addressStreet2) {
		waitForElementVisible(driver, EmployeeDetailPageUI.ADDRESS_STREET_2_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.ADDRESS_STREET_2_TEXTBOX_AT_CONTACT_DETAILS_FORM, addressStreet2);
	}

	public void enterToCityTextboxAtContactDetailsForm(String city) {
		waitForElementVisible(driver, EmployeeDetailPageUI.CITY_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.CITY_TEXTBOX_AT_CONTACT_DETAILS_FORM, city);
	}

	public void enterToStateTextboxAtContactDetailsForm(String state) {
		waitForElementVisible(driver, EmployeeDetailPageUI.STATE_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.STATE_TEXTBOX_AT_CONTACT_DETAILS_FORM, state);
	}

	public void enterToZipTextboxAtContactDetailsForm(String zipcode) {
		waitForElementVisible(driver, EmployeeDetailPageUI.ZIP_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.ZIP_TEXTBOX_AT_CONTACT_DETAILS_FORM, zipcode);
	}

	public void selectCountryDropdownAtContactDetailsForm(String country) {
		waitForElementClickable(driver, EmployeeDetailPageUI.COUNTRY_DROPDOWN_AT_CONTACT_DETAILS_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.COUNTRY_DROPDOWN_AT_CONTACT_DETAILS_FORM, country);
	}

	public void enterToHomeTelephoneTextboxAtContactDetailsForm(String homeTelephone) {
		waitForElementVisible(driver, EmployeeDetailPageUI.HOME_TELEPHONE_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.HOME_TELEPHONE_TEXTBOX_AT_CONTACT_DETAILS_FORM, homeTelephone);
	}

	public void enterToMobileTextboxAtContactDetailsForm(String mobile) {
		waitForElementVisible(driver, EmployeeDetailPageUI.MOBILE_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.MOBILE_TEXTBOX_AT_CONTACT_DETAILS_FORM, mobile);
	}

	public void enterToWorkTelephoneTextboxAtContactDetailsForm(String workTelephone) {
		waitForElementVisible(driver, EmployeeDetailPageUI.WORK_TELEPHONE_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.WORK_TELEPHONE_TEXTBOX_AT_CONTACT_DETAILS_FORM, workTelephone);
	}

	public void enterToWorkEmailTextboxAtContactDetailsForm(String workEmail) {
		waitForElementVisible(driver, EmployeeDetailPageUI.WORK_EMAIL_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.WORK_EMAIL_TEXTBOX_AT_CONTACT_DETAILS_FORM, workEmail);
	}

	public void enterToOtherEmailTextboxAtContactDetailsForm(String otherEmail) {
		waitForElementVisible(driver, EmployeeDetailPageUI.OTHER_EMAIL_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.OTHER_EMAIL_TEXTBOX_AT_CONTACT_DETAILS_FORM, otherEmail);
	}

	public String getAddressStreet1ValueAtContactDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.ADDRESS_STREET_1_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.ADDRESS_STREET_1_TEXTBOX_AT_CONTACT_DETAILS_FORM, "value");
	}

	public String getAddressStreet2ValueAtContactDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.ADDRESS_STREET_2_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.ADDRESS_STREET_2_TEXTBOX_AT_CONTACT_DETAILS_FORM, "value");
	}

	public String getCityValueAtContactDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.CITY_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.CITY_TEXTBOX_AT_CONTACT_DETAILS_FORM, "value");
	}

	public String getStateValueAtContactDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.STATE_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.STATE_TEXTBOX_AT_CONTACT_DETAILS_FORM, "value");
	}

	public String getZipValueAtContactDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.ZIP_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.ZIP_TEXTBOX_AT_CONTACT_DETAILS_FORM, "value");
	}

	public String getCountryValueAtContactDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.COUNTRY_DROPDOWN_AT_CONTACT_DETAILS_FORM);
		return getFirstSelectedText(driver, EmployeeDetailPageUI.COUNTRY_DROPDOWN_AT_CONTACT_DETAILS_FORM);
	}

	public String getHomeTelephoneValueAtContactDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.HOME_TELEPHONE_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.HOME_TELEPHONE_TEXTBOX_AT_CONTACT_DETAILS_FORM, "value");
	}

	public String getMobileValueAtContactDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.MOBILE_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.MOBILE_TEXTBOX_AT_CONTACT_DETAILS_FORM, "value");
	}

	public String getWorkTelephoneValueAtContactDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.WORK_TELEPHONE_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.WORK_TELEPHONE_TEXTBOX_AT_CONTACT_DETAILS_FORM, "value");
	}

	public String getWorkEmailValueAtContactDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.WORK_EMAIL_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.WORK_EMAIL_TEXTBOX_AT_CONTACT_DETAILS_FORM, "value");
	}

	public String getOtherEmailValueAtContactDetailsForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.OTHER_EMAIL_TEXTBOX_AT_CONTACT_DETAILS_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.OTHER_EMAIL_TEXTBOX_AT_CONTACT_DETAILS_FORM, "value");
	}

	public void selectJobTitleDropdownAtJobForm(String jobTitle) {
		waitForElementClickable(driver, EmployeeDetailPageUI.JOB_TITLE_DROPDOWN_AT_JOB_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.JOB_TITLE_DROPDOWN_AT_JOB_FORM, jobTitle);
	}

	public void selectEmploymentStatusDropdownAtJobForm(String employeeStatus) {
		waitForElementClickable(driver, EmployeeDetailPageUI.EMPLOYMENT_STATUS_DROPDOWN_AT_JOB_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.EMPLOYMENT_STATUS_DROPDOWN_AT_JOB_FORM, employeeStatus);
	}

	public void selectJobCategoryDropdownAtJobForm(String jobCategory) {
		waitForElementClickable(driver, EmployeeDetailPageUI.JOB_CATEGORY_DROPDOWN_AT_JOB_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.JOB_CATEGORY_DROPDOWN_AT_JOB_FORM, jobCategory);
	}

	public void enterToJoinedDateTextboxAtJobForm(String joinedDate) {
		waitForElementVisible(driver, EmployeeDetailPageUI.JOINED_DATE_TEXTBOX_AT_JOB_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.JOINED_DATE_TEXTBOX_AT_JOB_FORM, joinedDate);
	}

	public void selectJSubUnitDropdownAtJobForm(String subUnit) {
		waitForElementClickable(driver, EmployeeDetailPageUI.SUB_UNIT_DROPDOWN_AT_JOB_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.SUB_UNIT_DROPDOWN_AT_JOB_FORM, subUnit);
	}

	public void selectLocationDropdownAtJobForm(String location) {
		waitForElementClickable(driver, EmployeeDetailPageUI.LOCATION_DROPDOWN_AT_JOB_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.LOCATION_DROPDOWN_AT_JOB_FORM, location);
	}

	public void enterToStartDateTextboxAtJobForm(String startDate) {
		waitForElementVisible(driver, EmployeeDetailPageUI.START_DATE_TEXTBOX_AT_JOB_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.START_DATE_TEXTBOX_AT_JOB_FORM, startDate);
	}

	public void enterToEndDateTextboxAtJobForm(String endDate) {
		waitForElementVisible(driver, EmployeeDetailPageUI.END_DATE_TEXTBOX_AT_JOB_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.END_DATE_TEXTBOX_AT_JOB_FORM, endDate);
	}

	public String getSelectedItemOfJobTitleAtJobForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.JOB_TITLE_DROPDOWN_AT_JOB_FORM);
		return getFirstSelectedText(driver, EmployeeDetailPageUI.JOB_TITLE_DROPDOWN_AT_JOB_FORM);
	}

	public String getSelectedItemOfEmploymentStatusAtJobForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.EMPLOYMENT_STATUS_DROPDOWN_AT_JOB_FORM);
		return getFirstSelectedText(driver, EmployeeDetailPageUI.EMPLOYMENT_STATUS_DROPDOWN_AT_JOB_FORM);
	}

	public String getSelectedItemOfJobCategoryAtJobForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.JOB_CATEGORY_DROPDOWN_AT_JOB_FORM);
		return getFirstSelectedText(driver, EmployeeDetailPageUI.JOB_CATEGORY_DROPDOWN_AT_JOB_FORM);
	}

	public String getJoinedDateValueAtJobForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.JOINED_DATE_TEXTBOX_AT_JOB_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.JOINED_DATE_TEXTBOX_AT_JOB_FORM, "value");
	}

	public String getSelectedItemOfSubUnitAtJobForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.SUB_UNIT_DROPDOWN_AT_JOB_FORM);
		return getFirstSelectedText(driver, EmployeeDetailPageUI.SUB_UNIT_DROPDOWN_AT_JOB_FORM);
	}

	public String getSelectedItemOfLocationAtJobForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.LOCATION_DROPDOWN_AT_JOB_FORM);
		return getFirstSelectedText(driver, EmployeeDetailPageUI.LOCATION_DROPDOWN_AT_JOB_FORM);
	}

	public String getStartDateValueAtJobForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.START_DATE_TEXTBOX_AT_JOB_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.START_DATE_TEXTBOX_AT_JOB_FORM, "value");
	}

	public String getEndDateValueAtJobForm() {
		waitForElementVisible(driver, EmployeeDetailPageUI.END_DATE_TEXTBOX_AT_JOB_FORM);
		return getElementAttribute(driver, EmployeeDetailPageUI.END_DATE_TEXTBOX_AT_JOB_FORM, "value");
	}

	public boolean isNewContractFileUploadSuccess(String contractfilename) {
		waitForElementVisible(driver, EmployeeDetailPageUI.CONTRACT_FILE_AT_JOB_FORM, contractfilename);
		return isElementDisplayed(driver, EmployeeDetailPageUI.CONTRACT_FILE_AT_JOB_FORM, contractfilename);
	}

	public void enterToNameTextboxAtAssignedSupervisorsForm(String supervisorName) {
		waitForElementVisible(driver, EmployeeDetailPageUI.SUPERVISOR_NAME_TEXTBOX_AT_ASSIGNED_SUPERVISORS_FORM);
		sendkeyToElement(driver, EmployeeDetailPageUI.SUPERVISOR_NAME_TEXTBOX_AT_ASSIGNED_SUPERVISORS_FORM, supervisorName);
	}

	public void selectReportingMethodAtAssignedSupervisorsForm(String reportingMethod) {
		waitForElementClickable(driver, EmployeeDetailPageUI.REPORTING_METHOD_DROPDOWN_AT_ASSIGNED_SUPERVISORS_FORM);
		selectItemInDropdown(driver, EmployeeDetailPageUI.REPORTING_METHOD_DROPDOWN_AT_ASSIGNED_SUPERVISORS_FORM, reportingMethod);
		
	}

}
