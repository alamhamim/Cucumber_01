Feature: validate searchbox 

Background: 
	Given browser is open 
		|chrome|
		|firefox|
		|opera|
		|edge|
		
	And user navigate to the url 
	
@tag1 
Scenario Outline: : verify the search box 
	When user on the homepage and verify the search box 
	And search something in the search box <"search"> 
	Then verify the search result 
	And close the browser 
	
	Examples: 
		|SearchItem|
		|Banana|
		
		@tag2 
		Scenario: verify the women product
			When verify the homepage 
			And click on the women 
			And click on all the women product and go back 
			Then close the browser 
			
		@tag3 
		Scenario: Validate Login 
			When verify the login logo 
			And click on it 
			And enters email address and password 
				|username|password|
				|user@email.com|user123|
			Then click on sign in 
			And verify the error 
			And close the browser 
			
