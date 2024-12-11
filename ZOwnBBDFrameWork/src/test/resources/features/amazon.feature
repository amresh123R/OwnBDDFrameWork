Feature: Open the Amazon Website

Background: 
Given Open the amazon website "https://www.amazon.in" in "edge" browser

@Smoke
Scenario: Open the amazon and verify the title of amazon website
Then Validate the title of amazon website with expected title "Online Shopping"


