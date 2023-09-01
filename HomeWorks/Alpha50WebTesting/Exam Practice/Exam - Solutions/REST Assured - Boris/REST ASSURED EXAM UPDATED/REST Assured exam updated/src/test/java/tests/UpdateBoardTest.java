package tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Constants.*;
import static tests.DeleteCreatedBoardTest.deleteCreatedBoardTest;
import static com.telerikacademy.api.tests.RequestsBodies.*;
import static com.telerikacademy.api.tests.NamesAndDescriptions.*;
import static io.restassured.RestAssured.*;
import static java.lang.String.format;
import static org.testng.Assert.*;
import static com.telerikacademy.api.tests.JSONValidator.*;

public class UpdateBoardTest extends BaseTestSetup {


    @Test
    public void changeBoardName() {
        if (boardId == null) {
            CreateBoardTest createBoardTest = new CreateBoardTest();
            createBoardTest.createBoardTest();
        }
        baseURI = format("%s/boards/%s?%s", baseURL, boardId, API_KEY_AND_TOKEN);
        Response response = given()
                .contentType("application/json")
                .body(updateBoardName)
                .when()
                .put(baseURI);
        int statusCode = response.getStatusCode();
        System.out.println(response.asPrettyString());
        String responseName = response.getBody().jsonPath().get("name").toString();
        assertEquals(statusCode, 200, "Invalid status code.");
        assertNotNull(response.body().asString(), "Response body is null");
        assertEquals(response.getBody().jsonPath().get("name").toString()
                ,boardNewName,
                "Board name is different than expected");
    }
}

