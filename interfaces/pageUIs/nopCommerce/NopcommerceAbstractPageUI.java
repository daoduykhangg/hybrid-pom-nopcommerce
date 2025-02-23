package pageUIs.nopCommerce;

public class NopcommerceAbstractPageUI {
	public static final String CUSTOMER_INFOR_LINK = "//div[@class='listbox']//a[text()='Customer info']";
	public static final String ADDRESSES_LINK = "//div[@class='listbox']//a[text()='Addresses']";
	public static final String ORDERS_LINK = "//div[@class='listbox']//a[text()='Orders']";
	public static final String MY_PRODUCT_REVIEW_LINK = "//div[@class='listbox']//a[text()='My product reviews']";

	public static final String DYNAMIC_LINK = "//div[@class='listbox']//a[text()='%s']";
	public static final String LOADING_ICON = "//div[@id='ajaxBusy']/span";
	public static final String PANEL_STATUS_BY_PANEL_ID = "//div[@id='%s']/div[contains(@class,'panel-heading')]";
	public static final String UPLOAD_FILE_BY_PANELID_BUTTON = "//div[@id='%s']//input[@type='file']";
	public static final String UPLOAD_FILE_TYPE = "//input[@type='file']";
	
	public static final String DYNAMIC_RADIO_BUTTON_BY_ID = "//input[@id='gender-%s']";
	public static final String DYNAMIC_TEXTBOX_BY_ID = "//input[@id='%s']";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "//select[@name='%s']";
	public static final String DYNAMIC_BUTTON_BY_VALUE = "//input[@value='%s']";
	public static final String DYNAMIC_ERROR_MESSAGE_BY_ID = "//span[@class='field-validation-error']//span[@id='%s-error']";
	
	public static final String DYNAMIC_PRODUCT_NAME_MENU_PAGE = "//ul[@class='top-menu notmobile']//a[text()='%s']";
	public static final String SHOPPING_CART_NO_ITEM_TOOLTIP = "//div[@class='count' and text()='You have no items in your shopping cart.']";

}
