package pages;

import core.BasePage;

public class ValidateRegistrationPage extends BasePage {
	public void waitStandbyLoader() {
		dsl.expectLoaderDisappear();
	}
	
	public String especificTextOfPage() {
		return dsl.giveTextForXpath("//p");
	}

	public void writeToken(String email) {
		dsl.writeInXpath("//input", email);
	}

	public String trokenWritten() {
		return dsl.giveTextForAtributeInXpath("//input", "value");
	}

	public void next() {
		dsl.clickInXpath("//button");
	}
}
