//package trello.api.tests;
//
//import base.BaseTestSetup;
//import io.restassured.response.Response;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//import static com.telerikacademy.api.tests.Constants.*;
//import static com.telerikacademy.api.tests.Endpoints.BASE_URL;
//import static com.telerikacademy.api.tests.Endpoints.CARDS_ENDPOINT;
//import static com.telerikacademy.api.tests.Helper.isValid;
//import static com.telerikacademy.api.tests.JSONRequests.CARD;
//import static io.restassured.RestAssured.baseURI;
//import static java.lang.String.format;
//import static org.apache.http.HttpStatus.SC_OK;
//
//public class CreateCardTest extends BaseTestSetup {
//    @Test
//    public void correctDataReturned_when_createCardTest() {
//        baseURI = format("%s%s", BASE_URL, CARDS_ENDPOINT);
//
//        String requestBody = format(CARD, CARD_NAME, CARD_DESCRIPTION, LIST_ID, KEY, TOKEN);
//        Assert.assertTrue(isValid(requestBody), "Body is not a valid JSON");
//
//        Response response = getApplicationJSONSpecification()
//                .body(requestBody)
//                .post();
//
//        int statusCode = response.getStatusCode();
//        Assert.assertEquals(statusCode, SC_OK, "Incorrect status code. Expected 200");
//        System.out.printf("A card with key %s was created%n%n", CARD_ID);
//
//        Assert.assertFalse(response.jsonPath().getString("id").isEmpty(), "Card ID is empty in the response");
//        Assert.assertEquals(response.jsonPath().getString("name"), "My first card", "Card name is not correct");
//    }
//}
