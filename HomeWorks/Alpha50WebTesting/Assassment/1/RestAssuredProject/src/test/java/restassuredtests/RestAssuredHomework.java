package restassuredtests;

import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


    // This is a method to run the tests in a specific order
@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class RestAssuredHomework {

    // Please, paste your own info below:
    public static final String BASE_URI = "https://fgargov.atlassian.net/";
    public static final String JIRA_USER_EMAIL = "fgargov@gmail.com";
    public static final String JIRA_TOKEN = "ATATT3xFfGF0fywuTcwWSSn6cALoYgoYTlwogczyb2jPL34J4yuwBnUO69E3EnLRhKEr7EP_pMEKKSLPhXsnCxsrwJobsn28Cfw7TMQm2Qn9iw8w9fNaENgiemn_OLNipIJCBhiNQk_xYZxBLKtETQIZxilkIMAbRddmTsrAq57WcDvKmvuivOg=37758451";
    public static final String PROJECT_KEY = "PAH";

    // Now run all tests at once directly from the class play button above.
    public static String bugKey;
    public static String storyKey;


    @BeforeClass
    public static void setUpAuthentication() {
        // Set up basic authentication
        PreemptiveBasicAuthScheme basicAuth = new PreemptiveBasicAuthScheme();
        basicAuth.setUserName(JIRA_USER_EMAIL);
        basicAuth.setPassword(JIRA_TOKEN);
        RestAssured.authentication = basicAuth;
    }

    @Test
    public void post1_CreateStoryInJira() {
        // Jira API endpoint
        String jiraUrl = BASE_URI + "rest/api/2/issue/";

        // This is the body content
        String bodyContent = String.format(
                "  {\n" +
                        "    \n" +
                        "    \"fields\": {\n" +
                        "        \"issuetype\": {\n" +
                        "            \"name\": \"Story\" \n" +
                        "        },\n" +
                        "\n" +
                        "        \"project\": {\n" +
                        "            \"key\": \"%s\"\n" +
                        "        },\n" +
                        "       \n" +
                        "        \"priority\": {   \n" +
                        "            \"name\": \"Highest\"\n" +
                        "        },\n" +
                        "\n" +
                        "        \"description\": \"As potential customer, looking for travels around the world, \\n\\nand knowing about phptravels.net,\\n\\nI want to type in the website url in a browser\\n\\nAnd visit the website so that I can browse the content\",\n" +
                        "       \n" +
                        "        \"summary\": \"Visit PhpTravels.Net and browse through the content of the website\"\n" +
                        "       \n" +
                        "    }\n" +
                        "}", PROJECT_KEY);

        // Send a POST request to create the story
        Response response = RestAssured.given().baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .body(bodyContent)
                .post("rest/api/2/issue");

        // Extract the response details
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asPrettyString();

        // Print the response details
        System.out.println("Response Status Code: " + statusCode);
        System.out.println("A new story was just created with the following Response Body: " + responseBody);

        // Assertion for Response Status Code
        int expectedStatusCode = 201; // 201 represents a successful creation of the resource
        Assert.assertEquals("Response status code does not match", expectedStatusCode, statusCode);

        // Assertion for Key_Not_Null of the newly created entity
        storyKey = response.getBody().jsonPath().get("key").toString();
        Assert.assertNotNull("Story Key is null", storyKey);

        // Assertion for Id_Not_Null of the newly created entity
        String storyId = response.getBody().jsonPath().get("id").toString();
        Assert.assertNotNull("Story ID is null", storyId);

    }

    @Test
    public void post2_CreateBugInJira() {
        // Jira API endpoint
        String jiraUrl = BASE_URI + "rest/api/2/issue/";

        // This is the json body content
        String bodyContent = String.format(
                "{\n" +
                        "    \"fields\": {\n" +
                        "        \"project\": {\n" +
                        "            \"key\": \"%s\"\n" +
                        "        },\n" +
                        "        \"summary\": \"The website cannot be reached through Chrome, Firefox, and Edge browsers\",\n" +
                        "        \"description\": \"*Description:*\\n\\nAs a potential customer,\\n\\nI want to type in the website URL in a browser,\\n\\nAnd visit the website so that I can browse the content.\\n\\n*Preconditions:*\\n\\nThe following steps are done after opening Chrome, Firefox, and Edge browsers (latest versions):\\n\\n*Steps to reproduce:*\\n\\n# Navigate to the URL box of the browser\\n# Type in [phptravels.net|http://phptravels.net]\\n# Press Enter\\n\\n*Expected results:*\\n\\n# The website should be loaded and displayed.\\n\\n*Actual results:*\\n\\n# A message is displayed stating “NO RESPONSE FROM API SERVER.“\\n\",\n" +
                        "        \"issuetype\": {\n" +
                        "            \"name\": \"Bug\"\n" +
                        "        },\n" +
                        "        \"environment\": \"Chrome, Firefox, and Edge (latest versions)\",\n" +
                        "        \"priority\": {\n" +
                        "            \"name\": \"Highest\"\n" +
                        "        },\n" +
                        "        \"labels\": [\n" +
                        "            \"Severity-1\"\n" +
                        "        ]\n" +
                        "    \n" +
                        "    }\n" +
                        "}", PROJECT_KEY);

        // Send a POST request to create the bug
        Response response = RestAssured.given().baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .body(bodyContent)
                .post("rest/api/2/issue");

        // Extract the response details
        int statusCode = response.getStatusCode();
        String responseBody = response.getBody().asPrettyString();

        // Print the response details
        System.out.println("Response Status Code: " + statusCode);
        System.out.println("A new bug was just created with the following Response Body: " + responseBody);

        // Assertion for Response Status Code
        int expectedStatusCode = 201; // 201 represents a successful creation of the resource
        Assert.assertEquals("Response status code does not match", expectedStatusCode, statusCode);

        // Assertion for Key_Not_Null of the newly created entity
        bugKey = response.getBody().jsonPath().get("key").toString();
        Assert.assertNotNull("Bug Key is null", bugKey);

        // Assertion for Id_Not_Null of the newly created entity
        String bugId = response.getBody().jsonPath().get("id").toString();
        Assert.assertNotNull("Bug ID is null", bugId);
    }

    @Test
    public void post3_LinkStoryAndBug() {

        // Jira API endpoint
        String jiraUrl = BASE_URI + "rest/api/2/issueLink/";

        // This is the body content
        String bodyContent = String.format(
                "{\n" +
                        "    \"type\": {\n" +
                        "        \"name\": \"Blocks\"\n" +
                        "    },\n" +
                        "    \"inwardIssue\": {\n" +
                        "        \"key\": \"%s\"\n" +
                        "    },\n" +
                        "    \"outwardIssue\": {\n" +
                        "        \"key\": \"%s\"\n" +
                        "    }\n" +
                        "}", bugKey, storyKey);

        // Send a POST request to create the link
        Response response = RestAssured.given()
                .baseUri(BASE_URI)
                .contentType(ContentType.JSON)
                .body(bodyContent)
                .post("rest/api/2/issueLink");

        // Extract the response details
        int statusCode = response.getStatusCode();

        // Inform the user of the outcome of this post
        System.out.println("Response Status Code: " + statusCode);
        System.out.println("Hooray! The new bug " + bugKey + " was just linked to the new story " + storyKey + ". :)");


        // Assertion for Response Status Code
        int expectedStatusCode = 201; // 201 represents a successful creation of the resource
        Assert.assertEquals("Response status code does not match", expectedStatusCode, statusCode);
    }
}
