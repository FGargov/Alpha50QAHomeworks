package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static com.telerikacademy.api.tests.utils.Constants.*;
import static com.telerikacademy.api.tests.utils.Endpoints.ISSUE_ENDPOINT;
import static com.telerikacademy.api.tests.utils.JSONRequests.SET_PRIORITY;
import static io.restassured.RestAssured.given;

public class PriorityTest {
    @Test
    public void correctPriorityReturn_when_setPriority() {
        RequestSpecification request = given()
                .baseUri(BASE_URL)
                .auth().preemptive().basic(EMAIL, TOKEN)
                .header("Content-Type", "application/json")
                .body(SET_PRIORITY);

        Response response = request.put(ISSUE_ENDPOINT + "/" + BUG_KEY);

        Assert.assertEquals(204, response.getStatusCode());
        System.out.println("Status code: " + response.getStatusCode());

        Assert.assertNotNull("Response body is null", response.getBody());
    }
}
