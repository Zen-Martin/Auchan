@Web
Feature: Re-Test Cases for Auchan Website without account Access
  Background:
    Given I am on the homePage

  @severity=minor
  @bug_1197
  Scenario: Bad host
    When Scroll down to footer
    And Click on *espace presse*
    Then The link redirects to an address that cannot be found

  @severity=critical
  @bug_1201
  Scenario: Link to 404 error page
    When Open the menu *besoin d'aide*, click on *Foires aux questions*
    And Open the menu *Nos rayons*, click on *Auchan Drive*
    Then A page displaying a message that the page is no longer available

  @severity=critical
  @bug_1210
  Scenario: Link to a non-existent page
    When Go to *Star War* page
    Then The page is no longer available

  @severity=minor
  @recommandation_1212
  Scenario: Update copyright
    When On the header bar, Click on the icon *in drive*
    Then The footer copyright is out dated

  @severity=critical
  @bug_1235
  Scenario: Link to a non-existent page
    When Scroll down, click on the *filières responsables*
    And Click on *voir tous les produits*
    Then A page displaying a message that the page is no longer available

