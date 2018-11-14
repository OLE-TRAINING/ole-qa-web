package core;

import java.io.File;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverFactory {

	private static WebDriver driver;

	private DriverFactory() {
	}

	public static WebDriver getDriver() {
		if (driver == null) {
			String path;
			switch (Properties.browser) {
			case FIREFOX:
				path = "src" + File.separator + "main" + File.separator + "resources" 
							 + File.separator + "driver"+ File.separator + "geckodriver.exe";				
				System.setProperty("webdriver.gecko.driver", path);
				driver = new FirefoxDriver();
				break;
				
			case CHROME:
				path = "src" + File.separator + "main" + File.separator + "resources" 
						 + File.separator + "driver"+ File.separator + "chromedriver.exe";				
				System.setProperty("webdriver.chrome.driver", path);
				driver = new ChromeDriver();
				break;
			}
			driver.manage().window().maximize();
		}
		return driver;
	}

	public static void killDriver() {
		if (driver != null) {
			driver.quit();
			driver = null;
		}
	}
}