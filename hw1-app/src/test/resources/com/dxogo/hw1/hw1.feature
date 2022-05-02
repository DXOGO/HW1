Feature: HW1
 
    Scenario: Search for Portugal Covid-19 stats
        When I want to access "http://localhost:8080"
        And I click in "prt" select button
        Then I should see "Portugal Covid-19 Information"