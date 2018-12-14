package pages;

import core.BasePage;

public class ConfirmInformationPage extends BasePage {
	public void backInitialScrean() {
		dsl.clickInXpath("//div[@class='profile-settings-menu']/i");
		dsl.clickInXpath("//div[@class='profile-settings-menu']/i/following-sibling::div//span[contains(text(), 'Sair')]");
		dsl.clickInXpath("//button[@class='btn-stay']");
	}
}
