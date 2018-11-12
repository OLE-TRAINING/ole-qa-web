package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;

import pages.PreloginPage;

public class RegistredPreloginTest extends BaseTest {
	private PreloginPage page = new PreloginPage();
	
	@Test
	public void openTest() {
		page.openTest();
		Assert.assertEquals("INFORME SEU E-MAIL", page.especificTextOfPage());
		
		page.writeEmail("registred@automation.com");
		Assert.assertEquals("registred@automation.com",page.textWritten());
		
		page.next();
	}
}
