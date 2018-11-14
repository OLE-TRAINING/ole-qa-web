package suit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import tests.FlowTestNotLogged;

@RunWith(Suite.class)
@SuiteClasses({ FlowTestNotLogged.class, 
				FlowTestNotLogged.class,
				FlowTestNotLogged.class,
				FlowTestNotLogged.class,
	})

public class SuitFlowTests {
}