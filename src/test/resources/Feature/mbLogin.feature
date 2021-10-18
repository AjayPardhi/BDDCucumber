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
Feature: MB Landing Page
 I want to fill the feedback form

  @BasicTest
  Scenario: Browse Landing Page and Submit Feedback
    Given User browse the website
    And clicks on BuyOnMB
    When User navigates on Sign in Page
    And comes back to landing page
    Then I validate the feedback form
    And Submit the feedback form
    Then close the alert window

  