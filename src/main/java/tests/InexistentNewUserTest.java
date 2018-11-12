package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;

import pages.NewUserPage;

public class InexistentNewUserTest extends BaseTest{
	private NewUserPage page = new NewUserPage();
	@Test
	public void inexistentNewUserPageTest() {
		page.waitStandbyLoader();
		
		//verificar se est� na pagina correta
		Assert.assertEquals("CRIE SUA NOVA CONTA", page.especificTextOfPage() );
		
		//verificar se o email est� correto
		Assert.assertEquals(user.getEmail(), page.getEmailInPage());
		
		//colocar um nome completo
		page.writeCompleteName(user.getName());
		
		//verificar se o nome est� correto
		Assert.assertEquals(user.getName(), page.nameWritten());
		
		//colocar um username
		page.writeUser(user.getUser());
		
		//verificar se o username est� correto
		Assert.assertEquals(user.getUser(), page.userWritten());
		
		//colocar uma senha
		page.writePassword(user.getPassWord());
		
		//verificar se a senha est� correta
		Assert.assertEquals(page.passwordWritten(), user.getPassWord());
		
		//clicar 
		page.next();
	}
}
