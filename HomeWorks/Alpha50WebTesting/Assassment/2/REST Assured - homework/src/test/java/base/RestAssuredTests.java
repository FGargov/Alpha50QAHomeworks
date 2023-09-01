package base;

import com.telerikacademy.api.tests.Constants;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.*;

import static io.restassured.RestAssured.given;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class RestAssuredTests extends BaseTestSetup {

    private static String projectKey;

    private static String storyKey;

    private static String bugKey;

    @BeforeAll
    public static void URI() {
        RestAssured.baseURI = String.format("https://%s/", Constants.host);
        var response = given()
                .auth().preemptive().basic(Constants.username, Constants.password)
                .when()
                .get("rest/api/2/project/search")
                .then()
                .extract().response();
        projectKey = response.path("values[0].key").toString();
    }

    @Test
    public void postStory() {
        var response = given()
                .contentType(ContentType.JSON)
                .auth().preemptive().basic(Constants.username, Constants.password)
                .and()
                .body(String.format(Constants.requestBodyForStory, projectKey))
                .when()
                .post("rest/api/2/issue/")
                .then()
                .extract().response();
        storyKey = response.path("key");

        //ba li go kakvo 6e mi vurne taz tupa jira
        Assertions.assertTrue(response.statusCode() >= 200 && response.statusCode() < 300);
    }

    @Test
    public void postBug() {
        var response = given()
                .contentType(ContentType.JSON)
                .auth().preemptive().basic(Constants.username, Constants.password)
                .and()
                .body(String.format(Constants.requestBodyForBug, projectKey))
                .when()
                .post("rest/api/2/issue/")
                .then()
                .extract().response();

        bugKey = response.path("key");

        //ba li go kakvo 6e mi vurne taz tupa jira
        Assertions.assertTrue(response.statusCode() >= 200 && response.statusCode() < 300);
    }

    @Test
    public void linkBugToStory() {
        var response = given()
                .contentType(ContentType.JSON)
                .auth().preemptive().basic(Constants.username, Constants.password)
                .and()
                .body(String.format(Constants.requestBodyForLink, bugKey, storyKey))
                .when()
                .post("rest/api/2/issueLink")
                .then()
                .extract().response();

        //ba li go kakvo 6e mi vurne taz tupa jira
        Assertions.assertTrue(response.statusCode() >= 200 && response.statusCode() < 300);
    }

    @Test
    @Order(4)
    public void linkExists() {
        var response = given()
                .contentType(ContentType.JSON)
                .auth().preemptive().basic(Constants.username, Constants.password)
                .and()
                .body(String.format(Constants.requestBodyForBug, projectKey))
                .when()
                .get("rest/api/2/issue/" + bugKey)
                .then()
                .extract().response();

        String link = response.path("fields.issuelinks[0].outwardIssue.key");

        Assertions.assertEquals(storyKey, link);
    }
}
