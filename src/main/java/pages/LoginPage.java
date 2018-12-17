package pages;

import core.BasePage;

public class LoginPage extends BasePage {
	public void writePasswordLogin(String password) {
		dsl.writeInXpath("//input", password);
	}

	public String getPasswordWrittenLogin() {
		return dsl.giveTextForAtributeInXpath("//input", "value");
	}

	public void clickEsqueceuSenha() {
		dsl.clickInXpath("//span");
	}
	
	public void expectForEspecificTextOfPage(String text) {
		
		dsl.expectForTextInXpath("//p[contains(.,'INFORME SUA SENHA')]", text);
		
	}
	
	public String getError() {
		return dsl.giveTextForXpath("//*[@id='hideMe']");
	}
}
