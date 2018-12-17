package core;

import static core.DriverFactory.getDriver;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import static core.DriverFactory.killDriver;

public class DSL {

	/************** Page opening/close **********************/
	public void opemInitPage() {
		getDriver().get("https://ole-traning.firebaseapp.com");
	}

	public void closePage() {
		killDriver();
	}

	/************** Give title ************************/
	public String title() {
		return getDriver().getTitle();
	}

	/************** interacts with elements/page ************/
	public void writeInXpath(String xpath, String text) {
		WebElement findElement = giveElementXpath(xpath, "");

		findElement.sendKeys(text);
	}
	
	public void fastWriteInXpath(String xpath, String text) {
		getDriver().findElement(By.xpath(xpath)).sendKeys(text);
	}

	public void clickInXpath(String xpath) {
		expectLoaderDisappear();
		WebElement findElement = giveElementXpath(xpath, "Clickable");
		findElement.click();
		expectLoaderDisappear();
	}
	
	public void clickWhithNoLoader(String xpath) {
		getDriver().findElement(By.xpath(xpath)).click();;
	}

	public void refresh(int type) {
		if (type == 1) {
			getDriver().navigate().refresh();
		} else if (type == 2) {
			Robot robot;
			try {
				robot = new Robot();
				robot.keyPress(KeyEvent.VK_CONTROL);
				robot.keyPress(KeyEvent.VK_F5);
				robot.keyPress(KeyEvent.KEY_RELEASED);
			} catch (AWTException e) {
				e.printStackTrace();
			}
		}

	}
	
	public void goDown() {
		JavascriptExecutor js = (JavascriptExecutor) getDriver();
		js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void clearTexts(String xpath, int width) {
		List<WebElement> findElements = getDriver().findElements(By.xpath(xpath));
		for(WebElement element:findElements) {
			for(int n=0;n < width; n++) {
				element.sendKeys(Keys.BACK_SPACE);
			}
		}	
	}
	
	public float getCssValue (String xpath, int index) {
		String locator=xpath+"["+index+"]"+"//div[@class='card-img-info']";
		WebElement element= giveElementXpathNoWait(locator);
		String css = element.getCssValue("top").substring(0, (element.getCssValue("top").length() - 1) - 1);
		return Float.parseFloat(css);
	}
	
	public boolean hasImage(String xpath, int index) {
		String locator = xpath+"["+index+"]"+"//p[contains(text(),'No data avaliable')]";
		return getDriver().findElement(By.xpath(locator)).getText().equals("No data avaliable");
	}
	/************** obtain texts **********************/
	public String giveTextForXpath(String text) {
		WebElement findElement = giveElementXpath(text, "Located");
		String text2 = findElement.getText();
		return text2;
	}
	
	public String giveTextForXpathNoWait(String text) {
		return getDriver().findElement(By.xpath(text)).getText();
	}

	public String giveTextForAtributeInXpath(String xpath, String atribute) {
		WebElement findElement = giveElementXpath(xpath, "Visible");
		String text2 = findElement.getAttribute(atribute);
		return text2;
	}

	/************** find elements ********************/

	public WebElement giveElementXpath(String xpath, String waitType) {
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 30);
		WebElement element1;

		if (waitType.equals("Clickable")) {
			element1 = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		} else if (waitType.equals("Visible")) {
			element1 = wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
		} else {
			// else if(waitType.equals("Located"))
			element1 = wait1.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));

		}
		return element1;
	}
	
	public List<WebElement> cardImgInfos(String xpath) {
		return getDriver().findElements(By.xpath(xpath));
	}
	
	public WebElement giveElementXpathNoWait(String xpath) {
		return getDriver().findElement(By.xpath(xpath));
	}

	/************* waits ********************************/
	public void expectLoaderDisappear() {
		expectDisappear("//div[@class='loader-content']");
	}

	public void expectDisappear(String xpath) {
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 30);
		wait1.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath(xpath)));
	}
	
	public void expectNotVisible(String xpath) {
		WebDriver driver = getDriver();
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 30);
		wait1.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath(xpath))));
	}
	
	public void waitInMiliSeconds(int n) {
		WebDriver driver = getDriver();
		driver.manage().timeouts().implicitlyWait(n, TimeUnit.MILLISECONDS);
	}
	
	public void expectForTextInXpath(String xpath, String text) {
		WebDriverWait wait1 = new WebDriverWait(getDriver(), 30);
		WebElement element;
		
		element = giveElementXpath(xpath,"Visible");
		System.out.println(element.getText());
		wait1.until(ExpectedConditions.textToBePresentInElement(element, text));
	}
	
	public void sleep(int n) {
		try {
			TimeUnit.MILLISECONDS.sleep(n);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void refreshElement(WebElement element ){
	    String sElement = element.toString().split("-> ")[1];
	    String locatorType = sElement.split(": ")[0];
	    if (locatorType.matches("css selector")) locatorType = "css";
	    String loc0 = sElement.split(": ")[1];
	    String theLocator = loc0.substring(0,loc0.length()-1);
	    System.out.println("Refreshing element with "+locatorType+": "+theLocator);

	    //return getDriver().getElement(theLocator,locatorType);
	}

}
