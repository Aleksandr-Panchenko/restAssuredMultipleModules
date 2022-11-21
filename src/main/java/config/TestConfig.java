package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.testng.annotations.BeforeClass;


import static constants.Constants.Endpoints.*;
import static constants.Constants.Paths.*;
import static constants.Constants.Protocols.*;
import static constants.Constants.Servers.*;

public class TestConfig {
    final protected RequestSpecification swapiSpec = new RequestSpecBuilder().setBaseUri(HTTP + SWAPI_SERVER).setBasePath(SWAPI_PATH).build();
    final protected RequestSpecification suggestionsSpec = new RequestSpecBuilder().setBaseUri(HTTPS + SUGGESTIONS_SERVER).setBasePath(SUGGESTIONS_PATH).
            setContentType("application/json").addHeader("Authorization", "Token 03d11cd91af504bfd50f9ec4f60007f4900fbb13").build();
    final protected RequestSpecification reqresSpec = new RequestSpecBuilder().setBaseUri(HTTPS + REQRES_SERVER).setBasePath(REQRES_PATH).build();
    final protected RequestSpecification jsonPlaceholderSpec = new RequestSpecBuilder().setBaseUri(HTTP + JSONPLACEHOLDER).build();
    final protected RequestSpecification jsonPlaceholderPostsSpec = new RequestSpecBuilder().setBaseUri(HTTP + JSONPLACEHOLDER).setBasePath(POSTS).build();
    final protected RequestSpecification pipedreamSpec = new RequestSpecBuilder().setBaseUri(HTTPS + PIPEDREAM).build();

    final protected ResponseSpecification getResponseSpecification = new ResponseSpecBuilder().expectResponseTime(Matchers.lessThan(20000L)).expectStatusCode(200).build();
    final protected ResponseSpecification postResponseSpecification = new ResponseSpecBuilder().expectResponseTime(Matchers.lessThan(5000L)).expectStatusCode(201).build();

    @BeforeClass
    public void setUp() {
//        кастомная спека подставляется в качестве базовой
//        RestAssured.requestSpecification = swapiSpec;
//        RestAssured.responseSpecification = responseSpecification;

//      настройка для единственного модуля в проекте, когда RequestSpecification не нужна
//        RestAssured.baseURI = constants.Constants.RunVariable.server;
//        RestAssured.basePath = constants.Constants.RunVariable.path;
    }
}
