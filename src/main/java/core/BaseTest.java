package core;

import static core.DriverFactory.killDriver;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class BaseTest {
	public static User user = new User();
	public Boolean endOfTest = false;
	private String pageTesting;
	@Rule
	public TestName testName = new TestName();
	
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
	public void ends() throws IOException {
		TakesScreenshot ss = (TakesScreenshot) DriverFactory.getDriver();
		File arquivo = ss.getScreenshotAs(OutputType.FILE);
		
		FileUtils.copyFile(arquivo, new File("target"+File.separator+"screenshot"+File.separator+testName.getMethodName()+".jpg"));
		
		if (Properties.FECHAR_BROWSER) {
			killDriver();
		}
		
		if(endOfTest) {
			System.out.println("Test finish without error");
		} else {
			System.out.println("Test finish with error in: "+pageTesting +", you can see the error in target/screenshot and in Junit faliure trace!");
		}
	}
	
	@AfterClass
	public static void endClasses() {
		if (Properties.FECHAR_BROWSER) {
			killDriver();
		}
	}
	
	public void logInformation(String modLog,String page) {
		if(modLog.equals("init")) {
			pageTesting = page;
			System.out.println("Testing "+page);
		}
		if(modLog.equals("tested")) {
			System.out.println(page+" has any error:"+endOfTest);
			System.out.println("----------------------------------------------------");
		}
	}
}