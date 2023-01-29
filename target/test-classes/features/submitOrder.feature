
Feature: Title of your feature
  I want to use this template for my feature file
	
	Background:
	Given navigate to the landingpage

  @mallulaTest
  Scenario Outline: purchase a order with the selected product
    Given login application with <username> and <password>
    When add the <productname> to the kart and checkout
    And add the <address> in the paymentpage
    Then I verify the order in the orders page

    Examples: 
      | username  							| password 	| productname  		|address|
      | anshika@gmail.com | Iamking@000| ZARA COAT 3 |	India	|
    
    
   
    
