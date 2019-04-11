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
Feature: Title of your feature

  @tag2
  Scenario Outline: Title of your scenario outline
    Given Daniel wants to look for a phrase
    When he looks for the phrase
      | wordOne | wordTwo      |
      | <data>  | <complement> |
    Then he expects to find the phrase

    Examples: 
      | data     | complement | expectedResult |
      | jenkhins | java       | jenkhins java  |
      | devops   | java       | devops java    |
      | docker   | java       | docker java    |
