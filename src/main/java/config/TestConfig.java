package config;

import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.hamcrest.Matchers;
import org.hamcrest.core.IsEqual;
import org.testng.annotations.BeforeClass;


import static constants.Constants.Actions.*;
import static constants.Constants.Paths.*;
import static constants.Constants.Protocols.*;
import static constants.Constants.Servers.*;

public class TestConfig {
    final protected RequestSpecification swapiSpec = new RequestSpecBuilder().setBaseUri(HTTP + SWAPI_SERVER).setBasePath(SWAPI_PATH).build();
    final protected RequestSpecification jsonPlaceholderSpec = new RequestSpecBuilder().setBaseUri(HTTP + JSONPLACEHOLDER).build();
    final protected RequestSpecification jsonPlaceholderPostsSpec = new RequestSpecBuilder().setBaseUri(HTTP + JSONPLACEHOLDER).setBasePath(POSTS).build();
    final protected RequestSpecification pipedreamSpec = new RequestSpecBuilder().setBaseUri(HTTPS + PIPEDREAM).build();

    final protected ResponseSpecification getResponseSpecification = new ResponseSpecBuilder().expectResponseTime(Matchers.lessThan(5000L)).expectStatusCode(200).build();
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
