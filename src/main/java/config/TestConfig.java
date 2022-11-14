package config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;


import static constants.Constants.Paths.*;
import static constants.Constants.Protocols.*;
import static constants.Constants.Servers.*;

public class TestConfig {
    public static RequestSpecification swapiSpec;
    public static RequestSpecification jsonPlaceholderSpec;

    @BeforeClass
    public void setUp() {
        swapiSpec = new RequestSpecBuilder().setBaseUri(HTTP + SWAPI_SERVER).setBasePath(SWAPI_PATH).build();
        jsonPlaceholderSpec = new RequestSpecBuilder().setBaseUri(HTTP + JSONPLACEHOLDER).build();

//      настройка для единственного модуля в проекте, когда RequestSpecification не нужна
//        RestAssured.baseURI = constants.Constants.RunVariable.server;
//        RestAssured.basePath = constants.Constants.RunVariable.path;
    }
}
