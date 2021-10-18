package managers;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import enums.DriverType;
import enums.EnvironmentType;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverManagerr {

	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;

	public WebDriverManagerr() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() {
		if(driver == null) driver = createDriver();
		return driver;
	}

	public WebDriver createDriver() {
		   switch (environmentType) {	    
	        case LOCAL : driver = createLocalDriver();
	        	break;
	        case REMOTE : driver = createRemoteDriver();
	        	break;
		   }
		   return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	public WebDriver createLocalDriver() {
        switch (driverType) {	    
        case FIREFOX : 
        	WebDriverManager.firefoxdriver().setup();
        	
        	driver = new FirefoxDriver();
	    	break;
        case CHROME : 
        	Map<String, Object> prefs = new HashMap<String, Object>();
    		prefs.put("profile.default_content_setting_values.notifications", 2);
    		WebDriverManager.chromedriver().setup();
    		ChromeOptions options = new ChromeOptions();
    		options.setExperimentalOption("prefs", prefs);
    		driver = new ChromeDriver(options);
    		break;
        case INTERNETEXPLORER : driver = new InternetExplorerDriver();
    		break;
        }

        if(FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize()) driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(), TimeUnit.SECONDS);
		return driver;
	}	

	public void closeDriver() {
		driver.quit();
	}
	
	public void getExplicitWait() {
		WebDriverWait wait = new WebDriverWait(driver,100);
		
		wait.until((ExpectedConditions.alertIsPresent()));
	}
	
	
	
	
	
	
	

}
