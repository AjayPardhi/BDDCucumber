package dependencyInjection;

import base.CommonFunctions;
import base.CommonFunctions02;
import managers.PageObjectManager;
import managers.WebDriverManagerr;

public class TestContext {

	private WebDriverManagerr webDriverManager;
	private PageObjectManager pageObjectManager;
	private CommonFunctions02 commonFunctions02;


	public TestContext(){
		webDriverManager = new WebDriverManagerr();
		pageObjectManager = new PageObjectManager(webDriverManager.getDriver());
		commonFunctions02  = new CommonFunctions02(webDriverManager.getDriver());

	}

	public WebDriverManagerr getWebDriverManager() {
		return webDriverManager;
	}

	public PageObjectManager getPageObjectManager() {
		return pageObjectManager;
	}


	public CommonFunctions02 getcommonFunctions02() { 
		return commonFunctions02;
	}






}
