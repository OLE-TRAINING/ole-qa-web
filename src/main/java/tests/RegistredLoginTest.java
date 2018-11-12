package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.LoginPage;

public class RegistredLoginTest extends BaseTest {
	private LoginPage page = new LoginPage();
	@Test
	public void loginTest(){
		Assert.assertEquals("INFORME SUA SENHA",page.especificTextOfPage());
		
		Assert.assertEquals("registred@automation.com", page.getEmail());
		
		page.writePassword("23232323a");
		Assert.assertEquals("23232323a", page.getPasswordWritten());
		
		page.next();
	}
}