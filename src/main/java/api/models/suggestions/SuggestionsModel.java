package api.models.suggestions;

import api.utils.NetworkCore;
import io.restassured.http.Method;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;

import static constants.Constants.Endpoints.POST_FIO;
import static constants.Constants.Paths.SUGGESTIONS_PATH;
import static constants.Constants.Protocols.HTTPS;
import static constants.Constants.Servers.SUGGESTIONS_SERVER;
import static org.apache.http.HttpHeaders.AUTHORIZATION;

public class SuggestionsModel extends NetworkCore {
    // #3
    @Getter
    @Setter
    @Builder
    public static class RequestModel {
        private String token;
        private String query;
        private int count;
    }

    public SuggestionsModel searchFio(RequestModel requestModel, Method method, int statusCode) {
//        HashMap<String, Object> getQueryParams = new HashMap();
//        getQueryParams.put("query", requestModel.getQuery());
//        getQueryParams.put("count", requestModel.getCount());

        HashMap<String, Object> bodyParams = new HashMap<>();
        bodyParams.put("query", requestModel.getQuery());
        bodyParams.put("count", requestModel.getCount());
        requestSpecBuilder.setBaseUri(HTTPS + SUGGESTIONS_SERVER).setBasePath(SUGGESTIONS_PATH + POST_FIO).
                setContentType("application/json").addHeader(AUTHORIZATION, "Token 03d11cd91af504bfd50f9ec4f60007f4900fbb13")
//                .addQueryParams(getQueryParams)
                .setBody(bodyParams);
        sendRequestAndGetResponse(method, statusCode);
        return this;
    }

}
