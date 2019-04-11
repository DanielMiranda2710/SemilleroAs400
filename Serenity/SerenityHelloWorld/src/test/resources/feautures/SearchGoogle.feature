#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
@tag
Feature: smoke test
  I want to use this template for my feature file

  @tag2
  Scenario Outline: Title of your scenario outline
    Given Daniel is in google home page
    When he searchs a "<data>" compuesta "<complement>"
    Then he verify the "<expectedResult>" in step

    Examples: 
      | data | complement | expectedResult |
      | Devops  | java       | Devops java       |
      | Jerkhin | java       | Jerkhin java      |
      | Docker  | java       | Docker java       |
