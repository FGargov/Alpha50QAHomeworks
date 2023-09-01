package tests;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static com.telerikacademy.api.tests.utils.Constants.*;
import static com.telerikacademy.api.tests.utils.Endpoints.ISSUE_ENDPOINT;
import static com.telerikacademy.api.tests.utils.JSONRequests.ASSIGNEE_ACCOUNT_ID;
import static com.telerikacademy.api.tests.utils.JSONRequests.CREATE_ASSIGN;
import static io.restassured.RestAssured.given;

public class AssignTest {
    @Test
    public void correctAssign_when_setAssignee() {
        RequestSpecification request = given()
                .baseUri(BASE_URL)
                .auth().preemptive().basic(EMAIL, TOKEN)
                .header("Content-Type", "application/json")
                .body(ASSIGNEE_ACCOUNT_ID);

        //Response response = request.put(ISSUE_ENDPOINT + "/" + STORY_KEY + "/" + "assignee");
        Response response = request.put(ISSUE_ENDPOINT + "/" + BUG_KEY);

        Assert.assertEquals(204, response.getStatusCode());
        System.out.println("Status code: " + response.getStatusCode());
    }
}
