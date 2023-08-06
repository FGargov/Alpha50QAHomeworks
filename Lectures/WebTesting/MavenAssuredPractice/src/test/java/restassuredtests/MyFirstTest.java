package restassuredtests;

import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class MyFirstTest {
    private static final String BASE_URI = "https://reqres.in/";
    private static final String USER_RESOURCE = "api/users/2";
    private static final String REGISTER_USER_RESOURCE = "api/register";
    private static final String EMAIL_SAMPLES = "eve.holt@reqres.in";
    private static final String PASSWORD_SAMPLES = "pistol";
    public static final String REGISTER_USER_BODY_FORMAT = "{\n" +
            "    \"email\": \"%s\",\n" +
            "    \"password\": \"%s\"\n" +
            "}";

    @Test
    public void correctEmailreturn_when_getByUserId() {
       // System.out.println("success");
        String userUrl = "https://reqres.in//api/users/2";

        Response response = given()
                .baseUri("https://reqres.in/")
                .get(USER_RESOURCE);

        //Тук го направих по един начин.
        /*Assert.assertTrue(response.statusCode() == 200);
        System.out.println(response.getBody().jsonPath().get("data.email").toString());*/

        //Тук по друг начин.
        //Assert.assertEquals(200, response.statusCode());
        assertResponseCode(200, response);
        Assert.assertEquals("janet.weaver@reqres.in", response.getBody().jsonPath().get("data.email").toString());
    }

    @Test
    public void correctDataReturned_when_registerUser() {
        Response response = given()
                .baseUri(BASE_URI)
                .body(String.format(REGISTER_USER_BODY_FORMAT, EMAIL_SAMPLES, PASSWORD_SAMPLES))
                .contentType("application/json")
                .post(REGISTER_USER_RESOURCE);

        //Assert.assertEquals(200, response.statusCode());
        assertResponseCode(200, response);
        Assert.assertEquals("4", response.getBody().jsonPath().get("id").toString());
    }

    private void assertResponseCode(int expectedStatusCode, Response response) {
        Assert.assertEquals(expectedStatusCode, response.statusCode());
    }
}
