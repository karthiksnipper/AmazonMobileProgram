package mock.runner;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

//import cucumber.api.*;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import mock.report.ReportCucumber;
@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/Features",
			                  glue={"mock.stepdefinition"},
			                  tags= "@TC-1",
			                  monochrome=true,
			                  plugin= {"pretty","json:target/index.json"},
			                  dryRun=false
			                  
			                  
		                        )
public class TestRunnerAmazon extends ReportCucumber {
	
	@AfterClass
	public static void afterClass() throws FileNotFoundException, IOException {
		System.out.println("AfterClass");
//		ReportCucumber.generateJVMReport(getProjectPath()+getPropertyFileValue("jsonPath"));
	}

}
