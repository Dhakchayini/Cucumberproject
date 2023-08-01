package org.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
@RunWith(Cucumber.class )
@CucumberOptions(
		features ="src/test/resources/Features",
		glue = "org.StepDefinition",
		dryRun=false,
//		monochrome = false,
		//strict = true,
		snippets = SnippetType.CAMELCASE
	//	plugin = "pretty"
		
		)
public class Runner {

}
