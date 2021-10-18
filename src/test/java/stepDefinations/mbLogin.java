package stepDefinations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import base.CommonFunctions;
import base.CommonFunctions02;
import dependencyInjection.TestContext;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import loginAndLandingPagePF.Login_ObjectRepo;
import managers.FileReaderManager;
import managers.PageObjectManager;
import managers.WebDriverManagerr;

public class mbLogin {

	WebDriver driver = null;
	String MainWindow;
	Login_ObjectRepo login;
	WebElement BuyMB;
	WebElement Popup;
	WebElement Rating;
	WebDriverWait wait;
	PageObjectManager pg;
	//	FileReaderManager Filereader;
	String propertyFilePath;
	WebDriverManagerr webDriverManager;
	TestContext TestContext;
	CommonFunctions commonFunctions;
	CommonFunctions02 commonFunctions02;

	public mbLogin(TestContext context,CommonFunctions cf) {
		TestContext = context;
		commonFunctions=cf;
		//  commonFunctions02 = cf2;

	}

	@Given("User browse the website")
	public void user_browse_the_website() {

		TestContext.getPageObjectManager().getlogin().navigate_to_mb();
	}
	@And("clicks on BuyOnMB")
	public void clicks_on_buy_on_mb() {
		System.out.println("*********clicks on BuyOnMB**************");
		commonFunctions.getImpliWait();

		TestContext.getPageObjectManager().getlogin().clickMB();

		// Verify User is on Shop page

		
		String shopPage= TestContext.getcommonFunctions02().GetTitle();
		System.out.println(" User is on Shop Page " +shopPage);

		//Identify Tabs
		TestContext.getcommonFunctions02().identifyTabs();

	}

	@When("User navigates on Sign in Page")
	public void user_navigates_on_sign_in_page() {
		System.out.println("*************User navigates on Sign in Page******************");

		MainWindow = TestContext.getcommonFunctions02().GetWindowHandle();
		Set<String>Windows = TestContext.getcommonFunctions02().GetWindowHandles();
		Iterator<String> itr = Windows.iterator();

		//	driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		while(itr.hasNext()) {


			String child_window=itr.next();
			if(!MainWindow.equals(child_window)) {
                
				TestContext.getcommonFunctions02().windowSwitch(child_window);
				TestContext.getPageObjectManager().getlogin().clickOutersignIn();
			}
		}
	}


	@And("comes back to landing page")
	public void comes_back_to_landing_page() {
		System.out.println("********comes back to landing page*************");
		TestContext.getcommonFunctions02().windowSwitch(MainWindow);
	}

	@Then("I validate the feedback form")
	public void i_validate_the_feedback_form() {
		System.out.println("Browse The Website");

		//		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
        TestContext.getPageObjectManager().getlogin().clickRating();
        TestContext.getPageObjectManager().getlogin().clickSelect1();
        TestContext.getPageObjectManager().getlogin().clickSelect2();
        TestContext.getPageObjectManager().getlogin().clickSelect3();
    //    TestContext.getPageObjectManager().getlogin().clickSubmit();
		


	}

	@And("Submit the feedback form")
	public void submit_the_feedback_form() {
		System.out.println("Browse The Website");
		
		TestContext.getPageObjectManager().getlogin().clickSubmit();

	}
	@And("close the alert window")
	public void Then_Close_the_Alert() {

		System.out.println("Close the Alert");
		
		TestContext.getWebDriverManager().getExplicitWait();
		
		TestContext.getcommonFunctions02().GetAlert();
		
		
		
	}
}


