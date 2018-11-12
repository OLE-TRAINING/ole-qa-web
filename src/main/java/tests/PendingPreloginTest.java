package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.PreloginPage;

public class PendingPreloginTest extends BaseTest{
		private PreloginPage page = new PreloginPage();
		@Test
		public void PendingPreloginPageTest(){
			page.openTest();
			Assert.assertEquals("INFORME SEU E-MAIL", page.especificTextOfPage());
			
			page.writeEmail("pending@automation.com");
			Assert.assertEquals("pending@automation.com",page.textWritten());
			
			page.next();
		}
}
