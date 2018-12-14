package pages;

import core.BasePage;

public class PendingUserPage extends BasePage {
	public void writeToken(String token) {
		dsl.writeInXpath("//input", token);
	}
	
	public String getTokenError() {
		return dsl.giveTextForXpath("//font[@class='error-handler']");
	}
}
