package stepDefinations;

import org.openqa.selenium.WebDriver;

import base.CommonFunctions;
import dependencyInjection.TestContext;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class Hooks {
	
	WebDriver driver = null;
	TestContext testcontext;
	CommonFunctions commonFunctions;
	
	public Hooks(TestContext context,CommonFunctions cf) {
		
		this.testcontext = context;
		commonFunctions=cf;
		
	}
	
	@Before
	
	public void setUp() {
		
		System.out.println("Test Context I have defined Webdriver in Your Constructor, So i am not going to initialise WebDriver");
		
	}
	
	@After
	
	public void tearDown() {
		testcontext.getWebDriverManager().closeDriver();
	}

}
