package swapi;

import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.GET_FILMS;
import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;

public class JsonPlaceholderTest extends TestConfig {
    @Test
    void allPosts() {
        given().spec(jsonPlaceholderSpec).
                log().uri().log().ifValidationFails(ALL).
                when().get( ).
                then().
                log().body().
                statusCode(200);
    }

    @Test
    void comments() {
        given().spec(jsonPlaceholderSpec).
                queryParams("postId", "1").
                log().uri().log().ifValidationFails(ALL).
                when().get().
                then().
                log().body().
                statusCode(200);
    }
}
