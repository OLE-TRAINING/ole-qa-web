package tests;
import org.junit.Assert;
import org.junit.Test;
import core.BaseTest;
import core.PagesUtils;
import pages.ConfirmInformationPage;
import pages.LoginPage;
import pages.NewPassWordPage;
import pages.NewUserPage;
import pages.PendingUserPage;
import pages.PreloginPage;
import pages.ValidateInexistentUserTokenPage;

public class FlowTestNotLogged extends BaseTest {
	private PagesUtils utils = new PagesUtils();
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
		System.out.println("initing test...");
		utils.openTest();
		
		logInformation("init", "preloginPage");
		Assert.assertEquals("INFORME SEU E-MAIL", preloginPage.especificTextOfPage());
		preloginPage.writeEmail("wrong@-email.com");
		logInformation("tested", "preloginPage");
		
		utils.next();
		
		logInformation("init", "newUserPage");
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
		logInformation("tested", "newUserPage");
		
		utils.openTest();
		
		logInformation("init", "preloginPage");
		preloginPage.writeEmail(user.getEmail());
		Assert.assertEquals(user.getEmail(), preloginPage.textWritten());
		logInformation("tested", "preloginPage");
		
		utils.next();
		
		logInformation("init", "newUserPage");
		Assert.assertEquals("CRIE SUA NOVA CONTA", newUserPage.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), newUserPage.getEmailInPage());

		newUserPage.writeCompleteName(user.getName());
		Assert.assertEquals(user.getName(), newUserPage.getNameWritten());

		newUserPage.writeUser(user.getUser());
		Assert.assertEquals(user.getUser(), newUserPage.getUserWritten());

		newUserPage.writePassword(user.getPassWord());
		Assert.assertEquals(newUserPage.getPasswordWritten(), user.getPassWord());
		logInformation("tested", "newUserPage");
		
		//-- verify wrong token and texts.
		utils.next();
		
		logInformation("init", "validateInexistentUserPage");
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
		logInformation("tested", "validateInexistentUserPage");
		
		utils.next();
		
		logInformation("init", "loginPage");
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
		logInformation("tested", "loginPage");
		utils.next();
		
		// -- pending test/ verify wrong text
		
		utils.backInitialScrean();
		logInformation("init", "preloginPage");
		Assert.assertEquals("INFORME SEU E-MAIL", preloginPage.especificTextOfPage());
		
		preloginPage.writeEmail(user.getEmail());
		Assert.assertEquals(user.getEmail(), preloginPage.textWritten());
		logInformation("tested", "preloginPage");
		
		utils.next();
		
		logInformation("init", "pendingUserPage");
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
		logInformation("tested", "pendingUserPage");
		
		utils.next();
		
		logInformation("init", "loginPage");
		loginPage.expectForEspecificTextOfPage("INFORME SUA SENHA");
		Assert.assertEquals("INFORME SUA SENHA", loginPage.especificTextOfPage());

		Assert.assertEquals(user.getEmail(), loginPage.getEmailInPage());

		loginPage.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), loginPage.getPasswordWrittenLogin());
		logInformation("tested", "loginPage");
		
		utils.next();

		// --lost PassWord test
		utils.backInitialScrean();
		
		utils.openTest();
		logInformation("init", "preloginPage");
		Assert.assertEquals("INFORME SEU E-MAIL", preloginPage.especificTextOfPage());

		preloginPage.writeEmail(user.getEmail());
		Assert.assertEquals(user.getEmail(), preloginPage.textWritten());
		logInformation("tested", "preloginPage");
		utils.next();

		logInformation("init", "pendingUserPage");
		Assert.assertEquals(
				"IDENTIFICAMOS QUE VOCÊ JÁ INICIOU UM CADASTRO, PARA CONCLUIRMOS, INFORME O TOKEN ENVIADO PARA SEU E-MAIL:",
				pendingUserPage.especificTextOfPage());

		Assert.assertEquals(user.getEmail(), pendingUserPage.getEmailInPage());
		
		pendingUserPage.writeToken(user.getToken());
		logInformation("tested", "pendingUserPage");
		
		utils.next();
		
		logInformation("init", "loginPage");
		loginPage.expectForEspecificTextOfPage("INFORME SUA SENHA");
		Assert.assertEquals("INFORME SUA SENHA", loginPage.especificTextOfPage());

		Assert.assertEquals(user.getEmail(), loginPage.getEmailInPage());

		loginPage.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), loginPage.getPasswordWrittenLogin());
		logInformation("tested", "loginPage");
		
		loginPage.clickEsqueceuSenha();
		
		logInformation("init", "confirmationPage");
		Assert.assertEquals("CONFIRME AS INFORMAÇÕES DE SUA CONTA", confirmationPage.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), confirmationPage.getEmailInPage());
		
		confirmationPage.writeConfirmUser("oOoOoOoOoOoO");
		utils.next();
		Assert.assertEquals(userInesistentError, confirmationPage.getError());
		
		utils.clearInputs(13);
		confirmationPage.writeConfirmUser("!+-@#$%5®6®®££777&*9-()()()(AD)(()");
		utils.next();
		Assert.assertEquals(userComfirmationError, confirmationPage.getError());
		utils.clearInputs("!+-@#$%5®6®®££777&*9-()()()(AD)(()".length()+1);
		
		confirmationPage.writeConfirmUser(user.getUser());
		logInformation("tested", "confirmationPage");
		
		utils.next();
		
		logInformation("init", "newPassWordPage");
		Assert.assertEquals("INFORME O TOKEN ENVIADO PARA O SEU EMAIL E A SUA NOVA SENHA", newPassWordPage.especificTextOfPage());
		
		//--error token test
		newPassWordPage.writeToken("error");
		newPassWordPage.writeNewPassWorld(user.getPassWord());
		newPassWordPage.writeConfirmPassWorld(user.getPassWord());
		utils.next();
		
		Assert.assertEquals(tokenIncorrectError, newPassWordPage.getError());
		utils.clearInputs(user.getPassWord().length()+1);
		newPassWordPage.writeToken("error0");
		newPassWordPage.writeNewPassWorld(user.getPassWord());
		newPassWordPage.writeConfirmPassWorld(user.getPassWord());	
		utils.next();
		Assert.assertEquals(tokenError,  newPassWordPage.getError());
		utils.clearInputs(user.getPassWord().length()+1);
		
		//-- error password test
		newPassWordPage.writeToken("error");
		newPassWordPage.writeNewPassWorld("@@@@@@");
		newPassWordPage.writeConfirmPassWorld("@@@@@@");
		utils.next();
		Assert.assertEquals(passWordConfirmationError, newPassWordPage.getError());
		utils.clearInputs(6);
		
		newPassWordPage.writeToken(user.getToken());
		newPassWordPage.writeNewPassWorld(user.getPassWord());
		newPassWordPage.writeConfirmPassWorld(user.getPassWord());

		logInformation("tested", "newPassWordPage");
		utils.next();
		
		logInformation("init", "loginPage");
		loginPage.expectForEspecificTextOfPage("INFORME SUA SENHA");
		Assert.assertEquals("INFORME SUA SENHA", loginPage.especificTextOfPage());
		Assert.assertEquals(user.getEmail(), loginPage.getEmailInPage());

		loginPage.writePasswordLogin(user.getPassWord());
		Assert.assertEquals(user.getPassWord(), loginPage.getPasswordWrittenLogin());
		logInformation("tested", "loginPage");
		utils.next();
		endOfTest = true;
	}
}