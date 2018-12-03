package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.HomePage;

public class HomeTest extends BaseTest {
	private HomePage page = new HomePage();

	@Test
	public void refreshingTest() {
		// --not registred test------------------
		page.openTest();
		Assert.assertEquals("INFORME SEU E-MAIL", page.especificTextOfPage());

		page.writeEmail(user.getEmail());

		Assert.assertEquals(user.getEmail(), page.textWritten());

		page.next();

		page.waitStandbyLoader();

		Assert.assertEquals("CRIE SUA NOVA CONTA", page.especificTextOfPage());

		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writeCompleteName(user.getName());

		Assert.assertEquals(user.getName(), page.getNameWritten());

		page.writeUser(user.getUser());

		Assert.assertEquals(user.getUser(), page.getUserWritten());

		page.writePassword(user.getPassWord());

		Assert.assertEquals(page.getPasswordWritten(), user.getPassWord());

		page.next();

		page.waitStandbyLoader();
		Assert.assertEquals("PARA SUA SEGURANÇA, INFORME O CÓDIGO ENVIADO PARA O SEU E-MAIL:",
				page.especificTextOfPage());

		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writeToken(user.getToken());

		page.next();

		page.waitStandbyLoader();

		page.waitMlSeconds(500);
		Assert.assertEquals("INFORME SUA SENHA", page.especificTextOfPage());
		page.waitMlSeconds(0);

		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), page.getPasswordWrittenLogin());

		page.next();
		
		//find error cards
		for (int i = 1; i <= 20; i++) {
			page.waitMlSeconds(100);
			page.switchTo(i);
			page.waitMlSeconds(0);
		}
		
	}
}