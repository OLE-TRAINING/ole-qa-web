package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;

import pages.PreloginPage;

public class InexistentPreLoginTest extends BaseTest {
	private PreloginPage page = new PreloginPage();
	
	@Test
	public void inexistentLoginTest() {
		//open test
		page.openTest();
		
		//verify if stay in initial page
		Assert.assertEquals("INFORME SEU E-MAIL", page.especificTextOfPage());
		
		//put email in input
		page.writeEmail(user.getEmail());
		
		//verify if email is put correctly
		Assert.assertEquals(user.getEmail(),page.textWritten());
		
		//next
		page.next();
	}
}