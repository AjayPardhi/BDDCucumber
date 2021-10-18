package managers;

import org.openqa.selenium.WebDriver;

import loginAndLandingPagePF.Login_ObjectRepo;

public class PageObjectManager {
	
	private WebDriver driver;

	private Login_ObjectRepo landsignin;
	public PageObjectManager(WebDriver driver) {

		this.driver = driver;
		
		
	}
	
	public Login_ObjectRepo getlogin() {
		
		return (landsignin == null) ? landsignin = new Login_ObjectRepo(driver) : landsignin;

		
	}

}
