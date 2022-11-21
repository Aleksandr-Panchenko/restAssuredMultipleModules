package tests.suggestions.positive;

import api.models.suggestions.SuggestionsModel;
import base.BaseTest;
import io.restassured.http.Method;
import io.restassured.specification.FilterableRequestSpecification;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class SuggestionsPositiveTests extends BaseTest {
    @DataProvider
    public Object[][] searchText() {
        return new Object[][]{
                {"Васи", 1},
                {"Васи", 9},
        };
    }

    @Test(description = "positive: FIO count = 1", dataProvider = "searchText")
    public void pSearchFioCount1(String query, int count) {
        SuggestionsModel.RequestModel requestModel = SuggestionsModel.RequestModel.builder().
                query(query).
                count(count).
                build();
        apiManager.getSuggestionsModel().searchFio(requestModel, Method.POST, 200);


    }

}
