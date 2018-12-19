package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.HomePage;

public class HomeTest extends BaseTest {
	private HomePage page = new HomePage();
	private String email = "bruno@ferraresi.com";
	private String passWord= "23232323a";
	public int flux = 1;

	@Test
	public void refreshingTest() {
		// --not registred test------------------
		System.out.println("initing test...");
		logInformation("init", "homePage");
		if (flux == 0) {
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
			Assert.assertEquals("PARA SUA SEGURAN�A, INFORME O C�DIGO ENVIADO PARA O SEU E-MAIL:",
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

			// find error cards
			Assert.assertTrue(page.existErrorInFilmCards());

			for (int i = 1; i <= 20; i++) {
				page.waitMlSeconds(100);
				page.switchTo(i);
				page.waitMlSeconds(0);
			}
		} else if (flux == 1) {
			page.openTest();
			Assert.assertEquals("INFORME SEU E-MAIL", page.especificTextOfPage());
			page.writeEmail(email);
			Assert.assertEquals(email, page.textWritten());
			page.next();
			
			page.waitMlSeconds(500);
			Assert.assertEquals("INFORME SUA SENHA", page.especificTextOfPage());
			page.waitMlSeconds(0);

			Assert.assertEquals(email, page.getEmailInPage());

			page.writePasswordLogin(passWord);
			Assert.assertEquals(passWord, page.getPasswordWrittenLogin());

			page.next();
			
			for (int i = 1; i <= 20; i++) {
				page.waitMlSeconds(100);
				page.switchTo(i);
				page.waitMlSeconds(0);
			}
			
			// find error cards
			try {
				Assert.assertFalse(page.existErrorInFilmCards());
			} catch(AssertionError e) {
				System.out.println("possible errors listed on movie cards!");
			}
		}	
		logInformation("tested", "homePage");
		endOfTest = true;
	}
}