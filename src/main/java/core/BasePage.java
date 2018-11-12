package core;

public class BasePage {
	public DSL dsl;
	
	public BasePage() {
		dsl = new DSL();
	}
	
	public void waitStandbyLoader() {
		dsl.expectLoaderDisappear();
	}
}
