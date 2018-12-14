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
		dsl.waitInMiliSeconds(5000);
		System.out.println(dsl.giveTextForXpath("//div/p[1]"));
		dsl.expectForTextInXpath("//div/p[1]", text);
		dsl.waitInMiliSeconds(0);
	}
	
	public String getError() {
		return dsl.giveTextForXpath("//*[@id='hideMe']");
	}
}
