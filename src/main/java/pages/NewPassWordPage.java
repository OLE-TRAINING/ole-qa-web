package pages;

import core.BasePage;

public class NewPassWordPage extends BasePage {
	public void writeToken(String token) {
		dsl.writeInXpath("//input", token);
	}
	
	public void writeNewPassWorld(String passWord) {
		dsl.writeInXpath("//input[@placeholder='Nova senha']", passWord);
	}
	
	public void writeConfirmPassWorld(String passWord) {
		dsl.writeInXpath("//input[@placeholder='Conﬁrme sua senha']", passWord);
	}
	
	public String getError() {
		return dsl.giveTextForXpath("//font[@class='error-handler']");
	}
}
