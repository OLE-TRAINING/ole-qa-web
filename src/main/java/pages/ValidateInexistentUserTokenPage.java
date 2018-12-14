package pages;

import core.BasePage;

public class ValidateInexistentUserTokenPage extends BasePage{
	public void writeToken(String token) {
		dsl.writeInXpath("//input", token);
	}

	public String getTokenWritten() {
		return dsl.giveTextForXpath("//input");
	}

	public void clickEmail() {
		dsl.clickInXpath("//p");
	}
	
	public String getTokenError() {
		return dsl.giveTextForXpath("//font[@class='error-handler']");
	}
}
