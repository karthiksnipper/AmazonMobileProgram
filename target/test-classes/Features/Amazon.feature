Feature: Validating the price filter function of the application
   @TC-1
   Scenario: Validating the product added to the cart, filter functions with rating  
		Given Launch the browser
		When user Search amazon on searchbar
		And user Print list of search result
		When user Clicks on amazon application
		When user Enter valid credentials
		And user selects Electronic button through all button in searchbar
		When user Enters dell computers
		When user Applies filter range rs30000 to rs50000
		Then user Validates the result first two pages in the range of rs30000 to rs50000
		Then user Prints rating5 rating from result on two pages
		When user Add the the selected rating5 product in wish list
		Then user validating the product added in the wish list
		
		
	