Feature: HW1
 
    Scenario: Search for World Covid-19 stats
        When I want to access "http://localhost:8080/world"
        Then The title of the page should be "World Report"