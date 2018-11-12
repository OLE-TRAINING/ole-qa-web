package suit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.PendingLoginTest;
import tests.PendingPreloginTest;
import tests.PendingValidateRegistrationTest;

@RunWith(Suite.class)
@SuiteClasses({ 
				PendingPreloginTest.class,
				PendingValidateRegistrationTest.class,
				PendingLoginTest.class
			})

public class PendingRegistrationSuitTest {
}