import config.TestConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;
import static io.restassured.matcher.RestAssuredMatchers.matchesXsdInClasspath;

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
                body(matchesXsdInClasspath("suggestionsFio.xsd")).
                spec(getResponseSpecification).
                log().body();
    }
}
