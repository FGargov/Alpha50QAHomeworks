package trello.api.tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.Endpoints.MEMBERS_ENDPOINT;
import static io.restassured.RestAssured.baseURI;
import static java.lang.String.format;
import static org.apache.http.HttpStatus.SC_OK;

public class UserTest extends BaseTestSetup {
    @Test
    public void validateAuthenticationTest() {
        baseURI = format("%s%s", BASE_URL, MEMBERS_ENDPOINT);

        Response response = getApplicationJSONSpecification()
                .queryParam("key", KEY)
                .queryParam("token", TOKEN)
                .get();

        int statusCode = response.getStatusCode();
        Assert.assertEquals(statusCode, SC_OK, "Incorrect status code. Expected 200");
    }
}
