package pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class HomePage extends BasePage {
	private List<WebElement> cardImgInfos;
	private int scrolls = 5;

	public void setCardImgInfos(String xpath) {
		cardImgInfos = dsl.cardImgInfos(xpath);
	}

	// --others
	public void waitMlSeconds(int n) {
		dsl.waitInMiliSeconds(n);
	}

	public void waitLoader() {
		dsl.expectNotVisible("//span[@class='loader-card']");
	}

	public void sleepMiliSeconds(int n) {
		dsl.sleep(n);
	}

	public void closePage() {
		dsl.closePage();
	}

	public void refresh() {
		dsl.refresh(1);
	}

	public void refreshCtrlF5() {
		dsl.refresh(2);
	}

	public void scrownDown() {
		dsl.goDown();
	}

	// --Prelogin Page -----------------------------------
	public void waitStandbyLoader() {
		dsl.expectLoaderDisappear();
	}

	public void openTest() {
		dsl.opemInitPage();
	}

	public String especificTextOfPage() {

		return dsl.giveTextForXpath("//div/p[1]");
	}

	public void writeEmail(String email) {
		dsl.writeInXpath("//input", email);
	}

	public String textWritten() {
		return dsl.giveTextForAtributeInXpath("//input", "value");
	}

	public void next() {
		dsl.clickInXpath("//button");
	}

	// --New user page------------------------------------

	public String getEmailInPage() {
		return dsl.giveTextForXpath("//p[2]");
	}

	public void writeCompleteName(String name) {
		dsl.writeInXpath("//input[@placeholder='Name']", name);
	}

	public String getNameWritten() {
		return dsl.giveTextForAtributeInXpath("//input[@placeholder='Name']", "value");
	}

	public void writeUser(String name) {
		dsl.writeInXpath("//input[@placeholder='User']", name);
	}

	public String getUserWritten() {
		return dsl.giveTextForAtributeInXpath("//input[@placeholder='User']", "value");
	}

	public void writePassword(String name) {
		dsl.writeInXpath("//input[@placeholder='Password']", name);
	}

	public String getPasswordWritten() {
		return dsl.giveTextForAtributeInXpath("//input[@placeholder='Password']", "value");
	}

	// --Validate InexistentUser TokenPage -------
	public void writeToken(String token) {
		dsl.writeInXpath("//input", token);
	}

	public String getTokenWritten() {
		return dsl.giveTextForXpath("//input");
	}

	public void clickEmail() {
		dsl.clickInXpath("//p");
	}

	// --Login Page -----------
	public void writePasswordLogin(String password) {
		dsl.writeInXpath("//input", password);
	}

	public String getPasswordWrittenLogin() {
		return dsl.giveTextForAtributeInXpath("//input", "value");
	}

	// -- Home page -----------
	public int countFilms() {
		setCardImgInfos("//div[@class='card-content']");
		return cardImgInfos.size();
	}

	public boolean existErrorInFilmCards() {
		dsl.expectLoaderDisappear();
		int index = 1;
		boolean flag = false;

		// make scrools
		for (int scroll = 1, countFilm = 0; scroll <= scrolls;) {
			countFilm = countFilms();

			if (scroll * 20 == countFilm) {
				scroll++;
				scrownDown();
			}
		}

		// make log of wrong elements
		String cssValue;
		String xpath="//div[@class='card-component']/div[@class='card-content']";
		Boolean noHasImage = false;
		float cssFloatValue;
		WebElement element;

		for (@SuppressWarnings("unused") WebElement walks : cardImgInfos) {
			
			// exclude "px" of string
			element = dsl.giveElementXpathNoWait(xpath+"["+index+"]");
			
			cssValue = element.findElement(By.xpath("//div[@class='card-img-info']")).getCssValue("top").substring(0, (element.getCssValue("top").length() - 1) - 1);
			
			cssFloatValue = Float.parseFloat(cssValue);
			
			try {
				noHasImage = element.findElement(By.xpath("//p[contains(text(),'No data avaliable')]")).getText().equals("No data avaliable");
				System.out.println("getText():" + element.findElement(By.xpath("//p[contains(text(),'No data avaliable')]")).getText());
			
			} catch (NoSuchElementException exception) {
				//the element no has tag p
			}
		
			// print log error: correct is 320 if it is less than 85 it will be considered wrong
			if (cssFloatValue <= 85 || noHasImage) {
				System.out.println("");
				System.out.println("css top:" + cssFloatValue);
				System.out.println("Image:"+!noHasImage);
				System.out.println("Movie locator:" + xpath+"["+index+"]"+"//p[@class='card-image']");
				System.out.println("/-------------------------------------------------------------------------------/");
				flag = true;
			}

			if (noHasImage) {
				flag = false;
			}
			index++;
		}
		return flag;
	}

	public void switchTo(int n) {
		scrownDown();
		dsl.clickInXpath("//i");
		dsl.clickInXpath("//div[@class='dropdown-content']/a[" + n + "]");
	}
}
