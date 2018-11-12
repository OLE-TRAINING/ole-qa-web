package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.FlowNotLoggedPage;

public class FlowTestNotLogged extends BaseTest {
	private FlowNotLoggedPage page = new FlowNotLoggedPage();

	@Test
	public void flowTestNotLogged() {
		// --open test
		page.openTest();

		// --Initial Page test -------------------------------------
		Assert.assertEquals("INFORME SEU E-MAIL", page.especificTextOfPage());

		page.writeEmail(user.getEmail());

		Assert.assertEquals(user.getEmail(), page.textWritten());

		page.next();

		// --Create New User Page test-------------------------
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

		// --ValidateTokenPage test-----------------------
		page.waitStandbyLoader();
		Assert.assertEquals("PARA SUA SEGURANÇA, INFORME O CÓDIGO ENVIADO PARA O SEU E-MAIL:",
				page.especificTextOfPage());

		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writeToken(user.getToken());
		// Assert.assertEquals(user.getToken(), page.getTokenWritten());

		page.next();

		// --Login page test -----------------------------
		page.waitStandbyLoader();
		page.waitSeconds(2);
		Assert.assertEquals("INFORME SUA SENHA", page.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), page.getPasswordWrittenLogin());

		page.next();

		// -- Back Initial Screan ------------------------
		page.backInitialScrean();

		// --Initial Page test -------------------------------------
		Assert.assertEquals("INFORME SEU E-MAIL", page.especificTextOfPage());

		page.writeEmail(user.getEmail());

		Assert.assertEquals(user.getEmail(), page.textWritten());

		page.next();

		// -- Pending Prelogin test ----------------------------------
		Assert.assertEquals(
				"IDENTIFICAMOS QUE VOCÊ JÁ INICIOU UM CADASTRO, PARA CONCLUIRMOS, INFORME O CÓDIGO ENVIADO PARA SEU E-MAIL:",
				page.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writeToken(user.getToken());

		page.next();

		// --Login page test (click lost password)-----------------------------
		page.waitStandbyLoader();
		Assert.assertEquals("INFORME SUA SENHA", page.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), page.getPasswordWrittenLogin());

		page.clickEsqueceuSenha();

		// --ConfirmInformationPage test ----------------------------------------
		Assert.assertEquals("CONFIRME AS INFORMAÇÕES DE SUA CONTA", page.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writeConfirmUser(user.getUser());

		page.next();

		// -- NewPassWordPage --------------------------------------
		user.setPassWord("23232323b");

		Assert.assertEquals("INFORME SUA NOVA SENHA", page.especificTextOfPage());

		page.writeToken(user.getToken());
		page.writeNewPassWorld(user.getPassWord());
		page.writeConfirmPassWorld(user.getPassWord());

		page.next();

		// --Login page test -----------------------------
		page.waitStandbyLoader();
		Assert.assertEquals("INFORME SUA SENHA", page.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), page.getPasswordWrittenLogin());
		page.next();
	}
}