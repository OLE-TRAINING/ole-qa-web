package pages;

import core.BasePage;

public class FlowNotLoggedPage extends BasePage {
	//(PagesUtils) --others
	public void openTest() {
		dsl.opemInitPage();
	}
	
	public void waitMleconds(int n) {
		dsl.waitInMiliSeconds(n);
	}
	
	public void waitLoader() {
		dsl.expectNotVisible("//span[@class='loader-card']");
	}
	
	public void sleepSeconds(int n) {
		dsl.sleep(n);
	}
	public void closePage() {
		dsl.closePage();
	}
	
	public void refresh() {
		dsl.refresh(1);
	}
	
	public void refreshCtrlF5() {
		dsl.refresh(2);
	}
	
	public void scrownDown() {
		dsl.goDown();
	}
	
	// --Prelogin Page -----------------------------------
	public void waitStandbyLoader() {
		dsl.expectLoaderDisappear();
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

	// --New user page------------------------------------

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
	
	public void clearInputs(int width) {
		dsl.clearTexts("//input", width);
	}
	// --Validate InexistentUser TokenPage -------
	public void writeToken(String token) {
		dsl.writeInXpath("//input", token);
	}

	public String getTokenWritten() {
		return dsl.giveTextForXpath("//input");
	}

	public void clickEmail() {
		dsl.clickInXpath("//p");
	}

	// --Login Page -----------
	public void writePasswordLogin(String password) {
		dsl.writeInXpath("//input", password);
	}

	public String getPasswordWrittenLogin() {
		return dsl.giveTextForAtributeInXpath("//input", "value");
	}

	public void clickEsqueceuSenha() {
		dsl.clickInXpath("//span");
	}

	// --back initial page--------
	public void backInitialScrean() {
		dsl.clickInXpath("//div[@class='profile-settings-menu']/i");
		dsl.clickInXpath("//div[@class='profile-settings-menu']/i/following-sibling::div//span[contains(text(), 'Sair')]");
		dsl.clickInXpath("//button[@class='btn-stay']");
	}

	// --Pending Prelogin page -------
	// all methods inplementeds before---

	// --Confirm Information Page ----------
	public void writeConfirmUser(String name) {
		//dsl.writeInXpath("//input[@placeholder='Usuário']", name);
		dsl.writeInXpath("//input[@placeholder='usuário']", name);
	}
	
	//-- NewPassWordPage --------------
	public void writeNewPassWorld(String passWord) {
		dsl.writeInXpath("//input[@placeholder='New password']", passWord);
	}
	
	public void writeConfirmPassWorld(String passWord) {
		dsl.writeInXpath("//input[@placeholder='Password confirm']", passWord);
	}
}
