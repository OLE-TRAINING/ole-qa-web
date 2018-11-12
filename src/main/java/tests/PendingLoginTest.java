package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;

import pages.LoginPage;

public class PendingLoginTest extends BaseTest {
		private LoginPage page = new LoginPage();
		@Test
		public void PendingLoginPageTest() {
			page.waitStandbyLoader();
			Assert.assertEquals("INFORME SUA SENHA", page.especificTextOfPage());
			Assert.assertEquals("pending@automation.com", page.getEmail());
			
			page.writePassword("23232323a");
			Assert.assertEquals("23232323a", page.getPasswordWritten());
			
			page.next();			
		}		
}