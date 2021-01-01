package pageUIs.orangeHRM;

public class EmployeeDetailPageUI {
	public static final String FIRSTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM = "//input[@id='firstName']";
	public static final String LASTNAME_TEXTBOX_AT_ADD_EMPLOYEE_FORM = "//input[@id='lastName']";
	public static final String EMPLOYEE_ID_TEXTBOX_AT_ADD_EMPLOYEE_FORM = "//input[@id='employeeId']";
	public static final String SAVE_BUTTON = "//input[@id='btnSave']";
	
	public static final String FULLNAME_HEADER_AT_PERSONAL_DETAIL_FORM = "//div[@id='profile-pic']//h1[text()='%s']";
	public static final String FIRSTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM = "//input[@id='personal_txtEmpFirstName']";
	public static final String LASTNAME_TEXTBOX_AT_PERSONAL_DETAIL_FORM = "//input[@id='personal_txtEmpLastName']";
	public static final String EMPLOYEE_ID_TEXTBOX_AT_PERSONAL_DETAIL_FORM = "//input[@id='personal_txtEmployeeId']";
	public static final String SSN_NUMBER_TEXTBOX_AT_PERSONAL_DETAIL_FORM = "//input[@id='personal_txtNICNo']";
	public static final String GENDER_RADIO_BUTTON_AT_PERSONAL_DETAIL_FORM = "//label[text()='%s']/preceding-sibling::input";
	public static final String NATIONALITY_DROPDOWN_AT_PERSONAL_DETAIL_FORM = "//select[@id='personal_cmbNation']";
	public static final String MARITAL_STATUS_DROPDOWN_AT_PERSONAL_DETAIL_FORM = "//select[@id='personal_cmbMarital']";
	public static final String DATE_OF_BIRTH_TEXTBOX_AT_PERSONAL_DETAIL_FORM = "//input[@id='personal_DOB']";
	public static final String SUCCESS_MESSAGE_AT_PERSONAL_DETAIL_FORM = "//div[contains(@class,'message success')]";
	
	public static final String DYNAMIC_SIDEBAR_TAB_BY_NAME ="//ul[@id='sidenav']//a[text()='%s']";
	
	public static final String ADDRESS_STREET_1_TEXTBOX_AT_CONTACT_DETAILS_FORM = "//input[@id='contact_street1']";
	public static final String ADDRESS_STREET_2_TEXTBOX_AT_CONTACT_DETAILS_FORM = "//input[@id='contact_street2']";
	public static final String CITY_TEXTBOX_AT_CONTACT_DETAILS_FORM = "//input[@id='contact_city']";
	public static final String STATE_TEXTBOX_AT_CONTACT_DETAILS_FORM = "//input[@id='contact_province']";
	public static final String ZIP_TEXTBOX_AT_CONTACT_DETAILS_FORM = "//input[@id='contact_emp_zipcode']";
	public static final String COUNTRY_DROPDOWN_AT_CONTACT_DETAILS_FORM = "//select[@id='contact_country']";
	public static final String HOME_TELEPHONE_TEXTBOX_AT_CONTACT_DETAILS_FORM = "//input[@id='contact_emp_hm_telephone']";
	public static final String MOBILE_TEXTBOX_AT_CONTACT_DETAILS_FORM = "//input[@id='contact_emp_mobile']";
	public static final String WORK_TELEPHONE_TEXTBOX_AT_CONTACT_DETAILS_FORM = "//input[@id='contact_emp_work_telephone']";
	public static final String WORK_EMAIL_TEXTBOX_AT_CONTACT_DETAILS_FORM = "//input[@id='contact_emp_work_email']";
	public static final String OTHER_EMAIL_TEXTBOX_AT_CONTACT_DETAILS_FORM = "//input[@id='contact_emp_oth_email']";
	
	public static final String JOB_TITLE_DROPDOWN_AT_JOB_FORM = "//select[@id='job_job_title']";
	public static final String EMPLOYMENT_STATUS_DROPDOWN_AT_JOB_FORM = "//select[@id='job_emp_status']";
	public static final String JOB_CATEGORY_DROPDOWN_AT_JOB_FORM = "//select[@id='job_eeo_category']";
	public static final String JOINED_DATE_TEXTBOX_AT_JOB_FORM = "//input[@id='job_joined_date']";
	public static final String SUB_UNIT_DROPDOWN_AT_JOB_FORM = "//select[@id='job_sub_unit']";
	public static final String LOCATION_DROPDOWN_AT_JOB_FORM = "//select[@id='job_location']";
	public static final String START_DATE_TEXTBOX_AT_JOB_FORM = "//input[@id='job_contract_start_date']";
	public static final String END_DATE_TEXTBOX_AT_JOB_FORM = "//input[@id='job_contract_end_date']";
	public static final String CONTRACT_FILE_AT_JOB_FORM = "//li[@class='contractReadMode']//a[text()='%s']";
	
	public static final String PAY_GRADE_DROPDOWN_AT_ADD_SALARY_COMPONENT_FORM = "//select[@id='salary_sal_grd_code']";
	public static final String SALARY_COMPONENT_TEXTBOX_AT_ADD_SALARY_COMPONENT_FORM = "//input[@id='salary_salary_component']";
	public static final String PAY_FREQUENCY_DROPDOWN_AT_ADD_SALARY_COMPONENT_FORM = "//select[@id='salary_payperiod_code']";
	public static final String CURRENCY_DROPDOWN_AT_ADD_SALARY_COMPONENT_FORM = "//select[@id='salary_currency_id']";
	public static final String AMOUNT_TEXTBOX_AT_ADD_SALARY_COMPONENT_FORM = "//input[@id='salary_basic_salary']";
	public static final String COMMENTS_TEXTBOX_AT_ADD_SALARY_COMPONENT_FORM = "//textarea[@id='salary_comments']";
	
	public static final String SUPERVISOR_NAME_TEXTBOX_AT_ASSIGNED_SUPERVISORS_FORM = "//input[@id='reportto_supervisorName_empName']";
	public static final String REPORTING_METHOD_DROPDOWN_AT_ASSIGNED_SUPERVISORS_FORM = "//select[@id='reportto_reportingMethodType']";
}
