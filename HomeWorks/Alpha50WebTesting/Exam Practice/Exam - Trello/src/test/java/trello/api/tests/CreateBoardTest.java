package trello.api.tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.Endpoints.BOARDS_ENDPOINT;
import static com.telerikacademy.api.tests.Helper.isValid;
import static com.telerikacademy.api.tests.JSONRequests.BOARD;
import static io.restassured.RestAssured.baseURI;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_OK;

public class CreateBoardTest extends BaseTestSetup {
    @Test
    public void correctDataReturned_when_createBoardTest() {
        baseURI = format("%s%s", BASE_URL, BOARDS_ENDPOINT);

        String requestBody = format(BOARD, BOARD_SUMMARY, BOARD_DESCRIPTION, ORGANIZATION_ID, KEY, TOKEN);
        Assert.assertTrue(isValid(requestBody), "Body is not a valid JSON");

        Response response = getApplicationJSONSpecification()
                .body(requestBody)
                .post();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, SC_OK, "Incorrect status code. Expected 200");
        System.out.printf("Board with key %s was created%n%n", BOARD_ID);


        Assert.assertTrue(response.getContentType().contains("application/json"), "Content type is not JSON");
        Assert.assertEquals(response.jsonPath().getString("name"), "First Board - exam", "Board name is not correct");
        Assert.assertFalse(response.jsonPath().getString("id").isEmpty(), "Board ID is empty in the response");
        Assert.assertTrue(response.getTime() <= 2000, "Response time is greater than 2000ms");
    }
}
