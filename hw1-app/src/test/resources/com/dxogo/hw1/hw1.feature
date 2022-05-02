Feature: HW1
 
    Scenario: Search for World Covid-19 stats
        When I want to access "http://localhost:8080/world"
        And I click in "prt" select button
        Then I should see "Portugal Covid-19 Information"