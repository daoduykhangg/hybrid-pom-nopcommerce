package commons;

public class GlobalConstants {
	public static final String DEV_SERVER = "https://demo.nopcommerce.com/";
	public static final long SHORT_TIMEOUT = 5;
	public static final long LONG_TIMEOUT = 30;
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String ROOT_FOLDER = System.getProperty("user.dir");
	public static final String BROWSER_LOG_FOLDER = ROOT_FOLDER + getDirectorySlash("browserlog");
	public static final String DOWNLOAD_FOLDER = ROOT_FOLDER + getDirectorySlash("downloadFiles");
	public static final String UPLOAD_FOLDER = ROOT_FOLDER + getDirectorySlash("uploadFiles");
	public static final String AUTOIT_FOLDER = ROOT_FOLDER + getDirectorySlash("autoIT");
	public static final String BROWSER_USERNAME = "daoduykhang1";
	public static final String BROWSER_AUTOMATE_KEY = "HBtQqFo3p4X8zU22puub";
	public static final String BROWSER_URL = "https://" + BROWSER_USERNAME + ":" + BROWSER_AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	public static final String SAUCELAB_USERNAME = "duykhangkma";
	public static final String SAUCELAB_AUTOMATE_KEY = "048bbf3d8d5f4cf2bf97a638a9798857";
	public static final String SAUCELAB_URL = "https://" + SAUCELAB_USERNAME + ":" + SAUCELAB_AUTOMATE_KEY + "@ondemand.us-west-1.saucelabs.com:443/wd/hub";
	
	public static final String CROSS_USERNAME = "khang.dao@winmagic.com".replaceAll("@", "%40");
	public static final String CROSS_AUTOMATE_KEY = "ufdf131be0073d0b";
	public static final String CROSS_URL = "http://" + CROSS_USERNAME + ":" + CROSS_AUTOMATE_KEY + "@hub.crossbrowsertesting.com:80/wd/hub";
	
	public static String getDirectorySlash(String folderName) {
		if (isMac() || isUnix() || isSolaris()) {
			folderName = "/" + folderName + "/";
		} else {
			folderName = "\\" + folderName + "\\";
		}
		return folderName;
	}

	public static boolean isWindows() {
		return (GlobalConstants.OS_NAME.toLowerCase().indexOf("win") >= 0);
	}

	public static boolean isMac() {
		return (GlobalConstants.OS_NAME.toLowerCase().indexOf("mac") >= 0);
	}

	public static boolean isUnix() {
		return (GlobalConstants.OS_NAME.toLowerCase().indexOf("nix") >= 0 || GlobalConstants.OS_NAME.toLowerCase().indexOf("nux") >= 0 || GlobalConstants.OS_NAME.toLowerCase().indexOf("aix") > 0);
	}

	public static boolean isSolaris() {
		return (GlobalConstants.OS_NAME.toLowerCase().indexOf("sunos") >= 0);
	}
}
