package pages;

import core.BasePage;

public class PreloginPage extends BasePage {
	public void waitStandbyLoader() {
		dsl.expectLoaderDisappear();
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
}