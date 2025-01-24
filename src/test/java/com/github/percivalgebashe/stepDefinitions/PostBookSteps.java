package com.github.percivalgebashe.stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpStatus;

import static org.testng.Assert.assertEquals;

public class PostBookSteps {
    private RequestSpecification request;
    private Response response;
    String token;

    @Given("api endpoint {string}")
    public void setupBase(String baseURL){
        String requestBody = """
    {
        "userName" : "Sazze",
        "password" : "Password@123"
    }
    """;
        request = RestAssured.given().baseUri(baseURL);
        response = request.auth().basic("Sazze", "Password@123")
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("Account/v1/GenerateToken");
        JsonPath jsonPath = response.jsonPath();

        System.out.println(jsonPath.get().toString());

        token = jsonPath.get("token").toString();
    }

    @When("user sends POST request to add a book")
    public void postBook(){
       String requestBody = """
                {
                    "userId" : "d8930960-29b1-4661-a2f3-1850af374885",
                    "collectionOfIsbns" : [
                        {
                            "isbn" : "9781449337711"
                        }
                    ]
                }
        """;

        response=request.auth().oauth2(token)
                .header("Content-Type", "application/json")
                .body(requestBody)
                .post("BookStore/v1/Books");
    }

    @Then("the user should get Success http status code")
    public void confirmStatus(){
        assertEquals(response.getStatusCode(), HttpStatus.SC_CREATED);

        String requesyBody = """
                {
                    "isbn" : "9781449337711",
                    "userId" : "d8930960-29b1-4661-a2f3-1850af374885"
                }
        """;
        response = request.auth().oauth2(token)
                .header("Content-Type", "application/json")
                .body(requesyBody)
                .delete("BookStore/v1/Book");

        assertEquals(response.getStatusCode(), 204);
    }
}
