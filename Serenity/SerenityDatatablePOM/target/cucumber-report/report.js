$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/resources/feautures/SearchGoogle.feature");
formatter.feature({
  "name": "Title of your feature",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenarioOutline({
  "name": "Title of your scenario outline",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag2"
    }
  ]
});
formatter.step({
  "name": "Daniel est� en google",
  "keyword": "Given "
});
formatter.step({
  "name": "el busca la frase \"\u003cpalabra\u003e\" compuesta \"\u003cpalabrados\u003e\"",
  "keyword": "When "
});
formatter.step({
  "name": "I verify the \"\u003cresultadoEsperado\u003e\" in step",
  "keyword": "Then "
});
formatter.examples({
  "name": "",
  "description": "",
  "keyword": "Examples",
  "rows": [
    {
      "cells": [
        "palabra",
        "palabrados",
        "resultadoEsperado"
      ]
    },
    {
      "cells": [
        "switch",
        "uno",
        "switch"
      ]
    },
    {
      "cells": [
        "name2",
        "dos",
        "Fail"
      ]
    },
    {
      "cells": [
        "name2",
        "tres",
        "Fail"
      ]
    }
  ]
});
formatter.scenario({
  "name": "Title of your scenario outline",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag2"
    }
  ]
});
formatter.step({
  "name": "Daniel est� en google",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "el busca la frase \"switch\" compuesta \"uno\"",
  "keyword": "When "
});
formatter.match({
  "location": "SearchGoogleStepsDefinitions.elBuscaLaFraseCompuesta(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I verify the \"switch\" in step",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchGoogleStepsDefinitions.iVerifyTheInStep(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Title of your scenario outline",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag2"
    }
  ]
});
formatter.step({
  "name": "Daniel est� en google",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "el busca la frase \"name2\" compuesta \"dos\"",
  "keyword": "When "
});
formatter.match({
  "location": "SearchGoogleStepsDefinitions.elBuscaLaFraseCompuesta(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I verify the \"Fail\" in step",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchGoogleStepsDefinitions.iVerifyTheInStep(String)"
});
formatter.result({
  "status": "skipped"
});
formatter.scenario({
  "name": "Title of your scenario outline",
  "description": "",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag2"
    }
  ]
});
formatter.step({
  "name": "Daniel est� en google",
  "keyword": "Given "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "el busca la frase \"name2\" compuesta \"tres\"",
  "keyword": "When "
});
formatter.match({
  "location": "SearchGoogleStepsDefinitions.elBuscaLaFraseCompuesta(String,String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "I verify the \"Fail\" in step",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchGoogleStepsDefinitions.iVerifyTheInStep(String)"
});
formatter.result({
  "status": "skipped"
});
});