package tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static com.telerikacademy.api.tests.utils.Constants.*;
import static com.telerikacademy.api.tests.utils.Endpoints.ISSUE_ENDPOINT;
import static com.telerikacademy.api.tests.utils.JSONRequests.*;
import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class TransitionTest {
    @Test
    public void moveStoryToInProgressTest() {
        RequestSpecification request = given()
                .baseUri(BASE_URL)
                .auth().preemptive().basic(EMAIL, TOKEN)
                .header("Content-Type", "application/json")
                .body(CHANGE_TRANSITION);

        Response response = request.post(ISSUE_ENDPOINT + "/" + STORY_KEY + "/" + "transitions");

        Assert.assertEquals(204, response.getStatusCode());
        System.out.println("Status code: " + response.getStatusCode());

        Assert.assertNotNull("Response body is null", response.getBody());
    }

    @Test
    public void correctTransitionReturn_when_getByStoryKeyTransition(){
        RequestSpecification request = given()
                .baseUri(BASE_URL)
                .auth().preemptive().basic(EMAIL, TOKEN)
                .header("Content-Type", "application/json");

        Response response = request.get(ISSUE_ENDPOINT + "/" + STORY_KEY + "/" + "transitions");

        Assert.assertEquals(200, response.getStatusCode());
        System.out.println("Status code: " + response.getStatusCode());

        Assert.assertNotNull("Response body is null", response.getBody());
    }
}
