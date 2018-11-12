package pages;

import core.BasePage;

public class PreloginPage extends BasePage {
	public void waitStandbyLoader() {
		dsl.expectLoaderDisappear();
	}
	
	public void openTest() {
		dsl.opemInitPage();
	}

	public String especificTextOfPage() {
		return dsl.giveTextForXpath("//p");
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
}
