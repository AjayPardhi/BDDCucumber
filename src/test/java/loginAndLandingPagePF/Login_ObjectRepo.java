package loginAndLandingPagePF;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import dataprovider.ConfigFileReader;
import managers.FileReaderManager;

public class Login_ObjectRepo {
	
	protected WebDriver driver;
	
	ConfigFileReader configFileReader;

	public Login_ObjectRepo(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		configFileReader= new ConfigFileReader();
				
	}
	
	//For Landing Page
	
	@FindBy (xpath = "//a[normalize-space()='BUY ON MEDIKABAZAAR']")
	WebElement BuyMB;
	
	@FindBy (xpath = "//i[@class='iconfont-user-menu']")
	WebElement OuterSignIn;
	
	@FindBy (xpath = "//div[@class='inside-login-signin']")
	WebElement InnerSignIn;
	
	@FindBy (xpath = "//div[@id='news-signup_close']")
	WebElement Popup;
	
	@FindBy (xpath = "//span[@class='toggle-number green-3']")
	WebElement Rating;
	
	@FindBy (xpath = "//input[@id='langs_1']")
	WebElement Select1;
	
	@FindBy (xpath = "//input[@id='langs_2']")
	WebElement Select2;
	
	@FindBy (xpath = "//input[@id='langs_6']")
	WebElement Select3;
	
	@FindBy (xpath = "//input[@id='form1-submit']")
	WebElement Submit;
	
	
		
	public void clickMB(){
		BuyMB.click();
	}
	
	public void clickOutersignIn() {
		OuterSignIn.click();
	}
	
	public void clickInnerSignIn() {
		InnerSignIn.click();
	}
	
	public  void clickPopup() {
		Popup.click();
	}
	
	public void clickRating() {
		Rating.click();
	}
	
	public void clickSelect1() {
		Select1.click();
	}
	public void clickSelect2() {
		Select2.click();
	}
	public void clickSelect3() {
		Select3.click();
	}
	public void clickSubmit() {
		Submit.click();
	}
	
	public void navigate_to_mb() {
		driver.get(FileReaderManager.getInstance().getConfigReader().getApplicationUrl());
	}
	
}
