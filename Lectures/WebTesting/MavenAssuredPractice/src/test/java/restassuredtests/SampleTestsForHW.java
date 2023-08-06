package restassuredtests;
// Import the necessary libraries
import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;
import static org.junit.Assert.*;

public class SampleTestsForHW {

    // Define the base URI and authentication details
    public static final String BASE_URI = "https://your-jira-instance.atlassian.net";
    public static final String USERNAME = "your-username";
    public static final String API_TOKEN = "your-api-token";

    @Test
    public void createStory() {

        // Set the base URI and authentication scheme
        RestAssured.baseURI = BASE_URI;
        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName(USERNAME);
        authScheme.setPassword(API_TOKEN);
        RestAssured.authentication = authScheme;

        // Create a JSON object for the request body
        String requestBody = "{\n" +
                "  \"fields\": {\n" +
                "    \"project\": {\n" +
                "      \"key\": \"TEST\"\n" +
                "    },\n" +
                "    \"summary\": \"Create a story in JIRA via JIRA API\",\n" +
                "    \"description\": \"As a tester, I want to create a story in JIRA via JIRA API so that I can automate my test cases.\",\n" +
                "    \"issuetype\": {\n" +
                "      \"name\": \"Story\"\n" +
                "    },\n" +
                "    \"priority\": {\n" +
                "      \"name\": \"High\"\n" +
                "    }\n" +
                "  }\n" +
                "}";

        // Send a POST request to the JIRA API endpoint for creating an issue
        Response response = RestAssured.given()
                .contentType(ContentType.JSON)
                .body(requestBody)
                .post("/rest/api/3/issue");

        // Print the response status code and body
        System.out.println("Status code: " + response.getStatusCode());
        System.out.println("Response body: " + response.getBody().asString());

        // Add some

        // Assert that the status code is 201 (Created)
        assertEquals("Status code is not 201", 201, response.getStatusCode());

        // Assert that the response body is not null
        assertNotNull("Response body is null", response.getBody());

        // Assert that the response body contains the expected data
        assertEquals("Summary is not correct", "Create a story in JIRA via JIRA API", response.getBody().jsonPath().getString("fields.summary"));
        assertEquals("Description is not correct", "As a tester, I want to create a story in JIRA via JIRA API so that I can automate my test cases.", response.getBody().jsonPath().getString("fields.description"));
        assertEquals("Issue type is not correct", "Story", response.getBody().jsonPath().getString("fields.issuetype.name"));
        assertEquals("Priority is not correct", "High", response.getBody().jsonPath().getString("fields.priority.name"));
    }
}
