package helpers;

import config.BrowserstackConfig;
import config.ProjectConfig;
import org.aeonbits.owner.ConfigFactory;

import java.net.MalformedURLException;
import java.net.URL;

import static io.restassured.RestAssured.given;

public class Browserstack {

    public static String videoUrl(String sessionId) {
        return given()
                .auth().basic(ProjectConfig.browserstackConfig.username(), ProjectConfig.browserstackConfig.key())
                .when()
                .get(ProjectConfig.browserstackConfig.sessionUrl() + sessionId + ".json")
                .then()
                .statusCode(200)
                .log().body()
                .extract()
                .response()
                .path("automation_session.video_url");
    }

    public static URL getBrowserstackUrl() {
        try {
            return new URL(String.format(ProjectConfig.browserstackConfig.hubUrl(), ProjectConfig.browserstackConfig.username(),
                    ProjectConfig.browserstackConfig.key()));
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }
}
