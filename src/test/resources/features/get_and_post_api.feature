Feature: Get and Post

#  Scenario: Return the value of "University" where the country name is South Africa
#    Given the Get Universities endpoint is provided "http://universities.hipolabs.com"
#    When the user sends a GET request to the API endpoint
#    Then the user should receive a successful response
#    And fetch the value of the university where the country is South Africa


  Scenario: Adding books to user account
    Given api endpoint "https://demoqa.com/"
    When user sends POST request to add a book
    Then the user should get Success http status code