package base;

import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import org.junit.Test;
import org.testng.annotations.BeforeMethod;

import static com.telerikacademy.api.tests.utils.Constants.BASE_URL;

public class BaseTestSetup {

    @BeforeMethod
    public void setup() {
        EncoderConfig encoderConfig = RestAssured.config().getEncoderConfig()
                .appendDefaultContentCharsetToContentTypeIfUndefined(false);

        RestAssured.config = RestAssured.config().encoderConfig(encoderConfig);
    }
}
