package api.utils;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.config.RestAssuredConfig;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

import static io.restassured.RestAssured.*;
import static io.restassured.config.HeaderConfig.*;
import static org.apache.http.HttpHeaders.AUTHORIZATION;

public class NetworkCore {
    protected Response response;
    protected JSONObject responseBody;
    protected RequestSpecBuilder requestSpecBuilder = new RequestSpecBuilder();
    // #1
    public void sendRequestAndGetResponse(Method method, int statusCode) {
        RestAssuredConfig overwriteConfig = config().headerConfig(headerConfig().overwriteHeadersWithName(AUTHORIZATION));
        response = given().config(overwriteConfig).spec(requestSpecBuilder.build()).
         //       log().uri().log().parameters().log().body().
                 log().all().
                when().request(method);
        response.then().assertThat().statusCode(statusCode);
        try {
            responseBody = new JSONObject(response.getBody().asString());
        } catch (Exception e) {
            Assert.fail("Cannot get response body");
        }
    }
}
