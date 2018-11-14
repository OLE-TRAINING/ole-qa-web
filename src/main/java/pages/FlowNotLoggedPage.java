package pages;

import core.BasePage;

public class FlowNotLoggedPage extends BasePage {
	// --others
	public void waitMlSeconds(int n) {
		dsl.waitInMiliSeconds(n);
	}
	public void closePage() {
		dsl.closePage();
	}
	
	// --Prelogin Page -----------------------------------
	public void waitStandbyLoader() {
		dsl.expectLoaderDisappear();
	}

	public void openTest() {
		dsl.opemInitPage();
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

	public void next() {
		dsl.clickInXpath("//button");
	}

	// --New user page------------------------------------

	public String getEmailInPage() {
		return dsl.giveTextForXpath("//p[2]");
	}

	public void writeCompleteName(String name) {
		dsl.writeInXpath("//input[@placeholder='Name']", name);
	}

	public String getNameWritten() {
		return dsl.giveTextForAtributeInXpath("//input[@placeholder='Name']", "value");
	}

	public void writeUser(String name) {
		dsl.writeInXpath("//input[@placeholder='User']", name);
	}

	public String getUserWritten() {
		return dsl.giveTextForAtributeInXpath("//input[@placeholder='User']", "value");
	}

	public void writePassword(String name) {
		dsl.writeInXpath("//input[@placeholder='Password']", name);
	}

	public String getPasswordWritten() {
		return dsl.giveTextForAtributeInXpath("//input[@placeholder='Password']", "value");
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
		dsl.clickInXpath("//div[@class='header-content']/div/i");
	}

	// --Pending Prelogin page -------
	// all methods inplementeds before---

	// --Confirm Information Page ----------
	public void writeConfirmUser(String name) {
		dsl.writeInXpath("//input[@placeholder='username']", name);
	}
	
	//-- NewPassWordPage --------------
	public void writeNewPassWorld(String passWord) {
		dsl.writeInXpath("//input[@placeholder='New password']", passWord);
	}
	
	public void writeConfirmPassWorld(String passWord) {
		dsl.writeInXpath("//input[@placeholder='Password confirm']", passWord);
	}

}
