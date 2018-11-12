package pages;

import core.BasePage;

public class NewUserPage extends BasePage {
	public void waitStandbyLoader() {
		dsl.expectLoaderDisappear();
	}

	public String especificTextOfPage() {
		return dsl.giveTextForXpath("//p");
	}

	public String getEmailInPage() {
		return dsl.giveTextForXpath("//p[2]");
	}

	public void writeCompleteName(String name) {
		dsl.writeInXpath("//input[@placeholder='Name']", name);
	}
	
	public String nameWritten() {
		return dsl.giveTextForAtributeInXpath("//input[@placeholder='Name']", "value");
	}
	
	public void writeUser(String name) {
		dsl.writeInXpath("//input[@placeholder='Name']", name);
	}
	
	public String userWritten() {
		return dsl.giveTextForAtributeInXpath("//input[@placeholder='Name']", "value");
	}
	
	public void writePassword(String name) {
		dsl.writeInXpath("//input[@placeholder='Password']", name);
	}
	
	public String passwordWritten() {
		return dsl.giveTextForAtributeInXpath("//input[@placeholder='Password']", "value");
	}
	
	public void next() {
		dsl.clickInXpath("//button");
	}
}
