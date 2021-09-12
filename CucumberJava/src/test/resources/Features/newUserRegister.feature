@Feature
@severity=critical

Feature: To register a new user on YourLoga

  Scenario Outline: To register a new user
  Given user is on YourLoga Home page
  When user clicks on Sign In button
  And enters <emailaddress>
  And clicks on Create an Account button
  And user enters user details <firstname> <lastname> <password>
  And user enters address details <address> <city> <state> <zip>
  And user enters mobile number <phone>  
  And cliks on Register button
  Then new user account creation is verified on landing page <firstname> <lastname>
  
  Examples:
  |emailaddress |firstname |lastname |password |address |city |state |zip |phone |
  |nachrewes@test.com |nj |racheljane |rachsameyre |77 pent street |KA |California |64587 |5078909076 |