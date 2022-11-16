package swapi;

import config.TestConfig;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;

public class JsonPlaceholderTests extends TestConfig {
    @Test
    void getAllPosts() {
        given().spec(jsonPlaceholderSpec).
                log().uri().log().ifValidationFails(ALL).
                when().get().
                then().
                spec(getResponseSpecification).
                log().body();
    }

    @Test
    void getComments() {
        given().spec(jsonPlaceholderSpec).
                queryParams("postId", "1").
                log().uri().log().ifValidationFails(ALL).
                when().get().
                then().
                spec(getResponseSpecification).
                log().body().
                statusCode(200);
    }

    @Test
    void putPost() {
        String putBody = "{\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"foo\",\n" +
                "    \"body\": \"bar\",\n" +
                "    \"userId\": 1,\n" +
                "  }";
        given().spec(jsonPlaceholderPostsSpec).
                body(putBody).
                log().uri().log().ifValidationFails(ALL).
                when().put("1").
                then().
                spec(getResponseSpecification).
                log().body().
                statusCode(200);
    }

    @Test
    void deletePost() {
        given().spec(jsonPlaceholderPostsSpec).
                log().uri().log().ifValidationFails(ALL).
                when().delete("1").
                then().
                spec(getResponseSpecification).
                log().body();
    }

    @Test
    void postPost() {
        String postBody = "{\n" +
                "\"title\":\"foo\",\n" +
                "\"body\":\"bar\",\n" +
                "\"userId\":1,\n" +
                "}";
        given().spec(jsonPlaceholderPostsSpec).
                body(postBody).
                log().uri().log().ifValidationFails(ALL).
                when().post().
                then().
                spec(postResponseSpecification).
                log().body();
    }
}
