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
Feature: Open news found

  Background: 
  Given Daniel wants to look for a news
    When he looks for the article
      | wordOne    | wordTwo    |
      | artificial | vision     |
    Then he expects to find the news 
      | artificial vision |
   
      
   Scenario: Search news

    Given Daniel wants to enter the news
    When he selects the news
    Then he validates the selection
    
    
