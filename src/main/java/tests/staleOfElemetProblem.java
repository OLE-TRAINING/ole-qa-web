package tests;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class staleOfElemetProblem {
	static WebDriver driver;
	
	public static void main(String[] args) {
		String path="src" + File.separator + "main" + File.separator + "resources" 
				 + File.separator + "driver"+ File.separator+"chromedriver";
		
		System.setProperty("webdriver.chrome.driver",   path);
		driver = new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com");
		
		WebElement username = driver.findElement(By.name("username"));
		
		username.sendKeys("naveenk");
		
		WebElement password = driver.findElement(By.name("password"));
		password.sendKeys("test@123");
	}
}