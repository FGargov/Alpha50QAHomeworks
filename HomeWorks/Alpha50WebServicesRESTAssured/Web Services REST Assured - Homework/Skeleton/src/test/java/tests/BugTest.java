package tests;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import static com.telerikacademy.api.tests.utils.Constants.*;
import static com.telerikacademy.api.tests.utils.Endpoints.ISSUE_ENDPOINT;
import static com.telerikacademy.api.tests.utils.JSONRequests.*;
import static io.restassured.RestAssured.given;


public class BugTest {
    @Test
    public void createDataReturned_when_createBug() {
        RequestSpecification request = given()
                .baseUri(BASE_URL + ISSUE_ENDPOINT)
                .auth().preemptive().basic(EMAIL, TOKEN)
                .header("Content-Type", "application/json")
                .body(CREATE_BUG);

        Response response = request.post();

        //System.out.println("Response body: " + response.getBody().asString());
        Assert.assertEquals(201, response.getStatusCode());
        System.out.println("Status code: " + response.getStatusCode());

        Assert.assertTrue("Content type is not JSON", response.getContentType().contains("application/json"));
        Assert.assertNotNull("Response body is null", response.getBody());
        //Assert.assertTrue("Response time is greater than 2000ms", response.getTime() <= 2000);
    }

    @Test
    public void correctBugReturn_when_getByBugKey() {
        RequestSpecification request = given()
                .baseUri(BASE_URL)
                .auth().preemptive().basic(EMAIL, TOKEN)
                .header("Content-Type", "application/json");

        Response response = request.get(ISSUE_ENDPOINT + "/" + BUG_KEY);

        Assert.assertEquals(200, response.getStatusCode());
        System.out.println("Status code: " + response.getStatusCode());

        Assert.assertNotNull(response.getBody().jsonPath().getString("key"), "Bug key is null.");

        String bugKey = response.getBody().jsonPath().getString("key");
        Assert.assertTrue("Bug key format is not as expected.", bugKey.matches("PAH-[0-9]+$"));
    }
}
