package com.github.percivalgebashe.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.apache.http.HttpStatus;

import java.util.List;

public class GetUniversitySteps {

    private Response response;
    @Given("the Get Universities endpoint is provided {string}")
    public void endPointProvided(String baseURL){
        RestAssured.baseURI = baseURL;
    }

    @When("the user sends a GET request to the API endpoint {string}")
    public void sendGet(String resource){
        response = RestAssured.given()
                .get(resource);
    }

    @Then("the user should receive a successful response")
    public void confirmSuccess(){
        response.then()
                .contentType(ContentType.JSON)
                .assertThat()
                .statusCode(HttpStatus.SC_OK);
    }

    @Then("fetch the value of the university where the country is South Africa")
    public void fetUniversity(){
        List<String> universities = response.then()
                .extract()
                .jsonPath()
                .get();

        System.out.println(universities);
    }
}