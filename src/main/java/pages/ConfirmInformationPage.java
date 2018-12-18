package pages;

import core.BasePage;

public class ConfirmInformationPage extends BasePage {
	public void writeConfirmUser(String name) {
		dsl.writeInXpath("//input[@placeholder='Nome de Usuário']", name);
	}
	
	public String getError() {
		return dsl.giveTextForXpath("//font[@class='error-handler']");
	}
}