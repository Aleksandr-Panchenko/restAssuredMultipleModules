package swapi;


import config.TestConfig;
import org.testng.annotations.Test;

import static constants.Constants.Actions.*;

import static io.restassured.RestAssured.*;
import static io.restassured.filter.log.LogDetail.*;

public class SwapiTests extends TestConfig {

    @Test
    void filmsTest() {
        given().spec(swapiSpec).
                log().uri().log().ifValidationFails(ALL).
                when().get(GET_FILMS + "1").
                then().
                log().body().
                statusCode(200);

    }
}
