package restassuredtests;

import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleHWTaskThree {

    private static final String JIRA_BASE_URL = "https://your-jira-instance-url/rest/api/2/issue/";

    public static void main(String[] args) {
        RestAssured.baseURI = JIRA_BASE_URL;

        RequestSpecification request = RestAssured.given();
        request.auth().preemptive().basic("your-jira-username", "your-jira-api-token");
        request.header("Content-Type", "application/json");

        String requestBody = "{ \"type\": { \"name\": \"is blocked by\" }, \"inwardIssue\": { \"key\": \"BUG_KEY\" }, " +
                "\"outwardIssue\": { \"key\": \"STORY_KEY\" } }"; // Replace BUG_KEY and STORY_KEY with actual issue keys

        request.body(requestBody);

        Response response = request.post();

        // Assertions
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201, "Expected status code 201 (Created) but found: " + statusCode);

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("\"id\":"), "Issue link was not created successfully. Response body: " + responseBody);

        System.out.println("Status code: " + statusCode);
        System.out.println("Response body: " + responseBody);
    }
}
