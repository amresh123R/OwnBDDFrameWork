Feature: Open the google home page 
Check the home page related all functionalities
 
 Background:
 Given User open the google website "https://google.com" in "chrome" browser
 
 @Regression
 Scenario:
When User type the "Automation Testing" in search box
And Click on search button
Then Verify the searched paged with title "Automation Testing"


 
	