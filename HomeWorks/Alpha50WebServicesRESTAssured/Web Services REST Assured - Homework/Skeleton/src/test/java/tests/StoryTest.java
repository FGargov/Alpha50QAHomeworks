package tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static com.telerikacademy.api.tests.utils.Constants.*;
import static com.telerikacademy.api.tests.utils.Endpoints.ISSUE_ENDPOINT;
import static com.telerikacademy.api.tests.utils.JSONRequests.CREATE_STORY;
import static io.restassured.RestAssured.given;

public class StoryTest {
    @Test
    public void correctDataReturned_when_createStory() {
        RequestSpecification request = given()
                .baseUri(BASE_URL + ISSUE_ENDPOINT)
                .auth().preemptive().basic(EMAIL, TOKEN)
                .header("Content-Type", "application/json")
                .body(CREATE_STORY);

        Response response = request.post();

        //Assertions
        Assert.assertEquals(201, response.getStatusCode());
        System.out.println("Status code: " + response.getStatusCode());

        Assert.assertTrue("Content type is not JSON", response.getContentType().contains("application/json"));
        Assert.assertNotNull("Response body is null", response.getBody());
        Assert.assertTrue("Response time is greater than 2000ms", response.getTime() <= 2000);
    }

    @Test
    public void correctStoryReturn_when_getByStoryKey() {
        RequestSpecification request = given()
                .baseUri(BASE_URL)
                .auth().preemptive().basic(EMAIL, TOKEN)
                .header("Content-Type", "application/json");

        Response response = request.get(ISSUE_ENDPOINT + "/"+ STORY_KEY);

        Assert.assertEquals(200, response.getStatusCode());
        System.out.println("Status code: " + response.getStatusCode());

        Assert.assertNotNull("Response body is null", response.getBody());

        Assert.assertNotNull(response.getBody().jsonPath().getString("key"), "Story key is null.");

        String storyKey = response.getBody().jsonPath().getString("key");
        Assert.assertTrue("Story key format is not as expected.", storyKey.matches("PAH-[0-9]+$"));

        Assert.assertEquals(response.getBody().jsonPath().getString("fields.summary"), "Create a new forum topic successfully");

        Assert.assertEquals(response.getBody().jsonPath().getString("fields.issuetype.name"), "Story");
    }
}
