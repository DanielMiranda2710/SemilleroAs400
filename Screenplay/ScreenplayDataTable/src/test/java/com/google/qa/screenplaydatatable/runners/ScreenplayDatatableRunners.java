package com.google.qa.screenplaydatatable.runners;

import org.junit.runner.RunWith;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)   
@CucumberOptions( features="src/test/resources/features",
        glue = { "com.google.qa.screenplaydatatable.stepdefinitions" },
        snippets =  SnippetType.CAMELCASE
        )  
public class ScreenplayDatatableRunners {

}
