package co.com.google.qa.searchgooglecucumber.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.SnippetType;

@RunWith(Cucumber.class)
@CucumberOptions(features="src/test/resources/features",
	glue = {"co.com.google.qa.searchgooglecucumber.stepsdefinitions"},
	snippets = SnippetType.CAMELCASE,
	plugin = {"pretty", "html:target/cucumber-report", "json:target/cucumber.json"})

public class SearchGoogleRunner {
	
}
