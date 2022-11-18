import config.TestConfig;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Map;

import static constants.Constants.Actions.*;

import static io.restassured.RestAssured.*;
import static io.restassured.filter.log.LogDetail.*;

public class SwapiTests extends TestConfig {

    @Test
    void swapiTest() {
        Response response = given().spec(swapiSpec).
                log().uri().log().ifValidationFails(ALL).
                when().get().
                then().
                spec(getResponseSpecification).
                log().body().extract().response();
        Map<String, String> cookies = response.getCookies();
        Headers headers = response.getHeaders();
        String respContentType = response.getContentType();
    }

    @Test
    void filmsTest() {
        given().spec(swapiSpec).
                log().uri().log().ifValidationFails(ALL).
                when().get(GET_FILMS + "1").
                then().
                spec(getResponseSpecification).
                log().body();
    }

    @Test
    void getPeople() {
        Response response = given().spec(swapiSpec).
                log().uri().log().ifValidationFails(ALL).
                when().get(GET_PEOPLE).
                then().
                spec(getResponseSpecification).
                log().body().
                extract().response();
        Map<String, ?> lukeSkywalker = response.path("results.find{ it.name = 'Luke Skywalker'}");
        ArrayList<?> mass77 = response.path("results.findAll{ it.mass == '77'}");
        ArrayList<?> namesInSWFilms = response.path("results.findAll{ it.films}.name");
        String firstLukeFilm = response.path("results.find{ it.name = 'Luke Skywalker'}.films?.find()");
        String lukeUrl = response.path("results.find{ it.name = 'Luke Skywalker'}.url");
    }
}
