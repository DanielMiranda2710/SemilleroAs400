$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:src/test/resources/features/SearchGoogle.feature");
formatter.feature({
  "name": "Google search",
  "description": "  I want to search a word in google",
  "keyword": "Feature",
  "tags": [
    {
      "name": "@tag"
    }
  ]
});
formatter.scenario({
  "name": "Successful search in google",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@tag"
    },
    {
      "name": "@tag1"
    }
  ]
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "Daniel is on the google home page",
  "keyword": "Given "
});
formatter.match({
  "location": "SearchGoogleStepDefinition.daniel_is_on_the_google_home_page()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he does the search",
  "keyword": "When "
});
formatter.match({
  "location": "SearchGoogleStepDefinition.he_does_the_search()"
});
formatter.result({
  "status": "passed"
});
formatter.step({
  "name": "he validates that the result is success",
  "keyword": "Then "
});
formatter.match({
  "location": "SearchGoogleStepDefinition.he_validates_that_the_result_is_success()"
});
formatter.embedding("image/png", "embedded0.png");
formatter.result({
  "status": "passed"
});
});