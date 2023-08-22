package trello.api.tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.Constants.TOKEN;
import static com.telerikacademy.api.tests.Endpoints.LISTS_ENDPOINT;
import static com.telerikacademy.api.tests.Helper.isValid;
import static com.telerikacademy.api.tests.JSONRequests.LIST;
import static io.restassured.RestAssured.baseURI;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_OK;

public class CreateListOfBoardTest extends BaseTestSetup {
    @Test
    public void correctDataReturned_when_createListOfBoardTest() {
        baseURI = format("%s%s", BASE_URL, LISTS_ENDPOINT);

        String requestBody = format(LIST, LIST_SUMMARY, BOARD_ID, KEY, TOKEN);
        Assert.assertTrue(isValid(requestBody), "Body is not a valid JSON");

        Response response = getApplicationJSONSpecification()
                .body(requestBody)
                .post();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, SC_OK, "Incorrect status code. Expected 200");
        System.out.printf("A list on a board with key %s was created%n%n", LIST_ID);

        Assert.assertEquals(response.jsonPath().getString("name"), "My first List on an exam board", "List name is not correct");
        Assert.assertFalse(response.jsonPath().getString("id").isEmpty(), "List ID is empty in the response");
    }
}
