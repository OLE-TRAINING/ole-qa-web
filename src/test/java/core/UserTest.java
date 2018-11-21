package core;

import static org.junit.Assert.assertEquals;

import org.hamcrest.CoreMatchers;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ErrorCollector;


public class UserTest {
	private User user = new User();
	@Rule
	public ErrorCollector error = new ErrorCollector();
	
	@Test
	public void test() {
		String email = user.newEmail(50);
		String nome = user.newName(50);
		
		System.out.println(email);
		assertEquals(50, email.length());
		error.checkThat(email.length(), CoreMatchers.is(50));
		
		
		System.out.println(nome);
		assertEquals(50, nome.length());
		error.checkThat(nome.length(), CoreMatchers.is(50));
	}
}
