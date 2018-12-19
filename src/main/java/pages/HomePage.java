package pages;

import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import core.BasePage;

public class HomePage extends BasePage {
	private List<WebElement> cardImgInfos;
	private int scrolls = 15;
	
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
	
	public void fatWriteEmail(String email) {
		dsl.fastWriteInXpath("//input", email);
	}

	public String textWritten() {
		return dsl.giveTextForAtributeInXpath("//input", "value");
	}

	public void next() {
		dsl.clickInXpath("//button");
	}
	
	public void fastNext() {
		dsl.clickWhithNoLoader("//button");
	}

	// --New user page------------------------------------

	public String getEmailInPage() {
		return dsl.giveTextForXpath("//p[2]");
	}

	public void writeCompleteName(String name) {
		dsl.writeInXpath("//input[@placeholder='Name']", name);
	}
	
	public void fastWriteCompleteName(String name) {
		dsl.fastWriteInXpath("//input[@placeholder='Name']", name);
	}
	public String getNameWritten() {
		return dsl.giveTextForAtributeInXpath("//input[@placeholder='Name']", "value");
	}

	public void writeUser(String name) {
		dsl.writeInXpath("//input[@placeholder='User']", name);
	}
	
	public void fastWriteUser(String name) {
		dsl.fastWriteInXpath("//input[@placeholder='User']", name);
	}

	public String getUserWritten() {
		return dsl.giveTextForAtributeInXpath("//input[@placeholder='User']", "value");
	}

	public void writePassword(String name) {
		dsl.writeInXpath("//input[@placeholder='Password']", name);
	}
	
	public void fastWritePassword(String name) {
		dsl.fastWriteInXpath("//input[@placeholder='Password']", name);
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
		System.out.println("Start scrols");
		for (int scroll = 1, countFilm = 0; scroll <= scrolls;) {
			countFilm = countFilms();
			if (scroll * 20 == countFilm) {
				System.out.println("Films listed:"+countFilm+", making scroll:"+scroll);
				scroll++;
				scrownDown();
			}
		}
		
		// make log of wrong elements
		String xpath="//div[@class='card-component']/div[@class='card-content']";
		Boolean hasImage = false;
		float cssFloatValue;
		float diff=(float)24.532;

		for (@SuppressWarnings("unused") WebElement walks : cardImgInfos) {
			
			// exclude "px" of string
			cssFloatValue = dsl.getCssValue(xpath, index) + diff;
			try {
				hasImage = dsl.hasImage(xpath, index);
			} catch (NoSuchElementException exception) {
				//the element no has tag p
			}
		
			// print log error: correct is 320 if it is less than 85 it will be considered wrong
			// error: if no has image
			if (cssFloatValue <= 85 || hasImage) {
				System.out.println("");
				System.out.println("Image:"+!hasImage);
				System.out.println("Css top element:"+cssFloatValue);
				System.out.println("Movie locator:" + xpath+"["+index+"]");
				System.out.println("/-------------------------------------------------------------------------------/");
				flag = true;
			}
			hasImage=false;
			index++;
		}
		return flag;
	}

	public void switchTo(int n) {
		scrownDown();
		dsl.clickInXpath("//i");
		dsl.clickInXpath("//div[@class='dropdown-content']/a[" + n + "]");
	}
	
	public void switchToNoScrow(int n) {
		dsl.clickInXpath("//i");
		dsl.clickInXpath("//div[@class='dropdown-content']/a[" + n + "]");
	}
}