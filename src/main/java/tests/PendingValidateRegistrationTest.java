package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.ValidateRegistrationPage;

public class PendingValidateRegistrationTest extends BaseTest {
	private ValidateRegistrationPage page = new ValidateRegistrationPage();

	@Test
	public void validateRegistrationTest() {
		// verificar se est� na pagina registro pendente
		Assert.assertEquals(
				"IDENTIFICAMOS QUE VOC� J� INICIOU UM CADASTRO, PARA CONCLUIRMOS, INFORME O C�DIGO ENVIADO PARA SEU E-MAIL:",
				page.especificTextOfPage());
		
		// colocar um tokem mokado:"s4c3ss"
		page.writeToken("s4c3ss");

		// verificar se o token foi colocado corretamente
		Assert.assertEquals("s4c3ss", page.trokenWritten());

		// clicar em "VALIDAR"
		page.next();
	}
}