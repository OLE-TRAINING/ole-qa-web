package tests;
import org.junit.Assert;
import org.junit.Test;
import core.BaseTest;
import pages.FlowNotLoggedPage;

public class FlowTestNotLogged extends BaseTest {
	private FlowNotLoggedPage page = new FlowNotLoggedPage();
	private String nameError=				  "Obrigatório apenas letras e no máximo 50 caracteres.";
	                                           
	private String userError= 				  "Obrigatório conter letras e/ou números, no máximo 15 caracteres.";
	
	private String userComfirmationError= 	  "Nome de usuário pode conter no máximo 15 caracteres e apenas letras e números";
	private String userInesistentError =	  "Nome de usuário inexistente";
	private String passWordError= 			  "Obrigatório conter letras e números, entre 6 e 10 caracteres.";

	private String passWordloginPageError =   "Senha incorreta";
	private String passWordConfirmationError = "Senha deve conter entre 6 e 10 caracteres e apenas letras e números";
	private String emailError = 			  "Não foi possível realizar o cadastro com este email";
	private String tokenError =            	  "Token de validação incorreto";
	private String tokenIncorrectError =      "Token inválido";
	
	
	@Test
	public void flowTestNotLogged() {
		// --not registred test------------------
		
		//-- wrong email/verify error messages text
		page.openTest();
		Assert.assertEquals("INFORME SEU E-MAIL", page.especificTextOfPage());
		page.writeEmail("wrong@-email.com");
		page.next();
		Assert.assertEquals("wrong@-email.com", page.getEmailInPage());
		page.writeCompleteName("!");
		page.writeUser("!");
		page.writePassword("!");
		
		Assert.assertEquals(nameError, page.getNameErrorMsg());
		Assert.assertEquals(userError, page.getUserErrorMsg());
		Assert.assertEquals(passWordError, page.getPassWordErrorMsg());
		
		page.clearImputs();
		page.writeCompleteName(user.getName());
		page.writeUser(user.getUser());
		page.writePassword(user.getPassWord());
		page.next();
		Assert.assertEquals(emailError, page.getEmailErrorMsg());
		page.openTest();
		
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
		
		//-- verify wrong token and texts.
		page.next();

		page.waitStandbyLoader();
		Assert.assertEquals("PARA SUA SEGURANÇA, INFORME O TOKEN ENVIADO PARA O SEU E-MAIL:", page.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), page.getEmailInPage());
		
		page.writeToken("error");
		page.next();
		Assert.assertEquals(tokenIncorrectError, page.getTokenError());
		page.clearImputs();
		page.writeToken("error0");
		page.next();
		Assert.assertEquals(tokenError, page.getTokenError());
		page.clearImputs();
		
		page.writeToken(user.getToken());

		page.next();

		page.waitStandbyLoader();
		
		//-- verify wrong text initial page
		page.waitMlSeconds(300);
		Assert.assertEquals("INFORME SUA SENHA", page.especificTextOfPage());
		page.waitMlSeconds(0);	
		Assert.assertEquals(user.getEmail(), page.getEmailInPage());
		
		page.writePasswordLogin("123456789");
		page.next();
		Assert.assertEquals(passWordloginPageError, page.getError());
		page.clearImputs();
		
		page.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), page.getPasswordWrittenLogin());

		page.next();
		
		// -- pending test/ verify wrong text
		page.backInitialScrean();
		
		page.openTest();
		Assert.assertEquals("INFORME SEU E-MAIL", page.especificTextOfPage());
		
		page.writeEmail(user.getEmail());
		Assert.assertEquals(user.getEmail(), page.textWritten());

		page.next();

		Assert.assertEquals("IDENTIFICAMOS QUE VOC  JÁ INICIOU UM CADASTRO, PARA CONCLUIRMOS, INFORME O TOKEN ENVIADO PARA SEU E-MAIL:",
				page.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), page.getEmailInPage());
		
		page.writeToken("error");
		page.next();
		Assert.assertEquals(tokenIncorrectError, page.getTokenError());
		page.clearImputs();
		page.writeToken("error0");
		page.next();
		Assert.assertEquals(tokenError, page.getTokenError());
		page.clearImputs();
		
		page.writeToken(user.getToken());

		page.next();

		page.waitStandbyLoader();

		page.waitMlSeconds(300);
		Assert.assertEquals("INFORME SUA SENHA", page.especificTextOfPage());
		page.waitMlSeconds(0);

		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), page.getPasswordWrittenLogin());

		page.next();

		// --lost PassWord test
		page.backInitialScrean();

		page.openTest();
		Assert.assertEquals("INFORME SEU E-MAIL", page.especificTextOfPage());

		page.writeEmail(user.getEmail());
		Assert.assertEquals(user.getEmail(), page.textWritten());

		page.next();

		Assert.assertEquals(
				"IDENTIFICAMOS QUE VOC  J¡ INICIOU UM CADASTRO, PARA CONCLUIRMOS, INFORME O TOKEN ENVIADO PARA SEU E-MAIL:",
				page.especificTextOfPage());

		Assert.assertEquals(user.getEmail(), page.getEmailInPage());
		
		page.writeToken(user.getToken());

		page.next();
		page.waitStandbyLoader();

		page.waitMlSeconds(300);
		Assert.assertEquals("INFORME SUA SENHA", page.especificTextOfPage());
		page.waitMlSeconds(0);

		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), page.getPasswordWrittenLogin());

		page.clickEsqueceuSenha();

		Assert.assertEquals("CONFIRME AS INFORMA«’ES DE SUA CONTA", page.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), page.getEmailInPage());
		
		page.writeConfirmUser("oOoOoOoOoOoO");
		page.next();
		Assert.assertEquals(userInesistentError, page.getError());
		page.clearImputs();
		page.writeConfirmUser("!+-@#$%5®6®®££777&*9-()()()(AD)(()");
		page.next();
		Assert.assertEquals(userComfirmationError, page.getError());
		page.clearImputs();
		
		page.writeConfirmUser(user.getUser());

		page.next();

		Assert.assertEquals("INFORME SUA NOVA SENHA", page.especificTextOfPage());
		
		//--error token test
		page.writeToken("error");
		page.writeNewPassWorld(user.getPassWord());
		page.writeConfirmPassWorld(user.getPassWord());
		page.next();
		Assert.assertEquals(tokenIncorrectError, page.getTokenError());
		page.clearImputs();
		page.writeToken("error0");
		page.writeNewPassWorld(user.getPassWord());
		page.writeConfirmPassWorld(user.getPassWord());	
		page.next();
		Assert.assertEquals(tokenError,  page.getError());
		page.clearImputs();
		
		//-- error password test
		page.writeToken("error");
		page.writeNewPassWorld("@@@@@@");
		page.writeConfirmPassWorld("@@@@@@");
		page.next();
		Assert.assertEquals(passWordConfirmationError, page.getError());
		page.clearImputs();
		
		page.writeToken(user.getToken());
		page.writeNewPassWorld(user.getPassWord());
		page.writeConfirmPassWorld(user.getPassWord());

		page.next();

		page.waitStandbyLoader();

		page.waitMlSeconds(300);
		Assert.assertEquals("INFORME SUA SENHA", page.especificTextOfPage());
		page.waitMlSeconds(0);
		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), page.getPasswordWrittenLogin());

		page.next();
	}	
}