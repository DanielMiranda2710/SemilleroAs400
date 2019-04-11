package com.eltiempo.qa.screenplayeltiempo.runners;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)   
@CucumberOptions( features="src/test/resources/features/ScreenplayElTiempoFoundNews.feature",
        glue = { "com.eltiempo.qa.screenplayeltiempo.stepdefinitions" },
        snippets =  SnippetType.CAMELCASE
        )  

public class ScreenplayElTiempoRunner {}
