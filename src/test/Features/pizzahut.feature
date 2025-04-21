Feature: Pizzahut Order Flow

  @smoke 
  Scenario Outline: Validate Pizzahut pizza order flow
  Given User launch Pizzahut application with "<URL>"
  When User wait for auto location black pop up screen
  Then User close the pop up screen
 		 Then User type address as "<Location>"
    And User select first auto populate drop down option
   			 When User navigate to deals page
				 Then User validate vegetarian radio button flag is off
  				  And User clicks on Pizzas menu bar option
    When User select add button of any pizza from Recommended
 

    
    
  Examples:
  | URL                         | Location             |
  | https://www.pizzahut.co.in/ | lulu mall bangalore  |
