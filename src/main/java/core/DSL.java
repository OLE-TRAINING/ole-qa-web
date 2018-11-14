package core;

import static core.DriverFactory.getDriver;


import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static core.DriverFactory.killDriver;
public class DSL {
	
	/************** Page opening/close **********************/
	public void opemInitPage() {
		getDriver().get("https://ole-traning.firebaseapp.com/prelogin");
	}
	
	public void closePage() {
		killDriver();
	}

	/************** Give title ************************/
	public String title() {
		return getDriver().getTitle();
	}

	/************** interacts with elements ************/
	public void writeInXpath(String xpath,String text) {
		WebElement findElement = giveElementXpath(xpath, "");
		
		findElement.sendKeys(text);
	}
	
	public void clickInXpath(String xpath) {
		WebElement findElement = giveElementXpath(xpath, "Clickable");
		findElement.click();
	}
	
	/************** obtain texts **********************/
	public String giveTextForXpath(String text) {
		WebElement findElement = giveElementXpath(text, "Located");
		String text2 = findElement.getText();
		return text2;
	}
	
	public String giveTextForAtributeInXpath(String xpath,String atribute) {
		WebElement findElement = giveElementXpath(xpath, "Visible");
		String text2 = findElement.getAttribute(atribute);
		return text2;
	}
	
	
	/************** find elements ********************/
	
	public WebElement giveElementXpath(String xpath, String waitType) {
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 30);
		WebElement element1;
		
		expectLoaderDisappear();
		
		if (waitType.equals("Clickable")) {
			element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		} else if(waitType.equals("Visible")){
			element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		}  else {
			// else if(waitType.equals("Located"))
			element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
			
		}
		return element1;
	}
	
	/************* waits ********************************/
	public void expectLoaderDisappear() {
		expectDisappear("//div[@class='loader-content']");
	}
	
	public void expectDisappear(String xpath) {
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 30);
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void waitInMiliSeconds(int n) {
		WebDriver driver = getDriver();
		driver.manage().timeouts().implicitlyWait(n, TimeUnit.MILLISECONDS);
	}
}
