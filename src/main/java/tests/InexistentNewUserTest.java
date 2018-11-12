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
		
		//verificar se está na pagina correta
		Assert.assertEquals("CRIE SUA NOVA CONTA", page.especificTextOfPage() );
		
		//verificar se o email está correto
		Assert.assertEquals(user.getEmail(), page.getEmailInPage());
		
		//colocar um nome completo
		page.writeCompleteName(user.getName());
		
		//verificar se o nome está correto
		Assert.assertEquals(user.getName(), page.nameWritten());
		
		//colocar um username
		page.writeUser(user.getUser());
		
		//verificar se o username está correto
		Assert.assertEquals(user.getUser(), page.userWritten());
		
		//colocar uma senha
		page.writePassword(user.getPassWord());
		
		//verificar se a senha está correta
		Assert.assertEquals(page.passwordWritten(), user.getPassWord());
		
		//clicar 
		page.next();
	}
}
