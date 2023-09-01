package tests;

import base.BaseTestSetup;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static com.telerikacademy.api.tests.Colours.*;
import static com.telerikacademy.api.tests.Constants.*;
import static com.telerikacademy.api.tests.NamesAndDescriptions.*;
import static io.restassured.RestAssured.*;
import static java.lang.String.format;
import static org.testng.Assert.*;


public class CreateNewListTest extends BaseTestSetup {


    @Test
    public void createNewListTest() {
        checkForBoard(boardId);

        baseURI = format("%s/lists?name=%s&idBoard=%s&%s",
                baseURL,
                listName,
                boardId,
                API_KEY_AND_TOKEN);
        Response response = given().contentType("application/json")
                                   .when()
                                   .post(baseURI);
        int statusCode = response.getStatusCode();
        assertEquals(statusCode, 200, "Invalid status code");
        assertNotNull(response.body().asString());
        assertEquals(response.getBody().jsonPath().get("name").toString(),
                listName, "Name of the list is not corresponding.");
        listId = response.getBody().jsonPath().get("id").toString();
        System.out.printf(GREEN+"List %s with id :%s was created and was assigned to board with id :%s", listName, listId,boardId);
        System.out.println();

    }

    private void checkForBoard(String BoardId) {
        if (BoardId == null) {
            baseURI = format("%s/members/%s/boards?filter=open&%s"
                    , baseURL
                    , userName
                    ,API_KEY_AND_TOKEN);
            Response response = get(baseURI);
            int numberOfExistingBoards=response.getBody().jsonPath().getList("id").size()-1;
            String lastId=format("id[%d]",numberOfExistingBoards);
            if(numberOfExistingBoards<0){
                CreateBoardTest createBoardTest=new CreateBoardTest();
                createBoardTest.createBoardTest();
                return;
            }
            boardId=response.getBody().jsonPath().get(lastId);
        }
    }
}


