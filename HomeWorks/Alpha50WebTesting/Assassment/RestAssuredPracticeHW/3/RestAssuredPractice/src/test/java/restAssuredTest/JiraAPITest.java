package restAssuredTest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class JiraAPITest {

    private static final String BASE_URL = "https://fgargov.atlassian.net";
    private static final String USERNAME = "fgargov@gmail.com";
    private static final String API_TOKEN = "ATATT3xFfGF0fywuTcwWSSn6cALoYgoYTlwogczyb2jPL34J4yuwBnUO69E3EnLRhKEr7EP_pMEKKSLPhXsnCxsrwJobsn28Cfw7TMQm2Qn9iw8w9fNaENgiemn_OLNipIJCBhiNQk_xYZxBLKtETQIZxilkIMAbRddmTsrAq57WcDvKmvuivOg=37758451";

    @Test
    public void testCreateStory() {
        String requestBody = "{\n" +
                "  \"fields\": {\n" +
                "    \"project\": {\n" +
                "      \"key\": \"PAH\"\n" +
                "    },\n" +
                "    \"summary\": \"Creating a topic as an user of the forum.\",\n" +
                "    \"description\": \"Description: Testing if a user is able to create a new topic on the forum.\\n" +
                "\\nPreconditions: User is registered on the forum.\\n\\nTest steps:\\nLogin on the forum." +
                "\\nNavigate to the + New Topic button and click on it.\\nEnter a valid title for the topic (between 5 and 255 characters)." +
                "\\nEnter a valid content for the topic (between 10 and 32000 characters).\\nNavigate to the + Create Topic button and click on it." +
                "\\n\\nExpected outcome: New topic is created.\",\n" +
                "    \"issuetype\": {\n" +
                "      \"name\": \"Story\"\n" +
                "    },\n" +
                "    \"priority\": {\n" +
                "      \"name\": \"High\"\n" +
                "    }\n" +
                "  }\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .auth().preemptive().basic(USERNAME, API_TOKEN)
                .body(requestBody)
                .post(BASE_URL + "/issue")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(201, statusCode);
    }

    @Test
    public void testCreateBug() {
        String requestBody = "{\n" +
                "  \"fields\": {\n" +
                "    \"project\": {\n" +
                "      \"key\": \"PAH\"\n" +
                "    },\n" +
                "    \"summary\": \"Forum cuts the title after maximum chars is exceeded instead of displaying an error message\",\n" +
                "    \"description\": \"Description: Testing if when a user exceeds the maximum chars when creating a title, an error message pops up.\\n" +
                "\\nPreconditions: User is registered on the forum.\\n\\nTest steps:\\nLogin on the forum.\\nNavigate to the + New Topic button and click on it." +
                "\\nEnter a title for the topic with more than 255 characters.\\nEnter a valid content for the topic (between 10 and 32000 characters)." +
                "\\nNavigate to the + Create Topic button and click on it.\\n\\nExpected outcome: an error message pops up\\n" +
                "\\nActual outcome: Title is cut to the maximum allowed characters and a topic is created.\",\n" +
                "    \"environment\": \"Website URL: https://forum.telerikacademy.com/\\nBrowser tested: Edge.\\nOperating System: Windows 10.\",\n" +
                "    \"issuetype\": {\n" +
                "      \"name\": \"Bug\"\n" +
                "    },\n" +
                "    \"priority\": {\n" +
                "      \"name\": \"Medium\"\n" +
                "    }\n" +
                "  }\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .auth().preemptive().basic(USERNAME, API_TOKEN)
                .body(requestBody)
                .post(BASE_URL + "/issue")
                .then()
                .extract().response();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(201, statusCode);
    }

    @Test
    public void testLinkBugToStory() {
        String linkRequestBody = "{\n" +
                "  \"type\": {\n" +
                "    \"name\": \"Blocks\"\n" +
                "  },\n" +
                "  \"inwardIssue\": {\n" +
                "    \"key\": \"PAH-4\"\n" +
                "  },\n" +
                "  \"outwardIssue\": {\n" +
                "    \"key\": \"PAH-3\"\n" +
                "  }\n" +
                "}";

        Response response = given()
                .contentType(ContentType.JSON)
                .auth().preemptive().basic(USERNAME, API_TOKEN)
                .body(linkRequestBody)
                .post(BASE_URL + "/issueLink");

        int statusCode = response.getStatusCode();
        Assert.assertEquals(201, statusCode);
    }
}
