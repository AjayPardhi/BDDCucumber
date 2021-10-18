package base;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import dataprovider.ConfigFileReader;
import managers.FileReaderManager;

public class CommonFunctions {
	
protected WebDriver driver;
	
	ConfigFileReader configFileReader;
	
	public  CommonFunctions() {
		ConfigFileReader configFileReader = new ConfigFileReader();
		
	}
	
	public void getImpliWait() {
       FileReaderManager fg = FileReaderManager.getInstance();
       fg.getConfigReader().getImplicitlyWait();

	}
	

}
