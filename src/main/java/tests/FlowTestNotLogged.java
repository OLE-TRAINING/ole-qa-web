package tests;
import org.junit.Assert;
import org.junit.Test;
import core.BaseTest;
import core.PagesUtils;
import pages.ConfirmInformationPage;
import pages.FlowNotLoggedPage;
import pages.LoginPage;
import pages.NewPassWordPage;
import pages.NewUserPage;
import pages.PendingUserPage;
import pages.PreloginPage;
import pages.ValidateInexistentUserTokenPage;

public class FlowTestNotLogged extends BaseTest {
	private PagesUtils utils = new PagesUtils();
	private FlowNotLoggedPage page = new FlowNotLoggedPage();
	private PreloginPage preloginPage = new PreloginPage();
	private NewUserPage newUserPage = new NewUserPage();
	private ValidateInexistentUserTokenPage validateInexistentUserPage = new ValidateInexistentUserTokenPage();
	private PendingUserPage pendingUserPage = new PendingUserPage();
	private ConfirmInformationPage confirmationPage = new ConfirmInformationPage();
	private NewPassWordPage newPassWordPage = new NewPassWordPage();
	private LoginPage loginPage = new LoginPage();
	
	
	
	
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
		utils.openTest();
		Assert.assertEquals("INFORME SEU E-MAIL", preloginPage.especificTextOfPage());
		preloginPage.writeEmail("wrong@-email.com");
		utils.next();
		
		Assert.assertEquals("wrong@-email.com", newUserPage.getEmailInPage());
		newUserPage.writeCompleteName("!");
		newUserPage.writeUser("!");
		newUserPage.writePassword("!");
		
		Assert.assertEquals(nameError, newUserPage.getNameErrorMsg());
		Assert.assertEquals(userError, newUserPage.getUserErrorMsg());
		Assert.assertEquals(passWordError, newUserPage.getPassWordErrorMsg());
		
		utils.clearInputs(1);
		newUserPage.writeCompleteName(user.getName());
		newUserPage.writeUser(user.getUser());
		newUserPage.writePassword(user.getPassWord());
		utils.next();
		
		Assert.assertEquals(emailError, newUserPage.getEmailErrorMsg());
		utils.openTest();
		
		preloginPage.writeEmail(user.getEmail());
		Assert.assertEquals(user.getEmail(), preloginPage.textWritten());

		utils.next();

