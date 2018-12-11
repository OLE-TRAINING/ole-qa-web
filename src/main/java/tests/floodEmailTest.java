package tests;

import org.junit.Assert;
import org.junit.Test;

import core.BaseTest;
import pages.HomePage;

public class floodEmailTest extends BaseTest {
	private HomePage page = new HomePage();
	private String email = "bruno@ferraresi.com";
	private String passWord = "23232323a";
	private String token = "s4c3ss";
	private String userName = "brunofe";
	private String test = "floodEmail";

	@Test
	public void refreshingTest() {
		// --flood test------------------
		page.openTest();

		if (test.equals("floodEmail")) {

			// -- flood email test
			for (int i = 1; i <= 300; i++) {
				page.openTest();
				page.fatWriteEmail(user.getEmail());
				page.fastNext();
				page.waitStandbyLoader();
				page.fastWriteCompleteName(user.getName());
				page.fastWriteUser(user.getUser());
				page.fastWritePassword(user.getPassWord());
				page.fastNext();
				createUser();
				System.out.println("Email:" + i);
			}
			page.openTest();

		} else if (test.equals("scrown")) {
			// -- home test
			page.openTest();
			page.writeEmail(email);
			page.next();
			page.waitMlSeconds(500);
			page.waitMlSeconds(0);
			page.writePasswordLogin(passWord);
			page.next();
			// div[@class='dropdown-content']/a[19]/span

			page.switchToNoScrow(19);
			page.sleepMiliSeconds(5000);

			for (;;) {
				page.waitMlSeconds(50);
				page.scrownDown();
				page.waitMlSeconds(0);
			}
		}

	}
}