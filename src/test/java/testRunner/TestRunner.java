package testRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(
		
			features = ".\\src\\test\\java\\features\\placeValidation.feature",
			glue = {"stepDefinition"},
			plugin = {"pretty", "html:html_output", "json:json_output/jsonReport.json", "junit:junit_output/xmlReport.xml"},
			monochrome = true,
			dryRun = false,
			tags = {"@DeletePlace"}
			
	
		)



public class TestRunner {

	
}
