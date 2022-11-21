package api.api_manager;

import api.models.suggestions.SuggestionsModel;
import lombok.Getter;
import lombok.Setter;

public class ApiManager {
    // #2
    @Getter
    @Setter
    SuggestionsModel suggestionsModel = new SuggestionsModel();
}
