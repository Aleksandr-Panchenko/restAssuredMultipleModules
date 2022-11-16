import config.TestConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;

public class SuggestionsTests extends TestConfig {
    @Test
    void xmlXsdValidationTest() {
        given().spec(suggestionsSpec).
                log().uri().log().ifValidationFails(ALL).
                header("Accept", "application/xml").
                body("{\n" +
                        "  \"query\": \"Викто\",\n" +
                        "  \"count\": 1\n" +
                        "}").
                when().post("fio").
                then().
                body(matchesXsdInClasspath("xsdSchemas/suggestionsFio.xsd")).
                spec(getResponseSpecification).
                log().body();
    }

    @Test
    void jsonValidationTest() {
        given().spec(suggestionsSpec).
                log().uri().log().ifValidationFails(ALL).
                header("Accept", "application/json").
                body("{\n" +
                        "  \"query\": \"Викто\",\n" +
                        "  \"count\": 20\n" +
                        "}").
                when().post("fio").
                then().
                body(matchesJsonSchemaInClasspath("jsonSchemas/suggestionsFio.json")).
                spec(getResponseSpecification).
                log().body();
    }
}
