package restassuredtests;

import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class SampleTestForHWTaskOne {

    private static final String JIRA_BASE_URL = "https://your-jira-instance-url/rest/api/2/issue/";

    public static void main(String[] args) {
        RestAssured.baseURI = JIRA_BASE_URL;

        RequestSpecification request = RestAssured.given();
        request.auth().preemptive().basic("your-jira-username", "your-jira-api-token");
        request.header("Content-Type", "application/json");

        String requestBody = "{ \"fields\": { \"project\": { \"key\": \"YOUR_PROJECT_KEY\" }, " +
                "\"summary\": \"Sample Story created via API\", \"description\": \"This is a sample story created via API.\", " +
                "\"issuetype\": { \"name\": \"Story\" }, \"priority\": { \"name\": \"High\" } } }";

        request.body(requestBody);

        Response response = request.post();

        // Assertions
        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, 201, "Expected status code 201 (Created) but found: " + statusCode);

        String responseBody = response.getBody().asString();
        Assert.assertTrue(responseBody.contains("\"key\":"), "Story was not created successfully. Response body: " + responseBody);

        System.out.println("Status code: " + statusCode);
        System.out.println("Response body: " + responseBody);
    }
}
