package base;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import managers.WebDriverManagerr;



public class CommonFunctions02 extends WebDriverManagerr {
	
private WebDriver driver;
WebDriverManagerr webDriverManagerr;
WebDriverManagerr mnr = new WebDriverManagerr();
	
public CommonFunctions02(WebDriver driver02) {
	this.driver = driver02;
		// TODO Auto-generated constructor stub
	}

public String GetTitle() {
	  
	      
		System.out.println("Print the Title");
		
		return driver.getTitle();
		
	}
public void identifyTabs() {
	
	ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());


	System.out.println("No. of tabs: " + tabs.size());
	
}

public Set<String> GetWindowHandles() {
	return driver.getWindowHandles();
}

public String GetWindowHandle() {
	return driver.getWindowHandle();
}

public void windowSwitch(String window) {
	driver.switchTo().window(window);
}
public void GetAlert() {
	Alert alt = driver.switchTo().alert();
	String Alerttext = alt.getText();
	System.out.println(Alerttext);
	alt.accept();
	
}


}
