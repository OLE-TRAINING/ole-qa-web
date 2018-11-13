package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.FlowNotLoggedPage;

public class FlowTestNotLogged extends BaseTest {
	private FlowNotLoggedPage page = new FlowNotLoggedPage();

	@Test
	public void flowTestNotLogged() {
		// --not registred test-------------------
		page.openTest();
		Assert.assertEquals("INFORME SEU E-MAIL", page.especificTextOfPage());

		page.writeEmail(user.getEmail());

		Assert.assertEquals(user.getEmail(), page.textWritten());

		page.next();

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

		// -- pending test
		restart();

		page.openTest();
		Assert.assertEquals("INFORME SEU E-MAIL", page.especificTextOfPage());

		page.writeEmail(user.getEmail());

		Assert.assertEquals(user.getEmail(), page.textWritten());

		page.next();

		Assert.assertEquals(
				"IDENTIFICAMOS QUE VOCÊ JÁ INICIOU UM CADASTRO, PARA CONCLUIRMOS, INFORME O CÓDIGO ENVIADO PARA SEU E-MAIL:",
				page.especificTextOfPage());

		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writeToken(user.getToken());

		page.next();

		page.waitStandbyLoader();

		page.waitMlSeconds(100);
		Assert.assertEquals("INFORME SUA SENHA", page.especificTextOfPage());
		page.waitMlSeconds(0);

		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), page.getPasswordWrittenLogin());

		page.next();

		// --lost PassWord test
		restart();

		page.openTest();
		Assert.assertEquals("INFORME SEU E-MAIL", page.especificTextOfPage());

		page.writeEmail(user.getEmail());

		Assert.assertEquals(user.getEmail(), page.textWritten());

		page.next();

		Assert.assertEquals(
				"IDENTIFICAMOS QUE VOCÊ JÁ INICIOU UM CADASTRO, PARA CONCLUIRMOS, INFORME O CÓDIGO ENVIADO PARA SEU E-MAIL:",
				page.especificTextOfPage());

		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writeToken(user.getToken());

		page.next();
		page.waitStandbyLoader();

		page.waitMlSeconds(100);
		Assert.assertEquals("INFORME SUA SENHA", page.especificTextOfPage());
		page.waitMlSeconds(0);

		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), page.getPasswordWrittenLogin());

		page.clickEsqueceuSenha();

		Assert.assertEquals("CONFIRME AS INFORMAÇÕES DE SUA CONTA", page.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writeConfirmUser(user.getUser());

		page.next();

		Assert.assertEquals("INFORME SUA NOVA SENHA", page.especificTextOfPage());

		page.writeToken(user.getToken());
		page.writeNewPassWorld(user.getPassWord());
		page.writeConfirmPassWorld(user.getPassWord());

		page.next();

		page.waitStandbyLoader();

		page.waitMlSeconds(100);
		Assert.assertEquals("INFORME SUA SENHA", page.especificTextOfPage());
		page.waitMlSeconds(0);

		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), page.getPasswordWrittenLogin());

		page.next();
	}

	public void restart() {
		page.openTest();
	}
}