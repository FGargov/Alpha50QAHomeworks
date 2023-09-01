package base;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeMethod;

import static com.telerikacademy.api.tests.Constants.KEY;
import static com.telerikacademy.api.tests.Constants.TOKEN;
import static io.restassured.RestAssured.given;

public class BaseTestSetup {

    @BeforeMethod
    public void setup() {
        EncoderConfig encoderConfig = RestAssured.config().getEncoderConfig()
                .appendDefaultContentCharsetToContentTypeIfUndefined(false);

        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig);
    }

    public RequestSpecification getApplicationJSONSpecification() {
        return given()
                .auth().preemptive().basic(KEY, TOKEN)
                .contentType("application/json");
    }
}
