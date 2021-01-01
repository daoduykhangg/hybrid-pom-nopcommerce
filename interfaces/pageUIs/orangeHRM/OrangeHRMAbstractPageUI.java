package pageUIs.orangeHRM;

public class OrangeHRMAbstractPageUI {
	public static final String UPLOAD_FILE_TYPE = "//input[@type='file']";
	public static final String DYNAMIC_MENU_PAGE_BY_NAME = "//a[string()='%s']";
	public static final String DYNAMIC_BUTTON_BY_NAME_AT_FORM_HEADER = "//h1[text()='%s']/parent::div/following-sibling::div//input[@value='%s']";
	public static final String DYNAMIC_COLUMN_NAME_SIBLING = "//table[@id='%s']//th[string()='%s']/preceding-sibling::th";
	public static final String CELL_VALUE_MIX_BY_COLUMN_AND_ROW_INDEX = "//tr[%s]//td[%s]";
	
	public static final String DYNAMIC_NO_RECORDS_FOUND_TEXT = "//table[@id='%s']//td[text()='No Records Found']";
}
