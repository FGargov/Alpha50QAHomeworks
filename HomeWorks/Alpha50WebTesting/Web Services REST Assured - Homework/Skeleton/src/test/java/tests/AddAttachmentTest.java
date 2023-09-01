package tests;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import org.junit.Test;

import javax.swing.*;
import java.io.File;

import static com.telerikacademy.api.tests.utils.Constants.*;
import static com.telerikacademy.api.tests.utils.Endpoints.ISSUE_ENDPOINT;
import static com.telerikacademy.api.tests.utils.JSONRequests.CREATE_BUG;
import static io.restassured.RestAssured.given;

public class AddAttachmentTest {
    @Test
    public void createDataReturned_when_createBugWithAttachment() {
        File attachmentFile = new File("src/test/resources/Create topic - bug.jpeg");

        RequestSpecification request = given()
                .baseUri(BASE_URL + ISSUE_ENDPOINT + "/" + BUG_KEY + "/attachments")
                .auth().preemptive().basic(EMAIL, TOKEN)
                .header("X-Atlassian-Token", "no-check")
                .contentType("multipart/form-data")
                .multiPart("file", attachmentFile)
                .body(CREATE_BUG);

        Response response = request.post();

        Assert.assertEquals(200, response.getStatusCode());
        System.out.println("Status code: " + response.getStatusCode());

        //Assert.assertEquals(response.getBody().jsonPath().get("mimeType[0]"), "image/jpg", "Mime types do not match.");
    }
}
