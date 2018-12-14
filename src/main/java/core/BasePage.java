package core;

public class BasePage {
	public DSL dsl;
	
	public BasePage() {
		dsl = new DSL();
	}
	
	public String especificTextOfPage() {
		return dsl.giveTextForXpath("//div/p[1]");
	}
	
	public String getEmailInPage() {
		return dsl.giveTextForXpath("//p[2]");
	}
}
