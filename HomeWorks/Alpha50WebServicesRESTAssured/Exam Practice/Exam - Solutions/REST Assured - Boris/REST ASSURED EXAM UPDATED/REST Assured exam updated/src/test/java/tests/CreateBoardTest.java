package tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Colours.*;
import static com.telerikacademy.api.tests.Constants.*;
import static tests.DeleteCreatedBoardTest.deleteCreatedBoardTest;
import static com.telerikacademy.api.tests.RequestsBodies.*;
import static com.telerikacademy.api.tests.NamesAndDescriptions.*;
import static io.restassured.RestAssured.*;
import static java.lang.String.format;
import static org.testng.Assert.*;
import static com.telerikacademy.api.tests.JSONValidator.*;

public class CreateBoardTest extends BaseTestSetup {


    @Test
    public void createBoardTest() {

        boolean isNameValid = true;
        if (boardName.length() < MIN_BOARD_NAME_LENGHT || boardName.length() > MAX_BOARD_NAME_LENGTH) {
            isNameValid = false;
        }

        assertTrue(isNameValid, "Invalid Board name");
        checkForSpace();
        baseURI = format("%s/boards/?name=%s&%s", baseURL, boardName,API_KEY_AND_TOKEN);

        assertTrue(isValid(createBoardBody), "Invalid body.");

        Response response = given().contentType("application/json")
                                   .body(createBoardBody)
                                   .when()
                                   .post(baseURI);

        int statusCode = response.getStatusCode();
        String responseName = response.getBody().jsonPath().get("name").toString();
        int nameLength = responseName.length();


        assertEquals(statusCode, 200, "Invalid status code.");
        assertTrue(nameLength > MIN_BOARD_NAME_LENGHT || nameLength < MAX_BOARD_NAME_LENGTH);
        assertNotNull(response.body().asString(), "Response body is null");
        assertEquals(response.getBody().jsonPath().get("name").toString()
                , boardName,
                "Board name is different than expected");
        boardId = response.getBody().jsonPath().get("id").toString();

        System.out.printf(GREEN+"Board with id  \"%s\" was created.\n"+RESET, boardId);
        System.out.println();

    }

    private void checkForSpace() {
        baseURI = format("%s/members/%s/boards?filter=open&%s",
                baseURL,
                userName,
                API_KEY_AND_TOKEN);
        Response response = get(baseURI);
        int numberOfExistingBoards = response.getBody().jsonPath().getList("id").size() - 1;

        if (numberOfExistingBoards >= 9) {
            boardId = response.getBody().jsonPath().get("id[0]");
            deleteCreatedBoardTest();
            System.out.println(YELLOW+"Because there was not available slot for new Board, first created was deleted"+RESET);
        }
    }

}


