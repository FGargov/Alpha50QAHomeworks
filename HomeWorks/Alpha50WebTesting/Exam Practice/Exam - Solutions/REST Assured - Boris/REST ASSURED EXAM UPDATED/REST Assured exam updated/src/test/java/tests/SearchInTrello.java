//package tests;
//
//import base.BaseTestSetup;
//import io.restassured.response.Response;
//import org.testng.annotations.Test;
//import static com.telerikacademy.api.tests.Constants.*;
//
//import static tests.DeleteCreatedBoardTest.deleteCreatedBoardTest;
//
//import static io.restassured.RestAssured.*;
//import static java.lang.String.format;
//
//public class SearchInTrello extends BaseTestSetup {
//
//
//    public static   void searchInTrello(){
////        https://api.trello.com/1/search?query=boards&key={{accesKey}}&token={{accesToken}}
////        https://api.trello.com/1/members/{id}/boards?key=APIKey&token=APIToken
//
//        String whatImLookingFor="idBoards";
//
//        baseURI=format("%s/members/%s/boards?filter=open&%s",baseURL,userName,API_KEY_AND_TOKEN);
//        Response response=get(baseURI);
//        System.out.println(response.getStatusCode());
////        System.out.println(response.asPrettyString());
//        System.out.println(response.getBody().jsonPath().getList("id").size());
//        int test=response.getBody().jsonPath().getList("id").size()-1;
//        String lastId=format("id[%d]",test);
//        System.out.println(lastId);
//        if(test<0){
//            CreateBoardTest createBoardTest=new CreateBoardTest();
//            createBoardTest.createBoardTest();
//            System.out.println("New board was created");
//        } else if (test>=9) {
//                boardId = response.getBody().jsonPath().get("id[0]");
//                deleteCreatedBoardTest();
//                System.out.println("first board was deleted");
//        } else {
//            boardId= response.getBody().jsonPath().get(lastId);
//            System.out.println((String) response.getBody().jsonPath().get(lastId));
//            System.out.printf("board id is %s",boardId);
//        }
////
//    }
//
//
//}