		Assert.assertEquals("CRIE SUA NOVA CONTA", newUserPage.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), newUserPage.getEmailInPage());

		newUserPage.writeCompleteName(user.getName());
		Assert.assertEquals(user.getName(), newUserPage.getNameWritten());

		newUserPage.writeUser(user.getUser());
		Assert.assertEquals(user.getUser(), newUserPage.getUserWritten());

		newUserPage.writePassword(user.getPassWord());
		Assert.assertEquals(newUserPage.getPasswordWritten(), user.getPassWord());
		
		//-- verify wrong token and texts.
		utils.next();

		Assert.assertEquals("PARA SUA SEGURANÇA, INFORME O TOKEN ENVIADO PARA O SEU E-MAIL:", validateInexistentUserPage.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), validateInexistentUserPage.getEmailInPage());
		
		validateInexistentUserPage.writeToken("error");
		utils.next();
		Assert.assertEquals(tokenIncorrectError, validateInexistentUserPage.getTokenError());
		utils.clearInputs(5);
		validateInexistentUserPage.writeToken("error0");
		utils.next();
		Assert.assertEquals(tokenError, validateInexistentUserPage.getTokenError());
		utils.clearInputs(6);
		
		validateInexistentUserPage.writeToken(user.getToken());

		utils.next();
		
		//-- verify wrong text Login page
		loginPage.expectForEspecificTextOfPage("INFORME SUA SENHA");
		Assert.assertEquals("INFORME SUA SENHA", loginPage.especificTextOfPage());	
		Assert.assertEquals(user.getEmail(), loginPage.getEmailInPage());
		
		loginPage.writePasswordLogin("123456789");
		utils.next();
		Assert.assertEquals(passWordloginPageError, loginPage.getError());
		utils.clearInputs(9);
		
		loginPage.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), loginPage.getPasswordWrittenLogin());

		utils.next();
		
		// -- pending test/ verify wrong text
		utils.backInitialScrean();
		
		Assert.assertEquals("INFORME SEU E-MAIL", preloginPage.especificTextOfPage());
		
		preloginPage.writeEmail(user.getEmail());
		Assert.assertEquals(user.getEmail(), preloginPage.textWritten());

		utils.next();

		Assert.assertEquals("IDENTIFICAMOS QUE VOCÊ JÁ INICIOU UM CADASTRO, PARA CONCLUIRMOS, INFORME O TOKEN ENVIADO PARA SEU E-MAIL:",
				pendingUserPage.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), pendingUserPage.getEmailInPage());
		
		pendingUserPage.writeToken("error");
		utils.next();
		Assert.assertEquals(tokenIncorrectError, pendingUserPage.getTokenError());
		utils.clearInputs(5);
		pendingUserPage.writeToken("error0");
		utils.next();
		Assert.assertEquals(tokenError, pendingUserPage.getTokenError());
		utils.clearInputs(6);
		
		pendingUserPage.writeToken(user.getToken());

		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		page.next();

		page.waitStandbyLoader();

		page.expectForEspecificTextOfPage("INFORME SUA SENHA");
		Assert.assertEquals("INFORME SUA SENHA", page.especificTextOfPage());

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
				"IDENTIFICAMOS QUE VOCÊ JÁ INICIOU UM CADASTRO, PARA CONCLUIRMOS, INFORME O TOKEN ENVIADO PARA SEU E-MAIL:",
				page.especificTextOfPage());

		Assert.assertEquals(user.getEmail(), page.getEmailInPage());
		
		page.writeToken(user.getToken());

		page.next();
		page.waitStandbyLoader();

		page.expectForEspecificTextOfPage("INFORME SUA SENHA");
		Assert.assertEquals("INFORME SUA SENHA", page.especificTextOfPage());

		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), page.getPasswordWrittenLogin());

		page.clickEsqueceuSenha();

		Assert.assertEquals("CONFIRME AS INFORMAÇÕES DE SUA CONTA", page.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), page.getEmailInPage());
		
		page.writeConfirmUser("oOoOoOoOoOoO");
		page.next();
		Assert.assertEquals(userInesistentError, page.getError());
		page.clearInputs(13);
		page.writeConfirmUser("!+-@#$%5®6®®££777&*9-()()()(AD)(()");
		page.next();
		Assert.assertEquals(userComfirmationError, page.getError());
		page.clearInputs("!+-@#$%5®6®®££777&*9-()()()(AD)(()".length()+1);
		
		page.writeConfirmUser(user.getUser());

		page.next();

		Assert.assertEquals("INFORME SUA NOVA SENHA", page.especificTextOfPage());
		
		//--error token test
		page.writeToken("error");
		page.writeNewPassWorld(user.getPassWord());
		page.writeConfirmPassWorld(user.getPassWord());
		page.next();
		Assert.assertEquals(tokenIncorrectError, page.getTokenError());
		page.clearInputs(user.getPassWord().length()+1);
		page.writeToken("error0");
		page.writeNewPassWorld(user.getPassWord());
		page.writeConfirmPassWorld(user.getPassWord());	
		page.next();
		Assert.assertEquals(tokenError,  page.getError());
		page.clearInputs(user.getPassWord().length()+1);
		
		//-- error password test
		page.writeToken("error");
		page.writeNewPassWorld("@@@@@@");
		page.writeConfirmPassWorld("@@@@@@");
		page.next();
		Assert.assertEquals(passWordConfirmationError, page.getError());
		page.clearInputs(6);
		
		page.writeToken(user.getToken());
		page.writeNewPassWorld(user.getPassWord());
		page.writeConfirmPassWorld(user.getPassWord());

		page.next();

		page.waitStandbyLoader();

		page.expectForEspecificTextOfPage("INFORME SUA SENHA");
		Assert.assertEquals("INFORME SUA SENHA", page.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), page.getEmailInPage());

		page.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), page.getPasswordWrittenLogin());

		page.next();
	}	
}