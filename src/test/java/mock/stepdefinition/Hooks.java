package mock.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.*;

//import org.apache.logging.log4j.LogManager;
//import org.apache.logging.log4j.Logger;
import org.junit.*;
import org.openqa.selenium.OutputType;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import mock.baseclass.BaseClass;
import mock.pages.GooglePage;

public class Hooks extends BaseClass{
	
	private static final Logger logger = LogManager.getLogger(Hooks.class);
	
	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
//		getFireFoxDriver();
		logger.info("logger started from hooks class");
		getChromeDriver();
		logger.info("chrome driver succesfully launched");
		enterApplUrl(getPropertyFileValue("url"));
		logger.info("url loaded successfully");
		maximizewindow();
		logger.info("browser window maximized");
		implicitlyWait(20);
		logger.info("implicit wait instanciated");
	}
	
	@After
	public void afterScenario(Scenario scenario) {
		
		
//		driver.manage().deleteAllCookies();
		logger.info("success: scenarios Completed");
		quitWindow();
	}
		

	}
	


