package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static com.telerikacademy.api.tests.utils.Constants.*;
import static com.telerikacademy.api.tests.utils.Endpoints.LINK_ISSUE_ENDPOINT;
import static com.telerikacademy.api.tests.utils.JSONRequests.CREATE_ISSUE_LINK;
import static io.restassured.RestAssured.given;

public class LinkIssuesTest {
        @Test
        public void correctLinkBugToStory_when_createIssueLink(){

        RequestSpecification request = given()
                .baseUri(BASE_URL)
                .auth().preemptive().basic(EMAIL, TOKEN)
                .header("Content-Type", "application/json")
                .body(CREATE_ISSUE_LINK);

        Response response = request.post(LINK_ISSUE_ENDPOINT);

        Assert.assertEquals(201, response.getStatusCode());
        System.out.println("Status code: " + response.getStatusCode());

        Assert.assertNotNull("Response body is null", response.getBody());
    }
}
