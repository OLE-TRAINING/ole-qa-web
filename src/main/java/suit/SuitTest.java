package suit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.FlowTestNotLogged;
import tests.HomeTest;

@RunWith(Suite.class)
@SuiteClasses({
	FlowTestNotLogged.class,
	HomeTest.class,
	})

public class SuitTest {
}