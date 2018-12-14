package pages;

import core.BasePage;

public class NewUserPage extends BasePage {
	public String getEmailInPage() {
		return dsl.giveTextForXpath("//p[2]");
	}

	public void writeCompleteName(String name) {
		dsl.writeInXpath("//input[@placeholder='Nome']", name);
	}

	public String getNameWritten() {
		return dsl.giveTextForAtributeInXpath("//input[@placeholder='Nome']", "value");
	}

	public void writeUser(String name) {
		dsl.writeInXpath("//input[@placeholder='Usuário']", name);
	}

	public String getUserWritten() {
		return dsl.giveTextForAtributeInXpath("//input[@placeholder='Usuário']", "value");
	}

	public void writePassword(String name) {
		dsl.writeInXpath("//input[@placeholder='Senha']", name);
	}

	public String getPasswordWritten() {
		return dsl.giveTextForAtributeInXpath("//input[@placeholder='Senha']", "value");
	}

	public String getNameErrorMsg() {
		return dsl.giveTextForXpath("//div[@class='jss1 form'][1]/font");
	}
	
	public String getUserErrorMsg() {
		return dsl.giveTextForXpath("//div[@class='jss1 form'][2]/font");
	}
	
	public String getPassWordErrorMsg() {
		return dsl.giveTextForXpath("//div[@class='jss1 form'][3]/font");
	}
	
	public String getEmailErrorMsg() {
		return dsl.giveTextForXpath("//font[@class='error-handler']");
	}
	
	public String getTokenError() {
		return dsl.giveTextForXpath("//font[@class='error-handler']");
	}
	
	public String getError() {
		return dsl.giveTextForXpath("//*[@id='hideMe']");
	}
	
	public void clearInputs(int width) {
		dsl.clearTexts("//input", width);
	}
}
