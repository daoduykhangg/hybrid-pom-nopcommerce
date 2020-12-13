package pageUIs;

public class AbstractPageUI {
	public static final String CUSTOMER_INFOR_LINK = "//div[@class='listbox']//a[text()='Customer info']";
	public static final String ADDRESSES_LINK = "//div[@class='listbox']//a[text()='Addresses']";
	public static final String ORDERS_LINK = "//div[@class='listbox']//a[text()='Orders']";
	public static final String MY_PRODUCT_REVIEW_LINK = "//div[@class='listbox']//a[text()='My product reviews']";

	public static final String DYNAMIC_LINK = "//div[@class='listbox']//a[text()='%s']";
	public static final String LOADING_ICON = "//div[@id='ajaxBusy']/span";
	public static final String PANEL_STATUS_BY_PANEL_ID = "//div[@id='%s']/div[contains(@class,'panel-heading')]";
	public static final String UPLOAD_FILE_BY_PANELID_BUTTON = "//div[@id='%s']//input[@type='file']";
	
}
