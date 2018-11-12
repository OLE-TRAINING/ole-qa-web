package suit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.InexistentNewUserTest;
import tests.InexistentPreLoginTest;


@RunWith(Suite.class)
@SuiteClasses({ 
				InexistentPreLoginTest.class,
				InexistentNewUserTest.class
			})

public class SuitPreLogin {
}