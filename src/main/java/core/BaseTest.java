package core;

import static core.DriverFactory.killDriver;

import org.junit.After;
import org.junit.BeforeClass;


public class BaseTest {
	public static User user = new User();
	
	@BeforeClass
	public static void createUser() {
		
		//max email lenght = 50
		//email lenght >=25
		user.setEmail(user.newEmail(50));
		
		user.setName("Bruno Ferraresi "+user.newName(5));
		
		//max user lenght = 15
		user.setUser(user.newName(3));
		
		//max password = 10
		user.setPassWord("23232323a");
		user.setToken("s4c3ss");	
	}
	
	@After
	public void ends() {
		if (Properties.FECHAR_BROWSER) {
			killDriver();
		}
	}
}