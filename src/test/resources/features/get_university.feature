Feature: Hipolabs Get University

  Scenario: Return the value of "University" where the country name is South Africa
    Given the Get Universities endpoint is provided "http://universities.hipolabs.com"
    When the user sends a GET request to the API endpoint "/search?country=South+Africa"
    Then the user should receive a successful response
    And fetch the value of the university where the country is South Africa