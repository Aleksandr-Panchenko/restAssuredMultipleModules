package tests.reqres.positive;

import config.TestConfig;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static constants.Constants.Endpoints.*;
import static io.restassured.RestAssured.given;
import static io.restassured.filter.log.LogDetail.ALL;
import static org.hamcrest.Matchers.*;

public class ReqresPositiveTests extends TestConfig {

    @Test
    void getListUsersFromSecondPage() {
        given().spec(reqresSpec).
                queryParam("page", "2").
                log().uri().log().ifValidationFails(ALL).
                when().get(GET_LIST_USERS).
                then().
                spec(getResponseSpecification).
                log().body().
                body("page", equalTo(2)).
                body("data", not(empty()));
    }

    @Test
        // надо Убедиться что имена файлов-аватаров пользоваталей совпадают
    void checkListUsersAvatarNames() {
        Response response = given().spec(reqresSpec).
                queryParam("page", "2").
                log().uri().log().ifValidationFails(ALL).
                when().get(GET_LIST_USERS).
                then().extract().response();
        String jsonResponseAsString = response.asString();
    }
}
