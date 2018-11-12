package pages;

import core.BasePage;

public class LoginPage extends BasePage {
	
	public void waitStandbyLoader() {
		dsl.expectLoaderDisappear();
	}
	
	public String especificTextOfPage() {
		return dsl.giveTextForXpath("//p");
	}
	
	public String getEmail() {
		return dsl.giveTextForXpath("//p[2]");
	}
	
	public void writePassword(String password) {
		dsl.writeInXpath("//input", password);
	}
	
	public String getPasswordWritten() {
		return dsl.giveTextForAtributeInXpath("//input", "value");
	}
	
	public void next() {
		dsl.clickInXpath("//button");
	}
}
