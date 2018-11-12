package suit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.RegistredLoginTest;
import tests.RegistredPreloginTest;

@RunWith(Suite.class)
@SuiteClasses({ 
				RegistredPreloginTest.class, 
				RegistredLoginTest.class
			})

public class RegistredSuitTest {
}