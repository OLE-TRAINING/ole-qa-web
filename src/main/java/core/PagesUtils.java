package core;

public class PagesUtils extends BasePage {
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
		
		public void next() {
			dsl.clickInXpath("//button");
		}
		
		public void backInitialScrean() {
			dsl.clickInXpath("//div[@class='profile-settings-menu']/i");
			dsl.clickInXpath("//div[@class='profile-settings-menu']/i/following-sibling::div//span[contains(text(), 'Sair')]");
			dsl.clickInXpath("//button[@class='btn-stay']");
		}
		
		public void clearInputs(int width) {
			dsl.clearTexts("//input", width);
		}
}
